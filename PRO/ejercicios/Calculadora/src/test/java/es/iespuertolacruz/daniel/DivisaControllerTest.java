package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.Divisa;
import es.iespuertolacruz.daniel.controlador.DivisaController;
import es.iespuertolacruz.daniel.excepcion.DivisaException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;

public class DivisaControllerTest extends UtilidadesTest {

    Divisa divisa;
    DivisaController divisaController;

    @BeforeEach
    public void setUp() {
        if (divisa == null) {
            divisa = generarDivisa("JPY", 18);
        }
        if (divisaController == null) {
           divisaController = new DivisaController();
        }
        try {
            divisaController.insertar(divisa);
        } catch (DivisaException e) {
            fail("Ha ocurrido un error al insertar la divisa");
        } catch (FicheroException e) {
            fail("Ha ocurrido un error al insertar la divisa");
        }
    }

    @AfterEach
    public void after(){
        try {
            divisaController.eliminar(divisa);
        } catch (DivisaException e) {
            fail("Ha ocurrido un error al eliminar la divisa");
        } catch (FicheroException e) {
            fail("Ha ocurrido un error al eliminar la divisa");
        }
    }

    @Test
    public void validarTest() {
      try {
         divisaController.validarDivisa(divisa);
      } catch (DivisaException e) {
         fail("Se ha producido un error validando la divisa no controlado");
      }
    }

    @Test
    public void existeTest(){
        try {
            assertTrue(divisaController.existe(divisa), "Ha ocurrido un problema en el existeTest");
        } catch (FicheroException e) {
            fail("No existe el objeto");
        }
    }

    
    
}
