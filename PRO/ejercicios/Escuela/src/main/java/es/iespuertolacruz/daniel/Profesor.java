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
        return null;
    }

    @Override
    protected String getApellidos() {
        return null;
    }

    @Override
    protected String getDni() {
        return null;
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
