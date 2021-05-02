package es.iespuertolacruz.daniel;

import es.iespuertolacruz.daniel.api.Divisa;

public class UtilidadesTest {

    private static final String CODIGO = "EUR";
    private static final double VALOR = 1;

   public Divisa generarDivisa(String codigo, double valor) {
      Divisa fruta = null;
      if (codigo != null && valor != 0) {
          fruta = new Divisa(codigo, valor);
      } else {
          fruta = new Divisa();
          fruta.setCodigo(CODIGO);
          fruta.setValor(VALOR);
      }
      return fruta;
  }
    
}
