package es.iespuertolacruz.daniel.vista;

import es.iespuertolacruz.daniel.api.Fruta;
import es.iespuertolacruz.daniel.controlador.FrutaController;
import es.iespuertolacruz.daniel.exception.FrutaException;

public class AppFruteria {

    FrutaController frutaController;

    public AppFruteria() {
        frutaController = new FrutaController();
    }

    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }

    public void insertar(Fruta fruta) throws FrutaException {
        frutaController.insertar(fruta);
     }
}
