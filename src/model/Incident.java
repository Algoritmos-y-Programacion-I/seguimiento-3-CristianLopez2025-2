package model;
import java.time.LocalDate;


public class Incident {

    private LocalDate dateReport;
    private String description;
    private boolean solution;
    private int solutionHours; 

    /**
     * Descripcion: Constructor del incident.
     * @param dateReport Fecha del reporte del incidente.
     * @param description Descripcion del incidente. 
     */
    public Incident (LocalDate dateReport, String description) {
    this.dateReport = dateReport;
    this.description = description;
    }

    // Setters

    /**
     * Descripcion: Cambia la fecha del reporte del incidente.
     * @param dateReport Nueva fecha del reporte.
     */
    public void setDateReport(LocalDate dateReport) {
        this.dateReport = dateReport;
    }

    /**
     * Descripcion: Cambia la descripción del incidente.
     * @param description Nueva descripción.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Descripcion: Indica si el incidente fue solucionado o no.
     * @param solution true si está solucionado, false si no.
     */
    public void setSolution(boolean solution) {
        this.solution = solution;
    }

    /**
     * Descripcion: Registra las horas utilizadas para resolver el incidente.
     * @param solutionHours Número de horas de solución.
     */
    public void setSolutionHours(int solutionHours) {
        this.solutionHours = solutionHours;
    }

    //Getters
    /**
     * Descripcion: Obtiene la fecha del reporte.
     * @return Fecha del reporte.
     */
    public LocalDate getDateReport() {
        return dateReport;
    }

    /**
     * Descrpcion: Obtiene la descripción del incidente.
     * @return Descripción del incidente.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Descripcion: Verifica si el incidente fue solucionado.
     * @return true si fue solucionado, false si no.
     */
    public boolean getSolution() {
        return solution;
    }

    /**
     * Descripcion: Obtiene las horas que tomó resolver el incidente.
     * @return Horas de solución.
     */
    public int getSolutionHours() {
        return solutionHours;
    }
}