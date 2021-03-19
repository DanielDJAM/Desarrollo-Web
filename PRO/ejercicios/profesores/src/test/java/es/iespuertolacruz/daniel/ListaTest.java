package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.Exception.ProfesorException;

public class ListaTest {

    Lista lista;
    Profesor profesor;

    @BeforeEach
    public void setUp() {
        if (lista == null) {
            lista = new Lista();
        }
        profesor = crearProfesor();
        try {
            lista.insertar(profesor);
        } catch (ProfesorException e) {
            fail("Se ha producido un error insertando el profesor");
        }

    }
    
    @AfterEach
    public void after() {
        lista.eliminar(profesor);
    }

    @Test
    public void existeTest(){
        assertTrue(lista.existe(profesor), "El profesor no existe en la lista");
    }

    @Test
    public void listarTest(){
        String listado = lista.listar();
        assertTrue(listado.contains(profesor.toString()), "No existe el elemento en la lista");
    }

    /**
     * Funcion encargada de generar un profesor para test
     * @return objeto de tipo profesor
     */

    private Profesor crearProfesor() {
        return new Profesor("Juan", "Perez", "00000000H");
    }
    
}
