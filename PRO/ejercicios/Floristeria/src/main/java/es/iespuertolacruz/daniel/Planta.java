package es.iespuertolacruz.daniel;

public class Planta {

    String id;
    String nombre;
    int tamanio;
    float precioBase;
    float precioFinal;
    int articulos;



    public Planta(String id, String nombre, int tamanio, float precioBase, float precioFinal, int articulos) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.precioBase = precioBase;
        this.precioFinal = precioFinal;
        this.articulos = articulos;
    }

    /**
     * Getters de planta.
     */

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamanio() {
        return tamanio;
    }
    
    public float getPrecioBase() {
        return precioBase;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public int getArticulos() {
        return articulos;
    }



    /**
     * Setters de planta.
     */

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    public void setArticulos(int articulos) {
        this.articulos = articulos;
    }

    @Override
    public String toString() {
        return "Planta [articulos=" + articulos + ", id=" + id + ", nombre=" + nombre + ", precioBase=" + precioBase
                + ", precioFinal=" + precioFinal + ", tamanio=" + tamanio + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Planta other = (Planta) obj;
        if (articulos != other.articulos)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Float.floatToIntBits(precioBase) != Float.floatToIntBits(other.precioBase))
            return false;
        if (Float.floatToIntBits(precioFinal) != Float.floatToIntBits(other.precioFinal))
            return false;
        if (tamanio != other.tamanio)
            return false;
        return true;
    }

    

    

    

    

}
