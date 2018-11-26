package Modelo;

import Datos.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date ;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeriodoContable {
 
    // Atributos
    private  int idPeriodo;
    private  boolean cerrado;
    private  Date  inicio;
    private  Date fin;
    private  ArrayList<DetalleTransaccion> detallesDelPeriodo;
    private  Planilla planilla;
    private  ArrayList<Cuenta> catalogo; //Atributo Auxiliar que no aparece en el modelo
   
    // Constructor
    public PeriodoContable() throws SQLException {
        detallesDelPeriodo=new ArrayList<DetalleTransaccion>();
        catalogo=new ArrayList<Cuenta>();
    }
    
    // Para hacer pruebas nada más
    public static void main(String[] args) throws SQLException {
        PeriodoContable pc = new PeriodoContable();
        pc.PeriodoContableAbierto();
    }
    
    // Constructor para cerrar o abrir el periodo contable
    public void PeriodoContableAbierto() {
        Conexion conexion = new Conexion();
        
        try {
            String query;
            query = "SELECT * FROM PeriodoContable ORDER BY idPeriodo DESC LIMIT 1;";
            conexion.pst = conexion.conectar().prepareStatement(query);
            conexion.rs = conexion.pst.executeQuery();
            conexion.rs.next();
            setIdPeriodo(conexion.rs.getInt("idPeriodo"));

            this.setCerrado(conexion.rs.getBoolean("cerrado"));
            
            if(!this.isCerrado()){
                // Mostrando todos los datos en consola
                this.setPlanilla(new Planilla(conexion.rs.getInt("idPlanilla")));
                System.out.println("Fecha Planilla: "+this.getPlanilla().getFechaPlanilla());
                
                // ESTA CONSULTA ES SOLUCION A UN ERROR ANTERIOR 
                query = "SELECT inicio, fin FROM PeriodoContable WHERE idPeriodo = "+ getIdPeriodo() +";";
                conexion.pst = conexion.conectar().prepareStatement(query);
                conexion.rs = conexion.pst.executeQuery();
                conexion.rs.next();
                
                this.setInicio(conexion.rs.getDate("inicio"));
                this.setFin(conexion.rs.getDate("fin"));
                 query = "SELECT * FROM DetalleTransaccion WHERE idPeriodo = "+ this.getIdPeriodo()+";";
                 conexion.pst = conexion.conectar().prepareStatement(query);
                 conexion.rs = conexion.pst.executeQuery();
                 int i=-1;
                 while(conexion.rs.next()){
                    //System.out.println("idTrans: "+conexion.rs.getInt("idTrans"));
                    this.detallesDelPeriodo.add(new DetalleTransaccion(conexion.rs.getInt("idTrans")));
                    System.out.println("idCuenta: "+this.detallesDelPeriodo.get(++i).getIdCuenta());
                 }
                
            } else {
                this.setPlanilla(null);
                this.setDetallesDelPeriodo(null);
                this.setCatalogo(null);
                this.setInicio(null);
                this.setFin(null);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PeriodoContable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Metodos
    
    /*Crear metodo boolean llenarCatalogo() que llene el catalo con todos los registros de dicha tabla
    si el llenado se finalizo con exito entonces
        devolver true
    sino 
        devolver false
    */
    public boolean llenarCatalogo() throws SQLException{ //metodo de Eliezer XD
        Conexion conexion = new Conexion();
        String query = "SELECT id, codCuenta, nomCuenta, rubro, nivel FROM Cuenta ORDER BY id";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.rs = conexion.pst.executeQuery();
        while (conexion.rs.next()){
                Cuenta cuentita = new Cuenta();
                cuentita.setCodCuenta(conexion.rs.getString("codCuenta"));
                cuentita.setNomCuenta(conexion.rs.getString("nomCuenta"));
                cuentita.setRubro(conexion.rs.getInt("rubro"));
                cuentita.setNivel(conexion.rs.getInt("nivel"));
                cuentita.setId(conexion.rs.getInt("id"));
                //this.catalogo.add(new Cuenta(conexion.rs.getInt("id")));
                this.catalogo.add(cuentita);
            }
        return true;
    }
    
    
    
    public int getUltimoNumPartida(){
        int ultimo = 0;
        ultimo = this.getDetallesDelPeriodo().get(this.detallesDelPeriodo.size()-1).getTransaccion().getNumeroPartida();
        return ultimo;
    }

    public void agregarDetalleTransaccion(Transaccion transaccion, String codCuenta, double debe, double haber) {
        try{
            this.detallesDelPeriodo.add(new DetalleTransaccion(transaccion, new Cuenta(codCuenta), debe, haber, this.idPeriodo));
            
        }catch(SQLException ex){
            System.out.println("Ha ocurrido un problema al ingresar un nuevo detalleTransaccion.");
        }
        
        
    }
    
    // Métodos getter y setter
    /**
     * @return the idPeriodo
     */
    public int getIdPeriodo() {
        return idPeriodo;
    }

    /**
     * @param idPeriodo the idPeriodo to set
     */
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    /**
     * @return the cerrado
     */
    public boolean isCerrado() {
        return cerrado;
    }

    /**
     * @param cerrado the cerrado to set
     */
    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    /**
     * @return the inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fin
     */
    public Date getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(Date fin) {
        this.fin = fin;
    }

    /**
     * @return the detallesDelPeriodo
     */
    public ArrayList<DetalleTransaccion> getDetallesDelPeriodo() {
        return detallesDelPeriodo;
    }

    /**
     * @param detallesDelPeriodo the detallesDelPeriodo to set
     */
    public void setDetallesDelPeriodo(ArrayList<DetalleTransaccion> detallesDelPeriodo) {
        this.detallesDelPeriodo = detallesDelPeriodo;
    }

    /**
     * @return the planilla
     */
    public Planilla getPlanilla() {
        return planilla;
    }

    /**
     * @param planilla the planilla to set
     */
    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    /**
     * @return the catalogo
     */
    public ArrayList<Cuenta> getCatalogo() {
        return catalogo;
    }

    /**
     * @param catalogo the catalogo to set
     */
    public void setCatalogo(ArrayList<Cuenta> catalogo) {
        this.catalogo = catalogo;
    }
    
   

    
}
/* CODIGO QUE NOS SERVIRÁ DESPUÉS
            try {
                // Crear la planilla
                planilla = new Planilla(true);
                System.out.println("El id de la nueva planilla es: "+planilla.getIdPlanilla());
                
                System.out.println("El id del nuevo libro mayor es: "+libroMayor.getIdMayor());
                
                 // Leer ultimo id OJO: Provisional porque en el modelo no está el id autoincrementable
                String query;
                query = "SELECT idPeriodo FROM PeriodoContable ORDER BY idPeriodo DESC LIMIT 1;";
                conexion.pst= conexion.conectar().prepareStatement(query);
                conexion.rs = conexion.pst.executeQuery();
                conexion.rs.next();
                int id = conexion.rs.getInt("idPeriodo");
                id += 1;
                setIdPeriodo(id);
                
                // Registro del periodo contable
                query = "INSERT INTO PeriodoContable (idPeriodo, idMayor, idPlanilla) VALUES ("+ getIdPeriodo() +", "+ libroMayor.getIdMayor() +","+ planilla.getIdPlanilla() +");";
                conexion.pst = conexion.conectar().prepareStatement(query);
                conexion.pst.executeUpdate();
                System.out.println("Se ha registrado exitosamente el periodo contable.");
            } catch (SQLException ex) {
                Logger.getLogger(PeriodoContable.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Ha ocurrido un error al registrar.");
            }
*/