package es.iespuertolacruz.daniel;

import java.util.Objects;

public class Nota {

    String nombre;
    float calificacion;


    public Nota(String nombre, float calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Nota)) {
            return false;
        }
        Nota nota = (Nota) o;
        return Objects.equals(nombre, nota.nombre) && calificacion == nota.calificacion;
    }

    



}
