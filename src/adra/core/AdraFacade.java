package adra.core;

import adra.dto.ResultadoOperacion;
import adra.model.Donacion;
import adra.service.DonacionService;
import adra.service.EnvioService;
import adra.service.VoluntarioService;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade principal del sistema ADRA.
 * Envuelve los servicios de donaciones, envíos y voluntarios
 * y expone operaciones simples para las capas superiores (Views, Auth, etc.)
 */
public class AdraFacade {

    private final DonacionService donacionService;
    private final EnvioService envioService;
    private final VoluntarioService voluntarioService;

    public AdraFacade(DonacionService donacionService,
                      EnvioService envioService,
                      VoluntarioService voluntarioService) {
        this.donacionService = donacionService;
        this.envioService = envioService;
        this.voluntarioService = voluntarioService;
    }

    // ===================== DONACIONES =====================

    public ResultadoOperacion registrarDonacion(String codigo,
                                                String descripcion,
                                                String fechaIngreso,
                                                int cantidad,
                                                String donante) {
        return donacionService.registrarDonacion(
                codigo, descripcion, fechaIngreso, cantidad, donante
        );
    }

    public List<Donacion> listarDonaciones() {
        return donacionService.listarDonaciones();
    }

    public List<Donacion> buscarDonacionesPorCodigo(String codigo) {
        return donacionService.buscarDonacionesPorCodigo(codigo);
    }

    public List<Donacion> buscarDonacionesPorDonante(String donante) {
        return donacionService.buscarDonacionesPorDonante(donante);
    }

    /**
     * Búsqueda combinada por código y nombre de donante.
     * Esta es la que suele usar la pantalla de VISUALIZACIÓN.
     */
    public List<Donacion> buscarDonaciones(String codigo, String donante) {
        List<Donacion> todas = donacionService.listarDonaciones();
        List<Donacion> resultado = new ArrayList<>();

        String cod = (codigo == null ? "" : codigo.trim());
        String don = (donante == null ? "" : donante.trim().toLowerCase());

        for (Donacion d : todas) {
            boolean coincide = true;

            // filtro por código (si se ingresó)
            if (!cod.isEmpty()) {
                coincide = d.getCodigo() != null
                        && d.getCodigo().equalsIgnoreCase(cod);
            }

            // filtro por donante (si se ingresó)
            if (coincide && !don.isEmpty()) {
                coincide = d.getDonante() != null
                        && d.getDonante().toLowerCase().contains(don);
            }

            if (coincide) {
                resultado.add(d);
            }
        }

        return resultado;
    }

    // ======================= ENVÍOS =======================

    public ResultadoOperacion registrarEnvio(List<Donacion> donaciones,
                                             String destinatario,
                                             String destinoEnvio,
                                             String conductor) {

        return envioService.registrarEnvio(
                donaciones, destinatario, destinoEnvio, conductor
        );
    }

    // ==================== VOLUNTARIOS ====================

    public ResultadoOperacion registrarVoluntario(String codigo,
                                                  String nombre,
                                                  String telefono,
                                                  String dni,
                                                  int edad,
                                                  String correo,
                                                  String tarea) {
        return voluntarioService.registrarVoluntario(
                codigo, nombre, telefono, dni, edad, correo, tarea
        );
    }
}
