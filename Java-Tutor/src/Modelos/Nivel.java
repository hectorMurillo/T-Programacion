package Modelos;

public enum Nivel {
    PRINCIPIANTE(),
    INTERMEDIO(),
    AVANZADO();

    //private String _nivel;

    /*Nivel(String nivel) {
        this._nivel = nivel;
    }*/

    public int get_nivel() {
        int level = 0;
        if(this == PRINCIPIANTE)
            level = 1;
        else if(this == INTERMEDIO)
            level = 2;
        else
            level = 3;
        return level;
    }
}
