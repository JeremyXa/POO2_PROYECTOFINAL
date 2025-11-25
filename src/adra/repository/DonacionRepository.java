package adra.repository;

import adra.model.Donacion;

import java.io.IOException;
import java.util.List;

public interface DonacionRepository {
    void save(Donacion donacion) throws IOException;
    List<Donacion> findAll() throws IOException;
    List<Donacion> findByCodigo(String codigo) throws IOException;
    List<Donacion> findByDonante(String donante) throws IOException;
    void update(Donacion donacion) throws IOException;
    void deleteByCodigo(String codigo) throws IOException;
}
