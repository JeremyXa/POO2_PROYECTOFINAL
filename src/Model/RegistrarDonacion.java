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
    
    private String nombre;
    private final String codigoDonacion;
    private final String descripcionDonacion;
    private final String fechaIngreso;

    public RegistrarDonacion (String name, String codigoDonacion, String descripcionDonacion, String fechaIngreso) {
        this.nombre = nombre;
        this.codigoDonacion = codigoDonacion;
        this.descripcionDonacion = descripcionDonacion;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() { return nombre; }
    public String getcodigoDonacion() { return codigoDonacion; }
    public String getdescripcionDonacion() { return descripcionDonacion; }
    public String getFechaIngreso() { return fechaIngreso; }
}       
a