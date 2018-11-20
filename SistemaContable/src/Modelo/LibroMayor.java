package Modelo;


import Datos.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroMayor {
    // Atributos
    private String codCuenta;
    private String nombreCuenta;
    private double montoTotal;
    private ArrayList<DetalleTransaccion> detalleTransaccion;
    private int idMayor;
    
    // Constructor 
    public LibroMayor() {
        
    }
    
        // Constructor para hacer consulta de Planilla
    public LibroMayor(int idMayor) {
        this.setDetalleTransaccion(new ArrayList<DetalleTransaccion>());
        Conexion conexion = new Conexion();
        this.setIdMayor(idMayor);
        try {
            String query;
            query = "SELECT * FROM LibroMayor WHERE idMayor = "+ this.getIdMayor() +";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            conexion.rs.next();
            this.setCodCuenta(conexion.rs.getString("codigoCuenta"));
            this.setNombreCuenta(conexion.rs.getString("nombreCuenta"));
            this.setMontoTotal(conexion.rs.getDouble("montoTotal"));
            // FALTA CARGAR LOS DETALLE TRANSACCION
            
            // CARGAR DETALLE TRANSACCION
            query = "SELECT idDetalle FROM DetalleTransaccion WHERE cuentaMayor = "+ this.getNombreCuenta() +";";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            while (conexion.rs.next()) {                
                this.detalleTransaccion.add(new DetalleTransaccion(conexion.rs.getInt("idDetalle")));
            }
            
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un problema al consula Libro Mayor.");
            Logger.getLogger(LibroMayor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public int getUltimaTransaccion(){
        int ultimo = 0;
        ultimo = this.detalleTransaccion.get(this.detalleTransaccion.size()).getTransaccion().getIdTrans();
        return ultimo;
    }
     
    // Métodos getter y setter
        public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public ArrayList<DetalleTransaccion> getDetalleTransaccion() {
        return detalleTransaccion;
    }

    public void setDetalleTransaccion(ArrayList<DetalleTransaccion> detalleTransaccion) {
        this.detalleTransaccion = detalleTransaccion;
    }

    /**
     * @return the idMayor
     */
    public int getIdMayor() {
        return idMayor;
    }

    /**
     * @param idMayor the idMayor to set
     */
    public void setIdMayor(int idMayor) {
        this.idMayor = idMayor;
    }
}


/* CODIGO QUE NOS SERVIRÁ LUEGO
try {
                // Leer ultimo id OJO: Provisional porque en el modelo no está el id autoincrementable
                String query;
                query = "SELECT idMayor FROM LibroMayor ORDER BY idMayor DESC LIMIT 1;";
                conexion.pst= conexion.conectar().prepareStatement(query);
                conexion.rs = conexion.pst.executeQuery();
                conexion.rs.next();
                int id = conexion.rs.getInt("idMayor");
                id += 1;
                setIdMayor(id);

                query = "INSERT INTO LibroMayor (idMayor, montoTotal) VALUES ("+ getIdMayor() +", 0);";
                conexion.pst = conexion.conectar().prepareStatement(query);
                conexion.pst.executeUpdate();
                
                System.out.println("Se ha registrado un nuevo libro mayor.");
            } catch (SQLException ex) {
                Logger.getLogger(LibroMayor.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Ha ocurrido un error al registrar un libro mayor.");
            }
*/