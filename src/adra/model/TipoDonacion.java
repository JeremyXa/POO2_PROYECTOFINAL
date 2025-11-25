package adra.model;

public enum TipoDonacion {
    ALIMENTO("A"),
    ROPA("R"),
    MUEBLE("M");

    private final String prefijoCodigo;

    TipoDonacion(String prefijoCodigo) {
        this.prefijoCodigo = prefijoCodigo;
    }

    public String getPrefijoCodigo() {
        return prefijoCodigo;
    }

    public static TipoDonacion fromCodigoDonacion(String codigo) {
        if (codigo == null || codigo.isEmpty()) return ALIMENTO;
        char c = Character.toUpperCase(codigo.charAt(0));
        switch (c) {
            case 'A': return ALIMENTO;
            case 'R': return ROPA;
            case 'M': return MUEBLE;
            default:  return ALIMENTO;
        }
    }

    public static TipoDonacion fromString(String value) {
        if (value == null) return ALIMENTO;
        String v = value.trim().toUpperCase();
        switch (v) {
            case "ALIMENTO":
            case "ALIMENTOS": return ALIMENTO;
            case "ROPA":      return ROPA;
            case "MUEBLE":
            case "MUEBLES":   return MUEBLE;
            default:          return ALIMENTO;
        }
    }
}
