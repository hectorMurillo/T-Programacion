package Modelos;

import Utileria.Archivo;

import javax.tools.*;
import java.io.File;
import java.util.Arrays;

public class TutorModel {
    private Nivel nivelUsuario;
    private long tiempoInicial, tiempoFinal;
    private float duracion;
    private int numCompilaciones,numEjecuciones,numErrores;
    private String logErrores = "";
    private EjercicioModel ejercicioActual;

    public TutorModel(EjercicioModel ejercicioActual) {
        this.nivelUsuario = Nivel.PRINCIPIANTE;
        this.tiempoInicial = 0;
        this.tiempoFinal = 0;
        this.duracion = 0;
        this.numCompilaciones = 0;
        this.numEjecuciones = 0;
        this.numErrores = 0;
        this.ejercicioActual = ejercicioActual;
    }

}
