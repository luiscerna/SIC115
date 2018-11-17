/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Datos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.DetalleTransaccion;
/**
 *
 * @author Luis Cerna
 */
public class SistemaContable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String variable = new String("Hola Mundo! jajajajajajajahahaahajajaja");
            System.out.println(variable);
            String var= new String("Hola Mundo! Pao Estuvo aqui");
            System.out.println(var);
            
            Conexion conexion = new Conexion();
            
            String query = "select nombreEmpleado from Usuario";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            while (conexion.rs.next()){
                System.out.println(conexion.rs.getString("nombreEmpleado"));
            }
            
            DetalleTransaccion detalle = new DetalleTransaccion();
            detalle.asignarCuentaMayor("11010102");
            detalle.asignarCuentaMayor("11070101");
            
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(SistemaContable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
