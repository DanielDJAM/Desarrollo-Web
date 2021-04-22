package es.iespuertolacruz.daniel;

public class Nota {

    int NOTAMAXIMA = 10;
    int NOTAMINIMA = 0;
    int calificacion = 0;
    int recuperacion;

    /**
     * Constructor por defecto.
     */

    public Nota(){

    }

    /**
     * Constructor de la clase Nota.
     * @param calificacion de la nota.
     */

    public Nota(int calificacion){
        this.calificacion = calificacion;
    }

    public int getNOTAMAXIMA() {
        return NOTAMAXIMA;
    }

    public int getNOTAMINIMA() {
        return NOTAMINIMA;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getRecuperacion() {
        return recuperacion;
    }

    public void setRecuperacion(int recuperacion) {
        this.recuperacion = recuperacion;
    }

    /**
     * Metodo para generar una nota random.
     */

    public void generarNota(){
        calificacion = (int)(Math.random()*11);
    }

    
    
}
