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
            Logger.getLogger(DetalleTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Puesto(int codPuesto, String nombre, Double sueldo, int nivel){
         try {
             Conexion conexion = new Conexion();
            String query;
                    query = "SELECT codPuesto FROM Puesto ORDER BY codPuesto DESC LIMIT 1;";
                    conexion.pst= conexion.conectar().prepareStatement(query);
                    conexion.rs = conexion.pst.executeQuery();
                    conexion.rs.next();
                    int id = conexion.rs.getInt("codPuesto");
                    id += 1;
                    this.setCodPuesto(id); 
            
            query = "INSERT INTO Puesto (codPuesto, nombrePuesto, sueldoBase, usuario, nivelAcceso) VALUES (?, ?, ?, ?, ?)";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.pst.setInt(1, codPuesto);
            conexion.pst.setString(2, nombre);
            conexion.pst.setDouble(3, sueldo);
            conexion.pst.setString(4, nombre);
            conexion.pst.setInt(5, nivel);
            conexion.pst.executeUpdate();
            System.out.println("Se ha registrado exitosamente en detalle transaccion.");
         } catch (SQLException ex) {
            Logger.getLogger(DetalleTransaccion.class.getName()).log(Level.SEVERE, null, ex);
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
