package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Donacion;

public class InventarioSubjectImpl {

    private final List<InventarioObserver> observers = new ArrayList<>();

    public void agregarObserver(InventarioObserver o) {
        observers.add(o);
    }

    public void eliminarObserver(InventarioObserver o) {
        observers.remove(o);
    }

    public void notificar(Map<String, Donacion> inventario) {
        for (InventarioObserver o : observers) {
            o.inventarioActualizado(inventario);
        }
    }
}
