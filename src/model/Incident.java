package model;
import java.util.LocalDate;


public class Incident {

    private LocalDate dateReport;
    private String description;
    private boolean solution;
    private int solutionHours; 


    public Incident (LocalDate dateReport, String description) {
    this.dateReport = dateReport;
    this.description = description;
    }

    // Setters

    public void setDateReport(LocalDate dateReport) {
        this.dateReport = dateReport;
    }

    public void setDescription(String description) {
        this.decription = description;
    }

    public void setSolution(boolean solution) {
        this.solution = solution;
    }

    public void setSolutionHours(int solutionHours) {
        this.solutionHours = solutionHours;
    }

    //Getters

    public LocalDate getDateReport() {
        return dateReport;
    }

    public String getDescription() {
        return description;
    }

    public boolean getSolution() {
        return solution;
    }

    public int getSolutionHours() {
        return solutionHours;
    }
}
