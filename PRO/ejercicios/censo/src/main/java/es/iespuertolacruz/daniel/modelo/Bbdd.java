package es.iespuertolacruz.daniel.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import es.iespuertolacruz.daniel.api.DatosPersonales;
import es.iespuertolacruz.daniel.excepcion.BbddException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;

public class Bbdd {

    private static final String SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA = "Se ha producido un error realizando la consulta";
    private static final String TABLE = "TABLE";
    private static final String NOMBRE_TABLAS = "DatosPersonales";
    private String driver;
    private String url;
    private String usuario;
    private String password;
    ArrayList<String> listaTablas;

    public Bbdd(String driver, String url, String usuario, String password)
            throws FicheroException, BbddException, SQLException {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        if (listaTablas == null) {
            listaTablas = new ArrayList<>();
            String[] nombresTablas = NOMBRE_TABLAS.split(",");
            Collections.addAll(listaTablas, nombresTablas);
        }
        init();
    }

    /**
     * Funcion encargada de realizar la conexion con la BBDD
     * 
     * @return la conexion
     * @throws BbddException error controlado
     */
    private Connection getConnection() throws BbddException {
        Connection connection = null;

        try {
            Class.forName(driver);
            if (usuario == null || password == null) {
                connection = DriverManager.getConnection(url);
            } else {
                DriverManager.getConnection(url, usuario, password);
            }
        } catch (Exception exception) {
            throw new BbddException("No se ha podido establecer la coneccion con la BBDD", exception);
        }

        return connection;
    }

    private void init() throws FicheroException, BbddException, SQLException {
        DatabaseMetaData databaseMetaData;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> listaTablas = new ArrayList<>();

        String[] convertir = NOMBRE_TABLAS.split(",");
        List<String> nombreTablas = Arrays.asList(convertir);

        try {
            connection = getConnection();
            databaseMetaData = connection.getMetaData();
            resultSet = databaseMetaData.getTables(null, null, null, new String[] { TABLE });
            while (resultSet.next()) {
                listaTablas.add(resultSet.getString("TABLE_NAME"));
            }
            for (String tabla : nombreTablas) {
                if (!listaTablas.contains(tabla)) {
                    String sqlCrearTabla = new Fichero().leer("resources/sqlitedb/" + tabla + "Crear.sql");
                    actualizar(sqlCrearTabla);
                    String sqlInsertarDatos = new Fichero().leer("resources/sqlitedb/" + tabla + "-insertar.sql");
                    actualizar(sqlInsertarDatos);
                }
            }
        } catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la inicializacion de la BBDD", e);
        } finally {
            closeConnection(connection, null, resultSet);
        }

    }

    // CRUD DatosPersonales

    /**
     * Metodo que permite insertar un datosPersonales en la DB
     * 
     * @param datosPersonales a insertar
     * @throws BbddException controlada
     */
    public void insertar(DatosPersonales datosPersonales) throws BbddException {
        String sql = "INSERT INTO DatosPersonales(dni, nombre, fecha, id_direccion, tlfn) VALUES ('"
                + datosPersonales.getDni() + "', '" + datosPersonales.getNombre() + "', '" + datosPersonales.getFecha()
                + "', '" + datosPersonales.getIdDireccion() + "', '" + datosPersonales.getTelefono() + "')";
        actualizar(sql);
    }

    /**
     * Metodo que permite eliminar un datosPersonales de la DB
     * 
     * @param datosPersonales a eliminar
     * @throws BbddException controlada
     */
    public void eliminar(DatosPersonales datosPersonales) throws BbddException {
        String sql = "DELETE from DatosPersonales WHERE dni ='" + datosPersonales.getDni() + "'";
        actualizar(sql);

    }

    /**
     * Metodo que permite modificar un datosPersonales de la DB
     * 
     * @param datosPersonales a modificar
     * @throws BbddException controlada
     */
    public void modificar(DatosPersonales datosPersonales) throws BbddException {
        String sql = "UPDATE DatosPersonales SET dni = '" + datosPersonales.getDni() + "', nombre = '"
                + datosPersonales.getNombre() + "', fecha = '" + datosPersonales.getFecha() + "', id_direccion = '"
                + datosPersonales.getIdDireccion() + "', tlfn = '" + datosPersonales.getTelefono() + "' WHERE dni = '"
                + datosPersonales.getDni() + "'";
        actualizar(sql);
    }

    // CRUD Direccion

    /**
     * Metodo que permiter insertar una direccion en la DB
     * 
     * @param direccion a insertar
     * @throws BbddException controlada
     *
    public void insertar(Direccion direccion) throws BbddException {
        String sql = "INSERT INTO Direccion(id_direccion, codigoPostal, calle, puerta, provincia, pais) VALUES ('"
                + direccion.getIdDireccion() + "', '" + direccion.getCodigoPostal() + "', '" + direccion.getCalle()
                + "', '" + direccion.getPuerta() + "', '" + direccion.getProvincia() + "', '" + direccion.getPais()
                + "')";
        actualizar(sql);
    }*/

    /**
     * Metodo que permite elimnar una direccion de la DB
     * 
     * @param direccion a eliminar
     * @throws BbddException controlada
     *
    public void eliminar(Direccion direccion) throws BbddException {
        String sql = "DELETE from Direccion WHERE ticket ='" + direccion.getIdDireccion() + "'";
        actualizar(sql);
    }*/

    /**
     * Metodo que permite modificar una direccion e la DB
     * 
     * @param direccion a modificar
     * @throws BbddException controlada
     *
    public void modificar(Direccion direccion) throws BbddException {
        String sql = "UPDATE Direccion SET valor ='" + direccion.getCodigoPostal() + "', '" + direccion.getCalle()
                + "', '" + direccion.getPuerta() + "', '" + direccion.getProvincia() + "', '" + direccion.getPais()
                + "')";
        actualizar(sql);
    }*/

    /**
     * Metodo encargado de realizar la actualizacion de la BBDD
     * 
     * @param sql a ejecutar
     * @throws ExceptionException Error controlado
     */
    private void actualizar(String sql) throws BbddException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql); // actualiza la base de datos con la sentencia sql
        } catch (Exception exception) {
            throw new BbddException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, null);
        }

    }

    /* Funcion que obtiene el listado de todas las datosPersonaless
            * 
            * @return lista total
            * @throws BbddException Error controlado
            */

            private ArrayList<DatosPersonales> obtenerListado(String sql) throws BbddException {
                ArrayList<DatosPersonales> listaHabitantes = new ArrayList<>();
        
                DatosPersonales datosPersonales = null;
                Statement statement = null;
                ResultSet resultSet = null;
                Connection connection = null;
                try {
                    connection = getConnection();
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        String dni = resultSet.getString("dni");
                        String nombre = resultSet.getString("nombre");
                        String fecha = resultSet.getString("fecha");
                        String idDireccion = resultSet.getString("id_direccion");
                        int telefono = resultSet.getInt("tlfn");
                        datosPersonales = new DatosPersonales(dni, nombre, fecha, idDireccion, telefono);
                        listaHabitantes.add(datosPersonales);
                    }
                } catch (Exception exception) {
                    throw new BbddException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
                } finally {
                    closeConnection(connection, statement, resultSet);
                }
                return listaHabitantes;
            }

    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla DatosPersonales
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     * 
     *                       private ArrayList<DatosPersonales>
     *                       obtenerListado(String sql) throws BbddException {
     *                       ArrayList<DatosPersonales> listaDatosPersonaless = new
     *                       ArrayList<>();
     * 
     *                       DatosPersonales datosPersonales = null; Statement
     *                       statement = null; ResultSet resultSet = null; Direccion
     *                       direccion = null; Connection connection = null;
     *                       DireccionModelo direccionModelo = null; try {
     *                       connection = getConnection(); statement =
     *                       connection.createStatement(); resultSet =
     *                       statement.executeQuery(sql); while (resultSet.next()) {
     *                       String dni = resultSet.getString("dni"); String nombre
     *                       = resultSet.getString("nombre"); String fecha =
     *                       resultSet.getString("22/05/21"); String idDireccion =
     *                       resultSet.getString("idDireccion"); int telefono =
     *                       resultSet.getInt("telefono"); direccion =
     *                       direccionModelo.buscarDireccion(idDireccion);
     * 
     *                       datosPersonales = new DatosPersonales(dni, nombre,
     *                       fecha, direccion, telefono);
     *                       listaDatosPersonaless.add(datosPersonales); } } catch
     *                       (Exception exception) { throw new
     *                       BbddException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA,
     *                       exception); } finally { closeConnection(connection,
     *                       statement, resultSet); } return listaDatosPersonaless;
     *                       }
     */
    /**
     * Funcion que realiza la consulta sobre la BBDD y la tabla Direccion
     * 
     * @param sql de la consulta
     * @return lista de resultados
     * @throws BbddException Error controlado
     
    private ArrayList<Direccion> obtenerListadoDireccion(String sql) throws BbddException {
        ArrayList<Direccion> listaDireccion = new ArrayList<>();

        Direccion direccion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String idDireccion = resultSet.getString("idDireccion");
                String codigoPostal = resultSet.getString("codigoPostal");
                String calle = resultSet.getString("calle");
                String puerta = resultSet.getString("puerta");
                String provincia = resultSet.getString("provincia");
                String pais = resultSet.getString("pais");
                direccion = new Direccion(idDireccion, codigoPostal, calle, puerta, provincia, pais);
                listaDireccion.add(direccion);
            }
        } catch (Exception exception) {
            throw new BbddException(SE_HA_PRODUCIDO_UN_ERROR_REALIZANDO_LA_CONSULTA, exception);
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaDireccion;
    }*/

    /**
     * Funcion que obtiene el listado de todas las datosPersonaless
     * 
     * @return lista total
     * @throws BbddException Error controlado
     *
    public ArrayList<DatosPersonales> obtenerListadoDatosPersonales() throws BbddException {
        String sql = "SELECT * FROM DatosPersonales";
        return (ArrayList<DatosPersonales>) (ArrayList<?>) obtenerListados(sql);
    }*/

    /**
     * Funcion que obtiene el listado de todas las direccion
     * 
     * @return lista total
     * @throws BbddException Error controlado
     
    public ArrayList<Direccion> obtenerListadoDireccion() throws BbddException {
        String sql = "SELECT * FROM Direccion";
        return (ArrayList<Direccion>) (ArrayList<?>) obtenerListados(sql);
    }*/

    /**
     * Funcion que obtiene una datosPersonales
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
     */
    public DatosPersonales obtenerDatos(String dni) throws BbddException {
        DatosPersonales datosPersonales = null;
        ArrayList<DatosPersonales> listaDatos = null;
        String sql = "SELECT * FROM DatosPersonales where dni = ";
        sql = sql + "'" + dni + "'";
        listaDatos = obtenerListado(sql);
        if (!listaDatos.isEmpty()) {
            datosPersonales = listaDatos.get(0);
        }
        return datosPersonales;
    }

    /**
     * Funcion que obtiene una datosPersonales
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
     */
    public DatosPersonales obtenerDatos() throws BbddException {
        DatosPersonales datosPersonales = null;
        ArrayList<DatosPersonales> listaDatos = null;
        String sql = "SELECT * FROM DatosPersonales";
        listaDatos = obtenerListado(sql);
        if (!listaDatos.isEmpty()) {
            datosPersonales = listaDatos.get(0);
        }
        return datosPersonales;
    }

    /**
     * Funcion que obtiene una direccion
     * 
     * @param
     * @return lista total
     * @throws BbddException Error controlado
     
    public Direccion obtenerDireccion(String idDireccion) throws BbddException {
        Direccion direccion = null;
        ArrayList<Direccion> lista = null;
        String sql = "SELECT * FROM Direccion where id_direccion = ";
        sql = sql + "'" + idDireccion + "'";
        lista = (ArrayList<Direccion>) (ArrayList<?>) obtenerListados(sql);
        if (!lista.isEmpty()) {
            direccion = lista.get(0);
        }
        return direccion;
    }*/

    private void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws BbddException {
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
        } catch (Exception exception) {
            throw new BbddException("Se ha producido un error cerrando la coneccion", exception);
        }

    }

}
