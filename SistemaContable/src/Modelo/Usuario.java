package Modelo;


import Datos.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario extends Empleado {
    // Atributos
    private int idUsuario;
    private String usuario;
    private String password;
    private int nivelAcceso;
    private ArrayList<Cardex> cardex;

    // Constructor
    public Usuario() {
        
    }
    //Constructor de Consulta
    public Usuario(int idUsuario) {
         try {
            Conexion conexion = new Conexion();
            this.setIdUsuario(idUsuario);
            String query;
            query = "SELECT * FROM Usuario WHERE idUsuario = "+ this.getIdUsuario()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            if(conexion.rs.next()){
                this.setIdUsuario(conexion.rs.getInt("idUsuario"));
                this.setCodEmpleado(conexion.rs.getInt("codEmpleado"));
                this.setUsuario(conexion.rs.getString("usuario"));
                this.setPassword(conexion.rs.getString("password"));
                this.setNivelAcceso(conexion.rs.getInt("nivelAcceso"));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DetalleTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Constructor de Nuevo Registro
    public Usuario(String usuario, String password, int nivel, String codEmpleado, String nombre, String apellido, int puesto){ //Agregue otros parametos necesarios para el insert
         try {
             Conexion conexion = new Conexion();
            String query;
                    query = "SELECT idUsuario FROM Usuario ORDER BY idUsuario DESC LIMIT 1;";
                    conexion.pst= conexion.conectar().prepareStatement(query);
                    conexion.rs = conexion.pst.executeQuery();
                    conexion.rs.next();
                    int id = conexion.rs.getInt("idUsuario");
                    id += 1;
                    this.setIdUsuario(id); 
             
            query = "INSERT INTO Usuario (codEmpleado, idUsuario, codPuesto, nombreEmpleado, apellidoEmpleado, usuario, password, nivelAcceso) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.pst.setString(1, codEmpleado);
            conexion.pst.setInt(2, getIdUsuario());
            conexion.pst.setInt(3, puesto);
            conexion.pst.setString(4, nombre);
            conexion.pst.setString(5, apellido);
            conexion.pst.setString(6, usuario);
            conexion.pst.setString(7, password);
            conexion.pst.setInt(7, nivel);
            conexion.pst.executeUpdate();
            System.out.println("Se ha registrado exitosamente en usuarios.");
             } catch (SQLException ex) {
            Logger.getLogger(DetalleTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    // Métodos getter y setter
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public ArrayList<Cardex> getCardex() {
        return cardex;
    }

    public void setCardex(ArrayList<Cardex> cardex) {
        this.cardex = cardex;
    }
}
