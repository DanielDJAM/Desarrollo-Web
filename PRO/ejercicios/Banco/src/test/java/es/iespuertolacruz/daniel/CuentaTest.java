package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.Exception.CuentaException;


/**
 * Unit test for simple App.
 */
public class CuentaTest {

    Cuenta cuenta1;
    Cuenta cuenta2;

    @BeforeEach
    public void setUp(){
        cuenta1 = new Cuenta("Cuenta daniel", "123456789", 154.123456, 0.5);
        cuenta2 = crearCuenta();
    }

    @AfterEach
    public void after(){

    }
    
    @Test
    public void ingresarTest(){
        try {
            cuenta1.ingresar(50);
        } catch (CuentaException e) {
            fail("Ha ocurrido un error al ingresar en la cuenta.");
        }
        assertTrue(cuenta1.getSaldo() == 204.123456, "No ha ingresado correctamente.");
    }

    @Test
    public void ingresarErrorTest(){
        try {
            cuenta1.ingresar(0);
        } catch (CuentaException e) {
            assertTrue(e.getMessage().contains("negativa"), "No ha ingresado correctamente.");
        }
    }

    @Test
    public void eliminarTest(){
        try {
            cuenta1.retirar(100);
        } catch (CuentaException e) {
            fail("Ha ocurrido un error al retirar de la cuenta.");
        }
        assertTrue(cuenta1.getSaldo() == 54.123456000000004, "No ha retirado correctamente.");

    }

    @Test
    public void eliminarErrorTest(){
        try {
            cuenta2.retirar(0);
        } catch (CuentaException e) {
            assertTrue(e.getMessage().contains("retirar"));
        }
    }

    @Test
    public void eliminarError2Test(){
        try {
            cuenta2.retirar(5000);
        } catch (CuentaException e) {
            assertTrue(e.getMessage().contains("saldo"));
        }
    }

    @Test
    public void gettersTest(){
        assertTrue(cuenta1.getNombre().equals("Cuenta daniel"), "Ha ocurrido un error en el getter de cuenta");
        assertTrue(cuenta1.getNumero().equals("123456789"), "Ha ocurrido un error en el getter de cuenta");
        assertTrue(cuenta1.getSaldo() == 154.123456, "Ha ocurrido un error en el getter de cuenta");
        assertTrue(cuenta1.getTipoInteres() == 0.5, "Ha ocurrido un error en el getter de cuenta");
    }

    @Test
    public void mensajeError2Test(){
        CuentaException error = new CuentaException("Error critico", new Exception());

        assertTrue(error.toString().contains("critico"));
    }

    private Cuenta crearCuenta(){
        Cuenta cuenta = new Cuenta();
        
        cuenta.setNombre("Cuenta yisus");
        cuenta.setNumero("987654321");
        cuenta.setSaldo(1100.1111);
        cuenta.setTipoInteres(1.2);
        
        return cuenta;
    }
}
