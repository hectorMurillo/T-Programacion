import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    public static ArrayList<String> contenidoALista(Scanner entrada)
    {
        ArrayList<String> amigos = new ArrayList<>();
        while(entrada.hasNextLine())
        {
            String linea  = entrada.nextLine();
            if(linea != null)
            {
                amigos.add(linea.toLowerCase());
            }
        }
        return amigos;
    }
}