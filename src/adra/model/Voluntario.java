package adra.model;

public class Voluntario {

    private final String codigo;
    private final String nombre;
    private final String telefono;
    private final String dni;
    private final int edad;
    private final String correo;
    private final String tarea;

    public Voluntario(String codigo,
                      String nombre,
                      String telefono,
                      String dni,
                      int edad,
                      String correo,
                      String tarea) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.dni = dni;
        this.edad = edad;
        this.correo = correo;
        this.tarea = tarea;
    }

    public String getCodigo()   { return codigo; }
    public String getNombre()   { return nombre; }
    public String getTelefono() { return telefono; }
    public String getDni()      { return dni; }
    public int    getEdad()     { return edad; }
    public String getCorreo()   { return correo; }
    public String getTarea()    { return tarea; }
}
