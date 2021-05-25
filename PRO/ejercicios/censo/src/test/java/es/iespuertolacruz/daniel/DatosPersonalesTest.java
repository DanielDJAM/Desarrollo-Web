package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.DatosPersonales;

public class DatosPersonalesTest extends UtilidadesTest{

    DatosPersonales datosPersonales;
    DatosPersonales datosPersonales2;

    @BeforeEach
    public void setUp(){
        if (datosPersonales == null) {
            datosPersonales = crearDatosPersonales(null, null, null, null, 0);
        }
        if (datosPersonales2 == null) {
            datosPersonales2 = new DatosPersonales("123456789", "jorge", "11/11/11", "897465", 546654);
        }
    }

    @Test
    public void gettersYSettersTest(){
        datosPersonales = new DatosPersonales();
        datosPersonales.setDni("987456");
        datosPersonales.setNombre("jnasf");
        datosPersonales.setFecha("45/45/54");
        datosPersonales.setIdDireccion("lkjdfsnfds");
        datosPersonales.setTelefono(897456);

        assertEquals(datosPersonales.getDni(), "987456", "el dni debería ser el mismo pero no");
        assertEquals(datosPersonales.getNombre(), "jnasf", "el nombre debería ser el mismo pero no");
        assertEquals(datosPersonales.getFecha(), "45/45/54", "la fecha debería ser el mismo pero no");
        assertEquals(datosPersonales.getIdDireccion(), "lkjdfsnfds", "la direccion debería ser el mismo pero no");
        assertEquals(datosPersonales.getTelefono(), 897456, "el telefono debería ser el mismo pero no");
    }
    
}
