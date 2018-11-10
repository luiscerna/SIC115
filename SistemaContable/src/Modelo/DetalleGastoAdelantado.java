package Modelo;

public class DetalleGastoAdelantado {
    // Atributos
    private int idGastoA;
    private int mesesPagados;
    private double valorTotal;
    private double gastoMensual;

    // Constructor
    public DetalleGastoAdelantado() {
        
    }
    
    // Métodos getter y setter
    public int getIdGastoA() {
        return idGastoA;
    }

    public void setIdGastoA(int idGastoA) {
        this.idGastoA = idGastoA;
    }

    public int getMesesPagados() {
        return mesesPagados;
    }

    public void setMesesPagados(int mesesPagados) {
        this.mesesPagados = mesesPagados;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getGastoMensual() {
        return gastoMensual;
    }

    public void setGastoMensual(double gastoMensual) {
        this.gastoMensual = gastoMensual;
    }
}
