package adra.factory;

import adra.model.Donacion;
import adra.model.TipoDonacion;

public class DonacionFactory {

    public Donacion crear(String donante, String descripcion,
                          String fechaIngreso, int cantidad, String codigo) {

        TipoDonacion tipo = TipoDonacion.fromCodigo(codigo);
        return new Donacion(codigo, donante, descripcion, fechaIngreso, cantidad, tipo);
    }
}
