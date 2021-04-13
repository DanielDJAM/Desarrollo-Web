package es.iespuertolacruz.daniel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GestionPlantas {

    HashMap<String, Planta> plantas;

    public GestionPlantas() {
        plantas = new HashMap<String, Planta>();
    }

    public HashMap<String, Planta> getPlantas() {
        return plantas;
    }

    public void insertar(String key, Planta planta) {
        plantas.put(key, planta);
    }

/** 
    public Planta buscarID(String id){
        if (plantas.containsKey(id)){
            return plantas.get(id);
        }
        for (HashMap.Entry<String, Planta> lista : plantas.entrySet())
            if (lista == plantas.get(id)){
                plantas.get(id);
            }
        }
    }
*/
    public Planta buscarID(String clave, HashMap<String, Planta> listaProductos) {
        Planta planta = null;
        if (listaProductos.containsKey(clave)) {
            return listaProductos.get(clave);
            }
        return planta;
        // clave.equals(productos.next())

    }

    public Planta buscarPlanta(Planta planta, HashMap<String, Planta> listaProductos) {
        boolean encontrado = false;
        int i = 0;
        while (i > listaProductos.size() || !encontrado){
            if(listaProductos.get(i)){
                encontrado = true;
            }
            i++;
        }
    }

    public void eliminar(String key, Planta planta){
        plantas.remove(key, planta);
    }

    public String mostrarPlanta(){
    }

    /**
     * public Planta mostrarProductos(Planta planta, HashMap<String, Planta>
     * listaProductos) { Iterator<String> productos =
     * listaProductos.keySet().iterator(); while(productos.hasNext()){ if
     * (listaProductos.equals(productos)){ planta = listaProductos.; return planta;
     * } } }
     */
    /**
     * 
     * public HashMap<String, Planta> buscarID(String id){ HashMap<String, Planta>
     * lista = new HashMap<>(); if (id == plantas.get(id){ plantas.get(id); } for
     * (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) }
     * 
     */

}
