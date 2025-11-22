/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

import Structure.TablaHashDonaciones;
import Model.Donacion;
import Structure.FuenteDatosDonaciones;
import java.util.List;

public class SistemaFacade {

    private FuenteDatosDonaciones fuente;

    public SistemaFacade() {
        TablaHashDonaciones tabla = new TablaHashDonaciones();
        this.fuente = new AdaptadorDonacionesTXT(tabla);
    }

    // ---------- LOGIN ----------
    public boolean loginRegistro(String user, String pass) {
        return user.startsWith("R") && pass.endsWith("1");
    }

    public boolean loginVisualizacion(String user, String pass) {
        return user.startsWith("V") && pass.endsWith("2");
    }

    public boolean loginEnvio(String user, String pass) {
        return user.startsWith("E") && pass.endsWith("3");
    }

    // ---------- DONACIONES ----------
    public void registrarDonacion(String codigo, String donante,
                                  String descripcion, String fecha,
                                  int cantidad) {
        Donacion d = DonacionFactory.crear(codigo, donante, descripcion, fecha, cantidad);
        fuente.agregar(d);
    }

    public List<Donacion> obtenerTodasDonaciones() {
        return fuente.listar();
    }

    // aquí más métodos luego para buscar, modificar, eliminar...
}
