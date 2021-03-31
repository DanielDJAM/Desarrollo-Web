package es.iespuertolacruz.daniel;

import java.util.Objects;

public class Aula {

    int piso;
    int numero;
    Alumno alumno;


    public Aula(int piso, int numero, Alumno alumno) {
        this.piso = piso;
        this.numero = numero;
        this.alumno = alumno;
    }


    public int getPiso() {
        return this.piso;
    }

    public int getNumero() {
        return this.numero;
    }

    public Alumno getAlumno() {
        return this.alumno;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aula)) {
            return false;
        }
        Aula aula = (Aula) o;
        return piso == aula.piso && numero == aula.numero && Objects.equals(alumno, aula.alumno);
    }

}
