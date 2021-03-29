package es.iespuertolacruz.daniel;


public abstract class Persona {

    String nombre;
    String apellidos;
    String dni;


    protected Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    /**
     * Getters de la clase Persona
     * @return
     */


    protected abstract String getNombre(); 

    protected abstract String getApellidos();

    protected abstract String getDni();



}
