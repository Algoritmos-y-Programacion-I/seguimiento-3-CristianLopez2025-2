package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Computer {

    private String serialNumber;
    private boolean nextWindow;
    private ArrayList<Incident> incidents;
    
    /**
     * Descripcion: Constructor de Computer.
     * @param serialNumber: El numero serial del computador
     * @param nextWindow: Sirve para verificar
     * @param incidents: Crea un ArrayList con los incidentes que han tenido los computadores. 
    */
    public Computer(String serialNumber, boolean nextWindow, ArrayList<Incident> incidents) {
        this.serialNumber = serialNumber;
        this.nextWindow = nextWindow;
        this.incidents = incidents;
    }

    //Setters

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setNextWindow(boolean nextWindow) {
        this.nextWindow = nextWindow;
    }
    
    //Getters

    public String getSerialNumber(String serialNumber) {
        return serialNumber;
    }

    public boolean getNextWindow(boolean nextWindow) {
        return nextWindow;
    }

    public ArrayList<Incident> getIncidents() {
        return incidents;
    }

    /**
     * Descrpcion: Registra un incidente que haya tenido un computador.
     * @param dateReport  Fecha de reporte del incidente.
     * @param description Descripción del incidente.
     * 
     */
    public void addIncident(LocalDate dateReport, String description, String serialNumber) {
        Incident incid = new Incident(dateReport, description);
        incidents.add(incid);
    }

}
