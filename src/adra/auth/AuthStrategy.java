package adra.auth;

public interface AuthStrategy {
    boolean autenticar(String usuario, String password);
}
