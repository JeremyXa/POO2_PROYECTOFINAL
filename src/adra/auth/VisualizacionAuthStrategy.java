package adra.auth;

public class VisualizacionAuthStrategy implements AuthStrategy {

    @Override
    public boolean autenticar(String usuario, String password) {
        if (usuario == null || password == null) {
            return false;
        }
        usuario = usuario.trim();
        password = password.trim();
        return !usuario.isEmpty()
                && !password.isEmpty()
                && Character.toUpperCase(usuario.charAt(0)) == 'V'
                && password.endsWith("2");
    }
}
