package model;

public class TareaVoluntario {
    private Voluntario voluntario;
    private Localidad localidad;
    private String descripcionTarea;

    public TareaVoluntario(Voluntario voluntario, Localidad localidad, String descripcionTarea) {
        this.voluntario = voluntario;
        this.localidad = localidad;
        this.descripcionTarea = descripcionTarea;
    }

    public Voluntario getVoluntario() { return voluntario; }
    public Localidad getLocalidad() { return localidad; }
    public String getDescripcionTarea() { return descripcionTarea; }
}
