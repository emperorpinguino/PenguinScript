package main.java.compiler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;


public class UI {
    @FXML
    RadioButton rubyButton;
    @FXML
    RadioButton frButton;
    @FXML
    TextArea textArea1;
    @FXML
    TextArea textArea2;
    @FXML
    Button guardarButton;
    @FXML
    Button cargarButton;
    @FXML
    Button compilarButton;
    @FXML
    Button guardarXSEButton;
    @FXML
    Button salirButton;

    @FXML
    void setPlatformRuby() {
        rubyButton.setSelected(true);
        frButton.setSelected(false);
    }

    @FXML
    void setPlatformFR() {
        rubyButton.setSelected(false);
        frButton.setSelected(true);
    }

    @FXML
    void loadPS() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open PenguinScript");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PenguinScript (*.pn)", "*.pn")
        );
        File f = fileChooser.showOpenDialog(cargarButton.getScene().getWindow());
        if (f != null) {
            String st = "";
            String out = "";
            try {
                BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));
                while ((st = br.readLine()) != null)
                    out += st + '\n';

            }
            catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            textArea1.setText(out);
        }


    }

    @FXML
    void savePS() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PenguinScript");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PenguinScript (*.pn)", "*.pn")
        );
        File f = fileChooser.showOpenDialog(guardarButton.getScene().getWindow());
        if (f != null) {
            String name = f.getName();
            String aux = f.getAbsolutePath();
            if (!name.substring(name.length() - 3).equals(".pn"))
                aux = f.getAbsolutePath().concat(".pn");
            try {
                File file = new File(aux);
                BufferedWriter br = new BufferedWriter(new FileWriter(file));
                String output = textArea1.getText();
                br.write(output);
                br.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    void saveXSE() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Rubicon file");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Rubicon Files (*.rbc)", "*.rbc")
        );
        File f = fileChooser.showOpenDialog(guardarXSEButton.getScene().getWindow());
        if (f != null) {
            String name = f.getName();
            String aux = f.getAbsolutePath();
            if (!name.substring(name.length() - 4).equals(".rbc"))
                aux = f.getAbsolutePath().concat(".rbc");
            try {
                File file = new File(aux);
                BufferedWriter br = new BufferedWriter(new FileWriter(file));
                String output = textArea2.getText();
                br.write(output);
                br.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    void compile() {
        String script = textArea1.getText();
        XSEScriptLexer lexer = new XSEScriptLexer(CharStreams.fromString(script));
        XSEScriptParser parser = new XSEScriptParser(new CommonTokenStream(lexer));
        SyntaxErrorListener listener = new SyntaxErrorListener();
        parser.addErrorListener(listener);
        parser.program();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            String err = "";
            for (SyntaxError se : listener.getSyntaxErrors())
                err += se.getMessage() + '\n';
            textArea2.setText(err);
        }
        else {
            // Por alguna razon el listener se carga tanto el lexer como el parser,
            // asi que hay que crear uno nuevo
            XSEScriptLexer lexer2 = new XSEScriptLexer(CharStreams.fromString(script));
            XSEScriptParser parser2 = new XSEScriptParser(new CommonTokenStream(lexer2));
            ASTBuilder b = new ASTBuilder();
            AST<String> ast = b.build(parser2);
            ast.print(0);
            System.out.println("hace cosas 2");
            int version;
            if (rubyButton.isSelected())
                version = 0;
            else
                version = 1;
            CodeBuilder c = new CodeBuilder(version);
            String code = c.build(ast);
            textArea2.setText(code);
        }
    }



    @FXML
    void exit() {
        System.exit(0);
    }
}
