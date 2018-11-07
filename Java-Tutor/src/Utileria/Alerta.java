/**
 * Está clase sirve para crear alertas con
 * ayuda de un constructor
 *
 * @author  Héctor Murillo
 * @version @version
 * @since   2018-12-31
 */


package Utileria;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;

public class Alerta {
    private Alert alert = null;
    public int respuesta = 0;
    public Alerta(String title, String header, String body, Alert.AlertType type){
        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(body);
        alert.showAndWait();
    }
    /*Metodo para usarlo en las ayudas*/
    /*public Alerta(String title, String header, String body, Alert.AlertType type, ArrayList<ButtonType>buttons){
        alert = new Alert(type);
        alert.getButtonTypes().setAll(buttons.get(0),buttons.get(1),buttons.get(2),buttons.get(3));
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == buttons.get(0)){
            //Ayuda 1
            //this.respuesta = 1;
        }else if(result.get() == buttons.get(1)){
            //Ayuda2
            this.respuesta = 2;
        }else if(result.get() ==buttons.get(2)){
            //Ayuda 3
            this.respuesta = 3;
        }else{
            //Cancel
            this.respuesta = -1;
        }
    }*/

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }
}
