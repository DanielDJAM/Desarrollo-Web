package es.iespuertolacruz.daniel.controller;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.iespuertolacruz.daniel.api.Censo;
import es.iespuertolacruz.daniel.excepcion.CensoException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.excepcion.PersistenciaException;
import es.iespuertolacruz.daniel.modelo.CensoModelo;

public class CensoController {

    private static final String EL_DNI_ESTA_VACIO = "El dni esta vacio";
    CensoModelo censoModelo;

    /**
     * Constructor por defecto de la clase CensoController
     * @throws PersistenciaException
     * @throws FicheroException
     * @throws SQLException
     */
    public CensoController() throws PersistenciaException, FicheroException, SQLException{
        if (censoModelo == null) {
            censoModelo = new CensoModelo();
        }
    }

    /**
     * Metodo para validar censos
     * @param censo a validar
     * @throws CensoException
     */
    public void validar(Censo censo) throws CensoException{
        String mensaje = "";

        if (censo == null){
            mensaje = "El censo es nulo";
            throw new CensoException(mensaje);
        }
        if(censo.getDni() == null || censo.getDni().isEmpty()) {
            mensaje = "El dni es nulo o vacio,";
        }
        if(!validarDni(censo.getDni())) {
            mensaje += "dni no valido";
        }
        if (censo.getNombre() == null || censo.getNombre().isEmpty()) {
            mensaje += "El nombre es nulo o vacio,";
        }
        if (censo.getFecha() == null || censo.getFecha().isEmpty()) {
            mensaje += "La fecha es nula o vacia,";
        }
        if (censo.getDireccion() == null || censo.getDireccion().isEmpty()) {
            mensaje += "La id_direccion esta vacia";
        }
        if (censo.getTelefono() == 0) {
            mensaje += "Los datos de la persona estan vacios ";
        }
        if(!mensaje.isEmpty()) {
            throw new CensoException(mensaje);
        }
    }

    /**
     * Metodo para insertar un censo
     * @param censo a insertar
     * @throws CensoException
     * @throws FicheroException
     * @throws PersistenciaException
     */
    public void insertar(Censo censo) throws CensoException, PersistenciaException {
        validar(censo);
        if(existe(censo)) {
            throw new CensoException("La persona ya existe");
        }
        censoModelo.insertar(censo);
    }

    /**
     * Metodo para eliminar un censo
     * @param censo a eliminar
     * @throws FicheroException
     * @throws CensoException
     * @throws PersistenciaException
     */
    public void eliminar(Censo censo) throws  CensoException, PersistenciaException{
        validar(censo);
        if (!existe(censo)) {
          throw new CensoException("La persona no existe");
        }
        censoModelo.eliminar(censo);
    }

    /**
     * Metodo para modificar de la clase CensoController.
     * 
     * @param censo  a modificar.
     * @param censo2 censo con modificaciones.
     * @throws FicheroException
     * @throws PersistenciaException
     * @throws CensoException
     */
    public void modificar(Censo censo) throws  PersistenciaException, CensoException{
        validar(censo);
        if(!existe(censo)){
            throw new CensoException("La persona no se encuentra o no existe");
        }
        censoModelo.modificar(censo);
    }

    /**
     * Funcion que busca un censo por su dni
     * @param dni del censo a buscar
     * @return un censo
     * @throws CensoException
     * @throws FicheroException
     * @throws PersistenciaException
     */
    public Censo buscar(String dni) throws CensoException, PersistenciaException {
        Censo censo = null;
        if (dni == null || dni.isEmpty()) {
            throw new CensoException(EL_DNI_ESTA_VACIO);
        }
        censo = censoModelo.buscarCenso(dni);
        return censo;
    }

    /**
     * Funcion que verifica si existe un censo
     * @param dni por el que se busca
     * @return True/false si se ha encontrado
     * @throws CensoException
     * @throws FicheroException
     * @throws PersistenciaException
     */
    public boolean existe(Censo censo) throws CensoException, PersistenciaException {
        boolean encontrado = false;
        Censo censoEncontrado;
        censoEncontrado = buscar(censo.getDni());
        if (censoEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }

    public boolean validarDni(String dni){
        boolean resultado = false;
        Pattern patron = Pattern.compile("^[0-9]{8}[A-Za-z]$");
        Matcher valido = patron.matcher(dni);
        resultado = valido.find();
        return resultado;
    }
    
}
