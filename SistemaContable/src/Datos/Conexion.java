package Datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            System.out.println("Conectado a la base de datos");
        } catch (SQLException e) {
            System.out.println("No se ha podido establecer la conexión a la base de datos" + e);
        }
        return conexion;
    }
    
    
    public void desconectar() {
        try {
            this.conexion.close();
            System.out.println("Conexion cerrada efectivamente");
        } catch (SQLException ex) {
            System.out.println("Hay errores al cerrar la conexion");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
