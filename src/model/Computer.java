package model;

public class Computer {

    private String serialNumber;
    private boolean nextWindow;
    private computer[] computers;
    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para satisfacer los
     * requerimientos.
     */

    public Computer(String serialNumber, boolean nextWindow, computer[] computers) {
        this.serialNumber = serialNumber;
        this.nextWindow = nextWindow;
        this.computer = new computer[0];
    }

    //Setters

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setNextWindow(boolean nextWindow) {
        this.nextWindow = nextWindow;
    }
    
    public void setComputer(computer[] computers) {
        this.computers = computers;
    }

    //Getters

    public String getSerialNumber(String serialNumber) {
        return serialNumber;
    }

    public boolean getNextWindow(boolean nextWindow) {
        return nextWindow;
    }

    public computer[] getcomputers() {
        return computers;
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue los parametros y retorno que sean pertinentes.
     * Agregue la logica necesaria.
     */
    public void addIncident(LocalDate dateReport, String description, String serialNumber) {
        for(int i = 0; i < computers.length; i++){
            if( computers[i] == null) {
                computers[i] = new computer(serialNumber, dateReport, description);
                break;
            }
        }
    }

}
