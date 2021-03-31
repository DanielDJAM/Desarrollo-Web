package es.iespuertolacruz.daniel;

import java.util.Objects;

public class Profesor extends Persona{

    Aula aula;

    protected Profesor(String nombre, String apellidos, String dni, Aula aula) {
        super(nombre, apellidos, dni);
        this.aula = aula;
    }

    @Override
    protected String getNombre() {
        return this.nombre;
    }

    @Override
    protected String getApellidos() {
        return this.apellidos;
    }

    @Override
    protected String getDni() {
        return this.dni;
    }

    public Aula getAula() {
        return this.aula;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Profesor)) {
            return false;
        }
        Profesor profesor = (Profesor) o;
        return Objects.equals(aula, profesor.aula);
    }
    
}
