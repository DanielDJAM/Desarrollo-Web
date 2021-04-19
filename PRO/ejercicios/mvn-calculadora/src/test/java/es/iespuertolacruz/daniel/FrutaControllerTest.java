package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.Fruta;
import es.iespuertolacruz.daniel.controlador.FrutaController;
import es.iespuertolacruz.daniel.exception.FrutaException;


public class FrutaControllerTest {

    FrutaController frutaControl;
    Fruta fruta;

    @BeforeEach
    public void setUp(){
        if (frutaControl == null) {
            frutaControl = new FrutaController();
        }
        fruta = new Fruta("MZN", "Manzana", 0.5f, 0.5f);
        try {
            frutaControl.insertar(fruta);
        } catch (FrutaException e) {
            fail("Ha ocurrido un error al insertar un elemento en la lista");
        }


    }

    @AfterEach
    public void after(){
        
    }
    

    @Test
    public void comprobarTest(){
        assertTrue(true);
    }
    
}
