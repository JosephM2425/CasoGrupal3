package Enum;

public enum TipoRepuestoEnum {
    MOTOR(1), VOLANTE(2), PUERTA(3), ASIENTO(4), PARABRISAS(5), REPUESTO(0);
    private final int tipoRepuesto;
    TipoRepuestoEnum(int tipoRepuesto) {
        this.tipoRepuesto = tipoRepuesto;
    }
    public int getTipoRepuesto() {
        return tipoRepuesto;
    }
}
