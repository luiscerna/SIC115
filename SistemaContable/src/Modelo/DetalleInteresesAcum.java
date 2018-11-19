package Modelo;
//Crear constructor de consulta DetalleInteresesAcum(int idTrans) que obtenga el registro Único de esa tabla y le asigne sus valores a los atributos correspondientes

import Datos.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleInteresesAcum {
    // Atributos
    private int idAcum;
    private Transaccion trans;
    private double valorPresente;
    private double tasaAnual;
    private double tasaMensual;
    private double interesMensual;

    // Constructor
    public DetalleInteresesAcum(){
            
    }
    
    public DetalleInteresesAcum(Transaccion trans, double valorPresente, double tasaAnual) 
    {
        /*Debe hacer lo siguiente:
        --obtener el idAcum aumentando 1 al ultimo registrado
        --Calcular la this.tasaMensual
        --Calcular el this.interesMensual
        --Asignar los valores a sus respectivas variables
        --Al final, hacer el registro en la BD
        */
       
        try{
        Conexion conexion = new Conexion();
        String query;
                query = "SELECT idAcum FROM DetalleInteresesAcum ORDER BY idAcum DESC LIMIT 1;";
                conexion.pst= conexion.conectar().prepareStatement(query);
                conexion.rs = conexion.pst.executeQuery();
                conexion.rs.next();
                int id = conexion.rs.getInt("idAcum");
                id += 1;
                setIdAcum(id);
          
        this.tasaMensual = tasaAnual/12;
        this.interesMensual = this.tasaMensual*valorPresente;
                
        query = "INSERT INTO DetalleInteresesAcum (idAcum, idTrans, valorPresente, tasaAnual, tasaMensual, interesMensual) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setInt(1, getIdAcum());
        conexion.pst.setInt(2, trans.getIdTrans());
        conexion.pst.setDouble(3, valorPresente);
        conexion.pst.setDouble(4, tasaAnual);
        conexion.pst.setDouble(5, this.tasaMensual);
        conexion.pst.setDouble(6, this.interesMensual);
        conexion.rs = conexion.pst.executeQuery();
                
              System.out.println("Se ha registrado exitosamente en detalle transaccion.");
            } catch (SQLException ex) {
                Logger.getLogger(PeriodoContable.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Ha ocurrido un error al registrar.");
            }  
        
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
            this.trans.setIdTrans(id);
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

    public Transaccion getTrans() {
        return trans;
    }

    public void setTrans(Transaccion trans) {
        this.trans = trans;
    }
    
}
