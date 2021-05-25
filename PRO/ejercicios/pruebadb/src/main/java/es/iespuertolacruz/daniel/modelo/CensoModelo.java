package es.iespuertolacruz.daniel.modelo;

import java.sql.SQLException;

import es.iespuertolacruz.daniel.api.Censo;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.excepcion.PersistenciaException;


public class CensoModelo {

    SqliteDb persistencia;

    /**
     * Constructor por defecto de la clase CensoModelo
     * @throws FicheroException
     * @throws SQLException
     */
    public CensoModelo() throws PersistenciaException, FicheroException, SQLException{
        persistencia = new SqliteDb(null, null);
    }

    /**
     * Metodo encargado de realizar la insercion de un censo
     * 
     * @param censo a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Censo censo) throws PersistenciaException {
        persistencia.insertar(censo);
    }

    /**
     * Metodo encargado de realizar la eleminacion de un censo
     * 
     * @param censo a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(String dni) throws PersistenciaException {
        persistencia.eliminar(dni);
    }

    /**
     * Metodo encargado de realizar la modificacion de un censo
     * 
     * @param censo a modificar
     */
    public void modificar(Censo censo) throws PersistenciaException {
        persistencia.update(censo);
    }

    /**
     * Funcion encargada de realizar la busqueda de un censo
     * 
     * @param uid del censo
     * @return Censo a buscar
     * @throws PersistenciaException
     */
    public Censo buscarCenso(Censo censo) throws PersistenciaException {
       return persistencia.obtenerCenso(censo);
       
    }
    
}
