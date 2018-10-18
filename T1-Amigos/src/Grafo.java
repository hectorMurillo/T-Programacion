import java.util.*;
import java.util.regex.Pattern;

public class Grafo {

    private HashMap<String, Persona> personas = new HashMap<>();
    private Set<Persona> amigosPasados = new HashSet<>();

    String expAgregaUno = "^[a-zA-Z]+[\\s]+[-]+[\\s][a-zA-Z]+$";
    String expAgregaMuchos = "^[a-zA-Z]+[\\s]+[-]+[\\s]([a-zA-Z]+[,]{1}[a-zA-Z]+)+$";
    String expBuscaNivel = "^[a-zA-Z]+[\\s][-][\\s]([1-9]){1}$";
    String expBusca = "^[a-zA-Z]+$";

    public Grafo(ArrayList<String> elementos) {
        crearGrafo(elementos);
    }

    private void crearGrafo(ArrayList<String> elementos) {
        String[] partes;
        List<String> amigos = new ArrayList<>();
        String amigoPpal = "";
        for (String elemento : elementos) {
            partes = elemento.split("-");
            amigos = Arrays.asList(partes[1].split(","));

            amigoPpal = partes[0];
            agregarNodo(amigoPpal);

            //Por cada elemento
            for (String amigo : amigos) {
                agregarNodo(amigo);
                asignaAmigosMutuamente(amigoPpal, amigo);
            }
        }
    }

    private void asignaAmigosMutuamente(String amigoPpal, String amigo) {
        amigoPpal = amigoPpal.trim();
        amigo = amigo.trim();
        Persona amigo1 = this.personas.get(amigoPpal);
        Persona amigo2 = this.personas.get(amigo);
        amigo1.agregaAmigo(amigo2);
        amigo2.agregaAmigo(amigo1);
    }

    private void agregarNodo(String nombre) {
        nombre = nombre.trim();
        if (!existe(nombre)) {
            this.personas.put(nombre, new Persona(nombre));
        }
    }

    private boolean existe(String nombre) {
        return this.personas.containsKey(nombre.trim()) ? true : false;
    }

    private Persona obtenerPersona(String nombre) {
        return this.personas.get(nombre);
    }

    public void buscar(String nombre, int nivel) {
        int contador = 1;
        Persona persona = this.obtenerPersona(nombre);
        Set<Persona> amigos = persona.getAmigos();
        HashMap<Integer, Set> niveles = new HashMap<Integer, Set>();

        niveles.clear();
        amigosPasados.clear();

        this.amigosPasados.add(persona);

        do {
            Set nivelHasSet = new HashSet<Persona>();

            niveles.put(contador, nivelHasSet);

            if (contador == 1) {
                // Recorremos los amigos
                for (Persona amigo : amigos) {

                    //se checa si ya se recorrió
                    if (this.amigosPasados.add(amigo)) {
                        nivelHasSet.add(amigo);
                    }
                }
            } else {

                //nivel anterior
                Set<Persona> hashNivelAnterior = niveles.get(contador - 1);

                for (Persona personanivel : hashNivelAnterior) {
                    //amigos = personanivel.getAmigos();

                    // recorro los amigos
                    for (Persona amigo : personanivel) {

                        // checo si ya fue filtrado
                        if (this.amigosPasados.add(amigo)) {
                            nivelHasSet.add(amigo);
                        }
                    }
                }
            }
            contador++;
        } while (contador <= nivel);

        System.out.println("Amigos de " + nombre + " del " + nivel + " nivel \n");
        for (Object o : niveles.get(nivel))
        {
            Persona p = (Persona) o;
            System.out.print(p.getNombre()+" ");
        }
    }

    public void menu(String respuesta) {
        respuesta = respuesta.trim();
        if((Pattern.matches(expBusca,respuesta) &&  !respuesta.toLowerCase().equals("salir")))
        {
            buscar(respuesta,1);
        }
        else if(Pattern.matches(expBuscaNivel,respuesta))
        {
            String [] partesRespuesta = respuesta.split("-");
            buscar(partesRespuesta[0],Integer.parseInt(partesRespuesta[1]));
        }
        else if(Pattern.matches(expAgregaUno,respuesta))
        {
            String []partesRespuesta = respuesta.split("-");
            agregarNodo(partesRespuesta[0]);
            agregarNodo(partesRespuesta[1]);
            asignaAmigosMutuamente(partesRespuesta[0],partesRespuesta[1]);
        }
        else if(Pattern.matches(expAgregaMuchos,respuesta))
        {
            String [] partesRespuesta = respuesta.split("-");
            String [] amigosAAgregar = partesRespuesta[1].split(",");
            //Se agrega el amigoPpal
            agregarNodo(partesRespuesta[0]);
            for(int i = 0; i < amigosAAgregar.length ; i++)
            {
                agregarNodo(amigosAAgregar[i]);
                asignaAmigosMutuamente(partesRespuesta[0],amigosAAgregar[i]);
            }

        }
    }
}
