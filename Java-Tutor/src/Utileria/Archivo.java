package Utileria;
import Modelos.EjercicioModel;
import Modelos.EjerciciosModel;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    public static ArrayList<String> contenidoALista(Scanner entrada){
        ArrayList<String> renglon = new ArrayList<>();
        while(entrada.hasNextLine())
        {
            String linea  = entrada.nextLine();
            if(linea != null)
            {
                renglon.add(linea);
            }
        }
        return renglon;
    }

    public static String leerArchivo(String pathName){
        String contenidoARegresar = "";
        try{
            Scanner archivo = new Scanner(new File(pathName));
            ArrayList<String> contenido = Archivo.contenidoALista(archivo);
            for(String renglon:contenido){
                contenidoARegresar += "\n";
                contenidoARegresar += renglon;
            }
        }catch(FileNotFoundException ex){
            System.err.println(ex.getMessage());
        }
        return contenidoARegresar;
    }

    public static String leerResult(String pathName){
        String contenidoARegresar = "";
        try{
            Scanner archivo = new Scanner(new File(pathName));
            ArrayList<String> contenido = Archivo.contenidoALista(archivo);
            int contador = 1;
            for(String renglon:contenido){
                contador++;
                if(contador == 9)
                    contenidoARegresar += renglon;
            }
        }catch(FileNotFoundException ex){
            System.err.println(ex.getMessage());
        }
        return contenidoARegresar;
    }

    public static ArrayList<EjercicioModel> fromJsonToEjercicios(){
        Gson gson = new Gson();
        EjerciciosModel ejercicios = gson.fromJson(leerArchivo("./src/Archivos/Ejercicios.json"), EjerciciosModel.class);
        if(ejercicios == null)
            ejercicios.setEjercicios(null);
        return  ejercicios.getEjercicios();
    }
}