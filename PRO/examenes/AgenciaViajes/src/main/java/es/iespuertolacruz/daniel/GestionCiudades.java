package es.iespuertolacruz.daniel;

import java.util.ArrayList;

import es.iespuertolacruz.daniel.Exception.LugarException;

public class GestionCiudades {

    ArrayList<Lugar> gestionLugares;

    public void GestionCiudades(){
        gestionLugares = new ArrayList<>();
    }


    public ArrayList<Lugar> getGestionLugares() {
        return this.gestionLugares;
    }

    /**
     * Metodo para añadir un Lugars a la gestionLugares
     * @param Lugars objeto a añadir en la gestionLugares
     * @throws LugarsException
     */

    public void insertar(Lugar lugar) throws LugarException {
        if(!existe(lugar)) {
            gestionLugares.add(lugar);
        }else{
            throw new LugarException("El Lugars que intentas insertar ya existe");
        }
    }

    /**
     * Funcion para comprobar que existe un objeto en la gestionLugares
     * @param Lugar objeto a buscar
     * @return retorna true/false.
     */

    public boolean existe(String nombre){
        return gestionLugares.contains(nombre);
    }

    /**
     * Funcion para comprobar que existe un objeto en la gestionLugares
     * @param Lugar objeto a buscar
     * @return retorna true/false.
     */

    public boolean existe(Lugar lugar){
        return gestionLugares.contains(lugar);
    }

    /**
     * Funcion encargada de eliminar un elemento de la gestionLugares
     * @param Lugars a eliminar
     */

    public void eliminar(Lugar lugar) {
        gestionLugares.remove(lugar);
    }

    /**
     * Funcion encargada de gestionr los elementos de la gestionLugares
     * @return String con todos los elemnetos de la gestionLugares
     */

    public String listar(){
        return gestionLugares.toString();
    }

    
}
