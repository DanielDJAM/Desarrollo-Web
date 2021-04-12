package es.iespuertolacruz.daniel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import es.iespuertolacruz.daniel.Exception.LecturaException;

public class LecturaFichero extends Fichero {

    private static final String RETORNO_CARRO = "\n";

    public String leerFichero(String nombre) throws LecturaException {
        // Fichero del que queremos leer
        StringBuilder informacion = null;
        File fichero = null;
        Scanner scan = null;
        try {
            fichero = new File(nombre);
            if (!validarFichero(fichero)) {
                throw new LecturaException("Ha ocurrido un error al validar el fichero");
            }
            scan = new Scanner(fichero);
            informacion = new StringBuilder();

            // Leemos linea a linea el fichero
            while (scan.hasNextLine()) {
                String linea = scan.nextLine(); // Guardamos la linea en un String
                informacion.append(linea + RETORNO_CARRO); // Imprimimos la linea
            }

        } catch (LecturaException e) {
            throw e;
        } catch (Exception e) {
            throw new LecturaException("Ha ocurrido un error al leer el fichero.");
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return informacion.toString();
    }

}