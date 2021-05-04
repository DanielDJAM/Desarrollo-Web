package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.Vehiculo;
import es.iespuertolacruz.daniel.controller.VehiculoController;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.excepcion.VehiculoException;
import es.iespuertolacruz.daniel.modelo.Fichero;
import es.iespuertolacruz.daniel.modelo.VehiculoModelo;

public class VehiculoControllerTest extends UtilidadesTest {

    private static final String EL_MENSAJE_NO_CONTIENE_LA_CADENA_ESPERADA = "El mensaje no contiene la cadena esperada";
    Vehiculo vehiculo;
    Vehiculo vehiculo2;
    VehiculoController vehiculoController;
    VehiculoModelo vehiculoModelo;
    Fichero fichero;

    @BeforeEach
    public void setUp() {
        if (vehiculoController == null) {
            vehiculoController = new VehiculoController();
        }
        if (vehiculo == null) {
            vehiculo = crearVehiculo("2222BBB", "FORD");
        }
        if (vehiculo2 == null) {
            vehiculo2 = crearVehiculo(null, null);
        }
        try {
            vehiculoController.validar(vehiculo);
            vehiculoController.validar(vehiculo2);

        } catch (VehiculoException e) {
            fail("Error al insertar BeforeEach");
        }
        if (vehiculoModelo == null) {
            vehiculoModelo = new VehiculoModelo();
        }
    }

    @AfterEach
    public void after() {

    }

    @Test
    public void validarNullTest() {
        vehiculo = null;
        try {
            vehiculoController.validar(vehiculo);
        } catch (VehiculoException e) {
            assertTrue(e.getMessage().contains("nulo"), EL_MENSAJE_NO_CONTIENE_LA_CADENA_ESPERADA);
        }
    }

    @Test
    public void validarSinValoresTest() {
        vehiculo2.setMatricula("");
        vehiculo2.setMarca("");
        try {
            vehiculoController.validar(vehiculo2);
        } catch (VehiculoException e) {
            assertTrue(e.getMessage().contains("matricula"), EL_MENSAJE_NO_CONTIENE_LA_CADENA_ESPERADA);
            assertTrue(e.getMessage().contains("marca"), EL_MENSAJE_NO_CONTIENE_LA_CADENA_ESPERADA);
        }

    }

    @Test
    public void insertarTest() {
        try {
            vehiculoController.insertar(vehiculo);
            System.out.println(vehiculo.getMatricula());
            assertEquals(vehiculo, vehiculoController.mostrarVehiculo(vehiculo.getMatricula()), "El vehículo no ha sido insertado correctamente.");
        } catch (FicheroException e) {
            fail(e.getMessage());
        } catch (VehiculoException e) {
            fail("Fallo al insertar");
        }
    }
}
