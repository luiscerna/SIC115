package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Planilla {
    // Atributos
    private int idPlanilla;
    private Date fechaPlantilla;
    private ArrayList<Empleado> empleado;

    // Constructor
    public Planilla() {
        empleado =  new ArrayList<>();
    }

    // Métodos getter y setter
    public int getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(int idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public Date getFechaPlantilla() {
        return fechaPlantilla;
    }

    public void setFechaPlantilla(Date fechaPlantilla) {
        this.fechaPlantilla = fechaPlantilla;
    }

    public ArrayList<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(ArrayList<Empleado> empleado) {
        this.empleado = empleado;
    }
}
