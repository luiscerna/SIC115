package Datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    static Connection conexion;
    public static PreparedStatement pst;
    public static ResultSet rs;
    public static Statement st;
    
    public Connection conectar() {
        try {
            // Ruta Luis
            String rutafile = "C:\\Users\\Luis Cerna\\Documents\\SIC-02\\Database1.accdb";
            // Ruta Aby
            //String rutafile = "C:\\Users\\Luis Cerna\\Documents\\SIC-02\\Database1.accdb";
            // Ruta Eliezer
            //String rutafile = "C:\\Users\\Luis Cerna\\Documents\\SIC-02\\Database1.accdb";
            // Ruta Paola
            //String rutafile = "C:\\Users\\Luis Cerna\\Documents\\SIC-02\\Database1.accdb";
            // Ruta Moto
            //String rutafile = "C:\\Users\\Luis Cerna\\Documents\\SIC-02\\Database1.accdb";
            // Ruta Irene
            //String rutafile = "C:\\Users\\Luis Cerna\\Documents\\SIC-02\\Database1.accdb";
            String url = "jdbc:ucanaccess://" + rutafile;
            conexion = DriverManager.getConnection(url);
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
