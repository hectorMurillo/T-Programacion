import java.util.*;

public class Persona implements Iterable<Persona>{

    String nombre = "";
    Set<Persona> amigos = new HashSet<Persona>();
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Persona> getAmigos() {
        return amigos;
    }

    @Override
    public Iterator<Persona> iterator() {
        return this.amigos.iterator();
    }

    public void agregaAmigo(Persona amigo) {
        this.amigos.add(amigo);
    }
}