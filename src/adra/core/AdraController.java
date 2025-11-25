package adra.core;

import adra.dto.ResultadoOperacion;
import adra.factory.DonacionFactory;
import adra.model.Donacion;
import adra.model.Voluntario;
import adra.service.DonacionService;
import adra.service.EnvioService;
import adra.service.VoluntarioService;

import java.util.List;

public class AdraController {

    private final DonacionService donacionService;
    private final EnvioService envioService;
    private final VoluntarioService voluntarioService;

    public AdraController(DonacionService donacionService,
                          EnvioService envioService,
                          VoluntarioService voluntarioService) {
        this.donacionService = donacionService;
        this.envioService = envioService;
        this.voluntarioService = voluntarioService;
    }

    // ================== DONACIONES ==================

    public ResultadoOperacion registrarDonacion(String codigo,
                                                String descripcion,
                                                String fechaIngreso,
                                                int cantidad,
                                                String donante) {

        Donacion donacion = DonacionFactory.crear(
                codigo, descripcion, fechaIngreso, cantidad, donante
        );
        return donacionService.registrarDonacion(donacion);
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

    /** Usado por la interfaz Envio (código + donante opcionales). */
    public List<Donacion> buscarDonaciones(String codigo, String donante) {
        return donacionService.buscarDonaciones(codigo, donante);
    }

    // ================== ENVÍOS ==================

    public ResultadoOperacion registrarEnvio(List<Donacion> donaciones,
                                             String destinatario,
                                             String destinoEnvio,
                                             String conductor) {
        return envioService.registrarEnvio(donaciones, destinatario, destinoEnvio, conductor);
    }

    // ================== VOLUNTARIOS ==================

    public ResultadoOperacion registrarVoluntario(String codigo,
                                                  String nombre,
                                                  String telefono,
                                                  String dni,
                                                  int edad,
                                                  String correo,
                                                  String tarea) {
        Voluntario v = new Voluntario(codigo, nombre, telefono, dni, edad, correo, tarea);
        return voluntarioService.registrarVoluntario(v);
    }
}
