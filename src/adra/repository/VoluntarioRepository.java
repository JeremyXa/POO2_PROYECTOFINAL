package adra.repository;

import adra.model.Voluntario;
import java.util.List;

public interface VoluntarioRepository {
    void agregar(Voluntario voluntario);
    List<Voluntario> obtenerTodos();
    void guardarCambios();
}
