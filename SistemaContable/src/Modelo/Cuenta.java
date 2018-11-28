package Modelo;



import Datos.Conexion;
import java.sql.SQLException;


public class Cuenta {
    // Atributos
    private String codCuenta;
    private int rubro; 
    private int nivel;
    private String nomCuenta;
    private int id;
    
    // Constructor
    
    public Cuenta()
    {
       codCuenta=null;
       rubro=0;
       nivel=0;
       nomCuenta=null;
       id=0;
    }
    public Cuenta(String codCuenta) throws SQLException //Este constructor Ya se uso, si se modifica el parámetro favor notificar.
    {
           
        //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "SELECT codCuenta, nomCuenta, rubro, nivel, id nomCuenta FROM Cuenta WHERE codCuenta= ?"; 
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setString(1, codCuenta);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.next()){
            String codigo = conexion.rs.getString("codCuenta");
            int rubro = conexion.rs.getInt("rubro");
            String nombre = conexion.rs.getString("nomCuenta");
            int nivel=conexion.rs.getInt("nivel");
            this.codCuenta = codigo;
            this.rubro=rubro;
            this.nivel=nivel;
            this.nomCuenta=nombre;
            this.id=conexion.rs.getInt("id");
        }else{
            this.nomCuenta=null;
        }
    }
    public Cuenta(int idCuenta) throws SQLException //Este constructor Ya se uso, si se modifica el parámetro favor notificar.
    {
           
        //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "SELECT codCuenta, nomCuenta,rubro, nivel, nomCuenta FROM Cuenta WHERE id= ?"; 
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setInt(1, idCuenta);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.next()){
            String codigo = conexion.rs.getString("codCuenta");
            int rubro = conexion.rs.getInt("rubro");
            String nombre = conexion.rs.getString("nomCuenta");
            int nivel=conexion.rs.getInt("nivel");
            this.codCuenta = codigo;
            this.rubro=rubro;
            this.nivel=nivel;
            this.nomCuenta=nombre;
            this.id=idCuenta;
            
        }
    }

    // Métodos getter y setter
    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public int getRubro() {
        return rubro;
    }

    public void setRubro(int rubro) {
        this.rubro = rubro;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNomCuenta() {
        return nomCuenta;
    }

    public void setNomCuenta(String nomCuenta) {
        this.nomCuenta = nomCuenta;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
