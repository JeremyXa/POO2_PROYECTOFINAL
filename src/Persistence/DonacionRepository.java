package persistence;

import java.io.IOException;
import java.util.Map;
import model.Donacion;

public interface DonacionRepository {
    Map<String, Donacion> cargarTodas() throws IOException;
    void guardarTodas(Map<String, Donacion> donaciones) throws IOException;
    void guardarNueva(Donacion donacion) throws IOException;
    void eliminar(String codigo) throws IOException;
}
