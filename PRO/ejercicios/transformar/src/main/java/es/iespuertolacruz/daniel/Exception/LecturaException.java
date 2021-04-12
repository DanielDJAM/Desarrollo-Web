package es.iespuertolacruz.daniel.Exception;

public class LecturaException extends Exception{

    private static final long serialVersionUID = 1L;

    public LecturaException(String mensaje) {
        super(mensaje);
    }

    public LecturaException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
    
}
