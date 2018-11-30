package Datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    public static Connection conexion;
    public static PreparedStatement pst;
    public static ResultSet rs;
    public static Statement st;
    
    public  Connection conectar() {
        try {
            //Ruta relativa
            String rutafile = System.getProperty("user.dir")+"\\Acopashe.accdb";
            String url = "jdbc:ucanaccess://" + rutafile;
            conexion=DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se ha podido establecer la conexión a la base de datos" + e,"Error de Conexion",JOptionPane.INFORMATION_MESSAGE);
        }
        return conexion;
    }
    
    
    public void desconectar() {
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se ha podido cerrar la conexión a la base de datos o no existe ref: " + ex,"Error de Conexion",JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
