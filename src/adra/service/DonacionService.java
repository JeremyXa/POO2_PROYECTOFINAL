package adra.service;

import adra.dto.ResultadoOperacion;
import adra.model.Donacion;
import adra.observer.NotificationObserver;
import adra.repository.DonacionRepository;

import java.io.IOException;
import java.util.List;

public class DonacionService {

    private final DonacionRepository donacionRepository;
    private final NotificationObserver observer;

    // === CONSTRUCTOR QUE USA DependencyBuilder ===
    public DonacionService(DonacionRepository donacionRepository,
                           NotificationObserver observer) {
        this.donacionRepository = donacionRepository;
        this.observer = observer;
    }

    // ---------- OPERACIONES PRINCIPALES ----------

    public ResultadoOperacion registrarDonacion(Donacion donacion) {
        try {
            donacionRepository.save(donacion);

            if (observer != null) {
                observer.notificar("Donación registrada: " + donacion.getCodigo());
            }

            return ResultadoOperacion.exito("Donación registrada correctamente.");
        } catch (IOException e) {
            if (observer != null) {
                observer.notificar("Error registrando donación: " + e.getMessage());
            }
            return ResultadoOperacion.error("Error registrando donación: " + e.getMessage());
        }
    }

    public List<Donacion> listarDonaciones() {
        try {
            return donacionRepository.findAll();
        } catch (IOException e) {
            throw new RuntimeException("Error listando donaciones", e);
        }
    }

    public List<Donacion> buscarDonacionesPorCodigo(String codigo) {
        try {
            return donacionRepository.findByCodigo(codigo);
        } catch (IOException e) {
            throw new RuntimeException("Error buscando donaciones por código", e);
        }
    }

    public List<Donacion> buscarDonacionesPorDonante(String donante) {
        try {
            return donacionRepository.findByDonante(donante);
        } catch (IOException e) {
            throw new RuntimeException("Error buscando donaciones por donante", e);
        }
    }
}
