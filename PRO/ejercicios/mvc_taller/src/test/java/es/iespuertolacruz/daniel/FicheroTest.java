package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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

    @BeforeEach
    public void setUp() {
        if (fichero == null) {
            fichero = new Fichero();
        }
        if (vehiculo == null) {
            vehiculo = crearVehiculo("2222BBB", "FORD");
        }
        if (vehiculo == null) {
            vehiculo = crearVehiculo("4444TTT", "SEAT");
        }
        crearFichero();
        try {
            fichero.insertar(vehiculo);
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
            fichero.modificar(vehiculo, vehiculo2);
            assertEquals(vehiculo2, vehiculo, "Los objetos no son iguales.");
        } catch (FicheroException e) {
            fail("Error al modificar el vehiculo.");
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

    @Test
    public void noEsDirectorioTest() {
        boolean directorio = fichero.esDirectorio(nombreFichero);
        assertFalse(directorio, "No funciona correctamente dado que es un fichero:" + nombreFichero);
    }

    @Test
    public void esDirectorioTest() {
        String nombreDirectorio = "src";
        boolean directorio = fichero.esDirectorio(nombreDirectorio);
        assertTrue(directorio, "No funciona correctamente dado que es un directorio:" + nombreFichero);
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