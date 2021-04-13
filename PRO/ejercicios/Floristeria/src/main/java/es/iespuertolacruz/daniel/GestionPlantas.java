package es.iespuertolacruz.daniel;

import java.util.HashMap;
import java.util.Map;

public class GestionPlantas {

    HashMap<String, Planta> plantas;

    /**
     * Constructor de la clase.
     */

    public GestionPlantas() {
        plantas = new HashMap<>();
    }

    /**
     * Getter del HashMap.
     * @return la lista.
     */

    public Map<String, Planta> getPlantas() {
        return plantas;
    }

    /**
     * Metodo para insertar en el HashMap
     * @param key a insertar.
     * @param planta objeto a insertar.
     */

    public void insertar(String key, Planta planta) {
        plantas.put(key, planta);
    }
    
    /**
     * Funcion para buscar un objeto por la Key del HashMap
     * @param clave a buscar.
     * @param listaProductos HashMap en el que se busca.
     * @return retorna el objeto planta y si no lo encuentra, nulo.
     */

    public Planta buscarID(String clave, Map<String, Planta> plantas) {
        Planta planta = null;
        if (plantas.containsKey(clave)) {
            return plantas.get(clave);
            }
        return planta;
        // clave.equals(productos.next())

    }

    /**
     * Funcion para buscar una planta por el objeto planta.
     * @param planta objeto a buscar.
     * @return retorna el objeto si lo encuentra o nulo si es al contrario.
     */

    public Planta buscarPlanta(Planta planta) {
        Planta planta2 = null;
        if (plantas.containsKey(planta.getId())) {
            planta2 = plantas.get(planta.getId());
            return planta2;
        }
        return planta2;
    }

    /**
     * Metodo para eliminar en el HashMap.
     * @param key clave a eliminar.
     * @param planta a eliminar.
     */

    public void eliminar(String key, Planta planta){
        plantas.remove(key, planta);
    }

    /**
     * Funcion para listar el objeto definido por la clave.
     * @return retorna el objeto listado.
     */

    public String mostrarPlanta(String clave, Map<String, Planta> plantas){
        Planta planta = buscarID(clave, plantas);
        return planta.toString();
    }

    /**
     * Verificar si existe en la lista por la clave.
     * @param key clave.
     * @return retorna true si existe o false si es al contrario.
     */

    public Boolean existe(String key){
        return plantas.containsKey(key);
    }

   

}
