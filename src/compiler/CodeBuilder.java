package compiler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class CodeBuilder {
    private int version;
    private int textCount;
    private int progCount;
    private int moveCount;
    private int pokemartCount;
    private boolean isSection, endSection;
    private boolean isError;
    private String errorMsg;
    private int section;
    private int currentSection;
    private ArrayList<String> texts;
    private ArrayList<AST<String>> moves;
    private ArrayList<ArrayList<Object>> gotos;
    private ArrayList<AST<String>> pokemarts;
    private HashMap<Integer,Integer> ifFlows;

    HashMap<String,String> MSG = new HashMap<String,String>() {{
        put("LOCKMSG","0x2");
        put("POSTMSG","0x3");
        put("CLOSEONKEYMSG","0x4");
        put("YESNOMSG","0x5");
        put("NORMALMSG","0x6");
    }};
    HashMap<String,String> WEATHER = new HashMap<String,String>() {{
        put("NOWTHR","0x2");
        put("RAIN","0x3");
        put("SNOWFLAKES","0x4");
        put("STORM","0x5");
        put("FOG","0x6");
        put("ASHES","0x7");
        put("SANDSTORM","0x8");
        put("FOGALT","0x9");
        put("LIGHTFOG","0xA");
        put("NIGHT","0xB");
        put("OVERHEAT","0xC");
        put("STORMALT","0xD");
        put("UNDERWATER","0xE");
    }};
    HashMap<String,String> MOVES;
    HashMap<String,String> FADES = new HashMap<String,String>() {{
        put("BTON","0x0");
        put("NTOB","0x1");
        put("WTON","0x2");
        put("NTOW","0x3");
    }};

    HashMap<String, List<Integer>> GRAMMAR;


    public CodeBuilder(int version){
        textCount = progCount = moveCount = pokemartCount = 0;
        currentSection = progCount;
        moves = new ArrayList<>();
        pokemarts = new ArrayList<>();
        texts = new ArrayList<>();
        gotos = new ArrayList<>();
        ifFlows = new HashMap<>();
        MOVES = new HashMap<>();
        fillMOVES();
        GRAMMAR = new HashMap<>();
        fillGRAMMAR();
        isSection = true;
        endSection = false;
        section = progCount;
        this.version = version;
        isError = false;
        errorMsg = "";
    }

    private void fillMOVES () {
        FileInputStream fstream;
        try {
            // version = 0: RUBY
            // version = 1: FR
            if (version == 0)
                fstream = new FileInputStream("src/movesruby.txt");
            else
                fstream = new FileInputStream("src/movesfr.txt");

            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                MOVES.put(line,decToHex(String.valueOf(count)));
                count++;
            }
            fstream.close();
        }
        catch(FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            System.exit(1);
        }
        catch(IOException io) {
            System.out.println(io.getMessage());
            System.exit(1);
        }
    }

    private void fillGRAMMAR () {
        // Codigos
        // 1: DEC/HEX
        // 2: STRING
        // 3: ID
        // 4: LIST (SEGUIDO DEL TIPO DE LOS ELEMENTOS DE LA LISTA)
        // 5: TUPLE (SEGUIDO DE OTRO NUMERO CON LAS POSICIONES DEL TUPLE, Y LOS TIPOS DE LOS ELEMENTOS DEL TUPLE)
        // 6: FLAG
        // 7: VAR
        List<Integer> g = Arrays.asList(2,3,3);
        GRAMMAR.put("msgbox",g);
        g = Arrays.asList(3,3);
        GRAMMAR.put("setweather",g);
        g = Arrays.asList(2,1,1);
        GRAMMAR.put("obtainitem",g);
        g = Arrays.asList(1,1);
        GRAMMAR.put("pokeballitem",g);
        g = Arrays.asList(1);
        GRAMMAR.put("sfx",g);
        g = Arrays.asList(1);
        GRAMMAR.put("fanfare",g);
        g = Arrays.asList(1);
        GRAMMAR.put("bgm",g);
        g = Arrays.asList(1,4,3);
        GRAMMAR.put("move",g);
        g = Arrays.asList(4,3);
        GRAMMAR.put("moveplayer",g);
        g = Arrays.asList(4,3);
        GRAMMAR.put("movecamera",g);
        g = Arrays.asList(1,3);
        GRAMMAR.put("special",g);
        g = Arrays.asList(5,2,1,1,1,1);
        GRAMMAR.put("earthquake",g);
        g = Arrays.asList(3);
        GRAMMAR.put("fade",g);
        g = Arrays.asList(1);
        GRAMMAR.put("hidesprite",g);
        g = Arrays.asList(6);
        GRAMMAR.put("hidespritef",g);
        g = Arrays.asList(1);
        GRAMMAR.put("showsprite",g);
        g = Arrays.asList(5,2,1,1,1);
        GRAMMAR.put("warp",g);
        g = Arrays.asList(5,2,1,1,5,2,1,1);
        GRAMMAR.put("warpcoords",g);
        g = Arrays.asList(1,5,2,1,1);
        GRAMMAR.put("tpsrite",g);
        g = Arrays.asList(5,2,1,1,3);
        GRAMMAR.put("opendoor",g);
        g = Arrays.asList(5,2,1,1,3);
        GRAMMAR.put("closedoor",g);
        g = Arrays.asList(4,1);
        GRAMMAR.put("pokemart",g);
        g = Arrays.asList(7,1);
        GRAMMAR.put("==",g);
        g = Arrays.asList(7,1);
        GRAMMAR.put(">=",g);
        g = Arrays.asList(7,1);
        GRAMMAR.put("<=",g);
        g = Arrays.asList(7,1);
        GRAMMAR.put("!=",g);
        g = Arrays.asList(7,1);
        GRAMMAR.put(">",g);
        g = Arrays.asList(7,1);
        GRAMMAR.put("<",g);
        g = Arrays.asList();
        GRAMMAR.put("choice",g);
    }

    private void checkGrammar(AST<String> ast) {
        System.out.println("checkGrammar");
        // Hijo de ast al que se accede
        int count = 0;
        // Posicion de la lista en GRAMMAR a la que se accede
        int i;
        boolean err = false;
        try {
            List<Integer> g = GRAMMAR.get(ast.getValue());
            System.out.println("SIZE: " + g.size());
            for (i = 0; i < g.size(); i++) {
                System.out.println("i: " + i);
                System.out.println("value: " + ast.getChild(count).getValue());
                switch(g.get(count)) {
                    case 1:
                        if (!ast.getChild(count).getValue().equals("dec") && !ast.getChild(count).getValue().equals("hex"))
                            err = true;
                        break;
                    case 2:
                        if (!ast.getChild(count).getValue().equals("string"))
                            err = true;
                        break;
                    case 3:
                        if (!ast.getChild(count).getValue().equals("id"))
                            err = true;
                        break;
                    case 4:
                        if (!ast.getChild(count).getValue().toString().equals("list"))
                            err = true;
                        else {
                            AST<String> l = ast.getChild(count);
                            int type = g.get(i+1);
                            i++;
                            for (AST<String> child : l.getChildren()) {
                                switch(type) {
                                    case 1:
                                        if (!child.getValue().equals("dec") && !child.getValue().equals("hex"))
                                            err = true;
                                        break;
                                    case 3:
                                        if (!child.getValue().equals("id"))
                                            err = true;
                                        break;
                                }
                            }
                        }
                        break;
                    case 5:
                        if (!ast.getChild(count).getValue().toString().equals("tuple"))
                            err = true;
                        else {
                            AST<String> t = ast.getChild(count);
                            int size = g.get(i+1);
                            i += 2;
                            if (t.getChildren().size() != size)
                                err = true;
                            else {
                                for (int j = 0; j < size; j++) {
                                    switch (g.get(i)) {
                                        case 1:
                                            if (!t.getChild(j).getValue().equals("dec") && !t.getChild(j).getValue().equals("hex"))
                                                err = true;
                                            break;
                                        case 3:
                                            if (!t.getChild(j).getValue().equals("id"))
                                                err = true;
                                            break;
                                    }
                                    i++;
                                }
                            }
                        }
                        break;
                    case 6:
                        if (!ast.getChild(count).getValue().toString().equals("flag"))
                            err = true;
                        break;

                    case 7:
                        if (!ast.getChild(count).getValue().equals("var"))
                            err = true;
                        break;
                }
                count++;
            }
        }
        catch (IndexOutOfBoundsException e) {
            isError = true;
            errorMsg += "Error: Número de argumentos incorrecto en " + ast.getValue() + '\n';
            System.out.println("IndexOutOfBounds");
        }
        if (err) {
            isError = true;
            errorMsg += "Error: Tipo de argumentos incorrecto en " + ast.getValue() + '\n';
        }
        System.out.println("Acaba checkGrammar");
    }

    // Genera el código de un programa dado un compiler.AST
    public String build(AST<String> ast) {
        String code = "#dynamic 0x800000\n\n";
        ifFlows.put(0,0);
        code += buildProgram(ast);
        code += "end\n";
        code += buildGotos();
        code += buildTexts();
        code += buildMoves();
        code += buildPokeMarts();
        if (isError)
            code = errorMsg;
        return code;
    }

    // Genera el código de la parte principal del programa
    private String buildProgram(AST<String> program) {
        String code = "";
        for (AST<String> child : program.getChildren()) {
            System.out.println(isSection);
            if (isSection)
                code += "#org @prog" + section + "\n";
            isSection = false;
            progCount++;
            if (child.getValue().equals("="))
                code += buildAssig(child);
            else if (child.getValue().equals("ite")) {
                code += buildCond(child);
            }
            else
                code += buildInstr(child);
            if (endSection) {
                code += "end\n\n";
                isSection = true;
                endSection = false;
            }
        }
        if (isSection) {
            code += "#org @prog" + currentSection + "\n";
            isSection = false;
        }
        return code;
    }

    private String buildAssig(AST<String> assig) {
        String code = "";
        if (assig.getChild(0).getValue().equals("var")) {
            code += "setvar " + assig.getChild(0).getChild(0).getValue().toString().substring(1) + " ";
            if (assig.getChild(1).getValue().equals("hex"))
                code += assig.getChild(1).getChild(0).getValue().toString() + "\n";
            else if (assig.getChild(1).getValue().equals("dec"))
                code += decToHex(assig.getChild(1).getChild(0).getValue().toString()) + "\n";
        }
        else if (assig.getChild(0).getValue().equals("flag")) {
            if (assig.getChild(1).getChild(0).getValue().equals("true"))
                code += "setflag ";
            else if (assig.getChild(1).getChild(0).getValue().equals("false"))
                code += "clearflag ";
            code += assig.getChild(0).getChild(0).getValue().toString().substring(1) + "\n";
        }
        return code;
    }

    private String decToHex(String s) {
        int d = Integer.valueOf(s);
        String r = "";
        if (d == 0)
            r += "0";
        while (d > 0) {
            int m = d % 16;
            if (m < 10)
                r = m + r;
            else
                switch(m) {
                    case 10:
                        r = 'A' + r;
                        break;
                    case 11:
                        r = 'B' + r;
                        break;
                    case 12:
                        r = 'C' + r;
                        break;
                    case 13:
                        r = 'D' + r;
                        break;
                    case 14:
                        r = 'E' + r;
                        break;
                    case 15:
                        r = 'F' + r;
                        break;
                }
            d /= 16;
        }
        return "0x" + r;
    }

    private String buildCond(AST<String> cond) {
        System.out.println("progCount: " + progCount);
        String code = "";
        int dest = ifFlows.get(currentSection);
        ifFlows.put(progCount,dest==currentSection ? progCount : dest);
        ifFlows.put(currentSection,progCount);
        section = progCount;
        progCount++;
        ArrayList<Object> l = new ArrayList<>();
        switch(cond.getChild(0).getValue().toString()) {
            case "checkgender":
                code += "checkgender\n";
                code += "compare lastresult 0x0\n";
                code += "if 0x1 goto @prog" + progCount + "\n";
                break;
            case "choice":
                checkGrammar(cond.getChild(0));
                if (!isError) {
                    code += "msgbox @text" + textCount + " 0x5\n";
                    textCount++;
                    String aux = cond.getChild(0).getChild(0).getValue().toString();
                    texts.add(aux.substring(1, aux.length() - 1));
                    code += "compare lastresult 0x1\n";
                    code += "if 0x1 goto @prog" + progCount + "\n";
                }
                break;
            case "flag":
                code += "checkflag " + cond.getChild(0).getChild(0).getValue().toString().substring(1) + "\n";
                code += "if 0x1 goto @prog" + progCount + "\n";
                break;
            default:
                code += buildB_expr(cond.getChild(0));
                break;
        }
        ifFlows.put(progCount,section);

        // DEBUG
        for(HashMap.Entry<Integer, Integer> entry : ifFlows.entrySet()) {
            System.out.println("Nodo: " + entry.getKey() + " Destino: " + entry.getValue());
        }

        l.add(cond.getChild(1));
        l.add(progCount);

        gotos.add(l);
        progCount++;
        if (cond.getChildren().size() > 2) {
            isSection = false;
            code += buildProgram(cond.getChild(2));
        }
        code += "goto @prog" + ifFlows.get(currentSection) + "\n";
        section = ifFlows.get(currentSection);
        currentSection = section;
        endSection = true;
        return code;
    }

    private String buildB_expr(AST<String> b_expr) {
        String code = "";
        if (b_expr.getChild(0).getValue().equals("var")) {
            code += "compare " + b_expr.getChild(0).getChild(0).getValue().toString().substring(1);
            if (b_expr.getChild(1).getValue().equals("hex"))
                code += " " + b_expr.getChild(1).getChild(0).getValue().toString() + "\n";
            else if (b_expr.getChild(1).getValue().equals("dec"))
                code += " " + decToHex(b_expr.getChild(1).getChild(0).getValue().toString()) + "\n";
            code += "if ";
            switch(b_expr.getValue()) {
                case "<":
                    code += "0x0 goto @prog" + progCount + "\n";
                    break;
                case "==":
                    code += "0x1 goto @prog" + progCount + "\n";
                    break;
                case ">":
                    code += "0x2 goto @prog" + progCount + "\n";
                    break;
                case "<=":
                    code += "0x3 goto @prog" + progCount + "\n";
                    break;
                case ">=":
                    code += "0x4 goto @prog" + progCount + "\n";
                    break;
                case "!=":
                    code += "0x5 goto @prog" + progCount + "\n";
                    break;
            }
        }
        return code;
    }

    private String buildInstr(AST<String> instr) {
        String code = "";
        switch(instr.getValue()) {
            case "msgbox":
                checkGrammar(instr);
                if (!isError) {
                    code += buildMsgbox(instr);
                }
                break;
            case "setweather":
                checkGrammar(instr);
                if (!isError)
                    code += buildSetWeather(instr);
                break;
            case "obtainitem":
                checkGrammar(instr);
                if (!isError)
                    code += buildObtainItem(instr);
                break;
            case "pokeballitem":
                checkGrammar(instr);
                if (!isError)
                    code += buildPokeballItem(instr);
                break;
            case "sfx":
                checkGrammar(instr);
                if (!isError)
                    code += buildSfx(instr);
                break;
            case "fanfare":
                checkGrammar(instr);
                if (!isError)
                    code += buildFanfare(instr);
                break;
            case "bgm":
                checkGrammar(instr);
                if (!isError)
                    code += buildBgm(instr);
                break;
            case "move":
                checkGrammar(instr);
                if (!isError)
                    code += buildMove(instr);
                break;
            case "moveplayer":
                checkGrammar(instr);
                if (!isError)
                    code += buildMovePlayer(instr);
                break;
            case "movecamera":
                checkGrammar(instr);
                if (!isError)
                    code += buildMoveCamera(instr);
                break;
            case "special":
                checkGrammar(instr);
                if (!isError)
                    code += buildSpecial(instr);
                break;
            case "earthquake":
                checkGrammar(instr);
                if (!isError)
                    code += buildEarthquake(instr);
                break;
            case "fade":
                checkGrammar(instr);
                if (!isError)
                    code += buildFade(instr);
                break;
            case "hidesprite":
                checkGrammar(instr);
                if (!isError)
                    code += buildHideSprite(instr);
                break;
            case "hidespritef":
                checkGrammar(instr);
                if (!isError)
                    code += buildHideSpriteF(instr);
                break;
            case "showsprite":
                checkGrammar(instr);
                if (!isError)
                    code += buildShowSprite(instr);
                break;
            case "warp":
                checkGrammar(instr);
                if (!isError)
                    code += buildWarp(instr);
                break;
            case "warpcoords":
                checkGrammar(instr);
                if (!isError)
                    code += buildWarpCoords(instr);
                break;
            case "tpsprite":
                checkGrammar(instr);
                if (!isError)
                    code += buildTPSprite(instr);
                break;
            case "opendoor":
                checkGrammar(instr);
                if (!isError)
                    code += buildOpenDoor(instr);
                break;
            case "closedoor":
                checkGrammar(instr);
                if (!isError)
                    code += buildCloseDoor(instr);
                break;
            case "pokemart":
                checkGrammar(instr);
                if (!isError)
                    code += buildPokemart(instr);
                break;
            default:
                if (!isError)
                    code += instr.getValue() + "\n";
                break;
        }
        return code;
    }

    /* DE AQUÍ HASTA buildPokemart SON TODAS FUNCIONES GENERADORAS DEL CÓDIGO DE LAS INSTRUCCIONES */
    private String buildMsgbox(AST<String> msgbox) {
        System.out.println("entra en buildmsgbox");
        String code = "";
        code += "msgbox @text" + textCount + " ";
        textCount++;
        String aux = msgbox.getChild(0).getChild(0).getValue().toString();
        texts.add(aux.substring(1,aux.length()-1));
        String type = MSG.get(msgbox.getChild(1).getChild(0).getValue().toString());
        if (type == null) {
            isError = true;
            errorMsg += "Error: ID inválido en msgbox (arg 2)\n";
        }
        boolean wait = false;
        if (msgbox.getChild(2).getChild(0).getValue().toString().equals("WAIT"))
            wait = true;
        else if (msgbox.getChild(2).getChild(0).getValue().toString().equals("NOWAIT"))
            wait = false;
        else {
            isError = true;
            errorMsg += "Error: ID inválido en msgbox (arg 3)\n";
        }
        code += type + "\n";
        if (wait)
            code += "waitmsg\n";
        System.out.println("code: " + code + " isError: " + isError);
        return code;
    }

    private String buildSetWeather(AST<String> setweather) {
        String code = "";
        code += "setweather ";
        String type = WEATHER.get(setweather.getChild(0).getChild(0).getValue().toString());
        if (type == null) {
            isError = true;
            errorMsg += "Error: ID inválido en setweather (arg 1)\n";
        }
        boolean now = false;
        if (setweather.getChild(1).getChild(0).getValue().toString().equals("NOW"))
            now = true;
        else if (setweather.getChild(1).getChild(0).getValue().toString().equals("NOTNOW"))
            now = false;
        else {
            isError = true;
            errorMsg += "Error: ID inválido en setweather (arg 2)\n";
        }
        code += type + "\n";
        if (now)
            code += "doweather\n";
        return code;
    }

    private String buildObtainItem(AST<String> obtainitem) {
        String code = "msgbox @text" + textCount + " 0x2\n";
        String aux = obtainitem.getChild(0).getValue().toString();
        texts.add(aux.substring(1,aux.length()-1));
        textCount++;
        code += "waitmsg\n";
        code += "giveitem ";
        code += buildNumber(obtainitem.getChild(1));
        code += ' ';
        code += buildNumber(obtainitem.getChild(2));
        code += " MSG_OBTAIN\n";
        return code;
    }

    private String buildPokeballItem(AST<String> pokeballitem) {
        String code = "giveitem ";
        code += buildNumber(pokeballitem.getChild(0));
        code += ' ';
        code += buildNumber(pokeballitem.getChild(1));
        code += " MSG_FIND\n";
        return code;
    }

    private String buildSfx(AST<String> sfx) {
        String code = "sound ";
        code += buildNumber(sfx.getChild(0));
        code += "\n";
        return code;
    }

    private String buildFanfare(AST<String> fanfare) {
        String code = "fanfare ";
        code += buildNumber(fanfare.getChild(0));
        code += "\n";
        return code;
    }

    private String buildBgm(AST<String> bgm) {
        String code = "playsong ";
        code += buildNumber(bgm.getChild(0));
        code += " 0x0\n";
        return code;
    }

    private String buildMove(AST<String> move) {
        String code = "applymovement ";
        String id = "";
        code += buildNumber(move.getChild(0));
        code += id;
        code += " @move" + moveCount + "\n";
        moveCount++;
        moves.add(move.getChild(1));
        boolean wait = false;
        for (AST<String> child : move.getChildren())
            if (child.getValue().equals("WAIT")) {
                wait = true;
                break;
            }
        if (wait)
            code += "waitmovement " + id + "\n";
        return code;
    }

    private String buildMovePlayer(AST<String> moveplayer) {
        String code = "applymovement 0xFF";
        code += " @move" + moveCount + "\n";
        moveCount++;
        moves.add(moveplayer.getChild(0));
        boolean wait = false;
        for (AST<String> child : moveplayer.getChildren())
            if (child.getValue().equals("WAIT")) {
                wait = true;
                break;
            }
        if (wait)
            code += "waitmovement 0xFF\n";
        return code;
    }

    private String buildMoveCamera(AST<String> moveplayer) {
        String code = "";
        if (version == 0)
            code += "special 0x116\n";
        else
            code += "special 0x113\n";
        code += "applymovement 0x7F";
        code += " @move" + moveCount + "\n";
        moveCount++;
        moves.add(moveplayer.getChild(0));
        boolean wait = false;
        for (AST<String> child : moveplayer.getChildren())
            if (child.getValue().equals("WAIT")) {
                wait = true;
                break;
            }
        if (wait)
            code += "waitmovement 0x0\n";
        if (version == 0)
            code += "special 0x117\n";
        else
            code += "special 0x114\n";
        return code;
    }

    private String buildSpecial(AST<String> special) {
        String code = "special ";
        code += buildNumber(special.getChild(0));
        code += "\n";
        boolean wait = false;
        if (special.getChild(1).getChild(0).getValue().toString().equals("WAIT"))
            wait = true;
        else if (special.getChild(1).getChild(0).getValue().toString().equals("NOWAIT"))
            wait = false;
        else {
            isError = true;
            errorMsg += "Error: ID inválido en special (arg 2)\n";
        }
        if (wait)
            code += "waitstate\n";
        return code;
    }

    private String buildEarthquake(AST<String> earthquake) {
        String code = "sound 0x4B\n";
        code += "setvar 0x8004 ";
        code += buildNumber(earthquake.getChild(0));
        code += "\n";
        code += "setvar 0x8005 ";
        code += buildNumber(earthquake.getChild(1));
        code += "\n";
        code += "setvar 0x8006 ";
        code += buildNumber(earthquake.getChild(2));
        code += "\n";
        code += "setvar 0x8007 ";
        code += buildNumber(earthquake.getChild(3));
        code += "\n";
        code += "special 0x136\n";
        code += "waitstate\n";
        return code;
    }

    private String buildFade(AST<String> fade) {
        String code = "fadescreen ";
        code += FADES.get(fade.getChild(0).getValue()) + "\n";
        return code;
    }

    private String buildHideSprite(AST<String> hidesprite) {
        String code = "hidesprite ";
        code += buildNumber(hidesprite.getChild(0));
        code += "\n";
        return code;
    }

    private String buildHideSpriteF(AST<String> hidespritef) {
        String code = "setflag ";
        code += hidespritef.getChild(0).getChild(0).getValue().toString().substring(1);
        code += "\n";
        return code;
    }

    private String buildShowSprite(AST<String> showsprite) {
        String code = "showsprite ";
        if (showsprite.getChild(0).getValue().equals("dec"))
            code += decToHex(showsprite.getChild(0).getChild(0).getValue().toString());
        else
            code += showsprite.getChild(0).getChild(0).getValue();
        code += "\n";
        return code;
    }

    private String buildWarp(AST<String> warp) {
        String code = "warp ";
        for (AST<String> child : warp.getChildren()) {
            code += buildNumber(child);
            code += " ";
        }
        code += "0x0 0x0\n";
        return code;
    }

    private String buildWarpCoords(AST<String> warpcoords) {
        String code = "warp ";
        code += buildNumber(warpcoords.getChild(0));
        code += " ";
        code += buildNumber(warpcoords.getChild(1));
        code += " 0xFF ";
        code += buildNumber(warpcoords.getChild(2).getChild(0));
        code += " ";
        code += buildNumber(warpcoords.getChild(2).getChild(1));
        code += "\n";
        return code;
    }

    private String buildTPSprite(AST<String> tpsprite) {
        String code = "movesprite ";
        code += buildNumber(tpsprite.getChild(0));
        code += " ";
        code += buildNumber(tpsprite.getChild(1).getChild(0));
        code += " ";
        code += buildNumber(tpsprite.getChild(1).getChild(1));
        code += "\n";
        return code;
    }

    private String buildOpenDoor(AST<String> opendoor) {
        String code = "setdooropened ";
        code += buildNumber(opendoor.getChild(0).getChild(0));
        code += " ";
        code += buildNumber(opendoor.getChild(0).getChild(1));
        code += "\n";
        if (opendoor.getChild(1).getChild(0).getValue().toString().equals("NOW"))
            code += "doorchange\n";
        else if (!opendoor.getChild(1).getChild(0).getValue().toString().equals("NOTNOW")){
            isError = true;
            errorMsg += "Error: ID inválido en opendoor (arg 2)\n";
        }
        return code;
    }

    private String buildCloseDoor(AST<String> closedoor) {
        String code = "setdoorclosed ";
        code += buildNumber(closedoor.getChild(0).getChild(0));
        code += " ";
        code += buildNumber(closedoor.getChild(0).getChild(1));
        code += "\n";
        if (closedoor.getChild(1).getChild(0).getValue().toString().equals("NOW"))
            code += "doorchange\n";
        else if (!closedoor.getChild(1).getChild(0).getValue().toString().equals("NOTNOW")){
            isError = true;
            errorMsg += "Error: ID inválido en closedoor (arg 2)\n";
        }
        return code;
    }

    private String buildPokemart(AST<String> pokemart) {
        String code = "lock\nfaceplayer\n";
        code += "pokemart @mart" + pokemartCount;
        pokemarts.add(pokemart.getChild(0));
        pokemartCount++;
        code += "\nrelease\n";
        return code;
    }

    private String buildNumber(AST<String> ast) {
        String code = "";
        if (ast.getValue().equals("dec"))
            code += decToHex(ast.getChild(0).getValue().toString());
        else
            code += ast.getChild(0).getValue();
        return code;
    }

    private String buildTexts() {
        String code = "";
        for (int i = 0; i < texts.size(); i++) {
            code += "\n#org @text" + i + "\n";
            code += "= " + texts.get(i) + "\n";
        }
        return code;
    }

    private String buildGotos() {
        String code = "\n";
        System.out.println(gotos.size());
        for (int i = 0; i < gotos.size(); i++) {
            ArrayList<Object> gt = gotos.get(i);
            System.out.println(gt);
            isSection = true;

            section = (int)(gt.get(1));
            currentSection = section;
            code += buildProgram((AST<String>)(gt.get(0)));
            code += "goto @prog" + ifFlows.get(section) + "\n";
            code += "end\n\n";
        }
        return code;
    }

    private String buildMoves() {
        String code = "\n";
        for (int i = 0; i < moves.size(); i++) {
            code += "org @move" + i + "\n";
            for (AST<String> move : moves.get(i).getChildren()) {
                code += "#raw ";
                String m = MOVES.get(move.getValue().toString());
                if (m == null) {
                    isError = true;
                    errorMsg += "Error: ID inválido en " + moves.get(i) + (moves.get(i).equals("move") ? " (arg 2)\n" : " (arg 1)\n");
                }
                code += MOVES.get(move.getValue()) + "\n";
            }
            code += "#raw 0xFE\n\n";
        }
        return code;
    }

    private String buildPokeMarts() {
        String code = "";
        for (int i = 0; i < pokemarts.size(); i++) {
            code += "org @mart" + i + "\n";
            for (AST<String> item : pokemarts.get(i).getChildren()) {
                code += "#raw word ";
                code += buildNumber(item);
                code += "\n";
            }
            code += "#raw word 0x0\n\n";
        }
        return code;
    }
}
