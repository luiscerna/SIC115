package Modelo;

import java.util.ArrayList;

public class DetalleTransaccion {
    // Atributos
    private int idDetalle;
    private String cuentaMayor;
    private double debe;
    private double haber;
    private ArrayList<Catalogo> catalogo;
    private Transaccion transaccion;
    
    // Constructor
    public DetalleTransaccion(){
        
    }
    
    //Métodos getter y setter
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getCuentaMayor() {
        return cuentaMayor;
    }

    public void setCuentaMayor(String cuentaMayor) {
        this.cuentaMayor = cuentaMayor;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public ArrayList<Catalogo> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Catalogo> catalogo) {
        this.catalogo = catalogo;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
}
