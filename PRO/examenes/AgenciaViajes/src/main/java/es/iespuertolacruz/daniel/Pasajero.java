package es.iespuertolacruz.daniel;

import java.util.Objects;

public class Pasajero {

    String nombre;
    String dni;
    String destino;


    public Pasajero(String nombre, String dni, String destino) {
        this.nombre = nombre;
        this.dni = dni;
        this.destino = destino;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pasajero)) {
            return false;
        }
        Pasajero pasajero = (Pasajero) o;
        return Objects.equals(nombre, pasajero.nombre) 
        && Objects.equals(dni, pasajero.dni) 
        && Objects.equals(destino, pasajero.destino);
    }

    @Override
   public String toString() {
      return  getNombre() + ";" + getDni()+ ";" + getDestino() + "\n";
   }

}
