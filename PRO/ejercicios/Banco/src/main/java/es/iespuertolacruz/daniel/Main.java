package es.iespuertolacruz.daniel;

public class Main {

    public static void main(String[] args) {
        Cuenta cuenta;
        double saldoActual;

        cuenta = new Cuenta("Antonio López","1000-2365-85-1230456789",2500,0);
        saldoActual = cuenta.getSaldo();
        System.out.println("El saldo actual es"+ saldoActual );

        try {
            cuenta.retirar(2300);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        try {
            System.out.println("Ingreso en Cuenta");
            cuenta.ingresar(695);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
    }
}
