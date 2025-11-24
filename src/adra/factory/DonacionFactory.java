package adra.factory;

import adra.model.Donacion;
import adra.model.TipoDonacion;

public class DonacionFactory {

    private DonacionFactory() { }

    // Usa el código (A#, R#, M#) para deducir el tipo
    public static Donacion crear(String codigo,
                                 String descripcion,
                                 String fechaIngreso,
                                 int cantidad,
                                 String donante) {

        TipoDonacion tipo = TipoDonacion.fromCodigoDonacion(codigo);
        return new Donacion(codigo, descripcion, fechaIngreso, cantidad, donante, tipo);
    }

    // Sobrecarga por si en algún momento quieres pasar el tipo explícito
    public static Donacion crear(String codigo,
                                 String descripcion,
                                 String fechaIngreso,
                                 int cantidad,
                                 String donante,
                                 TipoDonacion tipo) {
        return new Donacion(codigo, descripcion, fechaIngreso, cantidad, donante, tipo);
    }
}
