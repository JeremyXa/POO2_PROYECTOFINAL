/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

public class ListaDeDonaciones {
    
    private ArrayList<RegistrarDonacion> listaDonaciones = new ArrayList<>();

    // Agregar donación
    public void agregarDonacion(RegistrarDonacion d) {
        listaDonaciones.add(d);
    }
    public void mostrarDonaciones() {
        if (listaDonaciones.isEmpty()) {
            System.out.println("No hay donaciones registradas.");
        } else {
            for (RegistrarDonacion d : listaDonaciones) {
                d.mostrarInfo();
                System.out.println("-----------------------");
            }
        }
    }
    // Listar todas
    public ArrayList<RegistrarDonacion> getListaDonaciones() {
        return listaDonaciones;
    }
}
