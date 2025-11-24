package adra.repository;

import adra.model.Voluntario;

import java.io.IOException;
import java.util.List;

public interface VoluntarioRepository {
    void save(Voluntario voluntario) throws IOException;
    List<Voluntario> findAll() throws IOException;
}
