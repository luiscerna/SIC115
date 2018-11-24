package Modelo;

import Datos.Conexion;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Movimiento {
    // Atributos
    private int idMov;
    private boolean esSalida;
    private Date fechaMov;
    private int cant;
    private double monto;
    private double precioU;
    private int codMaterial;

    // Constructor
    public Movimiento() {
        
    }
    
    //Constructor de consulta
    public Movimiento(int idMov){
     try {
            Conexion conexion = new Conexion();
            this.setIdMov(idMov);
            String query;
            query = "SELECT * FROM Movimiento WHERE idMov= "+ this.getIdMov()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            if(conexion.rs.next()){
                this.setIdMov(conexion.rs.getInt("idMov"));
                this.setCodMaterial(conexion.rs.getInt("codMaterial"));
                this.setFechaMov(conexion.rs.getDate("fechaMov"));
                this.setEsSalida(conexion.rs.getBoolean("esSalida"));
                this.setCant(conexion.rs.getInt("cant"));
                this.setMonto(conexion.rs.getDouble("montoT"));
                this.setPrecioU(conexion.rs.getDouble("precioU"));   
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DetalleTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public int getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(int codMaterial) {
        this.codMaterial = codMaterial;
    }
    
}
