package es.ejemplos.jpexposito;

import java.util.ArrayList;

import es.ejemplos.jpexposito.excepcion.FrutaException;

public class GestionArrayList {
    private static final String LA_LISTA_SE_ENUENTRA_VACIA = "La lista se enuentra vacia";
    ArrayList<Fruta> lista;

    public GestionArrayList() {
        lista = new ArrayList<>();
    }


    public ArrayList<Fruta> getLista() {
        return this.lista;
    }

    /**
     * Metodo que permite insertar en la lista
     * @param fruta a insertar
     */
    public void insertar(Fruta fruta) {
        lista.add(fruta);
    }

    /**
     * Metodo que permite eliminar al final de la lista
     * @param fruta a eliminar
     * @throws FrutaException controlada
     */
    public void eliminar(Fruta fruta) throws FrutaException {
        if (lista.isEmpty()) {
            throw new FrutaException(LA_LISTA_SE_ENUENTRA_VACIA);
        }
        lista.remove(fruta);
    }

    @Override
    public String toString() {
        return lista.toString();
    }


}
