package Modelo;

import java.util.Date;

public class Movimiento {
    // Atributos
    private int idMov;
    private boolean esSalida;
    private Date fechaMov;
    private int cant;
    private double monto;
    private double precioU;

    // Constructor
    public Movimiento() {
        
    }

    // Métodos getter y setter
    public int getIdMov() {
        return idMov;
    }

    public void setIdMov(int idMov) {
        this.idMov = idMov;
    }

    public boolean isEsSalida() {
        return esSalida;
    }

    public void setEsSalida(boolean esSalida) {
        this.esSalida = esSalida;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }
    
}
