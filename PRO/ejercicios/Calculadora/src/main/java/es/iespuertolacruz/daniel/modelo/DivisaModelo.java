package es.iespuertolacruz.daniel.modelo;

import java.util.ArrayList;

import es.iespuertolacruz.daniel.api.Divisa;
import es.iespuertolacruz.daniel.excepcion.FicheroException;


public class DivisaModelo {

    Fichero fichero;

   public DivisaModelo() {
      fichero = new Fichero();
   }

   public void insertar(Divisa divisa) throws FicheroException {
      fichero.insertar(divisa);
   }

   public void eliminar(Divisa divisa) throws FicheroException {
      fichero.eliminar(divisa);
   }

   /**
    * Funcion que busca una Calculadora a traves del identificar
    * @param identificador de la Calculadora
    * @return Calculadora con el identificador especificado
    * @throws FicheroException
    */
   public Divisa buscar(String identificador) throws FicheroException {
     Divisa divisa = null;
     ArrayList<Divisa> listado;
     listado = fichero.obtenerListado();
     int i = 0;
     while(i < listado.size() && divisa == null) {
        if (identificador.equals(listado.get(i).getCodigo())) {
           divisa = listado.get(i);
        }
        i++;
     }

     return divisa;
   }

   public void modificar(Divisa divisa, Divisa divisa2) throws FicheroException {
      fichero.modificar(divisa, divisa2);
   }
    
}
