import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aplicacion extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        /**btn.setOnAction(event -> {
         System.out.println("Clickeo "+event.getEventType());
         });*/
        BorderPane principal = new BorderPane();
        HBox contTitulo = new HBox();
        BorderPane contAccionario = new BorderPane();

        VBox contTextArea = new VBox();
        VBox contentTituloProblema = new VBox();
        Text titulo = new Text("Aprendiendo java");
        titulo.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, FontPosture.REGULAR, 21));
        titulo.setFill(Color.BLUE);
        titulo.setStroke(Color.BLACK);
        titulo.setStrokeWidth(1);
        contTitulo.getChildren().add(titulo);
        contTitulo.setAlignment(Pos.CENTER);
        contentTituloProblema.setAlignment(Pos.CENTER_LEFT);
        contentTituloProblema.getChildren().add(titulo);
        Text txtProblema = new Text();
        //Puedo generar varios labels con las lineas que esten en el archivo para desplegarla de mejor manera
        //txtProblema.setText("Problema 1 Problema 1Problema 1Problema 1Problema 1Problema 1Problema 1 loremsadjklasjdkas Problema 1 Problema 1Problema 1Problema 1Problema 1Problema 1Problema 1 loremsadjklasjdkas Problema 1 Problema 1Problema 1Problema 1Problema 1Problema 1Problema 1 loremsadjklasjdkas");
        FlowPane contTxtProblem = new FlowPane();
        contTxtProblem.getChildren().add(txtProblema);
        contentTituloProblema.getChildren().add(txtProblema);
        TextArea txtSolucion = new TextArea();
        contTextArea.getChildren().add(txtSolucion);
        contAccionario.setLeft(contTextArea);
        VBox contBotones = new VBox();
        Button[] btnAcciones = new Button[3];
        btnAcciones[0] = new Button("Compilar");
        btnAcciones[1] = new Button("Ejecutar");
        btnAcciones[2] = new Button("Ayuda");
        contBotones.getChildren().add(btnAcciones[0]);
        contBotones.getChildren().add(btnAcciones[1]);
        contBotones.getChildren().add(btnAcciones[2]);
        contBotones.getChildren().add(new Text("Tiempo"));
        contBotones.getChildren().add(new Text("Errores"));

        contAccionario.setRight(contBotones);
        principal.setTop(contentTituloProblema);
        principal.setCenter(contAccionario);
        Scene scene = new Scene(principal, 800, 600);
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tutor inteligente.");
        primaryStage.show();
        Operaciones op = new Operaciones();
        op.empezarCronometro();
    }
}
