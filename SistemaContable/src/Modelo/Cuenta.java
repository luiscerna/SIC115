package Modelo;



import Datos.Conexion;
import java.sql.SQLException;

/*Crear constructor Cuenta(codCuenta)

*/
public class Cuenta {
    // Atributos
    String codCuenta;
    int rubro;
    int nivel;
    String nomCuenta;
    
    // Constructor
    
    public Cuenta()
    {
        
    }
    public Cuenta(String codCuenta) throws SQLException //constructor para obtener Registro ya Existente
    {
           
        //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "select codCuenta, nomCuenta,rubro, nivel, nomCuenta from Cuenta where idTransaccion= ?"; //Revisar Tabla Cuenta, No tiene atributo idTransaccion
        conexion.pst.setString(1, codCuenta);
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.first()){
            String codigo = conexion.rs.getString("codCuenta");
            int rubro = conexion.rs.getInt("idTrans");//no existe el atributo idTrans en la tabla Cuenta
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
