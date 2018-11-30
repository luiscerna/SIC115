package Modelo;

import Datos.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Empleado {
    // Atributos
    private int codEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private boolean esObrero;
    private ArrayList<TarjetaDeTrabajo> tarjetaDeTrabajo;
    private Puesto puesto;

    // Solo de prueba
    public static void main(String[] args) {
        
        // Probando insert
        //Empleado emp = new Empleado("Luis", "Cerna", true, 1);
        
        // Probando select
        /*Empleado emp = new Empleado(5);
        System.out.println("codEmpleado: "+emp.getCodEmpleado()+" nombre: "+emp.getNombreEmpleado()+" codPuesto: "+emp.getPuesto().getCodPuesto());
        */
        
        // Probando actualizarEmpleado
        /*Empleado emp = new Empleado();
        emp.actualizarEmpleado(5, "Luis Roberto", "Cerna Vásquez", false, 5);
        */
        
        // Probando delete
        /*Empleado emp = new Empleado();
        emp.eliminarEmpleado(5);
        */
        
        // Todo funciona good
    }
    
    // Constructor
    public Empleado() {
        
    }
    
    // Constructor para traer una consulta de empleado con respecto a su id
    public Empleado(int codEmpleado) {
        this.setCodEmpleado(codEmpleado);
        
        Conexion conexion = new Conexion();
        
        try {
            String query;
            query = "SELECT * FROM Empleado WHERE codEmpleado = "+ this.getCodEmpleado()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            if(conexion.rs.next()){
                this.setNombreEmpleado(conexion.rs.getString("nombreEmpleado"));
                this.setApellidoEmpleado(conexion.rs.getString("apellidoEmpleado"));
                this.setEsObrero(conexion.rs.getBoolean("esObrero"));
                this.setPuesto(new Puesto(conexion.rs.getInt("codPuesto")));
            }else{
                this.setApellidoEmpleado("");
                this.setCodEmpleado(0);
                this.setEsObrero(false);
                this.setPuesto(null);
                this.setNombreEmpleado("");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    // Constructor insert
    public Empleado(String nombreEmpleado, String apellidoEmpleado, boolean esObrero, int codPuesto){
        this.setNombreEmpleado(nombreEmpleado);
        this.setApellidoEmpleado(apellidoEmpleado);
        this.setEsObrero(esObrero);
        this.setPuesto(new Puesto(codPuesto));
        
        Conexion conexion = new Conexion();
            
        try {
            String query;
            query = "SELECT codEmpleado FROM Empleado ORDER BY codEmpleado DESC LIMIT 1;";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            int id = 0;
            if(conexion.rs.next()){
                id = conexion.rs.getInt("codEmpleado");
                id += 1;
            } else {
                id = 1;
            }
            this.setCodEmpleado(id);
            System.out.println("codEmpleado nuevo "+getCodEmpleado());
            
            query = "INSERT INTO Empleado (codEmpleado, nombreEmpleado, apellidoEmpleado, esObrero, codPuesto) VALUES (?, ?, ?, ?, ?)";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.pst.setInt(1, getCodEmpleado());
            conexion.pst.setString(2, getNombreEmpleado());
            conexion.pst.setString(3, getApellidoEmpleado());
            conexion.pst.setBoolean(4, isEsObrero());
            conexion.pst.setInt(5, getPuesto().getCodPuesto());
            conexion.pst.executeUpdate();
            System.out.println("Se ha registrado exitosamente en empleado.");
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método para actualizar datos
    public boolean actualizarEmpleado(int codEmpleado, String nombreEmpleado, String apellidoEmpleado, boolean esObrero, int codPuesto){
        this.setCodEmpleado(codEmpleado);
        this.setNombreEmpleado(nombreEmpleado);
        this.setApellidoEmpleado(apellidoEmpleado);
        this.setEsObrero(esObrero);
        this.setPuesto(new Puesto(codPuesto));
        
        Conexion conexion = new Conexion();
        try {
            String query;
            query = "UPDATE Empleado SET nombreEmpleado = '"+getNombreEmpleado()+"', apellidoEmpleado = '"+getApellidoEmpleado()+"', esObrero = "+isEsObrero()+", codPuesto = "+getPuesto().getCodPuesto()+" WHERE codEmpleado = "+getCodEmpleado()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.pst.executeUpdate();
            System.out.println("Se ha actualizado exitosamente en empleado.");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    // Método eliminar empleado a partir de su id
    public boolean eliminarEmpleado(int codEmpleado){
        this.setCodEmpleado(codEmpleado);
        
        Conexion conexion = new Conexion();
        
        try {
            String query;
            query = "DELETE FROM Empleado WHERE codEmpleado = "+getCodEmpleado()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.pst.executeUpdate();
            System.out.println("Se ha eliminado exitosamente en empleado.");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    // Métodos getter y setter
    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public boolean isEsObrero() {
        return esObrero;
    }

    public void setEsObrero(boolean esObrero) {
        this.esObrero = esObrero;
    }

    public ArrayList<TarjetaDeTrabajo> getTarjetaDeTrabajo() {
        return tarjetaDeTrabajo;
    }

    public void setTarjetaDeTrabajo(ArrayList<TarjetaDeTrabajo> tarjetaDeTrabajo) {
        this.tarjetaDeTrabajo = tarjetaDeTrabajo;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    
    public ArrayList<Integer> codsEmpleados(){
        ArrayList<Integer> cods=new ArrayList<Integer>();
        try {
            
            String query;
             Conexion conexion = new Conexion();
            query = "SELECT * FROM Empleado ORDER BY codEmpleado;";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            while(conexion.rs.next()){
                cods.add(Integer.valueOf(conexion.rs.getInt("codEmpleado")));
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cods;
    }
} 
