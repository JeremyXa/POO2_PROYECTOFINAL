/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USUARIO
 */
public class Donacion {
   int id;
   int cantidad;
   String descripcion;
   int fecha_ingreso;

    public Donacion(int id, int cantidad, String descripcion, int Fecha_ingreso) {
        this.id = id;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(int fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
   
}
