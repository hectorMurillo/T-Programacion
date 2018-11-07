package Modelos;

public enum Nivel {
    PRINCIPIANTE("principiante"),
    INTERMEDIO("intermedio"),
    AVANZADO("avanzado");

    private String _nivel;

    Nivel(String nivel) {
        this._nivel = nivel;
    }

    public String get_nivel() {
        return this._nivel;
    }
}
