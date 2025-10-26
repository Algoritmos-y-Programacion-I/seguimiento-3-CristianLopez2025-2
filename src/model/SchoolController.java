package model;

import model.Incident;
import model.Computer;

public class SchoolController {

    private String name;
    private int hourSpentSupport;
    private int FLOORS = 5;
    private int COL = 10;
    private int HOURMAXSUPPORT = 100;
    private Computer[][] matrizComputers = new Computer[FLOORS][COL];
    private ArrayList<Computer> computers; 

    /**
     *Descripcion: Constructor de SchoolController
     *@param name: Recibe el nombre de la escuela que en este caso es Computaricemos.
     */
    
     public SchoolController(String name) {
        this.name = name;
    }

    //Setters 

    public void setName(String name) {
        this.name = name;
    }

    public void setHourSpentSupport(int hourSpentSupport) {
        this.hourSpentSupport = hourSpentSupport;
    }

    public void setFLOORS(int FLOORS) {
        this.FLOORS = FLOORS;
    }

    public void setCOL(int COL) {
        this.COL = COL;
    }

    //Getters

    public String getName() {
        return name;
    }

    public int getHourSpentSupport() {
        return hourSpentSupport;
    }

    public int getFLOORS() {
        return FLOORS;
    }

    public int getCOL() {
        return COL;
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
    public String agregarComputador(String SerialNumber, boolean nextWindow) {
        String mensaje = "";
        for (int f = 0; f < getFLOORS(); f++) { 
            for (int c = 0; c < getCOL(); c++) {
                if (f < 0 || f >= FLOORS) {
                mensaje += "No existe ese numero de fila"
                } else(c < 0 || c >= COL) {
                mensaje += "No existe ese numero de columna"
                }

                if (matrizComputers[FLOORS][COL] != null) {
                mensaje += "La posición (" + f + "," + c + ") ya está ocupada.";
                }
        
                matrizComputers[FLOORS][COL] = new Computer(serial, nextWindow);
                mensaje += "Computador " + serial + " agregado correctamente";
            }
        }
        return mensaje;
    }
    

    public String agregarIncidenteEnComputador(int FLOORS, int COL, String description) {
        String mensaje = "";
        for (int f = 0; f < getFLOORS(); f++) { 
            for (int c = 0; c < getCOL(); c++) {
                if (f < 0 || f >= FLOORS) {
                mensaje += "No existe ese numero de fila"
            } else(c < 0 || c >= COL) {
                mensaje += "No existe ese numero de columna"
            }
            retrun false;
            }
        }
        
        Computer incComputer = Computer[FLOORS][COL];
        if (incComputer == null) {
            mensaje += "No hay computaodr en esta posicion"
            return false;   
        }

        incComputer.addIncident(description);
        mensaje += "Incidente agregado al computador:" + incComputer.getSerialNumber();

        return mensaje;
    }

    public String SearchPositionComputer(Computer computers) {
        String mensaje = "";
        for (int f = 0; f < FLOORS; f++) {
            for (int c = 0; c < COL; c++) {
                if (Computer[FLOORS][COL] == computers) {
                mensaje += "Piso: " + f + ", Columna: " + c;
                }
            }
        }
        mensaje += "Ubicación no encontrada.";
        return mensaje;
    }

    public String getComputerList() {
        Computer maxComputer = null;
        int maxIncidents = 0;

        String mensaje = ""
        for (int f = 0; f < FLOORS; f++) {
            for (int c = 0; c < COL; c++) {
                Computer maxIncComputer = Computer[FLOORS][COL];
                if (maxIncComputer != null && maxIncComputer.getIncidents().size() > maxIncidents) {
                    maxIncidents = maxIncComputer.getIncidents().size();
                    maxComputer = maxIncComputer;
                }
            }
        }

        if (maxComputer == null) {
            mensaje += "No hay computadores registrados o no tienen inidentes"
        } else {
            mensaje += "Computador con más incidentes:\n" +
                       "Serial: " + maxComputer.getSerialNumber() + "\n" +
                       "Piso y columna del computador" + SearchPositionComputer(maxComputer)
                       "Total de incidentes: " + maxIncidents + "\n";
        }
        return mensaje;
    }
}
