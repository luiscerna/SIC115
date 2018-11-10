package Modelo;

public class Puesto {
    // Atributos
    private int codPuesto;
    private String nombrePuesto;
    private double sueldoBase;

    // Constructor
    public Puesto() {
        
    }

    // Métodos getter y setter
    public int getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(int codPuesto) {
        this.codPuesto = codPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
    
    
}
