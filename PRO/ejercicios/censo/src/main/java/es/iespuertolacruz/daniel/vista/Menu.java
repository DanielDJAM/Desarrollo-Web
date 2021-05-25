package es.iespuertolacruz.daniel.vista;

import java.util.Scanner;

import es.iespuertolacruz.daniel.api.DatosPersonales;
import es.iespuertolacruz.daniel.controller.DatosPersonalesController;
import es.iespuertolacruz.daniel.modelo.DatosPersonalesModelo;

public class Menu {

    private static final String DEBES_INSERTAR_UN_NUMERO = "Debes insertar un numero";
    private static final String ESCRIBE_UNA_DE_LAS_OPCIONES = "Escribe una de las opciones";
    private static final String REGRESANDO_AL_MENU_ANTERIOR = "Regresando al menu anterior.";

    DatosPersonales datosPersonales;
    DatosPersonalesController datosPersonalesController;
    DatosPersonalesModelo datosPersonalesModelo;

    Scanner scan = new Scanner(System.in);
    boolean salir = false;
    int opcion;
    String mensaje = "";
    String entrada = "";
    int numero;

    public void MenuPrincipal(){
        while (!salir) {

            System.out.println("¿Que deseas hacer?");
            System.out.println("1. Insertar habitante.");
            System.out.println("2. Eliminar habitante.");
            System.out.println("3. Buscar habitante.");
            System.out.println("4. Modificar habitante.");
            System.out.println("5. Salir.");

            try {

                System.out.println(ESCRIBE_UNA_DE_LAS_OPCIONES);
                opcion = Integer.parseInt(scan.nextLine());

                switch (opcion) {
                    case 1:
                        datosPersonales = new DatosPersonales();
                        datosPersonalesController = new DatosPersonalesController();
                        System.out.println("Ingrese el dni: ");
                        entrada = scan.next();
                        datosPersonales.setDni(entrada);
                        System.out.println("Ingrese el nombre: ");
                        scan.nextLine();
                        entrada = scan.nextLine();
                        datosPersonales.setNombre(entrada);
                        System.out.println("Ingrese la fecha: ");
                        scan.nextLine();
                        entrada = scan.nextLine();
                        datosPersonales.setFecha(entrada);
                        System.out.println("Ingrese la direccion: ");
                        scan.nextLine();
                        entrada = scan.nextLine();
                        datosPersonales.setIdDireccion(entrada);
                        System.out.println("Ingrese el nombre: ");
                        scan.nextLine();
                        entrada = scan.nextLine();
                        datosPersonales.setNombre(entrada);
                        System.out.println("Ingrese el telefono: ");
                        scan.nextLine();
                        numero = scan.nextInt();
                        datosPersonales.setTelefono(numero);
                        System.out.println("Comprobando datos introducidos . . . ");
                        datosPersonalesController.insertar(datosPersonales);
                        break;
                    case 2:
                        System.out.println("Ingrese el dni del habitante a eliminar: ");
                        scan.nextLine();
                        entrada = scan.nextLine();
                        datosPersonalesController.buscar(entrada);
                        datosPersonalesController.eliminar(datosPersonales);
                        break;
                    case 3:
                        System.out.println("Ingrese el dni del habitante a buscar: ");
                        scan.nextLine();
                        entrada = scan.nextLine();
                        datosPersonalesController.buscar(entrada);
                        break;
                    case 4:
                        System.out.println("Listado de los habitantes:  ");
                        scan.nextLine();
                        entrada = scan.nextLine();
                        datosPersonalesController.;
                        break;
                    case 5:
                        System.out.println("Muchas gracias por utilizar nuestra aplicacion. Esperamos que haya sido de su agrado.");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println(DEBES_INSERTAR_UN_NUMERO);
                scan.next();
            }
        }
    }
    
}
