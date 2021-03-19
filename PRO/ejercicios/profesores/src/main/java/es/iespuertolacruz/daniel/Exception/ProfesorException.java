package es.iespuertolacruz.daniel.Exception;

public class ProfesorException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto
     * @param mensaje de error
     */

    public ProfesorException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa
     * @param mensaje mensaje del error
     * @param causa causa del error
     */

    public ProfesorException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }

}