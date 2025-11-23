package factory;

import model.Trabajador;
import model.TrabajadorEnvio;
import model.TrabajadorRegistro;
import model.TrabajadorVisualizacion;

public class TrabajadorFactory {

    // user: Rxxxx, Vxxxx, Exxxx
    // pass: termina en 1, 2, 3
    public static Trabajador crearTrabajador(String usuario, String password) {
        if (usuario == null || password == null) return null;

        if (usuario.startsWith("R") && password.endsWith("1")) {
            return new TrabajadorRegistro(usuario, password, "Trabajador registro");
        }
        if (usuario.startsWith("V") && password.endsWith("2")) {
            return new TrabajadorVisualizacion(usuario, password, "Trabajador visualización");
        }
        if (usuario.startsWith("E") && password.endsWith("3")) {
            return new TrabajadorEnvio(usuario, password, "Trabajador envío");
        }
        return null;
    }
}
