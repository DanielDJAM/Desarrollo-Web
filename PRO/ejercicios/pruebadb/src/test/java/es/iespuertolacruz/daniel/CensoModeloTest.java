package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.Censo;
import es.iespuertolacruz.daniel.controller.CensoController;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.excepcion.PersistenciaException;
import es.iespuertolacruz.daniel.modelo.CensoModelo;

public class CensoModeloTest {

    CensoModelo censoModelo;
    Censo censo;
    Censo censo2;

    @BeforeEach
    public void setUp(){
        if (censoModelo == null){
            try {
                censoModelo = new CensoModelo();
            } catch (PersistenciaException e) {
                fail("Error de persistencia de censoModelo en beforeEach");
            } catch (FicheroException e) {
                fail("Error de fichero de censoModelo en beforeEach");
            } catch (SQLException e) {
                fail("Error de sql de censoModelo en beforeEach");
            }
        }

        if (censo == null){
            censo = new Censo("11111111A", "daniel", "11/11/11", "calle1", 111222333);
        }
        if (censo2 == null) {
            censo2 = new Censo("22222222B", "jorge", "22/22/22", "calle2", 777888999);
        }

        try {
            censoModelo.insertar(censo);
        } catch (PersistenciaException e) {
            fail("Error al insertar");
        }
    }

    @AfterEach
    public void setDown(){
        if (censo != null) {
            try {
                censoModelo.eliminar(censo);
            } catch (PersistenciaException e) {
                fail("error en eliminar");
            }
        }

    }

    @Test
    public void buscarTest(){
        try {
            Censo censoEncontrado = censoModelo.buscarCenso(censo.getDni());
            assertNotNull(censoEncontrado, "No se debe obtener un elemento nulo");
            assertEquals(censo, censoEncontrado, "no se ha encontrado al usuario");
        } catch (PersistenciaException e) {
            fail("Error al buscar usuario en la DB");
        }
    }

    @Test
    public void modificarTest(){
        try{
            Censo censoEncontrado = censoModelo.buscarCenso(censo.getDni());
            assertNotNull(censoEncontrado, "No se debe de obtener un elemento nulo");
            censoEncontrado.setNombre("Juan");
            censoModelo.modificar(censoEncontrado);
            Censo cuentaActualziada = censoModelo.buscarCenso(censoEncontrado.getDni());
            assertEquals(cuentaActualziada, censoEncontrado, "No se ha encontrado lo esperado");
        }catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
}
