package es.iespuertolacruz.daniel.Exception;

public class LugarException extends Exception {

    private static final long serialVersionUID = 2L;

    /**
     * Constructor por defecto
     * @param mensaje de error
     */

    public LugarException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa
     * @param mensaje mensaje del error
     * @param causa causa del error
     */

    public LugarException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
    
}
