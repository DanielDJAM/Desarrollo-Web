package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.DatosPersonales;
import es.iespuertolacruz.daniel.controller.DatosPersonalesController;
import es.iespuertolacruz.daniel.excepcion.BbddException;
import es.iespuertolacruz.daniel.excepcion.DatosPersonalesException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.modelo.DatosPersonalesModelo;

public class DatosPersonalesControllerTest extends UtilidadesTest {
    
    DatosPersonalesController datosPersonalesController;
    DatosPersonalesModelo datosPersonalesModelo;
    DatosPersonales datosPersonales = null;


    @BeforeEach
    public void setUp() {
        if (datosPersonalesController == null) {
            try {
                datosPersonalesController = new DatosPersonalesController();
            } catch (BbddException e) {
                fail("Error en datosPersonalesController BeforeEach");
            } catch (FicheroException e) {
                fail(e.getMessage());
            } catch (SQLException e) {
                fail("Error en datosPersonalesController BeforeEach");
            }
        }
/*
        if (datosPersonalesModelo == null) {
            try {
                datosPersonalesModelo = new DatosPersonalesModelo();
            } catch (BbddException e) {
                fail("Error en datosPersonalesModelo BeforeEach");
            } catch (FicheroException e) {
                fail("Error en datosPersonalesModelo BeforeEach");
            } catch (SQLException e) {
                fail("Error en datosPersonalesModelo BeforeEach");
            }
        }*/

        if (datosPersonales == null) {
            datosPersonales = crearDatosPersonales(null, null, null, null, 0);
        }

        try {
            datosPersonalesController.insertar(datosPersonales);
        } catch (DatosPersonalesException e) {
            fail("Error en insertar beforeEach");
        } catch (BbddException e) {
            fail("Error en insertar beforeEach");
        }
    }
    

    @AfterEach
    public void eliminarCuenta() {
        if (datosPersonales != null) {
            try {
                datosPersonalesController.eliminar(datosPersonales);
            } catch (DatosPersonalesException e) {
                fail("Error al eliminar en AfterEach");
            } catch (BbddException e) {
                fail("Error al eliminar en AfterEach");
            }
        }
    }
    

    @Test
    public void buscarTest() {
        try {
            DatosPersonales datosPersonalesEncontrada = datosPersonalesController.buscar(datosPersonales.getDni());
            assertNotNull(datosPersonalesEncontrada, "No se debe obtener un elemento nulo");
            assertEquals(datosPersonales, datosPersonalesEncontrada, "no se ha encontrado al usuario");
        } catch (DatosPersonalesException e) {
            fail("Error al buscar usuario");
        } catch (BbddException e) {
            fail("Error al buscar usuario en la DB");
        }
    }

    @Test
    public void modificarCuentaTest() {
        try{
            DatosPersonales datosPersonalesEncontrada = datosPersonalesController.buscar(datosPersonales.getDni());
            assertNotNull(datosPersonalesEncontrada, "No se debe de obtener un elemento nulo");
            datosPersonalesEncontrada.setNombre("Juan");
            datosPersonalesController.modificar(datosPersonalesEncontrada);
            DatosPersonales cuentaActualziada = datosPersonalesController.buscar(datosPersonalesEncontrada.getDni());
            assertEquals(cuentaActualziada, datosPersonalesEncontrada, "No se ha encontrado lo esperado");
        }catch (Exception e) {
            fail(e.getMessage());
        }
    }
}