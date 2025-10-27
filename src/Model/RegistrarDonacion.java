/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USUARIO
 */
public class RegistrarDonacion {
    
    private final String codigoDonacion;
    private final String descripcionDonacion;
    private final String fechaIngreso;
    private int cantidad;
    
    public RegistrarDonacion (String name, String codigoDonacion, String descripcionDonacion, String fechaIngreso, int cantidad) {
        this.codigoDonacion = codigoDonacion;
        this.descripcionDonacion = descripcionDonacion;
        this.fechaIngreso = fechaIngreso;
        this.cantidad = cantidad;
    }

    public String getcodigoDonacion() { return codigoDonacion; }
    
    public String getdescripcionDonacion() { return descripcionDonacion; }
    public String getFechaIngreso() { return fechaIngreso; }
    public int getcantidad() { return cantidad; }
} 
    public void mostrarInfo() {
        System.out.println("Código de Donación: " + codigoDonacion);
        System.out.println("Descripcion de la Donacion: " + descripcionDonacion);
        System.out.println("Fecha de Ingreso: " + fechaIngreso);
        System.out.println("Cantidad: " + cantidad);
    }