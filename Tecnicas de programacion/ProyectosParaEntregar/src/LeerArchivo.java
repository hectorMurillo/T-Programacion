import java.util.ArrayList;
import java.util.Scanner;

public class LeerArchivo {
    public ArrayList<String> obtenerContenido(Scanner input){
        ArrayList<String> expresiones = new ArrayList<>();

        while(input.hasNextLine()){
            String expresion = input.nextLine();
            expresiones.add(expresion);
        }

        return  expresiones;
    }
}
