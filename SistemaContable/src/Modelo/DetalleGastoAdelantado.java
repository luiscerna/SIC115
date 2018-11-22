package Modelo;

//Crear constructor de Consulta DetalleGastoAdelantado(int idTrans) que obtenga el registro Único de esa tabla y le asigne sus valores a los atributos correspondientes

import Datos.Conexion;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleGastoAdelantado {
    // Atributos
    private int idGastoA;
    private int mesesPagados;
    private double valorTotal;
    private double gastoMensual;
    private Transaccion trans;

    

    // Constructor
    public DetalleGastoAdelantado()
    {
        
    }
    public DetalleGastoAdelantado(Transaccion trans, int mesesPagados, double valTotal)
    {
        /*Debe hacer lo siguiente:
        --obtener el idGastoA aumentando 1 al ultimo registrado
        --Calcular que correspondería por mes, es decir el this.gastoMensual
        --Asignar los valores a sus respectivas variables
        --Al final, hacer el registro en la BD
        */
        try{
        Conexion conexion = new Conexion();
        String query;
                query = "SELECT idGastoA FROM DetalleGastoAdelantado ORDER BY idGastoA DESC LIMIT 1;";
                conexion.pst= conexion.conectar().prepareStatement(query);
                conexion.rs = conexion.pst.executeQuery();
                conexion.rs.next();
                int id = conexion.rs.getInt("idGastoA");
                id += 1;
                setIdGastoA(id);
                
                this.gastoMensual = valTotal/mesesPagados;
                query = "INSERT INTO DetalleGastoAdelantado (idGastoA, idTrans, mesesPagados, valorTotal, gastoMensual) "
                + "VALUES (?, ?, ?, ?, ?)";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setInt(1, getIdGastoA());
        conexion.pst.setInt(2, trans.getIdTrans());
        conexion.pst.setInt(3, mesesPagados);
        conexion.pst.setDouble(4, this.valorTotal);
        conexion.pst.setDouble(5, this.getGastoMensual());
      
        conexion.pst.executeUpdate();
                 System.out.println("Se ha registrado exitosamente en detalle transaccion.");
            } catch (SQLException ex) {
                Logger.getLogger(PeriodoContable.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Ha ocurrido un error al registrar.");
            }  
        
    }
    public DetalleGastoAdelantado(int trans) throws SQLException
    {
         //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "SELECT idGastoA, idTrans, mesesPagados, valorTotal, gastoMensual FROM DetalleGastoAdelantado WHERE idTrans= ?";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setInt(1, trans);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.next()){
            int idGastoA = conexion.rs.getInt("idGastoA");
            int id = conexion.rs.getInt("idTrans");
            int meses = conexion.rs.getInt("mesesPagados");
            double valor=conexion.rs.getDouble("valorTotal");
            double gasto=conexion.rs.getDouble("gastoMensual");
            this.idGastoA = idGastoA;
            this.trans.setIdTrans(id); 
            this.mesesPagados=meses;
            this.valorTotal=valor;
            this.gastoMensual=gasto;
        }
       
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

    public Transaccion getTrans() {
        return trans;
    }

    public void setTrans(Transaccion trans) {
        this.trans = trans;
    }
    
   
}
