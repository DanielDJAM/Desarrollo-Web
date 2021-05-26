package es.iespuertolacruz.daniel.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertolacruz.daniel.api.Censo;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.excepcion.PersistenciaException;

public class CensoModelo {

   private static final String TABLE_NAME= "Censo";

    SqliteDb persistencia;

    /**
     * Constructor por defecto de la clase CensoModelo
     * 
     * @throws FicheroException
     * @throws SQLException
     */
    public CensoModelo() throws PersistenciaException, FicheroException, SQLException {
        persistencia = new SqliteDb(null, null);
    }

    /**
     * Metodo encargado de realizar la insercion de un censo
     * 
     * @param censo a insertar
     * @throws PersistenciaException controlada
     */
    public void insertar(Censo censo) throws PersistenciaException {
        String sql = "INSERT INTO censo (dni, nombre, fecha, direccion, telefono) VALUES ('" + censo.getDni() 
        + "','" + censo.getNombre() 
        + "','" + censo.getFecha() 
        + "','" + censo.getDireccion() 
        + "','" + censo.getTelefono() 
        + "')";
        persistencia.update(sql);
    }

    /**
     * Metodo encargado de realizar la eleminacion de un censo
     * 
     * @param censo a eliminar
     * @throws PersistenciaException controlada
     */
    public void eliminar(Censo censo) throws PersistenciaException {
        String sql = "DELETE FROM censo WHERE dni = '" + censo.getDni() + "'";
        persistencia.update(sql);

    }

    /**
     * Metodo encargado de realizar la modificacion de un censo
     * 
     * @param censo a modificar
     */
    public void modificar(Censo censo) throws PersistenciaException {
        String sql = "UPDATE censo set"
        +" dni = '" + censo.getDni() 
        + "', nombre = '" + censo.getNombre()
        + "',  fecha = '" + censo.getFecha() 
        + "', direccion = '" + censo.getDireccion() 
        + "', telefono ='" + censo.getTelefono() 
        + "' WHERE dni = '" + censo.getDni() 
        + "'";
        persistencia.update(sql);
    }

    /**
     * Funcion encargada de obtener un censo
     * 
     * @param identificador del censo
     * @return Objeto censo
     * @throws PersistenciaException
     */
    public Censo buscarCenso(String identificador) throws PersistenciaException {
        Censo censo = null;
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE dni='" + identificador + "'";
        ArrayList<Censo> lista = buscar(sql);
        if (!lista.isEmpty()) {
            censo = lista.get(0);
        }
        return censo;
    }

    /**
    * Funcion que obtiene todos los usuarios de la BBDD
    * @return lista usuarios
    * @throws PersistenciaException error controlado
    */
    public ArrayList<Censo> buscarTodos() throws PersistenciaException {
        String sql = "SELECT * FROM " + TABLE_NAME;
        return buscar(sql);
    }

    /**
    * Funcion que realiza una consulta sobre una sentencia sql dada
    * @param sql de la consulta
    * @return lista resultados (0..n) Usuasios
    * @throws PersistenciaException error controlado
    */
   private ArrayList<Censo> buscar(String sql) throws PersistenciaException {
    ArrayList<Censo> lista = new ArrayList<>();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;
    try {
       connection = persistencia.getConnection();
       statement = connection.prepareStatement(sql);
       resultSet = statement.executeQuery();

       while(resultSet.next()) {
          Censo censo = new Censo();
          censo.setDni(resultSet.getString("dni"));
          censo.setNombre(resultSet.getString("nombre"));
          censo.setFecha(resultSet.getString("fecha"));
          censo.setDireccion(resultSet.getString("direccion"));
          censo.setTelefono(resultSet.getInt("telefono"));
          lista.add(censo);
       }
    } catch (SQLException exception) {
       throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
    } finally {
       persistencia.closeConecction(connection, statement, resultSet);
    }
    return lista;
 

    }
}
