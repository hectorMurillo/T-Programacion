package sample;
import com.sun.org.apache.bcel.internal.classfile.SourceFile;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.net.URI;
import java.net.URL;

public class Controller {

    @FXML
    TextArea txtAreaSolucion,txtAreaResultado;
    @FXML
    Label lblProblema;
    @FXML
    Button btnCompilar,btnEjecutar,btnAyuda;
    public void initialize() {
        String iniciaLizaSolucion = "public class Main{\n" +
                "    public static void main(String[] args) {\n" +
                "        //Empieza a codificar la solución\n" +
                "    }\n" +
                "}";
        String problema = "1.- Elaborar un programa en JAVA que imprima la palabra HOLA MUNDO!";
        lblProblema.setText(problema);
        txtAreaSolucion.setText(iniciaLizaSolucion);
        txtAreaResultado.appendText("Resultado: ");
        txtAreaResultado.setEditable(false);
        this.eventosBotones();
        this.eventosTxtAreas();
    }

    private void eventosTxtAreas() {
        txtAreaSolucion.setOnKeyPressed((ev)->{
            String algo = ev.getCharacter();
            System.out.println("skajdlk");
        });
    }

    private void eventosBotones() {
        btnCompilar.setOnAction((event) -> {
            try{
                this.crearArchivo();
            }catch (IOException ex){
                System.err.println(ex.getMessage());
            }
        });
    }


    private void crearArchivo() throws IOException{
        File root = new File("");
        root.mkdir();
        File sourceFile = new File(root.getAbsolutePath(),"\\Main.java");
        Writer writer = new FileWriter(sourceFile);
        writer.write(this.txtAreaSolucion.getText());
        writer.close();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        String url = sourceFile.getAbsolutePath();
        compiler.run(null,null,System.err, url);
    }

}
