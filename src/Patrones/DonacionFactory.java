/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

import Model.Donacion;
import Model.TipoDonacion;

public class DonacionFactory {

    public static Donacion crear(String codigo,
                                 String donante,
                                 String descripcion,
                                 String fecha,
                                 int cantidad) {
        TipoDonacion tipo = TipoDonacion.fromCodigo(codigo);
        return new Donacion(codigo, donante, descripcion, fecha, cantidad, tipo);
    }
}