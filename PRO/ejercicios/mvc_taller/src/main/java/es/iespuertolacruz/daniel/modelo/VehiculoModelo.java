package es.iespuertolacruz.daniel.modelo;

import java.util.ArrayList;

import es.iespuertolacruz.daniel.api.Vehiculo;
import es.iespuertolacruz.daniel.excepcion.FicheroException;

public class VehiculoModelo {

    Fichero fichero;

    /**
     * Constructor de la clase VehiculoModelo.
     */
    public VehiculoModelo(){
        fichero = new Fichero();
    }

    /**
     * Metodo que inserta un usuario en el fichero/lista.
     * @param vehiculo a insertar.
     * @throws FicheroException
     */
    public void insertar(Vehiculo vehiculo) throws FicheroException {
        fichero.insertar(vehiculo);
    }

    /**
     * Metodo que elimina un usuario del fichero/lista.
     * @param vehiculo a eliminar.
     * @throws FicheroException
     */
    public void eliminar(Vehiculo vehiculo) throws FicheroException{
        fichero.eliminar(vehiculo);
    }

    /**
     * Metodo que modifica un vehiculo con el vehiculo modificado.
     * @param vehiculo a modificar.
     * @param vehiculo2 modificado.
     * @throws FicheroException
     */
    public void modificar(Vehiculo vehiculo, Vehiculo vehiculo2) throws FicheroException {
        fichero.modificar(vehiculo, vehiculo2);
    }

    /**
     * Funcion para buscar un vehiculo y mostrarlo por pantalla.
     * @param vehiculo a buscar.
     * @return un string mostrando los datos del vehiculo. Si no lo encuentra, pone el mensaje por defecto.
     * @throws FicheroException
     */
    public Vehiculo mostrarVehiculo(String matricula) throws FicheroException{
        Vehiculo vehiculo = null;
        vehiculo = fichero.buscar(matricula);
        return vehiculo;
    }

    /**
     * Funcion para listar todos los vehiculos
     * @return devuelve la lista de todos los vehiculos.
     * @throws FicheroException
     */
    public ArrayList<Vehiculo> mostrarTodos() throws FicheroException{
        return fichero.obtenerListado();
    }
}
