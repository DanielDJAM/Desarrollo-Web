package es.iespuertolacruz.daniel;

/**
 * Clase del objeto alumno.
 */

public class Alumno {

    int numeroLista;
    boolean estado;
    Nota nota;

    /**
     * Clase del Alumno.
     * @param numeroLista del alumno.
     * @param estado del alumno.
     * @param nota del alumno.
     */
    public Alumno(int numeroLista, Nota nota){
        this.numeroLista = numeroLista;
        this.nota = nota;
        this.estado = comprobarEstado(nota);
    }

    

    public int getNumeroLista() {
        return numeroLista;
    }



    public void setNumeroLista(int numeroLista) {
        this.numeroLista = numeroLista;
    }



    public boolean isEstado() {
        return estado;
    }



    public void setEstado(boolean estado) {
        this.estado = estado;
    }



    public Nota getNota() {
        return nota;
    }

    public boolean comprobarEstado(Nota nota){
        estado = false;
        if (nota.getCalificacion() >=5){
            return estado = true;
        }
        return estado;
    }
    

    public void examenRecuperacion(Nota nota){
        if (!comprobarEstado(nota)==true){

        }
    }
}
