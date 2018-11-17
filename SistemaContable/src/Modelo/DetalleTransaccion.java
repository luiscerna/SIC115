package Modelo;

/*
    //El metodo para obtener el catalogo esta en PeriodoContable, pues fue pensado antes de modificar la BD XD

*/
import java.util.ArrayList;
import Datos.*;
import java.sql.SQLException;


public class DetalleTransaccion {
    // Atributos
    private int idDetalle;
    private String cuentaMayor;
    private String idCuentaMayor;
    private double debe;
    private double haber;
    private Transaccion transaccion;
    private Cuenta cuenta;
    
    // Constructor
    public DetalleTransaccion(){
        
    }
    
    public DetalleTransaccion(int idDetalle){
        
    }
    
    //Métodos getter y setter
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getCuentaMayor() {
        return cuentaMayor;
    }

    public void setCuentaMayor(String cuentaMayor) {
        this.cuentaMayor = cuentaMayor;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
    
    public boolean asignarCuentaMayor(String codCuenta) throws SQLException{
        
        //Cortando codCuenta
        String codCuentaMayor= codCuenta.substring(0,4); //Verificar que funciona para todos los niveles de "Detalle"
        
        //Rescatando datos de cuenta
        Conexion conexion = new Conexion();
        String query = "select codCuenta, nomCuenta from Cuenta where codCuenta = ?";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setString(1, codCuentaMayor);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos de la cuenta mayor al detalleCuenta
        if(conexion.rs.next()){
            String codigo = conexion.rs.getString("codCuenta");
            String nombre = conexion.rs.getString("nomCuenta");
            this.cuentaMayor = nombre;
            this.idCuentaMayor = codigo;
            System.out.println(cuentaMayor);
            System.out.println(idCuentaMayor);
            return true;
        }
        else 
            return false; 
    }
    
    
    
    
}
