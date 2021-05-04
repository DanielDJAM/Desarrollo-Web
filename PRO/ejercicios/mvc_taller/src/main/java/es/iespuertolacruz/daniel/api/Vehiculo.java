package es.iespuertolacruz.daniel.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Vehiculo {

    private String matricula;
    private String marca;

    private static final String DELIMITADOR = ",";

    /**
     * Constructor por defecto de la clase Vehiculo.
     */
    public Vehiculo() {

    }

    /**
    * Constructor que recibe una cadena de text
    * @param cadena con la informacion
    */
    public Vehiculo(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.matricula = (String) elementos.get(0);
        this.marca = (String) elementos.get(1);
    }

    /**
     * Constructor con todos los parametros de la clase vehiculo.
     * 
     * @param matricula del vehiculo.
     * @param marca     del vehiculo.
     */
    public Vehiculo(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }

    /**
     * Getters y Setters de la clase Vehiculo.
     */
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return getMatricula() + DELIMITADOR + getMarca();
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula) && Objects.equals(marca, vehiculo.marca);
    }

}
