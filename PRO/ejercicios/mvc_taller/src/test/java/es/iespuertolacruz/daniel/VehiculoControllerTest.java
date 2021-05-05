package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

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
    String nombreFichero = "Fichero-Usuarios.txt";
    Vehiculo vehiculo;
    Vehiculo vehiculo2;
    Vehiculo vehiculo3;
    VehiculoController vehiculoController;
    Fichero fichero;
    VehiculoModelo vehiculoModelo;

    @BeforeEach
    public void setUp() {
        if (vehiculoController == null) {
            vehiculoController = new VehiculoController();
        }
        if (vehiculoModelo == null) {
            vehiculoModelo = new VehiculoModelo();
        }
        if (fichero == null) {
            fichero = new Fichero();
        }
        if (vehiculo == null) {
            vehiculo = crearVehiculo("2222BBB", "FORD");
        }
        if (vehiculo2 == null) {
            vehiculo2 = crearVehiculo(null, null);
        }
        if (vehiculo3 == null) {
            vehiculo3 = crearVehiculo("3333CCC", "IBIZA");
        }
        crearFichero();
        try {
            vehiculoController.insertar(vehiculo);
            vehiculoController.insertar(vehiculo2);
        } catch (VehiculoException e) {
            fail(e.getMessage());
        } catch (FicheroException e) {
            fail("Error en insertar FicheroException BeforeEach");
        }

    }

    @AfterEach
    public void after() {
        eliminar();
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
            vehiculoController.insertar(vehiculo3);
            assertEquals(vehiculo3, vehiculoController.mostrarVehiculo(vehiculo3.getMatricula()),
                    "El vehículo no ha sido insertado correctamente.");
        } catch (FicheroException e) {
            fail("fallo en FicheroException");
        } catch (VehiculoException e) {
            fail("Fallo en vehiculoException");
        }
    }

    @Test
    public void eliminarTest() {
        try {
            vehiculoController.eliminar(vehiculo2);
            assertTrue(vehiculoController.mostrarVehiculo(vehiculo2.getMatricula()) == null,"El vehiculo no se ha borrado correctamente");
        } catch (FicheroException e) {
            fail("fallo en FicheroException");
        } catch (VehiculoException e) {
            fail("Fallo en vehiculoException");
        }
    }

    @Test
    public void modificarVehiculoTest() {
        try {
            vehiculoController.modificar(vehiculo3, vehiculo2);
            assertTrue(vehiculoController.existe(vehiculo2.getMatricula()), "Los objetos no son iguales.");
        } catch (FicheroException e) {
            fail("Error al modificar el vehiculo.");
        }
    }

    @Test
    public void mostrarVehiculoTest() {
        try {
            assertEquals(vehiculo, vehiculoController.mostrarVehiculo(vehiculo.getMatricula()),
                    "No se ha encontrado el vehiculo.");
        } catch (FicheroException e) {
            fail("Error en FicheroException");
        }
    }

    @Test
    public void mostrarTodosTest(){
        try {
            assertTrue(vehiculoController.mostrarTodos().contains(vehiculo));
        } catch (FicheroException e) {
            fail("Error al mostrar todos los vehiculos");
        }
    }

    private void crearFichero() {
        try {
            fichero.crear(nombreFichero, "");
        } catch (FicheroException e) {
            fail("Se ha producido un error en la escritura del fichero");
        }
    }

    private void eliminar() {
        try {
            fichero.eliminar(nombreFichero);
        } catch (FicheroException e) {
            fail("Se ha producido un error en la escritura del fichero");
        }
    }
}
