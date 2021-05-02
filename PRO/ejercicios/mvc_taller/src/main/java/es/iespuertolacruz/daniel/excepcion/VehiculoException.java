package es.iespuertolacruz.daniel.excepcion;

public class VehiculoException extends Exception{

    /**
    * Constructor de la exception con el parametro mensaje
    * @param mensaje descriptivo del error
    */
   public VehiculoException(String mensaje) {
    super(mensaje);
   }
    
}
