package es.iespuertolacruz.daniel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.daniel.Exception.FicheroException;

public class FicheroTest {

    private static final String NOMBRE_FICHERO_TXT = "nombreFichero.txt";
    Fichero fichero;
    LecturaFichero lectura;
    EscrituraFichero escritura;

    @BeforeEach
    public void setUp(){
        if (fichero == null) {
            fichero = new Fichero();
        }
        if ( lectura == null) {
            lectura = new LecturaFichero();
        }
        if (escritura == null) {
            escritura = new EscrituraFichero();
        }
        try {
            fichero.eliminar(NOMBRE_FICHERO_TXT);
        } catch (FicheroException e) {
            fail("Ha ocurrido un error al eliminar el fichero.");
        }

    }

    @AfterEach
    public void after(){

    }

    @Test
    public void volcarAficheroTest() {
        try {
            EscrituraFichero.volcarAfichero(NOMBRE_FICHERO_TXT);
            String contenido = LecturaFichero.leerFichero(NOMBRE_FICHERO_TXT);
            assertTrue(contenido.contains("test,test2,1"), "El fichero no contiene el alumno");
        } catch (FicheroException e) {
            fail("Error guardando el fichero de test");
        }
    }
    
}
