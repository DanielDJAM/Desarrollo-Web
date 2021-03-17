package es.iespuertolacruz.daniel.excepcion;

public class FicheroException extends Exception {

    private static final long serialVersionUID = -5784859412230405974L;
 
 
    public FicheroException(String mensaje) {
       super(mensaje);
    }
 
    public FicheroException(String mensaje, Exception causa) {
       super(mensaje, causa);
    }
    
 }
