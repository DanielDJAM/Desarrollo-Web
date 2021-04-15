package es.iespuertolacruz.daniel.api;

/**
 * Clase fruta de la aplicacion.
 */

public class Fruta {

    String identidicador;
    String nombre;
    float precio;
    float coste;

    /**
     * Constructor de la clase fruta.
     * @param identidicador identificador de la fruta.
     * @param nombre nombre de la fruta.
     * @param precio de la fruta.
     * @param coste de venta de la fruta.
     */

    public Fruta(String identidicador, String nombre, float precio, float coste) {
        this.identidicador = identidicador;
        this.nombre = nombre;
        this.precio = precio;
        this.coste = coste;
    }

    /**
     * Getters y Setters de la clase fruta.
     */

    public String getIdentidicador() {
        return identidicador;
    }

    public void setIdentidicador(String identidicador) {
        this.identidicador = identidicador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    /**
     * Funcion que realiza el calculo de una fruta.
     * @return beneficio por fruta.
     */

    public float beneficio(){
        return precio - coste;
    }

    

    
    
}
