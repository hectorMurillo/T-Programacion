package Modelos;

public class EjercicioModel {
    private int id_ejercicio;
    private int id_tema;
    private Nivel nivel;
    private String descripcion_problema;
    private boolean ejecucion_correcta;

    public int getId_ejercicio() {
        return id_ejercicio;
    }

    public void setId_ejercicio(int id_ejercicio) {
        this.id_ejercicio = id_ejercicio;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion_problema() {
        return descripcion_problema;
    }

    public void setDescripcion_problema(String descripcion_problema) {
        this.descripcion_problema = descripcion_problema;
    }

    public boolean isEjecucion_correcta() {
        return ejecucion_correcta;
    }

    public void setEjecucion_correcta(boolean ejecucion_correcta) {
        this.ejecucion_correcta = ejecucion_correcta;
    }
}
