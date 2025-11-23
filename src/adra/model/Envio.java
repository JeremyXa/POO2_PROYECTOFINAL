package adra.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Envio {

    private final String id;
    private final LocalDateTime fechaHora;
    private String destinatario;
    private String destino;
    private String conductor;
    private final List<Donacion> donaciones;

    public Envio(String destinatario, String destino, String conductor, List<Donacion> donaciones) {
        this(UUID.randomUUID().toString(), LocalDateTime.now(), destinatario, destino, conductor, donaciones);
    }

    public Envio(String id, LocalDateTime fechaHora, String destinatario,
                 String destino, String conductor, List<Donacion> donaciones) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.destinatario = destinatario;
        this.destino = destino;
        this.conductor = conductor;
        this.donaciones = new ArrayList<>(donaciones != null ? donaciones : Collections.emptyList());
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getDestino() {
        return destino;
    }

    public String getConductor() {
        return conductor;
    }

    public List<Donacion> getDonaciones() {
        return Collections.unmodifiableList(donaciones);
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }
}
