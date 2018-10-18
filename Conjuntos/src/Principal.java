import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try
        {
            Scanner archivoMenu = new Scanner(new File("Menu"));
            Scanner leer = new Scanner(System.in);
            int respuesta = 0;
            do{
                System.out.println("---------Seleccione una opción--------");
                for(String opcion : Archivo.contenidoALista(archivoMenu))
                {
                    System.out.println(opcion);
                }
                    respuesta = leer.nextInt();
                    if(respuesta != 0) {
                        Conjunto.Menu(respuesta);
                        respuesta = -1;
                    }
            }while (respuesta < 0 || respuesta > 14);
        }
        catch(Exception ex)
        {
            System.err.print(ex.getMessage());
        }
    }
}
