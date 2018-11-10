package Modelo;

public class TarjetaDeTrabajo {
    // Atributos
    private int idTarj;
    private int cantHorasExtra;
    private int cantHorasTrab;
    private int cantHorasTarde;

    // Constructor
    public TarjetaDeTrabajo() {
        
    }

    // Métodos getter y setter
    public int getIdTarj() {
        return idTarj;
    }

    public void setIdTarj(int idTarj) {
        this.idTarj = idTarj;
    }

    public int getCantHorasExtra() {
        return cantHorasExtra;
    }

    public void setCantHorasExtra(int cantHorasExtra) {
        this.cantHorasExtra = cantHorasExtra;
    }

    public int getCantHorasTrab() {
        return cantHorasTrab;
    }

    public void setCantHorasTrab(int cantHorasTrab) {
        this.cantHorasTrab = cantHorasTrab;
    }

    public int getCantHorasTarde() {
        return cantHorasTarde;
    }

    public void setCantHorasTarde(int cantHorasTarde) {
        this.cantHorasTarde = cantHorasTarde;
    }
    
}
