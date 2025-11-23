package observer;

import java.util.Map;
import model.Donacion;

public interface InventarioObserver {
    void inventarioActualizado(Map<String, Donacion> inventario);
}
