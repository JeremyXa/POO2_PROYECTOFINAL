package adra.auth;

public class VisualizacionAuthStrategy implements AuthStrategy {

    @Override
    public boolean autenticar(String usuario, String password, String extra) {
        return password != null && password.equals("visual123");
    }
}
