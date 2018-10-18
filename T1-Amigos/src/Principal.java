import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try
        {
            Scanner archivoAmigos = new Scanner(new File("Amigos"));
            ArrayList<String> amigos = Archivo.contenidoALista(archivoAmigos);
            Grafo grafo = new Grafo(amigos);
            Scanner leer = new Scanner(System.in);
            String respuesta;
            do{
                //Cambiar por teclee una instruccion *1.- Evaluar la instruccion y ejecutar la accion
                //correspondiente si tecleo salir o exit me salgo
                System.out.println("\n¿Qué desea hacer ?\n Agregar amigo (hector - manuel o hector - manuel,murillo) \n " +
                                    "Buscar amigo (hector - 2 o hector)\n Salir (Salir o salir)");
                respuesta = leer.nextLine();
                grafo.menu(respuesta);
            }while( !respuesta.toLowerCase().equals("salir") );
        }
        catch (Exception ex)
        {
            System.err.print("Error "+ ex.getMessage());
        }
    }
}
