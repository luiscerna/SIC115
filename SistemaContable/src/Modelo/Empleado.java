package Modelo;

import java.util.ArrayList;

public class Empleado {
    // Atributos
    private String codEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private boolean esObrero;
    private ArrayList<TarjetaDeTrabajo> tarjetaDeTrabajo;

    // Constructor
    public Empleado() {
        
    }
    
    // Métodos getter y setter
    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public boolean isEsObrero() {
        return esObrero;
    }

    public void setEsObrero(boolean esObrero) {
        this.esObrero = esObrero;
    }

    public ArrayList<TarjetaDeTrabajo> getTarjetaDeTrabajo() {
        return tarjetaDeTrabajo;
    }

    public void setTarjetaDeTrabajo(ArrayList<TarjetaDeTrabajo> tarjetaDeTrabajo) {
        this.tarjetaDeTrabajo = tarjetaDeTrabajo;
    }
}
