package model;

import model.Incident;
import model.Computer;
import java.util.ArrayList;
import java.time.LocalDate;

public class SchoolController {

    private String name;
    private int hourSpentSupport;
    private int FLOORS = 5;
    private int COL = 10;
    private int HOURMAXSUPPORT = 100;
    private Computer[][] matrizComputers = new Computer[FLOORS][COL];
    private ArrayList<Computer> computers = new ArrayList<>(); 

    /**
     *Descripcion: Constructor de SchoolController
     *@param name: Recibe el nombre de la escuela que en este caso es Computaricemos.
     */
    
     public SchoolController(String name) {
        this.name = name;
    }

    //Setters 

    /**
     * Descripcion: Asigna el nombre de la escuela.
     * @param name Nombre que se desea asignar.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Descripcion: Asigna las horas dedicadas a soporte técnico.
     * @param hourSpentSupport Cantidad de horas dedicadas al soporte.
     */
    public void setHourSpentSupport(int hourSpentSupport) {
        this.hourSpentSupport = hourSpentSupport;
    }

    //Getters

    /**
     * Descrpcion: Obtiene el nombre de la escuela.
     * @return Nombre de la escuela.
     */
    public String getName() {
        return name;
    }

    /**
     * Descripcion: Obtiene el total de horas dedicadas al soporte.
     * @return Horas dedicadas al soporte.
     */
    public int getHourSpentSupport() {
        return hourSpentSupport;
    }

    /**
     * Descripcion: Obtiene el número total de pisos disponibles.
     * @return Número de pisos (FLOORS).
     */
    public int getFLOORS() {
        return FLOORS;
    }

    /**
     * Descripcion: Obtiene el número total de columnas disponibles.
     * @return Número de columnas (COL).
     */
    public int getCOL() {
        return COL;
    }

    /**
     * Descripcion: Retorna la matriz de computadores.
     * @return Matriz bidimensional de objetos Computer.
     */
    public Computer[][] getMatrizComputers() {
        return matrizComputers;
    }

    /**
     * Descripcion: Permite registrar un nuevo computador en la matriz, validando que su número serial sea único.
     * @param serialNumber Número serial único del computador.
     * @param nextWindow Indica si el computador está junto a una ventana.
     * @return Mensaje confirmando si el computador fue agregado o si no hay espacio disponible.
     */
    public String agregarComputador(String serialNumber, boolean nextWindow) {
        String mensaje = "";
        if (existeSerial(serialNumber)) {
            mensaje += "Ya existe un computador con el serial " + serialNumber + ". Por favor ingresa uno diferente.";
            return mensaje;
        }

        for (int f = 0; f < FLOORS; f++) {
            for (int c = 0; c < COL; c++) {
                if (matrizComputers[f][c] == null) {
                    matrizComputers[f][c] = new Computer(serialNumber, nextWindow);
                    mensaje += "Computador agregado correctamente en el piso "  + f +  " y columna "  + c +  " con serial " + serialNumber;
                    return mensaje;
                }
            }
        }
        mensaje += "No hay espacios disponibles para agregar más computadores.";
        return mensaje;
    }

    /**
     * Descripcion: Verifica si ya existe un computador con el mismo número serial.
     * @param serialNumber Número serial que se desea validar.
     * @return true si el serial ya existe, false en caso contrario.
     */
    public boolean existeSerial(String serialNumber) {
    for (int f = 0; f < FLOORS; f++) {
        for (int c = 0; c < COL; c++) {
            Computer existComputer = matrizComputers[f][c];
            if (existComputer != null && existComputer.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                return true;
            }
        }
    }
    return false;
    }

    
    /**
     * Descripcion: Registra un nuevo incidente en un computador específico, identificado por su posición en la matriz.
     * @param f Fila (piso) donde se encuentra el computador.
     * @param c Columna donde se encuentra el computador.
     * @param dateReport Fecha del reporte del incidente.
     * @param description Descripción del incidente.
     * @return Mensaje indicando el resultado de la operación (si se agregó o si no existe el computador).
     **/
    public String agregarIncidenteEnComputador(int f, int c, LocalDate dateReport, String description) {
        String mensaje = "";
        Computer incComputer = matrizComputers[f][c];

        if (incComputer == null) {
            return "No hay computador en esta posición.";
        }
        
        if (f < 0 || f >= FLOORS) {
            mensaje += "No existe ese numero de fila";
        } else if(c < 0 || c >= COL) {
        mensaje += "No existe ese numero de columna";
        }

        incComputer.addIncident(dateReport, description);
        
        mensaje += "Incidente agregado al computador con serial: " + incComputer.getSerialNumber();
        return mensaje;
    }

    /**
     * Descripcion: Busca la posición de un computador específico dentro de la matriz.
     * @param computers Objeto Computer del cual se desea conocer su ubicación.
     * @return Mensaje con la ubicación del computador (piso y columna) o "Ubicación no encontrada".
     */
    public String SearchPositionComputer(Computer computers) {
        String mensaje = "";
        for (int f = 0; f < FLOORS; f++) {
            for (int c = 0; c < COL; c++) {
                if (matrizComputers[f][c] == computers) {
                mensaje += "Piso: " + f + ", Columna: " + c;
                return mensaje;
                }
            }
        }
        mensaje += "Ubicación no encontrada.";
        return mensaje;
    }

    /**
     * Descripcion: Retorna el computador que tenga la mayor cantidad de incidentes registrados.
     * @return Mensaje con la información del computador con más incidentes.
     */
    public String getComputerList() {
        Computer maxComputer = null;
        int maxIncidents = 0;
        String mensaje = "";
        
        for (int f = 0; f < FLOORS; f++) {
            for (int c = 0; c < COL; c++) {
                Computer maxIncComputer = matrizComputers[f][c];
                if (maxIncComputer != null && maxIncComputer.getIncidents().size() > maxIncidents) {
                    maxIncidents = maxIncComputer.getIncidents().size();
                    maxComputer = maxIncComputer;
                }
            }
        }

        if (maxComputer == null) {
            mensaje += "No hay computadores registrados o no tienen inidentes";
        } else {
            mensaje += "Computador con más incidentes: \n";
            mensaje += "Serial: " + maxComputer.getSerialNumber() + "\n";
            mensaje += "Piso y columna del computador:" + SearchPositionComputer(maxComputer) + "\n";
            mensaje += "Total de incidentes: " + maxIncidents;
        }
        return mensaje;
    }
}
