package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.Exception.FicheroException;
import es.iespuertolacruz.daniel.Exception.LugarException;
import es.iespuertolacruz.daniel.Exception.PasajeroException;

/**
 * Unit test for simple App.
 */
public class AgenciaViajesTest {

    FicheroViajero fichero = null;
    Pasajero pasajero;
    Lugar lugar;
    GestionCiudades gestionCiudades = null;
    GestionViajeros gestionViajeros = null;
    String nombreFichero = "ficheroPrueba.txt";
    String mensaFichero = "Esto es una prueba de contenido de fichero";
    String nombrePath = "datos.txt";

    @BeforeEach
    public void setUp() {
        if (fichero == null) {
            fichero = new FicheroViajero();
        }
        if (gestionCiudades == null) {
            gestionCiudades = new GestionCiudades();
        }
        if (gestionViajeros == null) {
            gestionViajeros = new GestionViajeros();
        }
        try {
            gestionCiudades.insertar(lugar);
        } catch (LugarException e) {
            fail("Error al insertar un lugar en la lista gestionCiudades");
        }
        try {
            gestionViajeros.insertar(pasajero);
        } catch (PasajeroException e) {
            fail("Error al insertar un pasajero en la lista gestionViajeros");
        }
        crearFichero();
        crearPasajero();
        crearLugar();

    }

    @AfterEach
    public void after() {
        eliminar();

    }

    @Test
    public void ficheroNoExisteTest() {
        String nombreFichero = "ficheroNoExiste.txt";
        String texto = null;
        try {
            texto = fichero.leer(nombreFichero);
        } catch (FicheroException e) {
            boolean validar = e.getMessage().contains("El fichero a leer no existe");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("El test (ficheroNoExisteTest) ha generado un error no controlado");
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
    public void leerFicheroTest() {
        String texto = null;
        try {
            texto = fichero.leer(nombreFichero);
            boolean validar = texto.contains(mensaFichero);
            assertTrue(validar, "El programa no lee correctamente el fichero");
        } catch (Exception e) {
            fail("Se ha producido un error en el test leer fichero");
        }
    }

    @Test
    public void insertarTest() {

        assertTrue(gestionViajeros.getGestionPasajeros().size() == 1,
                "El tamanio de la lista Coches es incorrecto, se esperaba 1");
        assertTrue(gestionCiudades.getGestionLugares().size() == 1,
                "El tamanio de la lista Clientes es incorrecto se esperaba 1");
    }

    @Test
    public void existeTest() {
        assertTrue(gestionCiudades.existe("12345678A"), "El lugar no existe en la lista");
        assertTrue(gestionViajeros.existe("Londres"), "El viajero no existe en la lista");
    }

    @Test
    public void eliminarTest() {
        gestionCiudades.eliminar(lugar);
        gestionViajeros.eliminar(pasajero);

        assertTrue(gestionCiudades.getGestionLugares().isEmpty(),
                "No se ha eliminado correctamente el elemento de la lista Coches");
        assertTrue(gestionViajeros.getGestionPasajeros().isEmpty(),
                "No se ha eliminado correctamente el elemento de la lista Clientes");

    }

    /**
     * Metodo para crear un fichero pasando la ruta y dos Strings.
     */

    private void crearFichero() {
        try {
            fichero.crear(nombrePath, pasajero.toString(), lugar.toString());
        } catch (FicheroException e) {
            fail("Se ha producido un error en la escritura del fichero");
        }
    }

    /**
     * Metodo par eliminar un fichero
     */

    private void eliminar() {
        try {
            fichero.eliminar(nombreFichero);
        } catch (FicheroException e) {
            fail("Se ha producido un error en la escritura del fichero");
        }
    }
    

    /**
     * Funcion para crear un pasajero
     * 
     * @return devuelve el pasajero
     */

    private Pasajero crearPasajero() {
        return pasajero = new Pasajero("Daniel", "12345678A", "Madrid");
    }

    /**
     * Funcion para crear un lugar
     * 
     * @return devuelve el lugar
     */

    private Lugar crearLugar() {
        return lugar = new Lugar("Londres", "Reino Unido");
    }

}
