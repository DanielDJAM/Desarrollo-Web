package es.iespuertolacruz.daniel.excepcion;

public class DivisaException extends Exception {

    private static final long serialVersionUID = 2L;

   /**
    * Constructor con el mensaje personalizado
    * @param mensaje personalizado
    */
    public DivisaException (String mensaje) {
      super(mensaje);
   }

   /**
    * Constructor con el mensaje y la exception que se produce
    * @param mensaje de la excepcion
    * @param exception que produce el error
    */
   public DivisaException (String mensaje, Exception exception) {
      super(mensaje, exception);
   }
    
}
