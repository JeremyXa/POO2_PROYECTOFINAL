package strategy;

import java.util.ArrayList;
import java.util.List;
import model.Donacion;

public class BusquedaPorDonante implements BusquedaDonacionStrategy {

    @Override
    public List<Donacion> buscar(List<Donacion> donaciones, String nombreDonante) {
        List<Donacion> res = new ArrayList<>();
        if (nombreDonante == null) return res;

        for (Donacion d : donaciones) {
            if (d.getDonante().getNombre().equalsIgnoreCase(nombreDonante)) {
                res.add(d);
            }
        }s
        return res;
    }
}
