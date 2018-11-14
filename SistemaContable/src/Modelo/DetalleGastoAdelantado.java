package Modelo;

//Crear constructor de Consulta DetalleGastoAdelantado(int idTrans) que obtenga el registro Único de esa tabla y le asigne sus valores a los atributos correspondientes
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
