package es.iespuertolacruz.daniel.controlador;

import es.iespuertolacruz.daniel.api.Divisa;
import es.iespuertolacruz.daniel.excepcion.DivisaException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.modelo.DivisaModelo;

public class DivisaController {

    private static final String LA_CALCULADORA_INDICADA_NO_EXISTE = "La Divisa indicada NO existe";
    DivisaModelo divisaModelo;

   public DivisaController() {
      divisaModelo = new DivisaModelo();
   }

    /**
     * Metodo encargado de realizar la validacion del objeto Divisa
     * 
     * @param Divisa a validar
     * @throws DivisaException con el mensaje descriptivo de lo que sucede
     */
    public void validarDivisa(Divisa divisa) throws DivisaException {
        String mensaje = "";

        if (divisa == null) {
            mensaje = "Se esta validando un objeto nulo de Divisa";
            throw new DivisaException(mensaje);
        }
        if (divisa.getCodigo() == null || divisa.getCodigo().isEmpty()) {
            mensaje = "El codigo de la Divisa es nulo o vacio, ";
        }
        if (divisa.getValor() == 0) {
            mensaje = "El valor de la Divisa es nulo o vacio, ";
        }
        if (!mensaje.isEmpty()) {
            throw new DivisaException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * 
     * @param Divisa a insertar
     * @throws DivisaException   con mensaje controlado
     * @throws FicheroException
     */
    public void insertar(Divisa divisa) throws DivisaException, FicheroException {
        validarDivisa(divisa);
        if (existe(divisa)) {
            throw new DivisaException("La Divisa indicada ya existe");
        }
        divisaModelo.insertar(divisa);
    }

    /**
     * Metodo encargado de eliminar
     * 
     * @param Divisa a eliminar
     * @throws DivisaException
     * @throws FicheroException
     */
    public void eliminar(Divisa divisa) throws DivisaException, FicheroException {
        validarDivisa(divisa);
        if (!existe(divisa)) {
            throw new DivisaException(LA_CALCULADORA_INDICADA_NO_EXISTE);
        }
        divisaModelo.eliminar(divisa);
    }

    /**
     * Meotod encargado de realiza la eliminacion de una Divisa
     * 
     * @param codigo del elemento a eliminar
     * @throws DivisaException   controlada con el error
     * @throws FicheroException
     */
    public void eliminar(String codigo) throws DivisaException, FicheroException {
        Divisa divisa;
        divisa = buscar(codigo);
        eliminar(divisa);
    }

    /**
     * Metodo encargado de buscar por codigo
     * 
     * @param codigo para localizar la Divisa
     * @return Divisa a traves del codigo
     * @throws FicheroException
     */
    public Divisa buscar(String codigo) throws FicheroException {
        Divisa divisa = null;
        divisa = divisaModelo.buscar(codigo);
        return divisa;
    }

    /**
     * Metodo encargado de realizar la modificacion de una Divisas
     * 
     * @param Divisa a modficar
     * @throws DivisaException controlada en caso de error
     * @throws FicheroException
     */
    public void modificar(Divisa divisa, Divisa divisa2) throws DivisaException, FicheroException {
        Divisa divisaAlmacenada;
        validarDivisa(divisa);
        divisaAlmacenada = buscar(divisa.getCodigo());
        if (divisaAlmacenada == null) {
            throw new DivisaException(LA_CALCULADORA_INDICADA_NO_EXISTE);
        }
        divisaModelo.modificar(divisa, divisa2);
    }

    /**
     * Funcion encargada de verificar si existe la Divisa
     * 
     * @param Divisa a encontrar
     * @return true/false
     * @throws FicheroException
     */
    public boolean existe(Divisa divisa) throws FicheroException {
        boolean encontrada = false;
        Divisa divisaEncontrada;

        divisaEncontrada = buscar(divisa.getCodigo());
        if (divisaEncontrada != null) {
            encontrada = true;
        }
        return encontrada;
    }

}
