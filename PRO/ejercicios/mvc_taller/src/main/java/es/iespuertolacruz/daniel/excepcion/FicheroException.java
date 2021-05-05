package es.iespuertolacruz.daniel.excepcion;

public class FicheroException extends Exception{

    private static final long serialVersionUID = 1L;   
   
   /**
    * Constructor con el mensaje personalizado
    * @param mensaje personalizado
    */
    public FicheroException (String mensaje) {
      super(mensaje);
   }

}
