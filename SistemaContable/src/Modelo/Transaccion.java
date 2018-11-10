package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Transaccion {
    
    // Atributos
    private int idTrans;
    private int numeroPartida;
    private Date fechaTrans;
    private double monto;
    private String concepto;
    private DetalleActivoFijo detalleActivoFijo;
    private DetalleInteresesAcum detalleInteresesAcum;
    private DetalleGastoAdelantado detalleGastoAdelantado;
    private ArrayList<Usuarios> usuarios;
    private Tipo tipo;
    
    // Constructor
    public Transaccion() {
        
    }
    
    // Métodos getter y setter

    public int getIdTrans() {
        return idTrans;
    }

    public void setIdTrans(int idTrans) {
        this.idTrans = idTrans;
    }

    public int getNumeroPartida() {
        return numeroPartida;
    }

    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public Date getFechaTrans() {
        return fechaTrans;
    }

    public void setFechaTrans(Date fechaTrans) {
        this.fechaTrans = fechaTrans;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public DetalleActivoFijo getDetalleActivoFijo() {
        return detalleActivoFijo;
    }

    public void setDetalleActivoFijo(DetalleActivoFijo detalleActivoFijo) {
        this.detalleActivoFijo = detalleActivoFijo;
    }

    public DetalleInteresesAcum getDetalleInteresesAcum() {
        return detalleInteresesAcum;
    }

    public void setDetalleInteresesAcum(DetalleInteresesAcum detalleInteresesAcum) {
        this.detalleInteresesAcum = detalleInteresesAcum;
    }

    public DetalleGastoAdelantado getDetalleGastoAdelantado() {
        return detalleGastoAdelantado;
    }

    public void setDetalleGastoAdelantado(DetalleGastoAdelantado detalleGastoAdelantado) {
        this.detalleGastoAdelantado = detalleGastoAdelantado;
    }

    public ArrayList<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
