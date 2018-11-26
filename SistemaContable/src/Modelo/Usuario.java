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
    private Puesto puesto;

    // Constructor
    public Usuario() {
        
    }
    
    // Solo de prueba
    public static void main(String[] args) {
        
        // Probando insert
        /*String usuario = "luiscerna";
        String password = "123";
        String nombre = "Luis";
        String apellido = "Cerna";
        Usuario user = new Usuario(usuario, password, 1, 1, nombre, apellido, 6);
        */
        
        // Probando select
        /*Usuario user = new Usuario(4);
        System.out.println("idUsario = "+user.getIdUsuario()+" nombre = "+user.getNombreEmpleado());
        */
        
        // Probando actualizarUsuario
        /*Usuario user = new Usuario();
        user.actualizarUsuario(4, 4, 1, "Luis Roberto", "Cerna Vásqiez", "luiscerna_01", "1234", 2);
        */
        
        // Probando delete
        /*Usuario user = new Usuario();
        user.eliminarUsuario(4);
        */
        
        // Todo funciona good
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
                this.setNombreEmpleado(conexion.rs.getString("nombreEmpleado"));
                this.setApellidoEmpleado(conexion.rs.getString("apellidoEmpleado"));
                this.setUsuario(conexion.rs.getString("usuario"));
                this.setPassword(conexion.rs.getString("password"));
                this.setNivelAcceso(conexion.rs.getInt("nivelAcceso"));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Constructor de Nuevo Registro
    public Usuario(String usuario, String password, int nivel, int codEmpleado, String nombre, String apellido, int puesto){ //Agregue otros parametos necesarios para el insert
         try {
            Conexion conexion = new Conexion();
            String query;
            query = "SELECT idUsuario FROM Usuario ORDER BY idUsuario DESC LIMIT 1;";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            int id = 0;
            if(conexion.rs.next()){
                id = conexion.rs.getInt("idUsuario");
                id += 1;
            } else {
                id = 1;
            }
            this.setIdUsuario(id);
            System.out.println("idUsuario nuevo: "+this.getIdUsuario());
             
            query = "INSERT INTO Usuario (codEmpleado, idUsuario, codPuesto, nombreEmpleado, apellidoEmpleado, usuario, password, nivelAcceso) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.pst.setInt(1, codEmpleado);
            conexion.pst.setInt(2, getIdUsuario());
            conexion.pst.setInt(3, puesto);
            conexion.pst.setString(4, nombre);
            conexion.pst.setString(5, apellido);
            conexion.pst.setString(6, usuario);
            conexion.pst.setString(7, password);
            conexion.pst.setInt(8, nivel);
            conexion.pst.executeUpdate();
            System.out.println("Se ha registrado exitosamente en usuarios.");
             } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método para actualizar datos
    public void actualizarUsuario(int idUsuario, int codEmpleado, int codPuesto, String nombreEmpleado, String apellidoEmpleado, String usuario, String password, int nivelAcceso){
        this.setIdUsuario(idUsuario);
        this.setCodEmpleado(codEmpleado);
        this.setPuesto(new Puesto(codPuesto));
        this.setNombreEmpleado(nombreEmpleado);
        this.setApellidoEmpleado(apellidoEmpleado);
        this.setUsuario(usuario);
        this.setPassword(password);
        this.setNivelAcceso(nivelAcceso);
        
        Conexion conexion = new Conexion();
        try {
            String query;
            query = "UPDATE Usuario SET codEmpleado = "+getCodEmpleado()+", codPuesto = "+getPuesto().getCodPuesto()+", nombreEmpleado = '"+getNombreEmpleado()+"', apellidoEmpleado = '"+getApellidoEmpleado()+"', usuario = '"+getUsuario()+"', password = '"+getPassword()+"', nivelAcceso = "+getNivelAcceso()+" WHERE idUsuario = "+getIdUsuario()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.pst.executeUpdate();
            System.out.println("Se ha actualizado exitosamente en usuario.");
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método eliminar usuario a partir de su id
    public void eliminarUsuario(int idUsuario){
        this.setIdUsuario(idUsuario);
        
        Conexion conexion = new Conexion();
        
        try {
            String query;
            query = "DELETE FROM Usuario WHERE idUsuario = "+getIdUsuario()+";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.pst.executeUpdate();
            System.out.println("Se ha eliminado exitosamente en usuario.");
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
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

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
}