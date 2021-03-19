package es.iespuertolacruz.daniel;

import java.util.Objects;

public class Lugar {

    String ciudad;
    String pais;


    public Lugar(String ciudad, String pais) {
        this.ciudad = ciudad;
        this.pais = pais;
    }


    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    @Override
    public String toString() {
        return getCiudad() + "," + getPais();
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lugar)) {
            return false;
        }
        Lugar lugar = (Lugar) o;
        return Objects.equals(ciudad, lugar.ciudad) && Objects.equals(pais, lugar.pais);
    }

}
