package adra.auth;

public class VoluntarioSupervisorAuthStrategy implements AuthStrategy {

    @Override
    public boolean autenticar(String usuario, String password) {
        if (usuario == null || password == null) {
            return false;
        }
        return "Esteban".equalsIgnoreCase(usuario.trim())
                && "1234".equals(password.trim());
    }
}
