package es.iespuertolacruz.daniel.exception;

public class FrutaException extends Exception{

    private static final long serialVersionUID = 3L;

    /**
     * Constructor con el mensaje personalizado
     * @param mensaje personalizado
     */

    public FrutaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con el mensaje y excepcion personalizada.
     * @param mensaje
     * @param excepcion
     */

    public FrutaException(String mensaje, Exception excepcion) {
        super(mensaje, excepcion);
    }

}
