import javax.swing.*;
import java.io.*;
import java.util.*;

public class AppAmigos {

    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("-------Bienvenidos a los amigos de mis amigos------");
        try{
            Scanner entrada = new Scanner(new File("amigos"));
            Map<String,Set<String>> amigos = Archivo.getFriendsFromFile(entrada);
            Scanner leer = new Scanner(System.in);
            System.out.println("Nombre a Buscar : ");
            String nombreABuscar = leer.next();
            if(!amigos.containsKey(nombreABuscar)){
                System.out.println("Lo sentimos "+nombreABuscar+" no se encuentra.");
            }else{
                int nivel = 1;
                System.out.println("¿ Qué nivel busca ?");
                nivel = leer.nextInt();
                buscarCoincidencias(amigos,nombreABuscar, nivel);
            }
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null,
                    "error: "+ex.getMessage(),"Error"
                    ,JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void buscarCoincidencias(Map<String,Set<String>> amigos, String nombre,int nivel){
        Set<String> nuevosAmigos = new HashSet<String>();
        Set<String> viejosAmigos = new HashSet<String>();
        nuevosAmigos.add(nombre);
        int distancia = 0;
        while(!nuevosAmigos.isEmpty() && distancia != nivel){
            distancia++;
            viejosAmigos.addAll(nuevosAmigos);
            Set<String> amigosDeNuevosAmigos = new HashSet<String>();
            for(String amigo: nuevosAmigos){
                try{
                    amigosDeNuevosAmigos.addAll(amigos.get(amigo));
                }catch(NullPointerException ex){

                }
            }
            amigosDeNuevosAmigos.removeAll(viejosAmigos);
            nuevosAmigos = amigosDeNuevosAmigos;
            if(nivel == distancia){
                System.out.println("Los amigos de "+nombre+" del nivel "+nivel+" son \n "+ nuevosAmigos);
            }
        }
    }
}
