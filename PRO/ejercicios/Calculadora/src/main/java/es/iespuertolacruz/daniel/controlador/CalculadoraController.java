package es.iespuertolacruz.daniel.controlador;

import es.iespuertolacruz.daniel.api.Calculadora;
import es.iespuertolacruz.daniel.excepcion.CalculadoraException;
import es.iespuertolacruz.daniel.excepcion.FicheroException;
import es.iespuertolacruz.daniel.modelo.CalculadoraModelo;

public class CalculadoraController {

    private static final String LA_CALCULADORA_INDICADA_NO_EXISTE = "La Calculadora indicada NO existe";
    CalculadoraModelo calculadoraModelo;

   public CalculadoraController() {
      calculadoraModelo = new CalculadoraModelo();
   }

    /**
     * Metodo encargado de realizar la validacion del objeto Calculadora
     * 
     * @param Calculadora a validar
     * @throws CalculadoraException con el mensaje descriptivo de lo que sucede
     */
    public void validarCalculadora(Calculadora calculadora) throws CalculadoraException {
        String mensaje = "";

        if (calculadora == null) {
            mensaje = "Se esta validando un objeto nulo de Calculadora";
            throw new CalculadoraException(mensaje);
        }
        if (calculadora.getIdentificador() == null || calculadora.getIdentificador().isEmpty()) {
            mensaje = "El identidicador de la Calculadora es nulo o vacio, ";
        }

        if (calculadora.getNombre() == null || calculadora.getNombre().isEmpty()) {
            mensaje += "El nombre de la Calculadora es nulo o vacio, ";
        }

        if (calculadora.getCoste() < 0) {
            mensaje += "El coste de la Calculadora es 0 o menor, ";
        }
        if (calculadora.getPrecio() < 0) {
            mensaje += "El precio de la Calculadora es 0 o menor.";
        }
        if (!mensaje.isEmpty()) {
            throw new CalculadoraException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar
     * 
     * @param Calculadora a insertar
     * @throws CalculadoraException   con mensaje controlado
     * @throws FicheroException
     */
    public void insertar(Calculadora calculadora) throws CalculadoraException, FicheroException {
        validarCalculadora(calculadora);
        if (existe(calculadora)) {
            throw new CalculadoraException("La Calculadora indicada ya existe");
        }
        calculadoraModelo.insertar(calculadora);
    }

    /**
     * Metodo encargado de eliminar
     * 
     * @param Calculadora a eliminar
     * @throws CalculadoraException
     * @throws FicheroException
     */
    public void eliminar(Calculadora calculadora) throws CalculadoraException, FicheroException {
        validarCalculadora(calculadora);
        if (!existe(calculadora)) {
            throw new CalculadoraException(LA_CALCULADORA_INDICADA_NO_EXISTE);
        }
        calculadoraModelo.eliminar(calculadora);
    }

    /**
     * Meotod encargado de realiza la eliminacion de una Calculadora
     * 
     * @param identificador del elemento a eliminar
     * @throws CalculadoraException   controlada con el error
     * @throws FicheroException
     */
    public void eliminar(String identificador) throws CalculadoraException, FicheroException {
        Calculadora calculadora;
        calculadora = buscar(identificador);
        eliminar(calculadora);
    }

    /**
     * Metodo encargado de buscar por identificador
     * 
     * @param identificador para localizar la Calculadora
     * @return Calculadora a traves del identificador
     */
    public Calculadora buscar(String identificador) {
        Calculadora calculadora = null;
        calculadora = calculadoraModelo.buscar(identificador);
        return calculadora;
    }

    /**
     * Metodo encargado de realizar la modificacion de una Calculadora
     * 
     * @param Calculadora a modficar
     * @throws CalculadoraException controlada en caso de error
     */
    public void modificar(Calculadora calculadora) throws CalculadoraException {
        Calculadora calculadoraAlmacenada;
        validarCalculadora(calculadora);
        calculadoraAlmacenada = buscar(calculadora.getIdentificador());
        if (calculadoraAlmacenada == null) {
            throw new CalculadoraException(LA_CALCULADORA_INDICADA_NO_EXISTE);
        }
        calculadoraModelo.modificar(calculadora);
    }

    /**
     * Funcion encargada de verificar si existe la Calculadora
     * 
     * @param Calculadora a encontrar
     * @return true/false
     */
    private boolean existe(Calculadora calculadora) {
        boolean encontrada = false;
        Calculadora calculadoraEncontrada;

        calculadoraEncontrada = buscar(calculadora.getIdentificador());
        if (calculadoraEncontrada != null) {
            encontrada = true;
        }
        return encontrada;
    }

}
