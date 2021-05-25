package es.iespuertolacruz.daniel.controller;

import java.sql.*;
import java.util.ArrayList;

import es.iespuertolacruz.daniel.api.DatosPersonales;
import es.iespuertolacruz.daniel.excepcion.BbddException;
import es.iespuertolacruz.daniel.excepcion.DatosPersonalesException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.modelo.DatosPersonalesModelo;

public class DatosPersonalesController {
    private static final String EL_DNI_ESTA_VACIO = "El dni esta vacio";
    DatosPersonalesModelo datosPersonalesModelo;

    /**
     * Constructor por defecto de la clase DatosPersonalesController
     * @throws BbddException
     * @throws FicheroException
     * @throws SQLException
     */
    public DatosPersonalesController() throws BbddException, FicheroException, SQLException{
        if (datosPersonalesModelo == null) {
            datosPersonalesModelo = new DatosPersonalesModelo();
        }
    }

    /**
     * Metodo para validar datosPersonaless
     * @param datosPersonales a validar
     * @throws DatosPersonalesException
     */
    public void validar(DatosPersonales datosPersonales) throws DatosPersonalesException{
        String mensaje = "";

        if (datosPersonales == null){
            mensaje = "El datosPersonales es nulo";
            throw new DatosPersonalesException(mensaje);
        }
        if(datosPersonales.getDni() == null || datosPersonales.getDni().isEmpty()) {
            mensaje = "El dni es nulo o vacio,";
        }
        if (datosPersonales.getNombre() == null || datosPersonales.getNombre().isEmpty()) {
            mensaje += "El nombre es nulo o vacio,";
        }
        if (datosPersonales.getFecha() == null || datosPersonales.getFecha().isEmpty()) {
            mensaje += "La fecha es nula o vacia,";
        }
        if (datosPersonales.getIdDireccion() == null || datosPersonales.getIdDireccion().isEmpty()) {
            mensaje += "La id_direccion esta vacia";
        }
        if (datosPersonales.getTelefono() == 0) {
            mensaje += "Los datos de la persona estan vacios ";
        }
        if(!mensaje.isEmpty()) {
            throw new DatosPersonalesException(mensaje);
        }
    }

    /**
     * Metodo para insertar un datosPersonales
     * @param datosPersonales a insertar
     * @throws DatosPersonalesException
     * @throws FicheroException
     * @throws BbddException
     */
    public void insertar(DatosPersonales datosPersonales) throws DatosPersonalesException, BbddException {
        validar(datosPersonales);
        if(existe(datosPersonales)) {
            throw new DatosPersonalesException("La persona ya existe");
        }
        datosPersonalesModelo.insertar(datosPersonales);
    }

    /**
     * Metodo para eliminar un datosPersonales
     * @param datosPersonales a eliminar
     * @throws FicheroException
     * @throws DatosPersonalesException
     * @throws BbddException
     */
    public void eliminar(DatosPersonales datosPersonales) throws  DatosPersonalesException, BbddException{
        validar(datosPersonales);
        if (!existe(datosPersonales)) {
          throw new DatosPersonalesException("La persona no existe");
        }
        datosPersonalesModelo.eliminar(datosPersonales);
    }

    /**
     * Metodo para modificar de la clase DatosPersonalesController.
     * 
     * @param datosPersonales  a modificar.
     * @param datosPersonales2 datosPersonales con modificaciones.
     * @throws FicheroException
     * @throws BbddException
     * @throws DatosPersonalesException
     */
    public void modificar(DatosPersonales datosPersonales) throws  BbddException, DatosPersonalesException{
        validar(datosPersonales);
        if(!existe(datosPersonales)){
            throw new DatosPersonalesException("La persona no se encuentra o no existe");
        }
        datosPersonalesModelo.modificar(datosPersonales);
    }

    /**
     * Funcion que busca un datosPersonales por su dni
     * @param dni del datosPersonales a buscar
     * @return un datosPersonales
     * @throws DatosPersonalesException
     * @throws FicheroException
     * @throws BbddException
     */
    public DatosPersonales buscar(String dni) throws DatosPersonalesException, BbddException {
        DatosPersonales datosPersonales = null;
        if (dni == null || dni.isEmpty()) {
            throw new DatosPersonalesException(EL_DNI_ESTA_VACIO);
        }
        datosPersonales = datosPersonalesModelo.buscarDatosPersonales(dni);
        return datosPersonales;
    }

    /**
     * Funcion que verifica si existe un datosPersonales
     * @param dni por el que se busca
     * @return True/false si se ha encontrado
     * @throws DatosPersonalesException
     * @throws FicheroException
     * @throws BbddException
     */
    public boolean existe(DatosPersonales datosPersonales) throws DatosPersonalesException, BbddException {
        boolean encontrado = false;
        DatosPersonales datosPersonalesEncontrado;
        datosPersonalesEncontrado = buscar(datosPersonales.getDni());
        if (datosPersonalesEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }

    public ArrayList<DatosPersonales> obtenerDatos() {
        return ArrayList<DatosPersonales>
    }
}
