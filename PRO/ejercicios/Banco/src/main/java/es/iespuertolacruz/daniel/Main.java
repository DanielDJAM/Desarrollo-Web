package es.iespuertolacruz.daniel;

import es.iespuertolacruz.daniel.Exception.CuentaException;

public class Main {

    Cuenta cuenta;
    String saldoActual;

    public void gestionCuenta() throws CuentaException {
    
        cuenta = new Cuenta("Antonio López","1000-2365-85-1230456789",2500,0);
        saldoActual = cuenta.toString();
        try {
        cuenta.retirar(2300);
        cuenta.ingresar(695);
        }catch (CuentaException e) {
            throw new CuentaException("error");
        }
    }
}
