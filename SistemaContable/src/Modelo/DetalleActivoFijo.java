package Modelo;
    //Crear constructor de Consulta DetalleACtivoFijo(int idTrans) que obtenga el registro Único de esa tabla y le asigne sus valores a los atributos correspondien
import Datos.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleActivoFijo {
    // Atributos
    private int idDesgaste;
    private Transaccion trans;
    private double valor;
    private int vidaUtil;
    private double valorSalvamento;
    private double desgasteAnual;
    private double desgasteMensual;
    
    // Constructor
    public DetalleActivoFijo() 
    {
        
    }
    
    //COnstructor para Insertar Registro
    public DetalleActivoFijo(Transaccion trans, double valPresente, double valSalvamento, int vidaUtil){
        // Asignando valores a sus variables
        // TipoActivo se encuentra en trans así que a ese haré referencia
        
        this.setTrans(trans);
        this.setValor(valPresente);
        this.setValorSalvamento(valSalvamento);
        this.setVidaUtil(vidaUtil);
        
        Conexion conexion = new Conexion();
        
        try {
            // Leer ultimo id OJO: Provisional porque en el modelo no está el id autoincrementable
            String query;
            query = "SELECT idDesgaste FROM DetalleActivoFijo ORDER BY idDesgaste DESC LIMIT 1;";
            conexion.pst= conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            int id = 0;
            if(conexion.rs.next()){
                id = conexion.rs.getInt("idDesgaste");
                id += 1;
            } else {
                id = 1;
            }
            
            this.setIdDesgaste(id);
            System.out.println("idDesgaste nuevo: "+this.getIdDesgaste());
            
            // Calcular desgaste anual (P-L)/n
            double desgasteAnual = (this.getValor()-this.getValorSalvamento())/this.getVidaUtil();
            this.setDesgasteAnual(desgasteAnual);
            
            // Calcular desgaste mensual ((P-L)/n)/12 => desgasteAnual/12
            double desgasteMensual = this.desgasteAnual/12;
            this.setDesgasteMensual(desgasteMensual);
            
            // Hacer el registro en la bd
            query = "INSERT INTO DetalleActivoFijo (idDesgaste, idTrans, valor, vidaUtil, valorSalvamento, desgasteAnual, desgasteMensual) VALUES ("+this.getIdDesgaste()+", "+this.getTrans().getIdTrans()+", "+this.getValor()+", "+this.getVidaUtil()+", "+this.getValorSalvamento()+", "+this.getDesgasteAnual()+", "+this.getDesgasteMensual()+");";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.pst.executeUpdate();
            System.out.println("Se ha registrado exitosamente el detalle activo fijo.");
            
        } catch (SQLException ex) {
            Logger.getLogger(DetalleActivoFijo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*Debe hacer lo siguiente:
        ya --obtener el idDesgaste aumentando 1 al ultimo registrado
        ya --Calcular la this.desgasteAnual
        ya --Calcular el this.desgasteMensual
        ya --Asignar los valores a sus respectivas variables incluyendo tipoActivo (Se hace al principio, lo encontré más conveniente)
        ya --Al final, hacer el registro en la BD
        ya --Se hace el registro con .executeUpdate(), el pst no devuelve resulset por que No es consulta
        */
    }
    public DetalleActivoFijo(int trans) throws SQLException
    {
        //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "SELECT idDesgaste, idTrans, valor, vidaUtil, valorSalvamento, desgateAnual, desgasteMensual FROM DetalleActivoFijo WHERE idTrans= ?";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.pst.setInt(1, trans);
        conexion.rs = conexion.pst.executeQuery();
        
        //Asignado los datos a los atributos de la clase
        if(conexion.rs.next()){
            int idDesgaste = conexion.rs.getInt("idDesgaste");
            int id = conexion.rs.getInt("idTrans");
            double valor = conexion.rs.getInt("valor");
            int vida =conexion.rs.getInt("vidaUtil");
            double salvamento =conexion.rs.getDouble("valorSalvamento");
            double desgasteAnual=conexion.rs.getDouble("desgasteAnual");
            double desgasteMensual=conexion.rs.getDouble("desgasteMensual");
            this.idDesgaste = idDesgaste;
            this.trans.setIdTrans(id);
            this.valor=valor;
            this.vidaUtil=vida;
            this.valorSalvamento=salvamento;
            this.desgasteAnual=desgasteAnual;
            this.desgasteMensual=desgasteMensual;
        }
    }
    
    // Métodos getter y setter
    public int getIdDesgaste() {
        return idDesgaste;
    }

    public void setIdDesgaste(int idDesgaste) {
        this.idDesgaste = idDesgaste;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public double getValorSalvamento() {
        return valorSalvamento;
    }

    public void setValorSalvamento(double valorSalvamento) {
        this.valorSalvamento = valorSalvamento;
    }

    public double getDesgasteAnual() {
        return desgasteAnual;
    }

    public void setDesgasteAnual(double desgasteAnual) {
        this.desgasteAnual = desgasteAnual;
    }

    public double getDesgasteMensual() {
        return desgasteMensual;
    }

    public void setDesgasteMensual(double desgasteMensual) {
        this.desgasteMensual = desgasteMensual;
    }

    public Transaccion getTrans() {
        return trans;
    }

    public void setTrans(Transaccion trans) {
        this.trans = trans;
    }
}
