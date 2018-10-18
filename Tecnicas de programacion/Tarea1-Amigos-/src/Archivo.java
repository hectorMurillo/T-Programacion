import java.util.*;

public class Archivo {
    public static Map<String, Set<String>> getFriendsFromFile (Scanner input){
        Map<String, Set<String>> amigos = new HashMap<String, Set<String>>();
        while (input.hasNextLine()){
            String linea = input.nextLine();
            if(linea.contains("-")){
                Scanner datos = new Scanner(linea);
                String nombreAmigo = datos.next();
                datos.next(); //Saltaría el "-"
                String nombresAmigos = datos.nextLine();
                List<String> nombres = Arrays.asList(nombresAmigos.split("\\s*,\\s*"));
                for (String nombre:nombres) {
                    Persona.addFriends(amigos,nombreAmigo,nombre);
                    Persona.addFriends(amigos,nombre,nombreAmigo);
                }
            }
        }
        return amigos;
    }
}