package adra.auth;

public class VoluntarioSupervisorAuthStrategy implements AuthStrategy {

    @Override
    public boolean autenticar(String usuario, String password, String extra) {
        // requiere cargo "Supervisor" + contraseña específica
        return "Supervisor".equalsIgnoreCase(extra)
                && password != null
                && password.equals("voluntario123");
    }
}
