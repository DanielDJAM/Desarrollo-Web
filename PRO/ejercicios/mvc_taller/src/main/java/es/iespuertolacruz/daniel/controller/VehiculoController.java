package es.iespuertolacruz.daniel.controller;

import es.iespuertolacruz.daniel.api.Vehiculo;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.excepcion.VehiculoException;
import es.iespuertolacruz.daniel.modelo.VehiculoModelo;

public class VehiculoController {

    VehiculoModelo vehiculoModelo;

    public VehiculoController(){
        vehiculoModelo = new VehiculoModelo();
    }

    public void validar(Vehiculo vehiculo) throws VehiculoException{
        String mensaje = "";

        if (vehiculo == null){
            mensaje = "El objeto a validar es nulo";
            throw new VehiculoException(mensaje);
        }
        if (vehiculo.getMatricula() == null || vehiculo.getMatricula().isEmpty()){
            mensaje = "La matricula es nula o vacia,";
        }
        if (vehiculo.getMarca() == null || vehiculo.getMarca().isEmpty()){
            mensaje += "La marca es nula o vacia.";
        }
        if (!mensaje.isEmpty()){
            throw new VehiculoException(mensaje);
        }
    }

    /**
     * Metodo insertar de la clase VehiculoController.
     * @param vehiculo a insertar.
     * @throws FicheroException
     * @throws VehiculoException
     */
    public void insertar(Vehiculo vehiculo) throws VehiculoException, FicheroException{
        validar(vehiculo);
        if (existe(vehiculo.getMatricula())) {
            throw new VehiculoException("El vehiculo se encuentra almacenado");
        }
        vehiculoModelo.insertar(vehiculo);
    }

    /**
     * Metodo para eliminar de la clase VehiculoController.
     * @param vehiculo a eliminar.
     * @throws FicheroException
     */
    public void eliminar(Vehiculo vehiculo) throws FicheroException {
        vehiculoModelo.eliminar(vehiculo);
    }

    /**
     * Metodo para modificar de la clase VehiculoController.
     * @param vehiculo a modificar.
     * @param vehiculo2 vehiculo con modificaciones.
     * @throws FicheroException
     */
    public void modificar(Vehiculo vehiculo, Vehiculo vehiculo2) throws FicheroException {
        vehiculoModelo.modificar(vehiculo, vehiculo2);
    }

    /**
     * Metodo para mostrar/buscar un solo vehiculo de la clase VehiculoController.
     * @param vehiculo a buscar.
     * @throws FicheroException
     */
    public Vehiculo mostrarVehiculo(String matricula) throws FicheroException {
       return vehiculoModelo.mostrarVehiculo(matricula);
    }

    /**
    * Funcion que verifica si un vehiculo existe 
    * @param matricula a encontrar
    * @return true/false
     * @throws FicheroException
    */
   public boolean existe(String matricula) throws FicheroException {
    boolean encontrado = false;
    Vehiculo vehiculo = null;

    vehiculo = mostrarVehiculo(matricula);
    if (vehiculo !=null) {
       encontrado = true;
    }
    return encontrado;
 }



    
}
