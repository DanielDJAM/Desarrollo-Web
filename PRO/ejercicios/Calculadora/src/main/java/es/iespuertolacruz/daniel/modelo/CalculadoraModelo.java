package es.iespuertolacruz.daniel.modelo;

import java.util.ArrayList;

import es.iespuertolacruz.daniel.api.Calculadora;
import es.iespuertolacruz.daniel.excepcion.FicheroException;

public class CalculadoraModelo {

    Fichero fichero;

   public CalculadoraModelo() {
      fichero = new Fichero();
   }

   public void insertar(Calculadora calculadora) throws FicheroException {
      fichero.insertar(calculadora);
   }

   public void eliminar(Calculadora calculadora) throws FicheroException {
      fichero.eliminar(calculadora);
   }

   /**
    * Funcion que busca una Calculadora a traves del identificar
    * @param identificador de la Calculadora
    * @return Calculadora con el identificador especificado
    * @throws FicheroException
    */
   public Calculadora buscar(String identificador) throws FicheroException {
     Calculadora calculadora = null;
     ArrayList<Calculadora> listado;
     listado = fichero.obtenerListado();
     int i = 0;
     while(i < listado.size() && calculadora == null) {
        if (identificador.equals(listado.get(i).getIdentificador())) {
           calculadora = listado.get(i);
        }
        i++;
     }

     return calculadora;
   }

   public void modificar(Calculadora calculadora) {
      //lo que sea
   }
    
}
