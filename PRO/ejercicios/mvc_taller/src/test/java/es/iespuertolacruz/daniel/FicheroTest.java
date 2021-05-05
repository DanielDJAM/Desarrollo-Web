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
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.modelo.Fichero;
public class FicheroTest extends UtilidadesTest{
    Fichero fichero = null;
    String nombreFichero = "Fichero-Usarios.txt";
    Vehiculo vehiculo;
    Vehiculo vehiculo2;
    Vehiculo vehiculo3;

    @BeforeEach
    public void setUp() {
        if (fichero == null) {
            fichero = new Fichero();
        }
        if (vehiculo == null) {
            vehiculo = crearVehiculo("2222BBB", "FORD");
        }
        if (vehiculo2 == null) {
            vehiculo2 = crearVehiculo("4444TTT", "SEAT");
        }
        if (vehiculo3 == null) {
            vehiculo3 = crearVehiculo("3333CCC", "IBIZA");
        }
        crearFichero();
        try {
            fichero.insertar(vehiculo);
            fichero.insertar(vehiculo3);

        } catch (FicheroException e) {
            fail("ERROR en insertar de BeforeEach");
        }
    }

    @Test
    public void insertarTest(){
        try {
            assertEquals(vehiculo, fichero.buscar(vehiculo.getMatricula()), "Ha ocurrido un error al insertar");
        } catch (FicheroException e) {
            fail("ERROR en insertarTest");
        }
    }

    @Test
    public void eliminarVehiculoTest(){
        try {
            fichero.eliminar(vehiculo);
            assertTrue(fichero.buscar(vehiculo.getMatricula()) == null, "Deberia ser True/nulo");
        } catch (FicheroException e) {
            fail("Error al eliminar el vehiculo del fichero.");
        }
    }

    @Test
    public void modificarVehiculoTest(){
        try {
            fichero.modificar(vehiculo3, vehiculo2);
            assertTrue(fichero.obtenerListado().contains(vehiculo2), "Los objetos no son iguales.");
        } catch (FicheroException e) {
            fail("Error al modificar el vehiculo.");
        }
    }

    @Test
    public void buscarTest() {
        try {
            assertEquals(vehiculo , fichero.buscar(vehiculo.getMatricula()), "No se ha encontrado el vehiculo.");
        } catch (FicheroException e) {
            fail("Error en FicheroException");
        }
    }



    @Test
    public void eliminarNoExisteTest() {
        String nombreFichero = "ficheroNoExiste.txt";

        try {
            fichero.eliminar(nombreFichero);
        } catch (FicheroException e) {
            boolean validar = e.getMessage().contains("No se puede eliminar un fichero que no existe");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("El test (eliminarNoExisteTest) ha generado un error no controlado");
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