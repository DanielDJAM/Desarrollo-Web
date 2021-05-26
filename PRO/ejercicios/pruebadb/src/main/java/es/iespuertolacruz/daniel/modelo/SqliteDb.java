package es.iespuertolacruz.daniel.modelo;

import java.sql.SQLException;

import es.iespuertolacruz.daniel.excepcion.PersistenciaException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;

public class SqliteDb extends Bbdd{

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL  = "jdbc:sqlite:Censo.db";

    public SqliteDb(String driver, String url, String miembro, String password) throws PersistenciaException, FicheroException, SQLException {
        super(driver, url, miembro, password);
    }

    public SqliteDb(String miembro, String password) throws PersistenciaException, FicheroException, SQLException  {
        super(DRIVER, URL, miembro, password);
     }
}
