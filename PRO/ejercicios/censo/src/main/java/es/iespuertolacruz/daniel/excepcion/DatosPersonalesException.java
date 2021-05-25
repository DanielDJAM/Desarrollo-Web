package es.iespuertolacruz.daniel.excepcion;

public class DatosPersonalesException extends Exception{

    private static final long serialVersionUID = 1L;
 
    /**
     * Constructor con el mensaje personalizado
     * 
     * @param mensaje personalizado
     */
    public DatosPersonalesException(String mensaje) {
       super(mensaje);
    }
 
    /**
     * Constructor con el mensaje y la exception que se produce
     * 
     * @param mensaje   de la excepcion
     * @param exception que produce el error
     */
    public DatosPersonalesException(String mensaje, Exception exception) {
       super(mensaje, exception);
    }

}
