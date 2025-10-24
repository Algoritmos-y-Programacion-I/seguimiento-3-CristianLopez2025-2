package model;

import model.Incident;
import model.Computer;

public class SchoolController {

    private String name;
    private int hourSpentSupport;
    int FLOORS = 5;
    int COL = 10;
    int[][] matrizComputers = new int[FLOORS][COL];

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para satisfacer los
     * requerimientos.
     */

    public SchoolController(String name, int hourSpentSupport ) {
        this.name = name;
        this.hourSpentSupport = hourSpentSupport;
    }

    

    //Setters 

    public void setName(String name) {
        this.name = name;
    }

    public void setHourSpentSupport(int hourSpentSupport) {
        this.hourSpentSupport = hourSpentSupport;
    }

    //Getters

    public String getName() {
        return name;
    }

    public int getHourSpentSupport() {
        return hourSpentSupport;
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Añada los metodos que considere hagan falta para satisfacer los
     * requerimientos.
     * Para cada metodo:
     * Agregue los parametros y retorno que sean pertinentes.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos.
     */
    public String agregarComputador(String SerialNumber) {

    }

    public void agregarIncidenteEnComputador() {

    }

    public void getComputerList() {

    }

}
