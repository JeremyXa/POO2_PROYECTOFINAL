package model;

public class Donacion {

    private String codigo;        // A#, M#, R#...
    private String nombre;        // nombre de la donación
    private String descripcion;
    private int cantidad;
    private String tipo;          // ALIMENTOS / MUEBLES / ROPA
    private Donante donante;

    public Donacion(String codigo, String nombre, String descripcion,
                    int cantidad, String tipo, Donante donante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.donante = donante;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getCantidad() { return cantidad; }
    public String getTipo() { return tipo; }
    public Donante getDonante() { return donante; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
