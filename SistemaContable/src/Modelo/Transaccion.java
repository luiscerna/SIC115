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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transaccion {
    
    // Atributos
    private int idTrans;
    private int numeroPartida;
    private Date fechaTrans;
    private double monto;
    private String concepto;
    private Usuario usuario;
    private int tipo;
   
    
    // Para hacer pruebas nada más
    public static void main(String[] args) {
        
        Date ahora = new Date();
        //String concepto = "Pago de algo xD";
        Transaccion trans = new Transaccion(1, 1, ahora, 1000, "Pago de algo xD", 1);
    }

    // Constructor
    public Transaccion()
    {
        
        
    }
    //Constructor de Nuevo Registro en la BD
    public Transaccion(int idUsuario,int idTipo, Date fecha, double montoT, String concepto, int numPartida){
        this.setUsuarios(new Usuario(idUsuario));
        this.setTipo(idTipo);
        this.setFechaTrans(fecha);
        this.setMonto(montoT);
        this.setConcepto(concepto);
        this.setNumeroPartida(numPartida);
        
        Conexion conexion = new Conexion();
        
        try {
            // Leer ultimo id OJO: Provisional porque en el modelo no está el id autoincrementable
            String query;
            query = "SELECT idTrans FROM Transaccion ORDER BY idTrans DESC LIMIT 1;";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            int id = 0;
            if(conexion.rs.next()){
                id = conexion.rs.getInt("idTrans");
                id += 1;
            } else {
                id = 1;
            }
            
            this.setIdTrans(id);
            System.out.println("idTrans nuevo: "+this.getIdTrans());
                        
            // Hacer el registro en la bd
            query = "INSERT INTO Transaccion (idTrans, codEmpleado, idUsuario, idTipo, fechaTrans, monto, concepto, numeroPartida) VALUES ("+this.getIdTrans()+", "+this.getUsuarios().getCodEmpleado()+", "+this.getUsuarios().getIdUsuario()+", "+this.getTipo()+", '2018-11-14 00:00:00', "+this.getMonto()+", '"+this.getConcepto()+"', "+this.getNumeroPartida()+");";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.pst.executeUpdate();
            System.out.println("Se ha registrado exitosamente la Transaccion.");
            
        } catch (SQLException ex) {
            Logger.getLogger(DetalleActivoFijo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Constructor de Consulta
    public Transaccion(int idtrans) throws SQLException //Dependiendo de su "tipo" debe
                                                       // crear su respectivo detalleActivoFijo o detalleInteresAcum o detalleGastoAdelantado (ver esas clases)
                                                       //Para eso consultar la tabla Tipo como referencia, en la BD
                                                      //Como referencia ver relaciones que dependen de esta tabla en la BD
   { 
       //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "SELECT idTrans, idTipo, fechaTrans,monto, concepto, numeroPartida FROM Transaccion WHERE idTrans = ?";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setInt(1, idtrans);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.next()){
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
            
            if(this.tipo==1)
            { 
            DetalleGastoAdelantado detalleGastoAdelantado = new DetalleGastoAdelantado(this.idTrans) ;
        
            }
            if(this.tipo==2)
            {
                DetalleGastoAdelantado detalleGastoAdelantado = new DetalleGastoAdelantado(this.idTrans) ;

            }
            if(this.tipo==3)
            {
                DetalleGastoAdelantado detalleGastoAdelantado = new DetalleGastoAdelantado(this.idTrans) ;

            }
            if(this.tipo==4)
            {
               DetalleInteresesAcum detalleInteresesAcum = new DetalleInteresesAcum(this.idTrans);
            }
            if(this.tipo==5)
            {
                DetalleInteresesAcum detalleInteresesAcum = new DetalleInteresesAcum(this.idTrans);
            }
            if(this.tipo==6)
            {
                DetalleActivoFijo detalleActivoFijo=new DetalleActivoFijo(this.idTrans);
            }
            if(this.tipo==7)
            {
                DetalleActivoFijo detalleActivoFijo=new DetalleActivoFijo(this.idTrans);
            }
        }else{
            System.out.println("No hay Regitro Válido en Transaccion");
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

    public Usuario getUsuarios() {
        return usuario;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuario = usuarios;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
