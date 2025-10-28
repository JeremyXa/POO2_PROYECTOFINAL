/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.RegistrarDonacion;
import Model.ListaDeDonaciones;

/**
 * Controlador que actúa como intermediario entre la vista y el modelo.
 * Permite gestionar las operaciones sobre las donaciones.
 * 
 * @author USUARIO
 */
public class ControladorDonacion {
    
    private RegistrarDonaciones registro;

    public ControladorDonacion() {
        this.registro = new RegistrarDonaciones();
    }

    // Agregar donación
    public void agregarDonacion(String codigo, String descripcion, String fecha, int cantidad) {
        RegistrarDonacion nueva = new RegistrarDonacion(codigo, descripcion, fecha, cantidad);
        registro.agregarDonacion(nueva);
        System.out.println("✅ Donación agregada con éxito.");
    }

    // Eliminar donación
    public void eliminarDonacion(String codigo) {
        boolean eliminado = registro.eliminarDonacion(codigo);
        if (eliminado) {
            System.out.println("🗑️ Donación eliminada correctamente.");
        } else {
            System.out.println("⚠️ No se encontró la donación con el código: " + codigo);
        }
    }

    // Actualizar donación
    public void actualizarDonacion(String codigo, int nuevaCantidad) {
        boolean actualizado = registro.actualizarDonacion(codigo, nuevaCantidad, null, null);
        if (actualizado) {
            System.out.println("🔄 Donación actualizada correctamente.");
        } else {
            System.out.println("⚠️ No se encontró la donación con el código: " + codigo);
        }
    }

    // Buscar donación
    public void buscarDonacion(String codigo) {
        RegistrarDonacion d = registro.buscarDonacion(codigo);
        if (d != null) {
            System.out.println("🔍 Donación encontrada:");
            d.mostrarInfo();
        } else {
            System.out.println("⚠️ No se encontró la donación con el código: " + codigo);
        }
    }

    // Mostrar todas las donaciones
    public void mostrarDonaciones() {
        registro.mostrarDonaciones();
    }
}
