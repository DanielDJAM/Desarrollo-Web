package es.iespuertolacruz.daniel.exception;

public class FicheroException extends Exception{

    private static final long serialVersionUID = 2L;

    /**
     * Constructor con el mensaje personalizado
     * @param mensaje personalizado
     */

    public FicheroException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con el mensaje y excepcion personalizada.
     * @param mensaje
     * @param excepcion
     */

    public FicheroException(String mensaje, Exception excepcion) {
        super(mensaje, excepcion);
    }

}
