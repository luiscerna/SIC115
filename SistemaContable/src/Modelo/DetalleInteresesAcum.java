package Modelo;
//Crear constructor de consulta DetalleInteresesAcum(int idTrans) que obtenga el registro Único de esa tabla y le asigne sus valores a los atributos correspondientes

import Datos.Conexion;
import java.sql.SQLException;

public class DetalleInteresesAcum {
    // Atributos
    private int idAcum;
    private int idTrans;
    private double valorPresente;
    private double tasaAnual;
    private double tasaMensual;
    private double interesMensual;

    // Constructor
    public DetalleInteresesAcum(){
            
    }
    
    public DetalleInteresesAcum(int idTrans, double valorPresente, double tasaAnual) 
    {
        /*Debe hacer lo siguiente:
        --obtener el idAcum aumentando 1 al ultimo registrado
        --Calcular la this.tasaMensual
        --Calcular el this.interesMensual
        --Asignar los valores a sus respectivas variables
        --Al final, hacer el registro en la BD
        */
        
    }
    
    public DetalleInteresesAcum(int idTrans) throws SQLException
    {
        //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "SELECT idAcum, idTrans, valorPresente, tasaAnual, tasaMensual, interesMensual FROM DetalleInteresesAcum WHERE idTrans= ?";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setInt(1, idTrans);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.next()){
            int idAcum = conexion.rs.getInt("idAcum");
            int id = conexion.rs.getInt("idTrans");
            double valorPresente= conexion.rs.getDouble("valorPresente");
            double tasaAnual=conexion.rs.getDouble("tasaAnual");
            double tasaMensual=conexion.rs.getDouble("tasaMensual");
            double interesMensual=conexion.rs.getDouble("interesMensual");
            this.idAcum=idAcum;
            this.idTrans=id;
            this.valorPresente=valorPresente;
            this.tasaAnual=tasaAnual;
            this.tasaMensual=tasaMensual;
            this.interesMensual=interesMensual;
            
        }
        
        
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
