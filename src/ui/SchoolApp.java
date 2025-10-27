package ui;

import java.util.Scanner;
import java.time.LocalDate;
import model.SchoolController;

public class SchoolApp {

    private Scanner input;
    private SchoolController controller;

    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.menu();

    }

    // Constructor
    public SchoolApp() {
        input = new Scanner(System.in);
        controller = new SchoolController("Computaricemos");
    }

    public void menu() {

        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("0) Salir del sistema");
            option = input.nextInt();

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

    }

    public void registrarComputador() {
        System.out.println("Ingrese el número serial: ");
        input.nextLine();
        String serialNumber = input.nextLine();

        if (controller.existeSerial(serialNumber)) {
            System.out.println("Ya existe un computador con el serial " + serialNumber + ". Por favor ingresa uno diferente.");
            return;
        }

        System.out.println("¿Está junto a una ventana? (Si/ No): ");
        String respuesta = input.nextLine().trim().toLowerCase();
        boolean nextWindow = respuesta.equals("si");
        

        System.out.println(controller.agregarComputador(serialNumber, nextWindow));
    }

    public void registrarIncidenteEnComputador() {
        System.out.print("Ingrese el piso donde se encuentra ubicado el computador de (0-4): ");
        int f = input.nextInt();
        
        System.out.print("Ingrese la columna donde se encuentra ubicado el computador de (0-9): ");
        int c = input.nextInt();
        input.nextLine(); 

        if (controller.getMatrizComputers()[f][c] == null) {
            System.out.println("No hay computador en esa posición.");
            return;
        }
        
        System.out.print("Descripción del incidente: ");
        String description = input.nextLine();

        System.out.println("Ingrese la fecha en la que se reporto el computador (año-mes-dia)");

        LocalDate dateReport = LocalDate.parse(input.nextLine());
        
        System.out.println(controller.agregarIncidenteEnComputador(f, c, dateReport, description));
    }

    public void consultarComputadorConMasIncidentes() {
        System.out.println(controller.getComputerList());
    }

}
