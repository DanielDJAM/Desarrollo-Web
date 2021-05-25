package es.iespuertolacruz.daniel;

import es.iespuertolacruz.daniel.api.DatosPersonales;

public class UtilidadesTest {

    private static final String DNI = "12345678D";
    private static final String NOMBRE = "Daniel";
    private static final String FECHA = "20/20/20";
    private static final int TELEFONO = 555666777;
    private static final String IDDIRECCION = "12345678D";
/*
    private static final String IDDIRECCION = "12345678D";
    private static final String CODIGOPOSTAL = "12345";
    private static final String CALLE = "San Jeronimo";
    private static final String PUERTA = "1ºA";
    private static final String PROVINCIA = "Santa Cruz de Tenerife";
    private static final String PAIS = "Espania";

    protected Direccion crearDireccion(String idDireccion, String codigoPostal, String calle, String puerta, String provincia, String pais){
        Direccion direccion = null;
        if (idDireccion != null && codigoPostal != null && calle != null && puerta != null && provincia != null && pais != null) {
            direccion = new Direccion(idDireccion, codigoPostal, calle, puerta, provincia, pais);
        } else {
            direccion = new Direccion();
            direccion.setIdDireccion(IDDIRECCION);
            direccion.setCodigoPostal(CODIGOPOSTAL);
            direccion.setCalle(CALLE);
            direccion.setPuerta(PUERTA);
            direccion.setProvincia(PROVINCIA);
            direccion.setPais(PAIS);
        }
        return direccion;
    }*/

    

    protected DatosPersonales crearDatosPersonales(String dni, String nombre, String fecha, String  idDireccion, int telefono) {
        DatosPersonales datosPersonales = null;
        if (dni != null && nombre != null && fecha != null && idDireccion != null && telefono != 0 ){
            datosPersonales = new DatosPersonales(dni, nombre, fecha, idDireccion, telefono);
        } else {
            datosPersonales = new DatosPersonales();
            datosPersonales.setDni(DNI);
            datosPersonales.setNombre(NOMBRE);
            datosPersonales.setFecha(FECHA);
            datosPersonales.setIdDireccion(IDDIRECCION);
            datosPersonales.setTelefono(TELEFONO);
            
        }
        return datosPersonales;
    }
    
}
