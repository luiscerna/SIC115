package Modelo;

/*
    //El metodo para obtener el catalogo esta en PeriodoContable, pues fue pensado antes de modificar la BD XD

*/
import Datos.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DetalleTransaccion {

    // Atributos
    private int idDetalle;
    private int codMayor;
    private double debe;
    private double haber;
    private Transaccion transaccion;
    private Cuenta cuenta;
    private int idCuenta;
    private int idPeriodo;
    
    // Constructores
    
    
    public DetalleTransaccion(){
        
    }
    
    public static void main(String[] args) throws SQLException {
        DetalleTransaccion detalle= new DetalleTransaccion(new Transaccion(1), new Cuenta(3), 78, 0, 0);
    }
    
    //Constructor para Hacer Nuevo Registro en la BD:
    public DetalleTransaccion(Transaccion trans, Cuenta cuenta, double debe, double haber, int idPeriodo) throws SQLException{ // quite el String codCuenta porque ese ya iria en la cuenta
        try {
            this.cuenta = new Cuenta(cuenta.getCodCuenta());
            this.asignarCuentaMayor(cuenta.getCodCuenta());
            this.debe=debe;
            this.haber=haber;
            this.transaccion=trans;
            this.idPeriodo=idPeriodo;
            this.idCuenta=cuenta.getId();
            Conexion conexion = new Conexion();
            String query;
                    query = "SELECT idDetalle FROM DetalleTransaccion ORDER BY idDetalle DESC LIMIT 1;";
                    conexion.pst= conexion.conectar().prepareStatement(query);
                    conexion.rs = conexion.pst.executeQuery();
                    conexion.rs.next();
                    int id = conexion.rs.getInt("idDetalle");
                    id += 1;
                    this.setIdDetalle(id); 
                    
           
            query = "INSERT INTO DetalleTransaccion (idDetalle, idTrans, codMayor, debe, haber, idCuenta, idPeriodo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.pst.setInt(1, this.getIdDetalle());
            conexion.pst.setInt(2, trans.getIdTrans());
            conexion.pst.setInt(3, this.codMayor);
            conexion.pst.setDouble(4, debe);
            conexion.pst.setDouble(5, haber);
            conexion.pst.setInt(6, cuenta.getId());
            conexion.pst.setInt(7, this.idPeriodo);
            conexion.pst.executeUpdate();
            System.out.println("Se ha registrado exitosamente en detalle transaccion.");
        } catch (SQLException ex) {
            Logger.getLogger(DetalleTransaccion.class.getName()).log(Level.SEVERE, null, ex);
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
            if(conexion.rs.next()){
                this.setTransaccion(new Transaccion(conexion.rs.getInt("idTrans")));
                conexion.pst = conexion.conectar().prepareStatement(query);
                conexion.rs = conexion.pst.executeQuery();
                conexion.rs.next();
                this.setDebe(conexion.rs.getDouble("debe"));
                this.setHaber(conexion.rs.getDouble("haber"));
                this.setCodMayor(conexion.rs.getInt("codMayor"));
                this.idPeriodo=conexion.rs.getInt("idPeriodo");
                this.idCuenta=conexion.rs.getInt("idCuenta");
                this.cuenta=new Cuenta(this.getIdCuenta());
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DetalleTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public boolean asignarCuentaMayor(String codCuenta) throws SQLException{
        
        //Cortando codCuenta
        String codCuentaMayor= codCuenta.substring(0,4); 
        
        //Rescatando datos de cuenta
        Conexion conexion = new Conexion();
        String query = "select id from Cuenta where codCuenta = ?";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setString(1, codCuentaMayor);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos de la cuenta mayor al detalleCuenta
        if(conexion.rs.next()){
            int id = conexion.rs.getInt("id");
            this.codMayor = id;
            System.out.println(getCodMayor());
            return true;
        }
        else 
            return false; 
    }

    //Metodos getter y setter
    /**
     * @return the idDetalle
     */
    public int getIdDetalle() {
        return idDetalle;
    }

    /**
     * @param idDetalle the idDetalle to set
     */
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    /**
     * @return the codMayor
     */
    public int getCodMayor() {
        return codMayor;
    }

    /**
     * @param codMayor the codMayor to set
     */
    public void setCodMayor(int codMayor) {
        this.codMayor = codMayor;
    }

    /**
     * @return the debe
     */
    public double getDebe() {
        return debe;
    }

    /**
     * @param debe the debe to set
     */
    public void setDebe(double debe) {
        this.debe = debe;
    }

    /**
     * @return the haber
     */
    public double getHaber() {
        return haber;
    }

    /**
     * @param haber the haber to set
     */
    public void setHaber(double haber) {
        this.haber = haber;
    }

    /**
     * @return the transaccion
     */
    public Transaccion getTransaccion() {
        return transaccion;
    }

    /**
     * @param transaccion the transaccion to set
     */
    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    /**
     * @return the cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the idCuenta
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * @param idCuenta the idCuenta to set
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * @return the idPeriodo
     */
    public int getIdPeriodo() {
        return idPeriodo;
    }

    /**
     * @param idPeriodo the idPeriodo to set
     */
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
}

    