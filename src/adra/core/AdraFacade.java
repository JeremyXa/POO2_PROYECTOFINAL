package adra.core;

import adra.dto.ResultadoOperacion;
import adra.factory.DonacionFactory;
import adra.model.Donacion;
import adra.model.Voluntario;
import adra.service.DonacionService;
import adra.service.EnvioService;
import adra.service.VoluntarioService;

import java.util.Collections;
import java.util.List;

public class AdraFacade {

    private final DonacionService donacionService;
    private final VoluntarioService voluntarioService;
    private final EnvioService envioService;
    private final DonacionFactory donacionFactory;

    public AdraFacade(DonacionService donacionService,
                      VoluntarioService voluntarioService,
                      EnvioService envioService,
                      DonacionFactory donacionFactory) {
        this.donacionService = donacionService;
        this.voluntarioService = voluntarioService;
        this.envioService = envioService;
        this.donacionFactory = donacionFactory;
    }

    // ==== REGISTRO DE DONACIONES ====

    public ResultadoOperacion registrarDonacion(String donante,
                                                String descripcion,
                                                String fechaIngreso,
                                                int cantidad,
                                                String codigo) {
        Donacion donacion = donacionFactory.crear(donante, descripcion, fechaIngreso, cantidad, codigo);
        return donacionService.guardar(donacion);
    }

    public List<Donacion> buscarDonacionesPorCodigo(String codigo) {
        Donacion d = donacionService.buscarPorCodigo(codigo);
        if (d == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(d);
    }

    public List<Donacion> buscarDonacionesPorDonante(String donante) {
        return donacionService.buscarPorDonante(donante);
    }

    public ResultadoOperacion actualizarDonacion(String codigo,
                                                 String nuevaDescripcion,
                                                 int nuevaCantidad) {
        Donacion existente = donacionService.buscarPorCodigo(codigo);
        if (existente == null) {
            return ResultadoOperacion.error("No existe una donación con ese código.");
        }
        existente.setDescripcion(nuevaDescripcion);
        existente.setCantidad(nuevaCantidad);
        return donacionService.actualizar(existente);
    }

    public ResultadoOperacion eliminarDonacion(String codigo) {
        return donacionService.eliminarPorCodigo(codigo);
    }

    public List<Donacion> obtenerTodasLasDonaciones() {
        return donacionService.obtenerTodas();
    }

    public ResultadoOperacion guardarDonaciones() {
        return donacionService.guardarCambios();
    }

    // ==== VOLUNTARIOS ====

    public ResultadoOperacion registrarVoluntario(String nombreCompleto,
                                                  String codigo,
                                                  String telefono,
                                                  String dni,
                                                  int edad,
                                                  String correo,
                                                  String tarea) {
        Voluntario voluntario = new Voluntario(codigo, nombreCompleto, telefono,
                dni, edad, correo, tarea);
        return voluntarioService.registrarVoluntario(voluntario);
    }

    public ResultadoOperacion guardarVoluntarios() {
        return voluntarioService.guardarCambios();
    }

    // ==== ENVÍOS ====

    public ResultadoOperacion registrarEnvio(String destinatario,
                                             String destino,
                                             String conductor,
                                             List<Donacion> donaciones) {
        return envioService.registrarEnvio(destinatario, destino, conductor, donaciones);
    }
}
