package Modelo;
/*Crear un constructor Transaccion(idTrans)que iguale los atributos de esta misma clase con los del unico registro
correspondiente al idTrans que se le pase como parametro
    ej. 
    String sentenciaSql= *aqui la consulta XD*;

    //codigo del acceso a la BD a traves de objeto conexion a creatividad de quien programe

    this.numeroPartida= resultado.getSTring(numeroPartida); //esta instruccion puede variar dependiendo de cada quien
*/
import Datos.Conexion;
import java.sql.SQLException;
import java.util.Date;

public class Transaccion {
    
    // Atributos
    private int idTrans;
    private int numeroPartida;
    private Date fechaTrans;
    private double monto;
    private String concepto;
    private DetalleActivoFijo detalleActivoFijo;
    private DetalleInteresesAcum detalleInteresesAcum;
    private DetalleGastoAdelantado detalleGastoAdelantado;
    private Usuario usuarios;
    private int tipo;
    
    // Constructor
    
    public Transaccion()
    {
        
    }
    public Transaccion(int idTrans) throws SQLException //Dependiendo de su "tipo" debe
                                                       // crear su respectivo detalleActivoFijo o detalleInteresAcum o detalleGastoAdelantado (ver esas clases)
                                                       //Para eso consultar la tabla Tipo como referencia, en la BD
                                                      //Como referencia ver relaciones que dependen de esta tabla en la BD
   { 
       //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "select idTrans, idTipo, fechaTrans,monto, concepto, numeroPartida from Transaccion where idTrans= ?";
        conexion.pst.setInt(1, idTrans);
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.first()){
            int id = conexion.rs.getInt("idTrans");
            int idTipo = conexion.rs.getInt("idTipo");
            int num = conexion.rs.getInt("numeroPartida");
            Date fecha=conexion.rs.getDate("fechaTrans");
            double monto=conexion.rs.getDouble("monto");
            String concepto=conexion.rs.getString("concepto");
            this.idTrans = id;
            this.numeroPartida=num;
            this.fechaTrans=fecha;
            this.monto=monto;
            this.concepto=concepto; 
            
            this.tipo=idTipo; 
        }
        if(this.tipo==1)
        {
            
        }
        
        
    }
    
    // Métodos getter y setter

    public int getIdTrans() {
        return idTrans;
    }

    public void setIdTrans(int idTrans) {
        this.idTrans = idTrans;
    }

    public int getNumeroPartida() {
        return numeroPartida;
    }

    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public Date getFechaTrans() {
        return fechaTrans;
    }

    public void setFechaTrans(Date fechaTrans) {
        this.fechaTrans = fechaTrans;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public DetalleActivoFijo getDetalleActivoFijo() {
        return detalleActivoFijo;
    }

    public void setDetalleActivoFijo(DetalleActivoFijo detalleActivoFijo) {
        this.detalleActivoFijo = detalleActivoFijo;
    }

    public DetalleInteresesAcum getDetalleInteresesAcum() {
        return detalleInteresesAcum;
    }

    public void setDetalleInteresesAcum(DetalleInteresesAcum detalleInteresesAcum) {
        this.detalleInteresesAcum = detalleInteresesAcum;
    }

    public DetalleGastoAdelantado getDetalleGastoAdelantado() {
        return detalleGastoAdelantado;
    }

    public void setDetalleGastoAdelantado(DetalleGastoAdelantado detalleGastoAdelantado) {
        this.detalleGastoAdelantado = detalleGastoAdelantado;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
