package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.api.Divisa;

/**
 * Unit test for simple App.
 */
public class DivisaTest extends UtilidadesTest {

    private static final String CODIGO = "EUR";
    private static final double VALOR = 1;

    Divisa euro;
    Divisa dolar;
    Divisa yuan;

    @BeforeEach
    public void setUp(){
        euro = new Divisa(CODIGO, VALOR);
        dolar = new Divisa("USD", 1.21);
        yuan = new Divisa("CNY", 7.84);
    }

    @AfterEach
    public void after(){

    }


    @Test
    public void getterSetterTest(){
        yuan.setCodigo("YUN");
        yuan.setValor(5.55);
        assertTrue(yuan.getCodigo().equals("YUN"), "Error en los getters/setters de Divisa");
        assertTrue(yuan.getValor() == 5.55, "Error en los getters/setters de Divisa");
    }

    @Test
    public void transformarStringToObjectTest() {
        Divisa divisaParseada = null;
        String texto = yuan.toString();
        try {
            divisaParseada = new Divisa(texto);
        } catch (Exception exception) {
            fail("Se ha producido un error realizando la transformacion a objeto:" +exception.getMessage());
        }
        assertNotNull(divisaParseada, "El elemento divisa no puede ser nulo");
        assertEquals("CNY", divisaParseada.getCodigo(), "El codigo obtenido es incorrecto");
        assertEquals(7.84, divisaParseada.getValor(), "El valor obtenido es incorrecto");
    }

    @Test
    public void generarDivisaVacia() {
        Divisa divisa2 = generarDivisa(null, 0);
        assertNotNull( divisa2, "El objeto divisa no se ha generado correctament");
        assertTrue(divisa2.getCodigo().contains(CODIGO), "Los valores del objeto divisa no son los adecuados");
        assertEquals(VALOR, divisa2.getValor(), "Los valores del objeto divisa no son los adecuados");
    }



}
