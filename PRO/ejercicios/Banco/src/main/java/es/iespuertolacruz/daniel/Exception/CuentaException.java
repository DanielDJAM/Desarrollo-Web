package es.iespuertolacruz.daniel.Exception;

public class CuentaException extends Exception{

    private static final long serialVersionUID = 1L;

    public CuentaException(String mensaje) {
        super(mensaje);
    }

    public CuentaException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
    
}
