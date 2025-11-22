/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structure;

import Model.Donacion;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TablaHashDonaciones {
    private Hashtable<String, Donacion> tabla = new Hashtable<>();

    public void insertar(Donacion d) {
        tabla.put(d.getCodigo(), d);
    }

    public Donacion buscar(String codigo) {
        return tabla.get(codigo);
    }

    public void eliminar(String codigo) {
        tabla.remove(codigo);
    }

    public Collection<Donacion> obtenerTodas() {
        return tabla.values();
    }
}
