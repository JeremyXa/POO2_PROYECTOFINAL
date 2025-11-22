/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hernan Grados
 */
public class Donacion {
    private final String codigo;
    private String donante;
    private String descripcion;
    private final String fechaIngreso;
    private int cantidad;
    private final TipoDonacion tipo;

    public Donacion(String codigo, String donante, String descripcion,
                    String fechaIngreso, int cantidad, TipoDonacion tipo) {
        this.codigo = codigo;
        this.donante = donante;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public String getDonante() { return donante; }
    public String getDescripcion() { return descripcion; }
    public String getFechaIngreso() { return fechaIngreso; }
    public int getCantidad() { return cantidad; }
    public TipoDonacion getTipo() { return tipo; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setDonante(String donante) { this.donante = donante; }
}
