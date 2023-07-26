package bl.entities.factory.objects;

public class TipoRepuesto {
    private int idTipoRepuesto;
    private String TipoRepuesto;

    public TipoRepuesto() {
    }

    public TipoRepuesto(String tipoRepuesto) {
        this.TipoRepuesto = tipoRepuesto;
    }

    public int getIdTipoRepuesto() {
        return idTipoRepuesto;
    }

    public void setIdTipoRepuesto(int idTipoRepuesto) {
        this.idTipoRepuesto = idTipoRepuesto;
    }

    public String getTipoRepuesto() {
        return TipoRepuesto;
    }

    public void setTipoRepuesto(String tipoRepuesto) {
        this.TipoRepuesto = tipoRepuesto;
    }

    @Override
    public String toString() {
        return "TipoRepuesto{" +
                "idTipoRepuesto='" + idTipoRepuesto + '\'' +
                ", TipoRepuesto='" + TipoRepuesto + '\'' +
                '}';
    }
}
