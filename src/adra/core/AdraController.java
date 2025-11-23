package adra.core;

import adra.auth.AuthStrategy;
import adra.dto.ResultadoOperacion;
import adra.model.Donacion;

import java.util.List;

public class AdraController {

    private final AdraFacade facade;
    private final AuthStrategy registroAuth;
    private final AuthStrategy visualizacionAuth;
    private final AuthStrategy envioAuth;
    private final AuthStrategy supervisorAuth;

    public AdraController(AdraFacade facade,
                          AuthStrategy registroAuth,
                          AuthStrategy visualizacionAuth,
                          AuthStrategy envioAuth,
                          AuthStrategy supervisorAuth) {
        this.facade = facade;
        this.registroAuth = registroAuth;
        this.visualizacionAuth = visualizacionAuth;
        this.envioAuth = envioAuth;
        this.supervisorAuth = supervisorAuth;
    }

    // ==== LOGIN ====

    public ResultadoOperacion loginRegistro(String usuario, String password) {
        boolean ok = registroAuth.autenticar(usuario, password);
        if (ok) {
            return ResultadoOperacion.exito("Acceso concedido a REGISTRO de donaciones.");
        }
        return ResultadoOperacion.error("Credenciales inválidas para REGISTRO.");
    }

    public ResultadoOperacion loginVisualizacion(String usuario, String password) {
        boolean ok = visualizacionAuth.autenticar(usuario, password);
        if (ok) {
            return ResultadoOperacion.exito("Acceso concedido a VISUALIZACIÓN.");
        }
        return ResultadoOperacion.error("Credenciales inválidas para VISUALIZACIÓN.");
    }

    public ResultadoOperacion loginEnvio(String usuario, String password) {
        boolean ok = envioAuth.autenticar(usuario, password);
        if (ok) {
            return ResultadoOperacion.exito("Acceso concedido a ENVÍO.");
        }
        return ResultadoOperacion.error("Credenciales inválidas para ENVÍO.");
    }

    public ResultadoOperacion loginSupervisor(String usuario, String password) {
        boolean ok = supervisorAuth.autenticar(usuario, password);
        if (ok) {
            return ResultadoOperacion.exito("Acceso concedido a REGISTRO DE VOLUNTARIOS.");
        }
        return ResultadoOperacion.error("Credenciales inválidas para REGISTRO DE VOLUNTARIOS.");
    }

    // ==== DONACIONES (llamadas desde Registro / Visualización / Envío) ====

    public ResultadoOperacion registrarDonacion(String donante,
                                                String descripcion,
                                                String fechaIngreso,
                                                int cantidad,
                                                String codigo) {
        return facade.registrarDonacion(donante, descripcion, fechaIngreso, cantidad, codigo);
    }

    public List<Donacion> buscarDonacionesPorCodigo(String codigo) {
        return facade.buscarDonacionesPorCodigo(codigo);
    }

    public List<Donacion> buscarDonacionesPorDonante(String donante) {
        return facade.buscarDonacionesPorDonante(donante);
    }

    public ResultadoOperacion actualizarDonacion(String codigo,
                                                 String descripcion,
                                                 int cantidad) {
        return facade.actualizarDonacion(codigo, descripcion, cantidad);
    }

    public ResultadoOperacion eliminarDonacion(String codigo) {
        return facade.eliminarDonacion(codigo);
    }

    public List<Donacion> obtenerTodasLasDonaciones() {
        return facade.obtenerTodasLasDonaciones();
    }

    public ResultadoOperacion guardarDonaciones() {
        return facade.guardarDonaciones();
    }

    // ==== VOLUNTARIOS ====

    public ResultadoOperacion registrarVoluntario(String nombreCompleto,
                                                  String codigo,
                                                  String telefono,
                                                  String dni,
                                                  int edad,
                                                  String correo,
                                                  String tarea) {
        return facade.registrarVoluntario(nombreCompleto, codigo, telefono, dni, edad, correo, tarea);
    }

    public ResultadoOperacion guardarVoluntarios() {
        return facade.guardarVoluntarios();
    }

    // ==== ENVÍOS ====

    public ResultadoOperacion registrarEnvio(String destinatario,
                                             String destino,
                                             String conductor,
                                             List<Donacion> donaciones) {
        return facade.registrarEnvio(destinatario, destino, conductor, donaciones);
    }
}
