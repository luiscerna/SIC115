package Modelo;

/*

    Hay que crear el metodo para la fecha de la planilla

*/

import java.util.ArrayList;
import java.util.Date;
import Datos.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Planilla {
    // Atributos
    private int idPlanilla;
    private Date fechaPlanilla;
    private ArrayList<Empleado> empleado;

    // Constructor
    public Planilla() {
        
    }

    // Constructor para registrar una nueva Planilla
    public Planilla(boolean crear) {
        Conexion conexion = new Conexion();
        if(crear){
            try {
                // Leer ultimo id OJO: Provisional porque en el modelo no está el id autoincrementable
                String query;
                query = "SELECT idPlanilla FROM Planilla ORDER BY idPlanilla DESC LIMIT 1;";
                conexion.pst= conexion.conectar().prepareStatement(query);
                conexion.rs = conexion.pst.executeQuery();
                conexion.rs.next();
                int id = conexion.rs.getInt("idPlanilla");
                id += 1;
                setIdPlanilla(id);

                query = "INSERT INTO Planilla (idPlanilla, fechaPlanilla) VALUES ("+getIdPlanilla()+", '2018-11-14 00:00:00');";
                conexion.pst = conexion.conectar().prepareStatement(query);
                conexion.pst.executeUpdate();
                
                //conexion.rs.next();
                //setIdPlanilla(conexion.rs.getInt(0));
                System.out.println("Se ha registrado una nueva planilla.");
            } catch (SQLException ex) {
                Logger.getLogger(Planilla.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se ha registrado una nueva planilla.");
            }
        }
    }

    // Métodos getter y setter
    public int getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(int idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public Date getFechaPlanilla() {
        return fechaPlanilla;
    }

    public void setFechaPlanilla(Date fechaPlanilla) {
        this.fechaPlanilla = fechaPlanilla;
    }

    public ArrayList<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(ArrayList<Empleado> empleado) {
        this.empleado = empleado;
    }
}
