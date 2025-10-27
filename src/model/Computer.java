package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Computer {

    private String serialNumber;
    private boolean nextWindow;
    private ArrayList<Incident> incidents;

    /**
     * Descripción: Constructor de Computer.
     * @param serialNumber Número serial del computador.
     * @param nextWindow Indica si el computador está en la próxima ventana de mantenimiento.
     */
    public Computer(String serialNumber, boolean nextWindow) {
        this.serialNumber = serialNumber;
        this.nextWindow = nextWindow;
        this.incidents = new ArrayList<>();
    }

    // Setters

    /**
     * Descripcion: Cambia el número de serie del computador.
     * @param serialNumber Nuevo número de serie.
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Descripcion: Cambia  el computador hacia la siguiente ventana.
     * @param nextWindow True si desea seguir sino false.
     */
    public void setNextWindow(boolean nextWindow) {
        this.nextWindow = nextWindow;
    }

    // Getters

    /**
     * Descripcion: Retorna el número de serie del computador.
     * @return Número de serie.
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Descripcion: Retorna si el computador pasará a la siguiente ventana o no.
     * @return true si el computador pasa a la siguiente ventana, false en caso contrario.
     */
    public boolean getNextWindow() {
        return nextWindow;
    }

    /**
     * Descripcion: Retorna la lista de incidentes asociados a este computador.
     * @return Lista de objetos Incident que contiene los incidentes registrados.
     */
    public ArrayList<Incident> getIncidents() {
        return incidents;
    }

    /**
     * Registra un nuevo incidente para este computador.
     * @param dateReport Fecha del reporte del incidente.
     * @param description Descripción del incidente.
     */
    public void addIncident(LocalDate dateReport, String description) {
    Incident incident = new Incident(dateReport, description);
    incidents.add(incident);
    }
}


