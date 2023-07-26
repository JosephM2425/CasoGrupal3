package bl.entities.factory.objects;

public class MarcaRepuesto {
    private int idMarcaRepuesto;
    private String Marca;

    public MarcaRepuesto() {
    }

    public MarcaRepuesto(String marca) {
        this.Marca = marca;
    }

    public int getIdMarcaRepuesto() {
        return idMarcaRepuesto;
    }

    public void setIdMarcaRepuesto(int idMarcaRepuesto) {
        this.idMarcaRepuesto = idMarcaRepuesto;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        this.Marca = marca;
    }

    @Override
    public String toString() {
        return "MarcaRepuesto{" +
                "idMarcaRepuesto='" + idMarcaRepuesto + '\'' +
                ", Marca='" + Marca + '\'' +
                '}';
    }
}
