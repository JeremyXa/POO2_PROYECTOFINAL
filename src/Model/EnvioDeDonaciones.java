/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Hernan Grados
 */
public class EnvioDeDonaciones {
    
    private String nombre;
    private String direccion;
    

    public EnvioDeDonaciones(String nombre, String direccion, String responsable, String tipoAyuda) {
        this.nombre = nombre;
        this.direccion = direccion;
        
    }

    // Getters y Setters

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    
    @Override
    public String toString() {
        return "Institución{" +
                ", Nombre='" + nombre + '\'' +
                ", Dirección='" + direccion + '\'' +
                '}';
    }
}
