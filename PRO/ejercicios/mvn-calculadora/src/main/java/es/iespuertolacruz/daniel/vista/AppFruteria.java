package es.iespuertolacruz.daniel.vista;

import es.iespuertolacruz.daniel.controlador.FrutaController;

/**
 * Hello world!
 *
 */
public class AppFruteria {

    FrutaController frutaController;

    public AppFruteria(){
        frutaController = new FrutaController();
    }

    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }

    public void insertar(String identificador, String nombre, float coste, float precio){
        frutaController.insertar(identificador, nombre, coste, precio);
    }
}
