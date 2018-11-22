package Modelo;
    //Crear constructor de Consulta DetalleACtivoFijo(int idTrans) que obtenga el registro Único de esa tabla y le asigne sus valores a los atributos correspondien
import Datos.Conexion;
import java.sql.SQLException;

public class DetalleActivoFijo {
    // Atributos
    private int idDesgaste;
    private Transaccion trans;
    private double valor;
    private int vidaUtil;
    private double valorSalvamento;
    private String tipoActivo;
    private double desgasteAnual;
    private double desgasteMensual;

    // Constructor
    public DetalleActivoFijo() 
    {
        
    }
    
    //COnstructor para Insertar Registro
    public DetalleActivoFijo(Transaccion trans, double valPresente, double valSalvamento, int vidaUtil){
        /*Debe hacer lo siguiente:
        --obtener el idDesgaste aumentando 1 al ultimo registrado
        --Calcular la this.desgasteAnual
        --Calcular el this.desgasteMensual
        --Asignar los valores a sus respectivas variables incluyendo tipoActivo
        --Al final, hacer el registro en la BD
        --Se hace el registro con .executeUpdate(), el pst no devuelve resulset por que No es consulta
        */
    }
    public DetalleActivoFijo(int trans) throws SQLException
    {
        //Conexion a la base de datos
        Conexion conexion = new Conexion();
        String query = "SELECT idDesgaste, idTrans, valor, vidaUtil, valorSalvamento, tipoActivo, desgateAnual, desgasteMensual FROM DetalleActivoFijo WHERE idTrans= ?";
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
            String activo=conexion.rs.getString("tipoActivo");
            double desgasteAnual=conexion.rs.getDouble("desgasteAnual");
            double desgasteMensual=conexion.rs.getDouble("desgasteMensual");
            this.idDesgaste = idDesgaste;
            this.trans.setIdTrans(id);
            this.valor=valor;
            this.vidaUtil=vida;
            this.valorSalvamento=salvamento;
            this.tipoActivo=activo;
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

    public String getTipoActivo() {
        return tipoActivo;
    }

    public void setTipoActivo(String tipoActivo) {
        this.tipoActivo = tipoActivo;
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
