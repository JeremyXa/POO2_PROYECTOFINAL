package adra.service;

import adra.dto.ResultadoOperacion;
import adra.model.Voluntario;
import adra.repository.VoluntarioRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VoluntarioService {

    private static final Logger logger =
            Logger.getLogger(VoluntarioService.class.getName());

    private final VoluntarioRepository repository;

    public VoluntarioService(VoluntarioRepository repository) {
        this.repository = repository;
    }

    // ============================================================
    //   REGISTRO DE VOLUNTARIOS
    // ============================================================

    /**
     * Versión original que recibe un objeto Voluntario.
     */
    public ResultadoOperacion registrarVoluntario(Voluntario voluntario) {
        if (voluntario == null) {
            return ResultadoOperacion.error("El voluntario no puede ser nulo.");
        }

        try {
            repository.save(voluntario);
            return ResultadoOperacion.exito("Voluntario registrado correctamente.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error registrando voluntario", e);
            return ResultadoOperacion.error(
                    "Error registrando voluntario: " + e.getMessage()
            );
        }
    }

    /**
     * 🔥 Nueva sobrecarga para que el Facade/Controller pueda llamar:
     * registrarVoluntario(String codigo, String nombre, String telefono,
     *                     String dni, int edad, String correo, String tarea)
     */
    public ResultadoOperacion registrarVoluntario(String codigo,
                                                  String nombre,
                                                  String telefono,
                                                  String dni,
                                                  int edad,
                                                  String correo,
                                                  String tarea) {
        Voluntario voluntario = new Voluntario(
                codigo,
                nombre,
                telefono,
                dni,
                edad,
                correo,
                tarea
        );
        return registrarVoluntario(voluntario);
    }

    // ============================================================
    //   CONSULTAS / LISTADOS
    // ============================================================

    public List<Voluntario> listarVoluntarios() {
        try {
            return repository.findAll();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error listando voluntarios", e);
            return new ArrayList<>();
        }
    }

    /**
     * Búsqueda por código (si tu controlador la usa).
     * Implementada filtrando en memoria para no depender
     * de métodos extra en el repositorio.
     */
    public List<Voluntario> buscarPorCodigo(String codigo) {
        String cod = (codigo == null) ? "" : codigo.trim();
        if (cod.isEmpty()) {
            return listarVoluntarios();
        }

        List<Voluntario> resultado = new ArrayList<>();
        for (Voluntario v : listarVoluntarios()) {
            if (v.getCodigo() != null
                    && v.getCodigo().equalsIgnoreCase(cod)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    /**
     * Búsqueda por nombre (si tu controlador la usa).
     */
    public List<Voluntario> buscarPorNombre(String nombre) {
        String nom = (nombre == null) ? "" : nombre.trim().toLowerCase();
        if (nom.isEmpty()) {
            return listarVoluntarios();
        }

        List<Voluntario> resultado = new ArrayList<>();
        for (Voluntario v : listarVoluntarios()) {
            if (v.getNombre() != null
                    && v.getNombre().toLowerCase().contains(nom)) {
                resultado.add(v);
            }
        }
        return resultado;
    }
}
