package es.iespuertolacruz.daniel.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.daniel.excepcion.PersistenciaException;

public class Bbdd {

    private static final String TABLE = "TABLE";
   private static final String TABLE_NAME= "Censo";

   protected String driver;
   protected String urlConexion;
   protected String usuario;
   protected String password;

   public Bbdd(String driver, String urlConexion, String usuario, String password) throws PersistenciaException {
      this.driver = driver;
      this.urlConexion = urlConexion;
      this.usuario = usuario;
      this.password = password;
      inicializarDdBd();
   }

   private void inicializarDdBd() throws PersistenciaException {
      DatabaseMetaData databaseMetaData;
      Connection connection = null;
      ResultSet resultSet = null;
      ArrayList<String> listaTablas = new ArrayList<>();
      try {
         connection = getConnection();
         databaseMetaData = connection.getMetaData();
         resultSet = databaseMetaData.getTables(null, null, null, new String[] {TABLE});
         while (resultSet.next()) {
            listaTablas.add(resultSet.getString("TABLE_NAME"));
        }
        if (!listaTablas.contains(TABLE_NAME)) {
           //Crear tabla censo
           String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS Censo ("
            + " dni VARCHAR(50) PRIMARY KEY,"
            + "nombre VARCHAR(50),"
            + "fecha VARCHAR(50),"
            + "direccion VARCHAR(50),"
            + "telefono INT(20));";
           update(sqlCrearTabla);
         }

      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error en la inicializacion de la BBDD", e);
      } finally {
         closeConecction(connection, null, resultSet);
      }

   }

   /**
    * Funcion encargada de realizar la conexion con la BBDD
    * @return conexion abierta
    * @throws PersistenciaException
    */
   public Connection getConnection() throws PersistenciaException {
      Connection connection = null;

      try {
         Class.forName(driver);
         if (usuario != null && password != null) {
            connection = DriverManager.getConnection(urlConexion, usuario, password);
         } else {
            connection = DriverManager.getConnection(urlConexion);
         }
      } catch (ClassNotFoundException | SQLException exception) {
         throw new PersistenciaException("No se ha podido estabalecer la conexion", exception);
      }
      
      return connection;
   }

   /**
    * Metodo encargado de realizar las inserciones/modificaciones/eliminacion de la BBDD
    * @param sql con la sentencia
    * @throws PersistenciaException error controlado
    */
   public void update(String sql) throws PersistenciaException {
      PreparedStatement statement = null;
      Connection connection = null;
      try {
         connection= getConnection();
         statement = connection.prepareStatement(sql);
         statement.executeUpdate();
      } catch (SQLException exception) {
         throw new PersistenciaException("Se ha producido un error en la busqueda", exception);
      } finally {
         closeConecction(connection, statement, null);
      }
   }

   /**
    * Metodo encargado de realizar el cierre de la conexion con la BBDD
    * 
    * @param connection contra la BBDD
    * @param statement  de la operacion
    * @param resultSet  resultado
    * @throws PersistenciaException error controlado
    */
   public void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException {
      try {
         if (resultSet != null) {
            resultSet.close();
         }
         if (statement != null) {
            statement.close();
         }
         if (connection != null) {
            connection.close();
         }
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error cerrando la sesion con la BBDD");
      }

   }
    
}
