package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.Fruta;

public class FrutaTest extends UtilidadesTest {

    Fruta fruta1;
    Fruta fruta2;

    @BeforeEach
    public void setUp(){
        fruta1 = new Fruta("MZN", "Manzana", 0.5f, 0.5f);
        fruta2 = generarfruta(AA221, NARANJA, 1f, 1f);
    }

    @AfterEach
    public void after(){
        
    }
    

    @Test
    public void gettersSettersTest(){
        fruta1.setIdentificador("MAZN");
        assertTrue(fruta1.getIdentificador().contains("MAZN"), "Ha ocurrido un error con un getter o setter de la clase fruta.");
        fruta1.setNombre("Manzanaaaa");
        assertTrue(fruta1.getNombre().contains("Manzanaaaa"), "Ha ocurrido un error con un getter o setter de la clase fruta.");
        fruta1.setPrecio(0.2f);
        assertTrue(fruta1.getPrecio() == 0.2f, "Ha ocurrido un error con un getter o setter de la clase fruta.");
        fruta1.setCoste(0.7f);
        assertTrue(fruta1.getCoste() == 0.7f, "Ha ocurrido un error con un getter o setter de la clase fruta.");
    }

    @Test
    public void beneficioTest(){
        assertTrue(fruta1.beneficio() == 0, "Ha ocurrido un error al calcular el beneficio");
    }
    
}
