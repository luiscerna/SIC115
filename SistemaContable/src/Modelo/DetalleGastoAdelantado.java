package Modelo;

//Crear constructor de Consulta DetalleGastoAdelantado(int idTrans) que obtenga el registro Único de esa tabla y le asigne sus valores a los atributos correspondientes

import Datos.Conexion;
import java.sql.SQLException;
import java.util.Date;

public class DetalleGastoAdelantado {
    // Atributos
    private int idGastoA;
    private int mesesPagados;
    private double valorTotal;
    private double gastoMensual;
    private int idTrans;

    // Constructor
    public DetalleGastoAdelantado()
    {
        
    }
    public DetalleGastoAdelantado(int idTrans) throws SQLException
    {
         //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "SELECT idGastoA, idTrans, mesesPagados, valorTotal, gastoMensual FROM DetalleGastoAdelantado WHERE idTrans= ?";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setInt(1, idTrans);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.next()){
            int idGastoA = conexion.rs.getInt("idGastoA");
            int id = conexion.rs.getInt("idTrans");
            int meses = conexion.rs.getInt("mesesPagados");
            double valor=conexion.rs.getDouble("valorTotal");
            double gasto=conexion.rs.getDouble("gastoMensual");
            this.idGastoA = idGastoA;
            this.idTrans=id;
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
}
