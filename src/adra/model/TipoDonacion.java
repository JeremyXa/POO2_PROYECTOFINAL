package adra.model;

public enum TipoDonacion {
    ALIMENTO,
    ROPA,
    MUEBLE,
    DESCONOCIDO;

    public static TipoDonacion fromCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            return DESCONOCIDO;
        }
        char c = Character.toUpperCase(codigo.charAt(0));
        switch (c) {
            case 'A':
                return ALIMENTO;
            case 'R':
                return ROPA;
            case 'M':
                return MUEBLE;
            default:
                return DESCONOCIDO;
        }
    }
}
