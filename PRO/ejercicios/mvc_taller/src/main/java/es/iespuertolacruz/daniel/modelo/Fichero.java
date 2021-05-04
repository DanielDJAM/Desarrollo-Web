package es.iespuertolacruz.daniel.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import es.iespuertolacruz.daniel.api.Vehiculo;
import es.iespuertolacruz.daniel.excepcion.FicheroException;

public class Fichero {

    private static final String SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO = "Se ha producido un error en el volcado del fichero";
    private static final String RETORNO_CARRO = "\n";
    private static final String NOMBRE_FICHERO = "Fichero-Usarios.txt";

    /**
     * Metodo encargado de almacenar una vehiculo en el fichero
     * 
     * @param vehiculo a insertar
     * @throws FicheroException controlado
     */
    public void insertar(Vehiculo vehiculo) throws FicheroException {
        ArrayList<Vehiculo> listado;
        listado = obtenerListado();
        listado.add(vehiculo);
        try {
            crear(NOMBRE_FICHERO, obtenerLista(listado));
        } catch (FicheroException exception) {
            throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, exception);
        }
    }

    /**
     * Funcion para obtener una lista de vehiculos
     * @param listado array
     * @return un string.
     */
    private String obtenerLista(ArrayList<Vehiculo> listado) {
        String lista = "";
        int i = 0;
        while (i<listado.size()) {
            lista += listado.get(i).toString() +RETORNO_CARRO;
            ++i;
        }
        return lista;
    }

    /**
     * Metodo encargado de eliminar una Vehiculo del fichero
     * 
     * @param Vehiculo a eliminar
     * @throws FicheroException error controlado
     */
    public void eliminar(Vehiculo vehiculo) throws FicheroException {
        ArrayList<Vehiculo> listado;
        listado = obtenerListado();
        listado.remove(vehiculo);
        try {
            crear(NOMBRE_FICHERO, obtenerLista(listado));
        } catch (FicheroException exception) {
            throw new FicheroException(SE_HA_PRODUCIDO_UN_ERROR_EN_EL_VOLCADO_DEL_FICHERO, exception);
        }
    }

    /**
     * Metodo encargado de modificar un elemento del fichero
     * 
     * @param VehiculoAlamcenada elemento a actualizar
     * @param Vehiculo elemento con la informacion actualizada
     * @throws FicheroException
     */
    public void modificar(Vehiculo vehiculoAlmacenada, Vehiculo vehiculo) throws FicheroException {
        ArrayList<Vehiculo> listado = obtenerListado();
        int posicion = -1;
        posicion = listado.indexOf(vehiculoAlmacenada);
        listado.remove(posicion);
        listado.add(posicion, vehiculo);
        crear(NOMBRE_FICHERO, obtenerLista(listado));

    }

    /**
     * Funcion encargada de obtener el listado de Vehiculos del fichero
     * 
     * @return listado de Vehiculos
     * @throws FicheroException
     */
    public ArrayList<Vehiculo> obtenerListado() throws FicheroException {
        ArrayList<Vehiculo> lista = new ArrayList<>();
        File fichero = null;
        Scanner scanner = null;

        try {
            fichero = new File(NOMBRE_FICHERO);
            if (!validarFichero(fichero)) {
                throw new FicheroException("El fichero a leer no existe");
            }
            scanner = new Scanner(fichero);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine(); // Guardamos la linea en un String
                if (!linea.isEmpty()) {
                    Vehiculo vehiculo = new Vehiculo(linea);
                    lista.add(vehiculo);
                }
            }
        } catch (FicheroException e) {
            throw e;
        } catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return lista;
    }

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
            fichero.write(cadenaTexto + RETORNO_CARRO);
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
     * Funcion que verifica si el fichero existo
     * 
     * @param fichero
     * @return
     */
    public boolean validarFichero(File fichero) {
        return fichero.exists();
    }

    /**
     * Metodo encargado de elimianr un fichero/directorio
     * 
     * @param nombre del fichero/directorio a elimina
     * @throws FicheroException error controlado
     */
    public void eliminar(String nombre) throws FicheroException {
        File fichero = new File(nombre);
        if (validarFichero(fichero)) {
            fichero.delete();
        } else {
            throw new FicheroException("No se puede eliminar un fichero que no existe");
        }

    }

    /**
     * Funcion que verifica si se trata de un directorio noFichero-Usarios
     * 
     * @param path de la ruta a validad
     * @return boolean Si/No se trata de un directorio
     */
    public boolean esDirectorio(String path) {
        File fichero = new File(path);
        return fichero.isDirectory();
    }

    /**
     * Funcion encargada de obtener un vehiculo
     * 
     * @param matricula del vehiculo
     * @return Objeto vehiculo
     * @throws FicheroException
     */
    public Vehiculo buscar(String matricula) throws FicheroException {
        Vehiculo vehiculo = null;
        ArrayList<Vehiculo> listado = obtenerListado();
        int i = 0;

        while (i < listado.size() && vehiculo == null) {
            if (matricula.equals(listado.get(i).getMatricula()) || matricula.equals(listado.get(i).getMarca())) {
                vehiculo = listado.get(i);
            }
            i++;
        }
        return vehiculo;
    }
    
}
