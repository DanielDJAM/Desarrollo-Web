package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.Vehiculo;


/**
 * Unit test for simple App.
 */
public class VehiculoTest extends UtilidadesTest {

    Vehiculo vehiculo = crearVehiculo("2222BBB", "Toyota");
    Vehiculo vehiculo2 = crearVehiculo(null, null);
    
    @Test
    public void validarVehiculo(){
        Vehiculo vehiculo3 = new Vehiculo("3333CCC");
        assertEquals("2222BBB", vehiculo.getMatricula(), "Error al comparar la matricula del vehiculo.");
        assertEquals("Toyota", vehiculo.getMarca(), "Error al comparar la marca del vehiculo.");
        assertEquals(MATRICULA, vehiculo2.getMatricula(), "Error al comparar la matricula del vehiculo.");
        assertEquals(MARCA, vehiculo2.getMarca(), "Error al comparar la marca del vehiculo.");
        assertEquals("3333CCC", vehiculo3.getMatricula(), "Error al comparar la matricula del vehiculo");
    }

    @Test
    public void mostrarVehiculoTest(){
        assertTrue(vehiculo.toString().contains(vehiculo.getMatricula()), "Error al mostrar el vehiculo.");
    }
}
