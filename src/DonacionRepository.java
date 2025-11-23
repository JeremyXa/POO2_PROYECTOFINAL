package adra.repository;

import adra.model.Donacion;
import java.util.List;

public interface DonacionRepository {
    void agregar(Donacion donacion);
    void actualizar(Donacion donacion);
    void eliminarPorCodigo(String codigo);
    Donacion buscarPorCodigo(String codigo);
    List<Donacion> buscarPorDonante(String donante);
    List<Donacion> obtenerTodas();
    void guardarCambios();
}
