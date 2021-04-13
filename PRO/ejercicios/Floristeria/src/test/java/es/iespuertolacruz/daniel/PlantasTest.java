package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlantasTest {

    GestionPlantas plantas;
    Planta planta;
    Planta planta2;

    @BeforeEach
    public void SetUp(){
        if (plantas == null) {
            plantas = new GestionPlantas();
        }

        planta = new Planta("123abc", "Rosa", 15, 2.5f, 3.2f, 60);
        planta2 = new Planta("111aaa", "Tulipan", 10, 1.3f, 2.8f, 30);

        plantas.insertar(planta.getId(), planta);
        plantas.insertar(planta2.getId(), planta2);
    }

    @AfterEach
    public void after(){
        plantas.eliminar(planta.getId(), planta);
        plantas.eliminar(planta2.getId(), planta2);
    }

    @Test
    public void existeTest(){
        assertTrue(plantas.existe(planta.getId()), "No existe la planta en la lista.");
        assertTrue(plantas.existe(planta2.getId()), "No existe la planta en la lista.");
    }

    @Test
    public void eliminarTest(){
        plantas.eliminar(planta.getId(), planta);
        plantas.eliminar(planta2.getId(), planta2);
        assertFalse(plantas.existe(planta.getId()), "No se ha podido eliminar la planta en la lista.");
        assertFalse(plantas.existe(planta2.getId()), "No se ha podido eliminar la planta en la lista.");
    }

    @Test
    public void buscarIDTest(){
        plantas.buscarID(planta.getId(), plantas.getPlantas());
        assertTrue(plantas.existe(planta.getId()) != null, "El objeto a buscar no existe.");
    }

    @Test
    public void buscarIDErrorTest(){
        plantas.buscarID("222bbb", plantas.getPlantas());
        assertFalse(plantas.existe("222bbb") == null, "El objeto a buscar no deberia existir.");
    }
 
    @Test
    public void buscarPlantaTest(){
        plantas.buscarPlanta(planta);
        assertTrue(plantas.existe(planta.getId()) != null, "El objeto a buscar no existe.");
    }

    @Test
    public void buscarPlantaErrorTest(){
        Planta planta3;
        planta3 = new Planta("222bbb", "girasol", 25, 1.9f, 4.8f, 10);
        plantas.buscarPlanta(planta3);
        assertFalse(plantas.existe("222bbb") == null, "El objeto a buscar no deberia existir.");
    }

    @Test
    public void mostrarPlantaTest(){
        String contenido = plantas.mostrarPlanta(planta.getId(), plantas.getPlantas());
        assertTrue(contenido.contains("Rosa"),
         "No se ha obtenido la informacion de un elemento");
        assertTrue(contenido.contains("123abc"),
         "No se ha obtenido la informacion de un elemento");
    }

    @Test
    public void gettersTest(){
        assertTrue(planta.getId().equals("123abc"), "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta.getNombre().equals("Rosa"), "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta.getPrecioBase() == 2.5f, "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta.getPrecioFinal() == 3.2f, "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta.getTamanio() == 15, "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta.getArticulos() == 60, "Ha ocurrido un error con los getters de la clase planta.");
    }

    @Test
    public void settersGettersTest(){
        Planta planta3 = new Planta("", "", 0, 0, 0, 0);
        planta3.setId("333ccc");
        planta3.setNombre("Margarita");
        planta3.setTamanio(15);
        planta3.setPrecioBase(2.5f);
        planta3.setPrecioFinal(3.2f);
        planta3.setArticulos(60);

        assertTrue(planta3.getId().equals("333ccc"), "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta3.getNombre().equals("Margarita"), "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta3.getPrecioBase() == 2.5f, "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta3.getPrecioFinal() == 3.2f, "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta3.getTamanio() == 15, "Ha ocurrido un error con los getters de la clase planta.");
        assertTrue(planta3.getArticulos() == 60, "Ha ocurrido un error con los getters de la clase planta.");
    }

    @Test
    public void equalsTest(){
        assertTrue(planta.equals(planta), "No es igual a planta.");
        assertFalse(planta.equals(null), "Es nula la planta.");
        assertFalse(planta.equals(planta.getClass() != planta.getClass()), "Nombre de la clase.");
        Planta planta3 = planta2;
        assertFalse(planta.getArticulos() == planta3.getArticulos(), "Es el mismo articulo");


    }



}
