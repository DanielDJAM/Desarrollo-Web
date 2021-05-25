package es.iespuertolacruz.daniel.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertolacruz.daniel.api.DatosPersonales;
import es.iespuertolacruz.daniel.excepcion.BbddException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;

public class DatosPersonalesModelo {

    SqliteDdbb persistencia;

    /**
     * Constructor por defecto de la clase DatosPersonalesModelo
     * @throws FicheroException
     * @throws SQLException
     */
    public DatosPersonalesModelo() throws BbddException, FicheroException, SQLException{
        persistencia = new SqliteDdbb(null, null);
    }

    /**
     * Metodo encargado de realizar la insercion de un datosPersonales
     * 
     * @param datosPersonales a insertar
     * @throws BbddException controlada
     */
    public void insertar(DatosPersonales datosPersonales) throws BbddException {
        persistencia.insertar(datosPersonales);
    }

    /**
     * Metodo encargado de realizar la eleminacion de un datosPersonales
     * 
     * @param datosPersonales a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(DatosPersonales datosPersonales) throws BbddException {
        persistencia.eliminar(datosPersonales);
    }

    /**
     * Metodo encargado de realizar la modificacion de un datosPersonales
     * 
     * @param datosPersonales a modificar
     */
    public void modificar(DatosPersonales datosPersonales) throws BbddException {
        persistencia.modificar(datosPersonales);
    }

    /**
     * Funcion encargada de realizar la busqueda de un datosPersonales
     * 
     * @param uid del datosPersonales
     * @return DatosPersonales a buscar
     * @throws BbddException
     */
    public DatosPersonales buscarDatosPersonales(String dni) throws BbddException {
       return persistencia.obtenerDatos(dni);
       
    }

    public ArrayList<DatosPersonales> listarTodo(){
        return persistencia.obtenerDatos();
    }
    
}
