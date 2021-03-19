package es.iespuertolacruz.daniel;

import java.util.ArrayList;

import es.iespuertolacruz.daniel.Exception.PasajeroException;

public class GestionViajeros {

    ArrayList<Pasajero> gestionPasajeros;

    /**
     * Constructor por defecto
     */

    public void GestionViajeros(){
        gestionPasajeros = new ArrayList<>();
    }


    public ArrayList<Pasajero> getGestionPasajeros() {
        return this.gestionPasajeros;
    }

    /**
     * Metodo para añadir un Pasajeros a la gestionPasajeros
     * @param Pasajeros objeto a añadir en la gestionPasajeros
     * @throws PasajerosException
     */

    public void insertar(Pasajero pasajero) throws PasajeroException {
        if(!existe(pasajero)) {
            gestionPasajeros.add(pasajero);
        }else{
            throw new PasajeroException("El Pasajeros que intentas insertar ya existe");
        }
    }

    /**
     * Funcion para comprobar que existe un objeto en la gestionPasajeros
     * @param Pasajero objeto a buscar
     * @return retorna true/false.
     */

    public boolean existe(String nombre){
        return gestionPasajeros.contains(nombre);
    }

    /**
     * Funcion para comprobar que existe un objeto en la gestionPasajeros
     * @param Pasajero objeto a buscar
     * @return retorna true/false.
     */

    public boolean existe(Pasajero pasajero){
        return gestionPasajeros.contains(pasajero);
    }

    /**
     * Funcion encargada de eliminar un elemento de la gestionPasajeros
     * @param Pasajeros a eliminar
     */

    public void eliminar(Pasajero pasajero) {
        gestionPasajeros.remove(pasajero);
    }

    /**
     * Funcion encargada de gestionr los elementos de la gestionPasajeros
     * @return String con todos los elemnetos de la gestionPasajeros
     */

    public String listar(){
        return gestionPasajeros.toString();
    }
    
}
