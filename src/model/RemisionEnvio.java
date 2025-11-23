package model;

import java.time.LocalDate;

public class RemisionEnvio {
    private String destinatario;
    private Localidad localidad;
    private LocalDate fecha;
    private String vehiculo;
    private String conductor;
    private Donacion donacion;

    public RemisionEnvio(String destinatario, Localidad localidad, LocalDate fecha,
                         String vehiculo, String conductor, Donacion donacion) {
        this.destinatario = destinatario;
        this.localidad = localidad;
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.conductor = conductor;
        this.donacion = donacion;
    }

    public String getDestinatario() { return destinatario; }
    public Localidad getLocalidad() { return localidad; }
    public LocalDate getFecha() { return fecha; }
    public String getVehiculo() { return vehiculo; }
    public String getConductor() { return conductor; }
    public Donacion getDonacion() { return donacion; }
}
