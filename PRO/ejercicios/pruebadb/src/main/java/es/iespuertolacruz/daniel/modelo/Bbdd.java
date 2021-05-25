package es.iespuertolacruz.daniel.modelo;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.daniel.api.Censo;
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
           //Extraer de fichero las sentencias sql para insertar en la BBDD
           //String sqlInsertarDatos = null;
           //update(sqlInsertarDatos);
           //Insertar datos
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
    * Funcion encargada de obtener un censo
    * 
    * @param identificador del censo
    * @return Objeto censo
    * @throws PersistenciaException
    */
   public Censo buscarCenso(String identificador) throws PersistenciaException {
      Censo censo = null;
      String sql = "SELECT * FROM "+TABLE_NAME+" WHERE dni='"+identificador+"'";
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
         connection = getConnection();
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
         closeConecction(connection, statement, resultSet);
      }
      return lista;
   }


   /**
    * Metodo encargado de realizar la insercion en la BBDD
    * 
    * @param usuario a insertar
    * @throws PersistenciaException
    */
   public void insertar(Censo censo) throws PersistenciaException {
      String sql = "INSERT INTO censo (dni, nombre, fecha, direccion, telefono) VALUES ('"+censo.getDni()+"','"+censo.getNombre()+"','"+censo.getFecha()+"','"
      +censo.getDireccion()+"','"+censo.getTelefono()+"')";
      update(sql);
   }

   /**
    * Metodo encargado de realizar la actualizacion de un censo
    * @param censo a actualizar
    * @throws PersistenciaException error controlado
    */
   public void update(Censo censo) throws PersistenciaException {
      String sql = "UPDATE censo set dni = '" + censo.getDni() + "',  nombre = '" + censo.getNombre()
            + "',  fecha = '" + censo.getFecha() +"', direccion = '" +censo.getDireccion()+"', telefono ='"+censo.getTelefono()+"' WHERE dni = '" + censo.getDni()+"'";
      update(sql);
   }
   /**
    * Metodo encargado de realizar la actualizacion en la BBDD
    * 
    * @param censo a actualizar
    * @throws PersistenciaException
    */
   public void eliminar(String identificador) throws PersistenciaException {
      String sql = "DELETE FROM censo WHERE dni = '" + identificador + "'";
      update(sql);
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
   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException {
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
