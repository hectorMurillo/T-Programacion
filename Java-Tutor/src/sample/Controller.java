package sample;

import Modelos.*;
import Utileria.Alerta;
import Utileria.Archivo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.HostServices;

import javax.tools.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    EjercicioModel ejercicioActual = new EjercicioModel();
    int numeroEjercicio = 0, numAyudas = 0, numErrores = 0, tiempo = 1;
    Nivel nivel = Nivel.PRINCIPIANTE;

    TutorModel tutor = null;
    @FXML
    TextArea txtAreaSolucion,txtAreaResultado;
    @FXML
    Label lblProblema, lblContTiempo, lblCantErrores;
    @FXML
    Button btnCompilar,btnEjecutar,btnAyuda,btnIniciar,btnSiguiente;
    private File sourceFile = null;
    String inicializaSolucion = "public class Ejercicio{\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.print(\"HELP ME\");\n" +
            "    }\n" +
            "}";

    public void initialize() {
        inicializaInterfaz();
    }

    private void inicializaInterfaz() {
        String nivel = Archivo.leerArchivo("./src/Archivos/Nivel").toString();
        System.out.println("Nivel: "+nivel);
        txtAreaSolucion.setText(inicializaSolucion);
        txtAreaResultado.appendText("Resultado: ");
        txtAreaResultado.setEditable(false);
        this.inhabilitaControles(true);
        this.btnSiguiente.setDisable(true);
        this.btnEjecutar.setDisable(true);
        this.eventosBotones();
        this.eventosTxtAreas();
        cargaEjercicioActual();
        tutor = new TutorModel(this.ejercicioActual);
    }

    private List<EjercicioModel> cargaEjercicioNivel(Nivel nivel) {
        List<EjercicioModel> todosEjercicios = Archivo.fromJsonToEjercicios();
        List<EjercicioModel> ejerciciosFiltrados = new ArrayList<>();
        for(EjercicioModel ej: todosEjercicios){
            if(ej.getNivel() == this.nivel)
                ejerciciosFiltrados.add(ej);
        }
        return ejerciciosFiltrados;
    }

    private void cargaEjercicioActual(){
        this.ejercicioActual = this.cargaEjercicioNivel(this.nivel).get(numeroEjercicio);
        this.lblProblema.setText(this.ejercicioActual.getDescripcion_problema());
    }

    private void eventosTxtAreas() {
        txtAreaSolucion.setOnKeyPressed((ev)->{
            this.btnEjecutar.setDisable(true);
        });
    }

    private void eventosBotones() {
        this.btnIniciar.setOnAction((evt)->{
            this.inhabilitaControles(false);
        });
        this.btnEjecutar.setOnAction((evt)->{
            try{
                this.proccesBuilder();
                List<String> devuelveValores = this.muestraContenido("./Soluciones/output.txt");
                txtAreaResultado.setText("Resultado: \n"+devuelveValores.get(8));
                if(this.ejercicioActual.getSolucion_esperada().equalsIgnoreCase(devuelveValores.get(8))){
                    new Alerta("Atención",null,"Felicidades, tu solución es correcta", Alert.AlertType.INFORMATION);
                    this.ejercicioActual.setEjecucion_correcta(true);
                    this.btnSiguiente.setDisable(false);
                }else{
                    new Alerta("Atención",null,"La solución no es la correcta pon atención a lo que se pide,\n si se te dificulta puedes clickear en \"Ayuda\"", Alert.AlertType.WARNING);
                    this.numErrores++;
                    this.lblCantErrores.setText(Integer.toString(this.numErrores));
                }
            }catch(IOException ex){

            }
        });
        this.btnCompilar.setOnAction((evt)->{
            this.createFile();
            txtAreaResultado.setText("");
            this.compile(sourceFile);
            this.btnEjecutar.setDisable(false);
        });
        this.btnAyuda.setOnAction((evt)->{
            Ayuda ayudaActual = this.ejercicioActual.getAyuda();
            Hyperlink url = createLink(ayudaActual.getUrl());
            new Alerta(ayudaActual.getEncabezado().toUpperCase(),null,ayudaActual.getCuerpo()+"\n Para más información visita:\n"+url,Alert.AlertType.INFORMATION);
            this.numAyudas++;
        });
        this.btnSiguiente.setOnAction((evt)->{
            this.numeroEjercicio++;
            this.cargaEjercicioActual();
            this.inhabilitaControles(true);
            this.btnSiguiente.setDisable(true);
            this.btnEjecutar.setDisable(true);
            this.txtAreaSolucion.setText(this.inicializaSolucion);
            this.txtAreaResultado.setText("Resultado:");
            //Mandar a llamar el Fuzzy
            Fuzzy fuzzy = new Fuzzy();
            double algo = fuzzy.getVariableOutPut(numErrores,numAyudas,this.tiempo,this.nivel.get_nivel());
            System.out.println("fuzzy : "+algo);
            this.numAyudas = 0;
            this.numeroEjercicio = 0;
        });
    }

    private Hyperlink createLink(URL url) {
        Hyperlink hyperlink = new Hyperlink(url.toString());

        hyperlink.setOnAction((evt)->{
           evt.getEventType().getName();
        });
        return hyperlink;
    }

    //Define las reglas cuando se queda en el mismo nivel, cuando avanza o lo baja de nivel

    //Este método debo encontrarle una mejora para que no tenga que dormir el hilo
    public static List<String> muestraContenido(String archivo) throws IOException {
        List<String> contenido = new ArrayList<>();
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        try{Thread.sleep(4000);}catch(Exception ex){}
        while((cadena = b.readLine())!=null) {
            contenido.add(cadena);
        }
        b.close();
        return contenido;
    }

    private void createFile(){
        try
        {
            sourceFile = new File("./Soluciones", "/Ejercicio.java");
            Writer writer = new FileWriter(sourceFile);
            writer.write(this.txtAreaSolucion.getText());
            writer.close();
        }catch(Exception ex){
            System.err.println("Hubo un error "+ex.getMessage());
        }
    }

    private void inhabilitaControles(boolean inhabilita) {
        this.btnIniciar.setDisable(!inhabilita);
        this.btnAyuda.setDisable(inhabilita);
        this.btnCompilar.setDisable(inhabilita);
        this.txtAreaSolucion.setDisable(inhabilita);
        if(!inhabilita)
            txtAreaSolucion.requestFocus();
    }


    public void compile(File sf) {
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            DiagnosticCollector<JavaFileObject> diagnostic = new DiagnosticCollector<>();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> compilation =
                    fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sf));
            JavaCompiler.CompilationTask task = compiler.getTask(null, null, diagnostic, null, null, compilation);
            verificaExito(task, diagnostic);
        } catch (Exception ex) {
            System.err.println("Hubo un error interno.");
        }
    }

    private void verificaExito(JavaCompiler.CompilationTask task, DiagnosticCollector<JavaFileObject> diagnostics) throws IOException {
        if( task.call() ){
            txtAreaResultado.setText("Compila correctamente.");

            this.proccesBuilder();

            btnEjecutar.setDisable(false);
        }
        else{

            this.numErrores++;

            lblCantErrores.setText(Integer.toString(numErrores));
            txtAreaResultado.setText("Resultado:\n");

            // Recorremos el diagnostico
            for (Diagnostic diag : diagnostics.getDiagnostics()) {
                txtAreaResultado.setText(txtAreaResultado.getText() + "\n" + diag.getMessage(null) + "\t Linea: " + diag.getLineNumber() + "\n");
            }
        }
    }

    private void proccesBuilder() {
        try{
            // create a process
            ProcessBuilder pb = new ProcessBuilder("cmd");

            // take all commands as input in a text file
            File commands = new File("./Soluciones/commands.txt");

            // File where error logs should be written
            File error = new File("./Soluciones/error.txt");

            // File where output should be written
            File output = new File("./Soluciones/output.txt");

            // redirect all the files
            pb.redirectInput(commands);
            pb.redirectOutput(output);
            pb.redirectError(error);

            pb.start();
        }catch (Exception ex){
            System.out.println("Exception: " + ex);
        }
    }

}
