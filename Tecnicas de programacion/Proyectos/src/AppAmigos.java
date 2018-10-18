public class AppAmigos {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Hector",new Persona("Manuel",new Persona("Oscar")));
        /*for (Persona p:persona1) {
            for(Persona pe_ :p.getAmigos()){
                System.out.println(pe_.getNombre());
            }
        }*/
    }
}
