package adra.core;

import adra.dto.ResultadoOperacion;
import adra.factory.DonacionFactory;
import adra.model.Donacion;
import adra.model.Voluntario;
import adra.service.DonacionService;
import adra.service.EnvioService;
import adra.service.VoluntarioService;

import java.io.IOException;
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

    // ---------- DONACIONES ----------
    public ResultadoOperacion registrarDonacion(String codigo,
                                                String descripcion,
                                                String fechaIngreso,
                                                int cantidad,
                                                String donante) {

        Donacion d = DonacionFactory.crear(codigo, descripcion, fechaIngreso, cantidad, donante);
        return donacionService.registrarDonacion(d);
    }

    public List<Donacion> listarDonaciones() throws IOException {
        return donacionService.listarDonaciones();
    }

    // ---------- ENVÍOS ----------
    public ResultadoOperacion registrarEnvio(List<Donacion> donaciones,
                                             String destinatario,
                                             String destinoEnvio,
                                             String conductor) {
        return envioService.registrarEnvio(donaciones, destinatario, destinoEnvio, conductor);
    }

    // ---------- VOLUNTARIOS ----------
    public ResultadoOperacion registrarVoluntario(String codigo,
                                                  String nombre,
                                                  String telefono,
                                                  String dni,
                                                  int    edad,
                                                  String correo,
                                                  String tarea) {
        Voluntario v = new Voluntario(codigo, nombre, telefono, dni, edad, correo, tarea);
        return voluntarioService.registrarVoluntario(v);
    }
}
