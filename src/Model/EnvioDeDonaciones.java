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
    private String responsable;
    private String tipoAyuda;

    public EnvioDeDonaciones(String nombre, String direccion, String responsable, String tipoAyuda) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.responsable = responsable;
        this.tipoAyuda = tipoAyuda;
    }

    // Getters y Setters

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }

    public String getTipoAyuda() { return tipoAyuda; }
    public void setTipoAyuda(String tipoAyuda) { this.tipoAyuda = tipoAyuda; }

    @Override
    public String toString() {
        return "Institución{" +
                ", Nombre='" + nombre + '\'' +
                ", Dirección='" + direccion + '\'' +
                ", Responsable='" + responsable + '\'' +
                ", TipoAyuda='" + tipoAyuda + '\'' +
                '}';
    }
}
