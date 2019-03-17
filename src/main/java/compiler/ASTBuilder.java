package main.java.compiler;

public class ASTBuilder {
    public ASTBuilder(){

    }

    public AST<String> build(XSEScriptParser parser) {
        return convertProgram(parser.program());
    }


    private AST<String> convertProgram(XSEScriptParser.ProgramContext program) {
        AST<String> ast = new AST("program");
        System.out.println(program.instruction());
        for (XSEScriptParser.InstructionContext instr : program.instruction()) {
            if (instr.v_assig() != null)
                ast.addChild(convertV_assig(instr.v_assig()));
            else if (instr.f_assig() != null)
                ast.addChild(convertF_assig(instr.f_assig()));
            else if (instr.cond() != null)
                ast.addChild(convertCond(instr.cond()));
            else if (instr.instr() != null)
                ast.addChild(convertInstr(instr.instr()));
        }
        return ast;
    }

    private AST<String> convertV_assig(XSEScriptParser.V_assigContext assig) {
        AST<String> ast = new AST("=");
        AST<String> aux = new AST("var");
        aux.addChild(new AST(assig.VAR().toString()));
        ast.addChild(aux);
        ast.addChild(convertValue(assig.value()));
        return ast;
    }

    private AST<String> convertF_assig(XSEScriptParser.F_assigContext assig) {
        AST<String> ast = new AST("=");
        AST<String> aux = new AST("flag");
        aux.addChild(new AST(assig.FLAG().toString()));
        ast.addChild(aux);
        ast.addChild(convertBool(assig.bool()));
        return ast;
    }

    private AST<String> convertBool(XSEScriptParser.BoolContext bool) {
        AST<String> ast = new AST("bool");
        if (bool.TRUE() != null)
            ast.addChild(new AST("true"));
        else if (bool.FALSE() != null)
            ast.addChild(new AST("false"));
        return ast;
    }

    private AST<String> convertValue(XSEScriptParser.ValueContext value) {
        AST<String> ast = new AST("dec");
        if (value.DEC_LIT() != null)
            ast.addChild(new AST(value.DEC_LIT().toString()));
        else if (value.HEX_LIT() != null) {
            ast = new AST("hex");
            ast.addChild(new AST(value.HEX_LIT().toString()));
        }
        return ast;
    }

    private AST<String> convertCond(XSEScriptParser.CondContext cond) {
        AST<String> ast = new AST("ite");
        ast.addChild(convertB_expr(cond.b_expr()));
        for (XSEScriptParser.ProgramContext p : cond.program())
            ast.addChild(convertProgram(p));
        return ast;
    }



    private AST<String> convertB_expr(XSEScriptParser.B_exprContext b_expr) {
        AST<String> ast = new AST<>("checkgender");
        if (b_expr.CHECKGENDER() != null)
            ast = new AST<>("checkgender");
        else if (b_expr.choice() != null)
            ast = convertChoice(b_expr.choice());
        else if (b_expr.FLAG() != null) {
            ast = new AST<>("flag");
            ast.addChild(new AST(b_expr.FLAG().toString()));
        }
        else if (b_expr.op() != null) {
            ast = convertOp(b_expr.op());
            AST<String> aux = new AST<>("var");
            aux.addChild(new AST(b_expr.VAR().toString()));
            ast.addChild(aux);
            ast.addChild(convertValue(b_expr.value()));
        }
        return ast;
    }

    private AST<String> convertOp(XSEScriptParser.OpContext op) {
        AST<String> ast = new AST("==");
        if (op.EQ() != null)
            ast = new AST("==");
        else if (op.NE() != null)
            ast = new AST("!=");
        else if (op.GE() != null)
            ast = new AST(">=");
        else if (op.GT() != null)
            ast = new AST(">");
        else if (op.LE() != null)
            ast = new AST("<=");
        else if (op.LT() != null)
            ast = new AST("<");

        return ast;
    }

    private AST<String> convertChoice(XSEScriptParser.ChoiceContext choice) {
        AST<String> ast = new AST("choice");
        ast.addChild(new AST(choice.STRING().toString()));
        return ast;
    }

    private AST<String> convertInstr(XSEScriptParser.InstrContext instr) {
        AST<String> ast = new AST(instr.COMMAND().toString());
        for (XSEScriptParser.ArgsContext arg : instr.args()) {
            if (arg.STRING() != null) {
                AST<String> aux = new AST<>("string");
                aux.addChild(new AST(arg.STRING().toString()));
                ast.addChild(aux);
            }
            else if (arg.ID() != null) {
                AST<String> aux = new AST<>("id");
                aux.addChild(new AST(arg.ID().toString()));
                ast.addChild(aux);
            }
            else if (arg.FLAG() != null) {
                AST<String> aux = new AST<>("flag");
                aux.addChild(new AST(arg.FLAG().toString()));
                ast.addChild(aux);
            }
            else if (arg.value() != null)
                ast.addChild(convertValue(arg.value()));
            else if (arg.list() != null)
                ast.addChild(convertList(arg.list()));
            else if (arg.tuple() != null)
                ast.addChild(convertTuple(arg.tuple()));
        }
        return ast;
    }

    private AST<String> convertList(XSEScriptParser.ListContext list) {
        AST<String> ast = new AST("list");
        for (XSEScriptParser.ElemContext elem : list.elem())
            ast.addChild(convertElem(elem));
        return ast;
    }

    private AST<String> convertTuple(XSEScriptParser.TupleContext tuple) {
        AST<String> ast = new AST("tuple");
        for (XSEScriptParser.ElemContext elem : tuple.elem())
            ast.addChild(convertElem(elem));
        return ast;
    }

    private AST<String> convertElem(XSEScriptParser.ElemContext elem) {
        AST<String> ast = new AST();
        if (elem.ID() != null) {
            ast = new AST("id");
            ast.addChild(new AST(elem.ID().toString()));
        }
        else if (elem.DEC_LIT() != null) {
            ast = new AST("dec");
            ast.addChild(new AST(elem.DEC_LIT().toString()));
        }
        else if (elem.HEX_LIT() != null) {
            ast = new AST("hex");
            ast.addChild(new AST(elem.HEX_LIT().toString()));
        }
        return ast;
    }
}
