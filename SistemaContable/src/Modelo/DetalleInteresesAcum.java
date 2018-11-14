package Modelo;
//Crear constructor de consulta DetalleInteresesAcum(int idTrans) que obtenga el registro Único de esa tabla y le asigne sus valores a los atributos correspondientes
public class DetalleInteresesAcum {
    // Atributos
    private int idAcum;
    private double valorPresente;
    private double tasaAnual;
    private double tasaMensual;
    private double interesMensual;

    // Constructor
    public DetalleInteresesAcum() {
        
    }
    
    // Métodos getter y setter
    public int getIdAcum() {
        return idAcum;
    }

    public void setIdAcum(int idAcum) {
        this.idAcum = idAcum;
    }

    public double getValorPresente() {
        return valorPresente;
    }

    public void setValorPresente(double valorPresente) {
        this.valorPresente = valorPresente;
    }

    public double getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(double tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public double getTasaMensual() {
        return tasaMensual;
    }

    public void setTasaMensual(double tasaMensual) {
        this.tasaMensual = tasaMensual;
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public void setInteresMensual(double interesMensual) {
        this.interesMensual = interesMensual;
    }
    
}
