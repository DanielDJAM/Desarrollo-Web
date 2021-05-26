package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.Censo;

public class CensoTest {

    Censo censo;

    @BeforeEach
    public void setUp(){
        if (censo == null) {
            censo = new Censo("123456789", "jorge", "11/11/11", "897465", 546654);
        }
    }

    @Test
    public void gettersYSettersTest(){
        censo = new Censo();
        censo.setDni("987456");
        censo.setNombre("jnasf");
        censo.setFecha("45/45/54");
        censo.setDireccion("lkjdfsnfds");
        censo.setTelefono(897456);

        assertEquals(censo.getDni(), "987456", "el dni debería ser el mismo pero no");
        assertEquals(censo.getNombre(), "jnasf", "el nombre debería ser el mismo pero no");
        assertEquals(censo.getFecha(), "45/45/54", "la fecha debería ser el mismo pero no");
        assertEquals(censo.getDireccion(), "lkjdfsnfds", "la direccion debería ser el mismo pero no");
        assertEquals(censo.getTelefono(), 897456, "el telefono debería ser el mismo pero no");
    }
    
}
