import java.util.*;

public class Persona implements Iterable<Persona> {
    private String nombre;
    /*private String apellido;
    private int edad;*/
    private Set<Persona> amigos = new HashSet<>();

    public Persona(String nombre, Persona...amigos){
        this.nombre = nombre;
        /*this.apellido = apellido;
        this.edad = edad;*/
        for (Persona amigo:amigos) {
            this.amigos.add(amigo);
        }
    }
    public Set<Persona> getAmigos() {
        return amigos;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAmigos(Set<Persona> amigos) {
        this.amigos = amigos;
    }

    @Override
    public Iterator<Persona> iterator() {
        return amigos.iterator();
    }

    public static void addFriends(Map<String, Set<String>> amigos, String nombre1, String nombre2){
        Set<String> amigosNuevos;
        nombre1 = nombre1.replaceAll("\\s","");
        nombre2 = nombre2.replaceAll("\\s","");
        if(!amigos.containsKey(nombre1)){
            amigos.put(nombre1,new HashSet<String>());
        }
        amigos.get(nombre1).add(nombre2);
    }
}