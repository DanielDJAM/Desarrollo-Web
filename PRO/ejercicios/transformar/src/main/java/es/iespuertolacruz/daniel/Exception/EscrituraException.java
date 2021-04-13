package es.iespuertolacruz.daniel.Exception;

public class EscrituraException extends Exception {

    private static final long serialVersionUID = 2L;

    public EscrituraException(String mensaje) {
        super(mensaje);
    }

    public EscrituraException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
}
