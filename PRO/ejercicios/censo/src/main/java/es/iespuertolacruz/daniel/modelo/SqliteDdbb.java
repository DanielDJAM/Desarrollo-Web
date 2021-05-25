package es.iespuertolacruz.daniel.modelo;

import java.sql.SQLException;

import es.iespuertolacruz.daniel.excepcion.BbddException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;

public class SqliteDdbb extends Bbdd{

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL  = "jdbc:sqlite:Censo.db";

    public SqliteDdbb(String usuario, String password) throws BbddException, FicheroException, SQLException  {
        super(DRIVER, URL, usuario, password);
    }

    public SqliteDdbb(String driver, String url, String usuario, String password) throws BbddException, FicheroException, SQLException {
        super(driver, url, usuario, password);
    }
    
}
