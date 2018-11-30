package Modelo;

import Datos.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Puesto {
    // Atributos
    private int codPuesto;
    private String nombrePuesto;
    private double sueldoBase;
    private int nivel;
    private int nivelAcceso;

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
    
    // Solo de prueba
    public static void main(String[] args) {
        
        // Probando insert
        //Puesto pue = new Puesto(9, "Puesto 9", 1500, 1);
        
        // Probando select
        /*Puesto pue = new Puesto(9);
        System.out.println("codPuesto: "+pue.getNombrePuesto()+" nombrePuesto: "+pue.getNombrePuesto());*/
        
        // Probando actualizarPuesto
        /*Puesto pue = new Puesto();
        pue.actualizarPuesto(9, "Puesto 99", 1200, 2);*/
        
        // Probando delete
        /*Puesto pue = new Puesto();
        pue.eliminarPuesto(9);*/
        
        // Todo funciona good
    }

    // Constructor
    public Puesto() {
        
    }
    
    //Constructor consulta
    public Puesto(int codPuesto){
    
         try {
            Conexion conexion = new Conexion();
            this.setCodPuesto(codPuesto);
            String query;
            query = "SELECT * FROM Puesto WHERE codPuesto = "+ this.getCodPuesto()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            if(conexion.rs.next()){
                this.setCodPuesto(conexion.rs.getInt("codPuesto"));
                this.setNombrePuesto(conexion.rs.getString("nombrePuesto"));
                this.setSueldoBase(conexion.rs.getDouble("sueldoBase"));
                this.setNivelAcceso(conexion.rs.getInt("nivelAcceso"));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Nuevo Registro
    public Puesto(int codPuesto, String nombre, double sueldo, int nivel){
         try {
             Conexion conexion = new Conexion();
            String query;
            query = "SELECT codPuesto FROM Puesto ORDER BY codPuesto DESC LIMIT 1;";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            int id = 0;
            if(conexion.rs.next()){
                id = conexion.rs.getInt("codPuesto");
                id += 1;
            } else {
                id = 1;
            }
            this.setCodPuesto(id); 
            
            query = "INSERT INTO Puesto (codPuesto, nombrePuesto, sueldoBase, nivelAcceso) VALUES (?, ?, ?, ?)";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.pst.setInt(1, codPuesto);
            conexion.pst.setString(2, nombre);
            conexion.pst.setDouble(3, sueldo);
            conexion.pst.setInt(4, nivel);
            conexion.pst.executeUpdate();
            System.out.println("Se ha registrado exitosamente en puesto.");
         } catch (SQLException ex) {
            Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método para actualizar datos
    public void actualizarPuesto(int codPuesto, String nombrePuesto, double sueldoBase, int nivelAcceso){
        this.setCodPuesto(codPuesto);
        this.setNombrePuesto(nombrePuesto);
        this.setSueldoBase(sueldoBase);
        this.setNivelAcceso(nivelAcceso);
        
        Conexion conexion = new Conexion();
        try {
            String query;
            query = "UPDATE Puesto SET nombrePuesto = '"+getNombrePuesto()+"', sueldoBase = "+getSueldoBase()+", nivelAcceso = "+getNivelAcceso()+" WHERE codPuesto = "+getCodPuesto()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.pst.executeUpdate();
            System.out.println("Se ha actualizado exitosamente en puesto.");
        } catch (SQLException ex) {
            Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método eliminar empleado a partir de su id
    public void eliminarPuesto(int codPuesto){
        this.setCodPuesto(codPuesto);
        
        Conexion conexion = new Conexion();
        
        try {
            String query;
            query = "DELETE FROM Puesto WHERE codPuesto = "+getCodPuesto()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.pst.executeUpdate();
            System.out.println("Se ha eliminado exitosamente en puesto.");
        } catch (SQLException ex) {
            Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos getter y setter
    public int getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(int codPuesto) {
        this.codPuesto = codPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
