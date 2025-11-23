package strategy;

import java.util.List;
import model.Donacion;

public interface BusquedaDonacionStrategy {
    List<Donacion> buscar(List<Donacion> donaciones, String criterio);
}
