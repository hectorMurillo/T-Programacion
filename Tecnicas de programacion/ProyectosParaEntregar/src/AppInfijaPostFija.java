import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppInfijaPostFija {
    public static void main(String[] args)
    {
        try
        {
            Scanner input = new Scanner(new File("formulas"));
            LeerArchivo leerArchivo = new LeerArchivo();
            Proposicion proposicion = new Proposicion();
            TablaDeVerdad tv = new TablaDeVerdad();

            //Pasar de infijo a Posfijo
            for(String prop : leerArchivo.obtenerContenido(input)){
                System.out.print("Infija : "+prop+
                        "\nPostFija : "+proposicion.infijoAPosFijo(prop)+"\n\n");
            }

            input = new Scanner(new File("formulas"));

            //Imprimpo resultado en tabla de verdad y el tipo de la tabla.
            for(String formula : leerArchivo.obtenerContenido(input))
            {
                tv.agregar(formula);
                tv.imprimeTabla();
                tv.imprimirTipo();
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
