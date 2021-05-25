package es.iespuertolacruz.daniel.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class DatosPersonales {

    public static final String DELIMITADOR = ",";
    String dni;
    String nombre;
    String fecha;
    String idDireccion;
    int telefono;

    /**
     * Constructor vacio de DatosPersonales
     */
    public DatosPersonales() {
    }


    /**
    * Constructor que recibe una cadena de texto
    * @param cadena con la informacion
    */
    public DatosPersonales(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.dni = (String) elementos.get(0);
        this.nombre = (String) elementos.get(1);
        this.fecha = (String) elementos.get(2);
        this.idDireccion = (String) elementos.get(3);
        this.telefono = (int) elementos.get(4);
    }

    /**
     * Constructor de la clase DatosPersonales
     * @param dni del usuario
     * @param nombre del usuario
     * @param fecha del usuario
     * @param direccion del usuario
     * @param telefono del usuario
     */
    public DatosPersonales(String dni, String nombre, String fecha, String idDireccion, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.fecha = fecha;
        this.idDireccion = idDireccion;
        this.telefono = telefono;
    }

    /**
     * Getters y Setters de la clase DatosPersonales
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

    public String getIdDireccion() {
        return this.idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "DatosPersonales [idDireccion=" + idDireccion + ", dni=" + dni + ", fecha=" + fecha + ", nombre=" + nombre
                + ", telefono=" + telefono + "]";
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DatosPersonales)) {
            return false;
        }
        DatosPersonales datosPersonales = (DatosPersonales) o;
        return Objects.equals(dni, datosPersonales.dni) && Objects.equals(nombre, datosPersonales.nombre) && Objects.equals(fecha, datosPersonales.fecha) && Objects.equals(idDireccion, datosPersonales.idDireccion) && telefono == datosPersonales.telefono;
    }

}
