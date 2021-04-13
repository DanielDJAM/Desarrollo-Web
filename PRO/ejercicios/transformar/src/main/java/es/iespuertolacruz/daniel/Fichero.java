package es.iespuertolacruz.daniel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import es.iespuertolacruz.daniel.Exception.FicheroException;

public class Fichero {

    /**
     * Metodo encargado de crear un fichero
     * 
     * @param nombre del fichero a crear
     * @throws FicheroException
     */

    public void crear(String nombre, String cadenaTexto) throws FicheroException {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(nombre);
            fichero.write(cadenaTexto + "\n");
        } catch (Exception ex) {
            throw new FicheroException("Se ha producido un error en la escritura del fichero", ex);
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    throw new FicheroException("No ha sido podible cerrar el fichero", e);
                }
            }
        }

    }

    /**
     * Metodo encargado de elimianr un fichero/directorio
     * 
     * @param nombre del fichero/directorio a elimina
     * @throws FicheroException error controlado
     */

    public void eliminar(String nombre) throws FicheroException {
        File fichero = new File(nombre);
        try {
            fichero.delete();
        } catch (Exception e) {
            throw new FicheroException("No se puede eliminar un fichero que no existe", e);
        }

    }

    /**
     * Funcion que verifica si el fichero existo
     * 
     * @param fichero
     * @return
     */

    public boolean validarFichero(File fichero) {
        return fichero.exists();
    }

    /**
     * Funcion que verifica si se trata de un directorio no
     * 
     * @param path de la ruta a validad
     * @return boolean Si/No se trata de un directorio
     */

    public boolean esDirectorio(String path) {
        File fichero = new File(path);
        return fichero.isDirectory();
    }
}
