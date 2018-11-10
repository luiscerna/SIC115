package Modelo;

import java.util.ArrayList;

public class Cardex {
    // Atributos
    private int codMaterial;
    private String nombreMaterial;
    private boolean esProducto;
    private double saldo;
    private int cantExist;
    private ArrayList<Movimiento> movimiento;

    // Constructor
    public Cardex() {
        
    }

    // Métodos getter y setter
    public int getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(int codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public boolean isEsProducto() {
        return esProducto;
    }

    public void setEsProducto(boolean esProducto) {
        this.esProducto = esProducto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCantExist() {
        return cantExist;
    }

    public void setCantExist(int cantExist) {
        this.cantExist = cantExist;
    }

    public ArrayList<Movimiento> getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(ArrayList<Movimiento> movimiento) {
        this.movimiento = movimiento;
    }
    
    
}
