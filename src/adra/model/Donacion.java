package adra.model;

public class Donacion {
    private final String codigo;
    private final String descripcion;
    private final String fechaIngreso;
    private final int cantidad;
    private final String donante;
    private final TipoDonacion tipo;

    public Donacion(String codigo,
                    String descripcion,
                    String fechaIngreso,
                    int cantidad,
                    String donante,
                    TipoDonacion tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.cantidad = cantidad;
        this.donante = donante;
        this.tipo = tipo;
    }

    public String getCodigo()       { return codigo; }
    public String getDescripcion()  { return descripcion; }
    public String getFechaIngreso() { return fechaIngreso; }
    public int    getCantidad()     { return cantidad; }
    public String getDonante()      { return donante; }

    // Alias para compatibilidad con código viejo
    public String getNombreDonante() { return donante; }

    public TipoDonacion getTipo()   { return tipo; }
}
