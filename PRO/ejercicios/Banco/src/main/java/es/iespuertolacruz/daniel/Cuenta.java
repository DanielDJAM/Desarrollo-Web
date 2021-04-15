package es.iespuertolacruz.daniel;

import es.iespuertolacruz.daniel.Exception.CuentaException;

public class Cuenta {


    private String nombre;
    private String numero;
    private double saldo;
    private double tipoInteres;

    /**
     * Constructor por defecto.
     */

    public Cuenta(){
    }

    /**
     * Constructor con todos las propiedades.
     * @param nom nombre de la cuenta.
     * @param num numero de la cuenta.
     * @param sal saldo de la cuenta.
     * @param tipo tipo de interes.
     */

    public Cuenta(String nom, String num, double sal, double tipo){
        nombre =nom;
        numero=num;
        saldo=sal;
        tipoInteres=tipo;
        
    }

    /**
     * Metodo para ingresar una cantidad en la cuenta.
     * @param cantidad a ingresar.
     * @throws CuentaException error al ingresar.
     */

    public void ingresar(double cantidad) throws CuentaException{
        if (cantidad <= 0){
            throw new CuentaException("No se puede ingresar una cantidad negativa");
        }
        saldo = saldo + cantidad;
    }

    /**
     * Metodo para retirar de la cuenta.
     * @param cantidad a retirar.
     * @throws CuentaException error al retirar.
     */

    public void retirar(double cantidad) throws CuentaException{
        if (cantidad <= 0) {
            throw new CuentaException ("No se puede retirar una cantidad negativa");
        }
        if (getSaldo() < cantidad) {
            throw new CuentaException ("No se hay suficiente saldo");
        }
        setSaldo(getSaldo() - cantidad);
    }

    /**
     * Getters y Setters.
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    /**
     * Mostrar saldo.
     * @return retorna el saldo de la cuenta
     */

    @Override
    public String toString() {
        return "Cuenta [saldo=" + saldo + "]";
    }

    

    

    
}
