package es.iespuertolacruz.daniel.Exception;

public class NotaException extends Exception {

    private static final long serialVersionUID = 3L;

    public NotaException(String mensaje) {
        super(mensaje);
    }

    public NotaException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }

}
