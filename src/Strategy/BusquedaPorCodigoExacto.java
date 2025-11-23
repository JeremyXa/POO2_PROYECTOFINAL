package strategy;

import java.util.ArrayList;
import java.util.List;
import model.Donacion;

public class BusquedaPorCodigoExacto implements BusquedaDonacionStrategy {

    @Override
    public List<Donacion> buscar(List<Donacion> donaciones, String codigo) {
        List<Donacion> res = new ArrayList<>();
        for (Donacion d : donaciones) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                res.add(d);
            }
        }
        return res;
    }
}
