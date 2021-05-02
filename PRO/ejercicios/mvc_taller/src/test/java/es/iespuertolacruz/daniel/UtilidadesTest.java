package es.iespuertolacruz.daniel;

import es.iespuertolacruz.daniel.api.Vehiculo;

public class UtilidadesTest {

    protected static final String MARCA = "FORD";
    protected static final String MATRICULA = "1111AAA";

    protected Vehiculo crearVehiculo(String matricula, String marca){
        Vehiculo vehiculo = null;
        if (matricula != null && marca != null){
            vehiculo = new Vehiculo(matricula, marca);
        } else {
            vehiculo = new Vehiculo();
            vehiculo.setMatricula(MATRICULA);
            vehiculo.setMarca(MARCA);
        }
        return vehiculo;
    }
    
}
