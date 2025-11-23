package strategy;

import java.util.ArrayList;
import java.util.List;
import model.Donacion;

public class BusquedaPorTipoCodigo implements BusquedaDonacionStrategy {

    @Override
    public List<Donacion> buscar(List<Donacion> donaciones, String prefijoTipo) {
        List<Donacion> res = new ArrayList<>();
        if (prefijoTipo == null || prefijoTipo.isEmpty()) return res;

        for (Donacion d : donaciones) {
            if (d.getCodigo().toUpperCase().startsWith(prefijoTipo.toUpperCase())) {
                res.add(d);
            }
        }
        return res;
    }
}
