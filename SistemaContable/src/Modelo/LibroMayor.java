package Modelo;

import java.util.ArrayList;

public class LibroMayor {
    // Atributos
    private int idMayor;
    private String codCuenta;
    private String nombreCuenta;
    private double montoTotal;
    private ArrayList<DetalleTransaccion> detalleTransaccion;
    
    // Constructor 
    public LibroMayor() {
    }
     
    // Métodos getter y setter
    public int getIdMayor() {
        return idMayor;
    }

    public void setIdMayor(int idMayor) {
        this.idMayor = idMayor;
    }

    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public ArrayList<DetalleTransaccion> getDetalleTransaccion() {
        return detalleTransaccion;
    }

    public void setDetalleTransaccion(ArrayList<DetalleTransaccion> detalleTransaccion) {
        this.detalleTransaccion = detalleTransaccion;
    }
}
