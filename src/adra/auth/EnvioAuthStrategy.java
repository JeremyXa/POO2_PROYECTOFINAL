package adra.auth;

public class EnvioAuthStrategy implements AuthStrategy {

    @Override
    public boolean autenticar(String usuario, String password, String extra) {
        // regla sencilla para el demo
        return password != null && password.equals("envio123");
    }
}
