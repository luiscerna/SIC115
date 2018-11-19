package Modelo;



import Datos.Conexion;
import java.sql.SQLException;


public class Cuenta {
    // Atributos
    int id; //Agregue el atributo id para cuando se tenga que hacer el insert en otras tablas.
    String codCuenta;
    int rubro; //Encapsular
    int nivel;//Encapsular
    String nomCuenta;
    
    // Constructor
    
    public Cuenta()
    {
        
    }
    public Cuenta(String codCuenta) throws SQLException //constructor para obtener Registro ya Existente
    {
           
        //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "SELECT codCuenta, nomCuenta,rubro, nivel, nomCuenta FROM Cuenta WHERE codCuenta= ?"; 
        conexion.pst.setString(1, codCuenta);
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.first()){
            String codigo = conexion.rs.getString("codCuenta");
            int rubro = conexion.rs.getInt("rubro");
            String nombre = conexion.rs.getString("nomCuenta");
            int nivel=conexion.rs.getInt("nivel");
            this.codCuenta = codigo;
            this.rubro=rubro;
            this.nivel=nivel;
            this.nomCuenta=nomCuenta;
            
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
}
