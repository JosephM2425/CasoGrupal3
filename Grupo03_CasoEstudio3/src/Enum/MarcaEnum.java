package Enum;

public enum MarcaEnum {
    SPACECRAFT(1), ROCKET(2), ESCAPE(3), EXPLORE(4), LAUNCH(5), MARCA(0);
    private final int marca;
    MarcaEnum(int tipoRepuesto) {
        this.marca = tipoRepuesto;
    }
    public int getTipoRepuesto() {
        return marca;
    }
}
