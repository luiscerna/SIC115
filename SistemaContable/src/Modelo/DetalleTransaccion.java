package Modelo;




import java.util.ArrayList;
import java.sql.*;
import Datos.*;
import java.sql.SQLException;


public class DetalleTransaccion {
    // Atributos
    private int idDetalle;
    private String cuentaMayor;
    private String idCuentaMayor;
    private double debe;
    private double haber;
    private ArrayList<Cuenta> catalogo;
    private ArrayList<Transaccion> transaccion;
    
    // Constructor
    public DetalleTransaccion(){
        
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

    public ArrayList<Cuenta> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Cuenta> catalogo) {
        this.catalogo = catalogo;
    }

    public ArrayList<Transaccion> getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(ArrayList<Transaccion> transaccion) {
        this.transaccion = transaccion;
    }
    
    public boolean asignarCuentaMayor(String codCuenta) throws SQLException{
        
        //Cortando codCuenta
        String codCuentaMayor= codCuenta.substring(0,3);
        
        //Rescatando datos de cuenta
        Conexion conexion = new Conexion();
        String query = "select codCuenta, nomCuenta from Cuenta where codCuenta = ?";
        conexion.pst.setString(1, codCuentaMayor);
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos de la cuenta mayor al detalleCuenta
        if(conexion.rs.first()){
            String codigo = conexion.rs.getString("codCuenta");
            String nombre = conexion.rs.getString("nomCuenta");
            this.cuentaMayor = nombre;
            this.idCuentaMayor = codigo;
            return true;
        }
        else 
            return false; 
    }
    
    /*Crear metodo boolean llenarCatalogo() que llene el catalo con todos los registros de dicha tabla
    si el llenado se finalizo con exito entonces
        devolver true
    sino 
        devolver false
*/
    public boolean llenarCatalogo() throws SQLException{
        Conexion conexion = new Conexion();
        String query = "select codCuenta, nomCuenta, rubro, nivel from Cuenta";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.rs = conexion.pst.executeQuery();
        while (conexion.rs.next()){
            Cuenta cuenta = new Cuenta();
                cuenta.codCuenta = conexion.rs.getString("codCuenta");
                cuenta.nomCuenta =  conexion.rs.getString("nomCuenta");
                cuenta.rubro = conexion.rs.getInt("rubro");
                cuenta.nivel = conexion.rs.getInt("nivel");
            catalogo.add(cuenta);  
            }
        return true;
    }
    
    
}
