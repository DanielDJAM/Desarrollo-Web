package es.iespuertolacruz.daniel;

import java.io.FileWriter;
import java.util.ArrayList;
import es.iespuertolacruz.daniel.Exception.ProfesorException;
import es.iespuertolacruz.daniel.*;

public class Lista {

    ArrayList<Profesor> lista;

    /**
     * Constructor por defecto.
     */

    public Lista(){
        lista = new ArrayList<>();
    }

    /**
     * Metodo para añadir un profesor a la lista
     * @param profesor objeto a añadir en la lista
     * @throws ProfesorException
     */

    public void insertar(Profesor profesor) throws ProfesorException {
        if(!existe(profesor)) {
            lista.add(profesor);
        }else{
            throw new ProfesorException("El profesor que intentas insertar ya existe");
        }
    }

    /**
     * Funcion para comprobar que existe un objeto en la lista
     * @param profesor objeto a buscar
     * @return retorna true/false.
     */

    public boolean existe(Profesor profesor){
        return lista.contains(profesor);
    }

    /**
     * Funcion encargada de eliminar un elemento de la lista
     * @param profesor a eliminar
     */

    public void eliminar(Profesor profesor) {
        lista.remove(profesor);
    }

    /**
     * Funcion encargada de listar los elementos de la lista
     * @return String con todos los elemnetos de la lista
     */

    public String listar(){
        return lista.toString();
    }

    /**
     * Metodo encargado de almacenar la informacion de la lista
     */

    public void almacenarDatos(String nombreFichero) {
        FileWriter myW

    }





}