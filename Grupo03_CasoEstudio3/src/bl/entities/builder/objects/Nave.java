package bl.entities.builder.objects;

public class Nave {
        private String categoria;
        private String marca;
        private String modelo;
        private int anio;
        private String codigoIdentificacion;
        private String color;

        public Nave(String categoria, String marca, String modelo, int anio, String codigoIdentificacion, String color) {
            this.categoria = categoria;
            this.marca = marca;
            this.modelo = modelo;
            this.anio = anio;
            this.codigoIdentificacion = codigoIdentificacion;
            this.color = color;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public int getAnio() {
            return anio;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        public String getCodigoIdentificacion() {
            return codigoIdentificacion;
        }

        public void setCodigoIdentificacion(String codigoIdentificacion) {
            this.codigoIdentificacion = codigoIdentificacion;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }


}
