package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.Exception.AlumnoException;
import es.iespuertolacruz.daniel.Exception.AulaException;
import es.iespuertolacruz.daniel.Exception.NotaException;
import es.iespuertolacruz.daniel.Exception.ProfesorException;

public class EscuelaTest {

    Gestion gestion;
    Profesor profesor;
    Alumno alumno;
    Nota nota;
    Aula aula;

    @BeforeEach
    public void SetUp(){
        if(gestion == null){
            gestion = new Gestion();
        }
        if (nota == null) {
            try {
                nota = crearNota("Programacion", 8.0f);
                gestion.insertar(nota);
            } catch (NotaException e) {
                fail("Ha ocurrido un error al crear la nota o al insertarla en la lista gestionNotas.");
            }
        }
        if (alumno == null) {
            try {
                alumno = crearAlumno("Daniel", "Alvarez", "11111111A", nota);
                gestion.insertar(alumno);
            } catch (AlumnoException e) {
                fail("Ha ocurrido un error al crear al alumno o al insertarlo en la lista gestionAlumnos.");
            }
        }
        if (aula == null) {
            try {
                aula = crearAula(2, 109, alumno);
                gestion.insertar(aula);
            } catch (AulaException e) {
                fail("Ha ocurrido un error al crear el aula o al insertarla en la lista gestionAulas.");
            }
        }
        if (profesor == null) {
            try {
                profesor = crearProfesor("Jony", "exposito", "22222222B", aula);
                gestion.insertar(profesor);
            } catch (ProfesorException e) {
                fail("Ha ocurrido un error al crear al profesor o al insertarlo en la lista gestionProfesores.");
            }
        }
     }

    @AfterEach
    public void after(){

        try {
            gestion.eliminar(nota);
            gestion.eliminar(alumno);
            gestion.eliminar(aula);
            gestion.eliminar(profesor);
        } 
        catch (NotaException not) {
            fail ("Se ha producido un error eliminando la nota.");
        }
        catch (AlumnoException alu) {
            fail ("Se ha producido un error eliminando al alumno.");
        }
        catch (AulaException aul) {
            fail ("Se ha producido un error eliminando el aula.");
        }
        catch (ProfesorException prof) {
            fail ("Se ha producido un error eliminando un profesor.");
        }

    }

    @Test
    public void existeTest(){
        assertTrue(gestion.existe(alumno), "El alumno no existe en la lista gestionAlumnos.");
        assertTrue(gestion.existe(aula), "El aula no existe en la lista gestionAula.");
        assertTrue(gestion.existe(nota), "La nota no existe en la lista gestionNotas.");
        assertTrue(gestion.existe(profesor), "El profesor no existe en la lista gestionProfesores.");
    }

    @Test
    public void noExisteTest() {
        Nota notaNoExiste;
        Alumno alumnoNoExiste;
        Aula aulaNoExiste;
        Profesor profesorNoExiste;
        try {
            notaNoExiste = crearNota("BBDD", 7.0f);
            alumnoNoExiste = crearAlumno("Juan", "miranda", "12345678A", notaNoExiste);
            aulaNoExiste = crearAula(1, 152, alumnoNoExiste);
            profesorNoExiste = crearProfesor("David", "Vargas", "1234321B", aulaNoExiste);

            assertFalse(gestion.existe(alumnoNoExiste), "El alumno ya existe.");
            assertFalse(gestion.existe(aulaNoExiste), "El aula ya existe.");
            assertFalse(gestion.existe(notaNoExiste), "La nota ya existe");
            assertFalse(gestion.existe(profesorNoExiste), "El profesor ya existe.");


        } 
        catch (NotaException not) {
            fail ("Se ha producido un error generando la nota.");
        }
        catch (AlumnoException alu) {
            fail ("Se ha producido un error generando al alumno.");
        }
        catch (AulaException aul) {
            fail ("Se ha producido un error generando el aula.");
        }
        catch (ProfesorException prof) {
            fail ("Se ha producido un error generando un profesor.");
        }
    }

    @Test
    public void buscarNotaErrorTest(){
        assertNull(gestion.buscarNota("11111111Z"), "No se ha encontrado ningún resultado");
    }

    @Test
    public void buscarNotaTest(){
        assertNotNull(gestion.buscarNota("11111111A"), "Se ha encontrado las notas del alumno");
    }

    @Test
    public void eliminarTest() {

        assertTrue(gestion.existe(alumno), "El alumno no se ha borrado correctamente.");
        assertTrue(gestion.existe(nota), "La nota no se ha borrado correctamente.");
        assertTrue(gestion.existe(aula), "El aula no se ha borrado correctamente.");
        assertTrue(gestion.existe(profesor), "El profesor no se ha borrado correctamente.");

    }

    @Test
    public void recuperarAlumnoTest() {
        assertFalse(alumno.recuperacionAlumno(nota), "El alumno debe recuperar");
    }

    @Test
    public void gettersTest() {
        assertTrue(alumno.getNombre().equalsIgnoreCase("Daniel"), "Se ha producido un error al obtener el nombre");
        assertTrue(alumno.getApellidos().equalsIgnoreCase("Alvarez"), "Se ha producido un error al obtener el apellido");
        assertTrue(alumno.getDni().equalsIgnoreCase("11111111A"), "Se ha producido un error al obtener el dni");
        assertTrue(alumno.getNota().equals(nota), "Se ha producido un error al obtener la nota");
        assertTrue(profesor.getNombre().equalsIgnoreCase("Jony"), "Se ha producido un error al obtener el nombre");
        assertTrue(profesor.getApellidos().equalsIgnoreCase("Exposito"), "Se ha producido un error al obtener el apellido");
        assertTrue(profesor.getDni().equalsIgnoreCase("22222222B"), "Se ha producido un error al obtener el dni");
        assertTrue(profesor.getAula().equals(aula), "Se ha producido un error al obtener el aula");
        assertTrue(nota.getCalificacion() == 8.0, "Se ha producido un error al obtener la calificacion");
        assertTrue(nota.getNombre().equalsIgnoreCase("Programacion"), "Se ha producido un error al obtener la asignatura");
        assertTrue(aula.getAlumno().equals(alumno), "Se ha producido un error al obtener el alumno");
        assertTrue(aula.getNumero() == 109, "Se ha producido un error al obtener el numero");
        assertTrue(aula.getPiso() == 2, "Se ha producido un error al obtener el piso");

    }

    private Alumno crearAlumno(String nombre, String apellidos, String dni, Nota nota) throws AlumnoException{
        return new Alumno(nombre, apellidos, dni, nota); 
    }

    private Profesor crearProfesor(String nombre, String apellidos, String dni, Aula aula) throws ProfesorException {
        return new Profesor(nombre, apellidos, dni, aula);
    }

    private Nota crearNota(String nombre, float calificacion) throws NotaException{
        return new Nota(nombre, calificacion);
    }

    private Aula crearAula(int piso, int numero, Alumno alumno) throws AulaException {
        return new Aula(piso, numero, alumno);
    }
    
}
