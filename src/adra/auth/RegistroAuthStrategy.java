package adra.auth;

public class RegistroAuthStrategy implements AuthStrategy {

    @Override
    public boolean autenticar(String usuario, String password, String extra) {
        return password != null && password.equals("registro123");
    }
}
