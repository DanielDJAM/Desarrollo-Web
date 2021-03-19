package es.iespuertolacruz.daniel.Exception;

public class FicheroException extends Exception {

    private static final long serialVersionUID = 3L;


   public FicheroException(String mensaje) {
      super(mensaje);
   }

   public FicheroException(String mensaje, Exception causa) {
      super(mensaje, causa);
   }
    
}
