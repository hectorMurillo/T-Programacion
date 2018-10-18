import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Archivo{
    public String leeArchivo(){
        try{
            Scanner entrada = new Scanner(new File("amigos"));
        }catch (FileNotFoundException ex){
            System.out.println("Error!!"+ex.getMessage());
        }
        return null;
    }
}
