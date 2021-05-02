package es.iespuertolacruz.daniel.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase Divisa.
 */

public class Divisa implements Serializable{

    private static final String DELIMITADOR = ",";

    String codigo;
    double valor;

    /**
     * Constructor vacio de la clase Divisa.
     */

    public Divisa(){

    }

    /**
     * Constructor de la clase Divisa
     * @param codigo de la divisa
     * @param valor de la divisa
     */

    public Divisa(String codigo, double valor){
        this.codigo = codigo;
        this.valor = valor;
    }

    /**
     * Constructor para verificar el toString
     * @param cadena a verificar.
     */

    public Divisa(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
           elementos.add(tokenizer.nextToken());
        }
        this.codigo = (String) elementos.get(0);
        this.valor = Double.parseDouble((String) elementos.get(1));
     }

    /**
     * Getters y Setters de la clase Divisa.
     */

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    


    /**
     * ToString de la clase Divisa.
     */

    @Override
    public String toString() {
        return getCodigo() + DELIMITADOR + getValor();
    }


    /**
     * Equals de la clase Divisa.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Divisa other = (Divisa) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
            return false;
        return true;
    }

    

    

    

    
    
}
