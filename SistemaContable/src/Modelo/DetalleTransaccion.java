package Modelo;

/*
    //El metodo para obtener el catalogo esta en PeriodoContable, pues fue pensado antes de modificar la BD XD

*/
import java.util.ArrayList;
import Datos.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DetalleTransaccion {
    // Atributos
    private int idDetalle;
    private String cuentaMayor;
    private int codCuentaMayor; // le cambie el tipo, porque estaba en String y en la tabla esta el id que seria int
    private double debe;
    private double haber;
    private Transaccion transaccion;
    private Cuenta cuenta;
    
    // Constructores
    
    
    public DetalleTransaccion(){
        
    }
    
    //Constructor para Hacer Nuevo Registro en la BD:
    public DetalleTransaccion(Transaccion trans, Cuenta cuenta, double debe, double haber) throws SQLException{ // quite el String codCuenta porque ese ya iria en la cuenta
        try {
            this.cuenta = new Cuenta(cuenta.getCodCuenta());
            this.asignarCuentaMayor(cuenta.getCodCuenta());
            Conexion conexion = new Conexion();
            String query;
                    query = "SELECT idDetalle FROM DetalleTransaccion ORDER BY idDetalle DESC LIMIT 1;";
                    conexion.pst= conexion.conectar().prepareStatement(query);
                    conexion.rs = conexion.pst.executeQuery();
                    conexion.rs.next();
                    int id = conexion.rs.getInt("idDetalle");
                    id += 1;
                    setIdDetalle(id);

            query = "INSERT INTO DetalleTransaccion (idDetalle, idTrans, cuentaMayor, debe, haber, codCuentaMayor, codCuenta) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.pst.setInt(1, getIdDetalle());
            conexion.pst.setInt(2, trans.getIdTrans());
            conexion.pst.setString(3, this.cuentaMayor);
            conexion.pst.setDouble(4, debe);
            conexion.pst.setDouble(5, haber);
            conexion.pst.setInt(6, this.codCuentaMayor);
            conexion.pst.setInt(7, cuenta.id);

            conexion.rs = conexion.pst.executeQuery();
            System.out.println("Se ha registrado exitosamente en detalle transaccion.");
        } catch (SQLException ex) {
            Logger.getLogger(PeriodoContable.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ha ocurrido un error al registrar.");
        }  
        
        /*
        --Obtener el idDetalle sumando 1 al ultimo idDetalle registrado en la BD    
        --asignar los demás valores
        --Hacer el registro en la BD 
        */
        
    }
    
    //Constructor de Consulta
    public DetalleTransaccion(int idDetalle){ 
        // LLENAR TRANSACCION Y CUENTA
        try {
            Conexion conexion = new Conexion();
            this.setIdDetalle(idDetalle);
            String query;
            query = "SELECT * FROM DetalleTransaccion WHERE idDetalle = "+ this.getIdDetalle()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            conexion.rs.next();
            this.setTransaccion(new Transaccion(conexion.rs.getInt("idTrans")));
            this.setCuentaMayor(conexion.rs.getString("cuentaMayor"));
            this.setDebe(conexion.rs.getDouble("debe"));
            this.setHaber(conexion.rs.getDouble("haber"));
            this.setCodCuentaMayor(conexion.rs.getInt("codCuentaMayor"));
            /*
                REVISAR EN LA BASE DE DATOS 'CODCUENTA'
            */
        } catch (SQLException ex) {
            Logger.getLogger(DetalleTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String codCuentaMayor= codCuenta.substring(0,4); 
        
        //Rescatando datos de cuenta
        Conexion conexion = new Conexion();
        String query = "select id, codCuenta, nomCuenta from Cuenta where codCuenta = ?";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setString(1, codCuentaMayor);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos de la cuenta mayor al detalleCuenta
        if(conexion.rs.next()){
            int id = conexion.rs.getInt("id");
            String codigo = conexion.rs.getString("codCuenta");
            String nombre = conexion.rs.getString("nomCuenta");
            this.cuentaMayor = codigo;
            this.codCuentaMayor = id;
            System.out.println(cuentaMayor);
            System.out.println(codCuentaMayor);
            return true;
        }
        else 
            return false; 
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getCodCuentaMayor() {
        return codCuentaMayor;
    }

    public void setCodCuentaMayor(int codCuentaMayor) {
        this.codCuentaMayor = codCuentaMayor;
    }  
}
