package es.iespuertolacruz.daniel.Exception;

public class ProfesorException extends Exception {

    private static final long serialVersionUID = 2L;

    public ProfesorException(String mensaje) {
        super(mensaje);
    }

    public ProfesorException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }

}
