package es.iespuertolacruz.daniel;

import java.util.Objects;

public class Alumno extends Persona {

    Nota nota;

    protected Alumno(String nombre, String apellidos, String dni, Nota nota) {
        super(nombre, apellidos, dni);
        this.nota = nota;
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

    public Nota getNota() {
        return this.nota;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(nota, alumno.nota);
    }

}
