package es.iespuertolacruz.daniel.Exception;

public class AulaException extends Exception {

    private static final long serialVersionUID = 4L;

    public AulaException(String mensaje) {
        super(mensaje);
    }

    public AulaException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }

}
