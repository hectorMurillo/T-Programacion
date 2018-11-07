package sample;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    public static ArrayList<String> contenidoALista(Scanner entrada)
    {
        ArrayList<String> lista = new ArrayList<>();
        while(entrada.hasNextLine())
        {
            String linea  = entrada.nextLine();
            if(linea != null)
            {
                lista.add(linea);
            }
        }
        return lista;
    }
}