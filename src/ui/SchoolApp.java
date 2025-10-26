package ui;

import java.util.Scanner;
import model.SchoolController;

public class SchoolApp {

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para conectar esta clase con el
     * modelo.
     */

    private Scanner input;

    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.menu();

    }

    // Constructor
    public SchoolApp() {
        input = new Scanner(System.in);
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos
     */

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

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos
     */

    public void registrarComputador() {
        System.out.println("Ingrese el número serial: ");
        String serialNumber = Scanner.nextLine();

        System.out.println("¿Está junto a una ventana? (true/false): ");
        boolean nextWindow = Scanner.nextBoolean();
        Scanner.nextLine();

        System.out.println(SchoolController.agregarComputador(serialNumber, nextWindow));

        System.out.println("Todos los espacios han sido procesados.");
    }

    public void registrarIncidenteEnComputador() {
        System.out.print("Ingrese el piso: ");
        int FLOORS = Scanner.nextInt();
        
        System.out.print("Ingrese la columna: ");
        int COL = Scanner.nextInt();
        Scanner.nextLine(); 
        
        System.out.print("Descripción del incidente: ");
        String description = Scanner.nextLine();
        
        SchoolController.addIncidentToComputer(FLOORS, COL, description);
    }

    public void consultarComputadorConMasIncidentes() {
        System.out.println(SchoolController.getComputerList());
        break;
    }

}
