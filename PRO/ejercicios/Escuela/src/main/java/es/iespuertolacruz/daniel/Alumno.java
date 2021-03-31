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

    public boolean recuperacionAlumno(Nota nota) {
        boolean recuperar = false;
        if (nota.getCalificacion() <5.0f) {
            return recuperar = true;
        }
        return recuperar;
    }

    public String listarNotas(){
        return "Alumno: " + getNombre() + " [nota=" + nota.toString() + "]\n";
    }



    

}
