package adra.model;

public class Voluntario {
    private String codigo;
    private String nombreCompleto;
    private String telefono;
    private String dni;
    private int edad;
    private String correo;
    private String tarea;

    public Voluntario(String codigo, String nombreCompleto, String telefono,
                      String dni, int edad, String correo, String tarea) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.dni = dni;
        this.edad = edad;
        this.correo = correo;
        this.tarea = tarea;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "codigo='" + codigo + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", tarea='" + tarea + '\'' +
                '}';
    }
}
