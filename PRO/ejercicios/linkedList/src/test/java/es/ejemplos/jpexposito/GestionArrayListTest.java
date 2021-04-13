package es.ejemplos.jpexposito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ejemplos.jpexposito.excepcion.FrutaException;

public class GestionArrayListTest {
    private String colorDefecto = "Rojo";
    private int pesoDefecto = 17;

    private Fruta fruta1;
    private Fruta fruta2;

    GestionArrayList gestionArrayList;

    @BeforeEach
    public void setUp() {
        if (gestionArrayList == null) {
            gestionArrayList = new GestionArrayList();
        }
        fruta1 = generarFruta("Verde", 15);
        fruta2 = generarFruta(null, 0);

        gestionArrayList.insertar(fruta1);
        gestionArrayList.insertar(fruta2);

    }

    @AfterEach
    public void after() {
        try {
            if (!gestionArrayList.getLista().isEmpty()) {
                gestionArrayList.eliminar(fruta1);
                gestionArrayList.eliminar(fruta2);
            }

        } catch (FrutaException e) {
            fail("Se producido un error eliminando el contenido de la lista");
        }
    }

    @Test
    public void eliminarElementosTest() {
        
        try {
            gestionArrayList.eliminar(fruta1);
            gestionArrayList.eliminar(fruta2);

        } catch (FrutaException e) {
            fail("La lista no debe de estar vacia, debe de contener elementos");
        }
    }

    @Test
    public void eliminarElementosErrorTest() {
        
        try {
            gestionArrayList.getLista().clear();
            gestionArrayList.eliminar(fruta1);

        } catch (FrutaException e) {
            assertTrue(e.getMessage().contains("vacia"), "lista no debe de estar vacia, debe de contener elementos");
        }
    }

    @Test
    public void obtenerElementosTest() {
        String contenido = gestionArrayList.toString();
        assertTrue(contenido.contains("15"),
         "No se ha obtenido la informacion de un elemento");
         assertTrue(contenido.contains("17"),
         "No se ha obtenido la informacion de un elemento");
    }

    @Test
    public void generarExceptionTest(){
        Exception frutaException = new FrutaException("Mensaje de error", new Exception());
        assertTrue(frutaException.getMessage().contains("Mensaje de error"), "No genera el mensaje esperado");
    }

    /**
     * Funcion que permite generar una fruta por defecto
     * @param color de la fruta
     * @param peso de la fruta
     * @return Fruta con los valores por defecto o indicados
     */
    private Fruta generarFruta(String color, int peso) {
        Fruta fruta = null;

        if (color != null && peso > 0) {
            fruta = new Fruta(color, peso);
        } else {
            fruta = new Fruta();
            fruta.setColor(colorDefecto);
            fruta.setPeso(pesoDefecto);
        }
        return fruta;

    }


}
