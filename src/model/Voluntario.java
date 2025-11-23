package model;

public class Voluntario {
    private String codigo;
    private String nombreCompleto;
    private String telefono;
    private String dni;
    private int edad;
    private String correo;

    public Voluntario(String codigo, String nombreCompleto, String telefono,
                      String dni, int edad, String correo) {
        this.codigo = codigo;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.dni = dni;
        this.edad = edad;
        this.correo = correo;
    }

    public String getCodigo() { return codigo; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getTelefono() { return telefono; }
    public String getDni() { return dni; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }
}
