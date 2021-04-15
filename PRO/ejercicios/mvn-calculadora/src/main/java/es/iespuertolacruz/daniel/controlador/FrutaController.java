package es.iespuertolacruz.daniel.controlador;

import es.iespuertolacruz.daniel.api.Fruta;
import es.iespuertolacruz.daniel.exception.FrutaException;
import es.iespuertolacruz.daniel.modelo.FrutaModelo;

/**
 * Controlador de la clase fruta.
 */

public class FrutaController {

    FrutaModelo frutaModelo;

    public FrutaController() {
        frutaModelo = new FrutaModelo();
    }

    /**
     * Metodo encargado de realizar la validacion del objeto fruta
     * 
     * @param fruta a validar
     * @throws FrutaException con el mensaje descriptivo del error.
     */

    public void validarFruta(Fruta fruta) throws FrutaException {
        String mensaje = "";

        if (fruta == null) {
            mensaje += "Se esta intentando validar un objeto vacio. \n";
            throw new FrutaException(mensaje);
        }
        if (fruta.getIdentidicador() == null || fruta.getIdentidicador().isEmpty()) {
            mensaje += "El identificador de la fruta es nulo o vacio \n";
        }
        if (fruta.getNombre() == null || fruta.getNombre().isEmpty()) {
            mensaje += "El nombre de la fruta es nulo o vacio \n";
        }
        if (fruta.getCoste() < 0) {
            mensaje += "El coste de la fruta es 0 o menor \n";
        }
        if (fruta.getPrecio() < 0) {
            mensaje += "El precio de la fruta es 0 o menor \n";
        }
        if (!mensaje.isEmpty()) {
            throw new FrutaException(mensaje);
        }

    }

    public void insertar(String identificador, String nombre, float coste, float precio){
        frutaModelo.insertar(identificador, nombre, coste, precio);
    }

}
