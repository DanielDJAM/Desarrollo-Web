package es.iespuertolacruz.daniel.api;

import java.util.Objects;

public class Censo {

    String dni;
    String nombre;
    String fecha;
    String direccion;
    int telefono;


    /**
     * Constructor por defecto
     */
    public Censo() {
    }

    /**
     * Constructor con todos los parametros
     * @param dni del habitante.
     * @param nombre del habitante.
     * @param fecha del habitante.
     * @param direccion del habitante.
     * @param telefono del habitante.
     */
    public Censo(String dni, String nombre, String fecha, String direccion, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.fecha = fecha;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Getters y Setters de Censo
     */
    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Censo [direccion=" + direccion + ", dni=" + dni + ", fecha=" + fecha + ", nombre=" + nombre
                + ", telefono=" + telefono + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Censo)) {
            return false;
        }
        Censo censo = (Censo) o;
        return Objects.equals(dni, censo.dni) && Objects.equals(nombre, censo.nombre) && Objects.equals(fecha, censo.fecha) && Objects.equals(direccion, censo.direccion) && telefono == censo.telefono;
    }

}
