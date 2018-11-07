package Modelos;

import Utileria.Alerta;
import Utileria.Archivo;
import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;
import javafx.scene.control.Alert;

import javax.tools.*;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class TutorModel_ {
    private Nivel nivelUsuario;
    private long tiempoInicial, tiempoFinal;
    private float duracion;
    private int numCompilaciones,numEjecuciones,numErrores;
    private String logErrores = "";
    private EjercicioModel ejercicioActual;

    public TutorModel_(EjercicioModel ejercicioActual) {
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
