import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Persona implements Iterable<Persona> {
    private String Nombre;
    private Set<Persona> amigos = new HashSet<>();

    public Persona(String nombre, Persona ... amigos) {
        Nombre = nombre;
        for (Persona amigo:amigos){
            this.amigos.add(amigo);
        }
    }

    public String getNombre() {
        return Nombre;
    }

    public Set<Persona> getAmigos() {
        return amigos;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setAmigos(Set<Persona> amigos) {
        this.amigos = amigos;
    }

    @Override
    public Iterator<Persona> iterator() {
        return amigos.iterator();
    }
}
