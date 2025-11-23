package adra.model;

public class Donacion {
    private String codigo;
    private String donante;
    private String descripcion;
    private String fechaIngreso;
    private int cantidad;
    private TipoDonacion tipo;

    public Donacion(String codigo, String donante, String descripcion,
                    String fechaIngreso, int cantidad, TipoDonacion tipo) {
        this.codigo = codigo;
        this.donante = donante;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDonante() {
        return donante;
    }

    public void setDonante(String donante) {
        this.donante = donante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public TipoDonacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoDonacion tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Donacion{" +
                "codigo='" + codigo + '\'' +
                ", donante='" + donante + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", cantidad=" + cantidad +
                ", tipo=" + tipo +
                '}';
    }
}
