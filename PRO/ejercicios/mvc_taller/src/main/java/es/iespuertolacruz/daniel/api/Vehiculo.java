package es.iespuertolacruz.daniel.api;

public class Vehiculo {

    private String matricula;
    private String marca;

    /**
     * Constructor por defecto de la clase Vehiculo.
     */
    public Vehiculo(){

    }

    public Vehiculo(String matricula){
        this.matricula = matricula;
    }

    /**
     * Constructor con todos los parametros de la clase vehiculo.
     * @param matricula del vehiculo.
     * @param marca del vehiculo.
     */
    public Vehiculo(String matricula, String marca){
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
        return "Vehiculo [marca=" + marca + ", matricula=" + matricula + "]";
    }

    
    
    
}
