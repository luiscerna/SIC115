package Modelo;
/*2-Se necesita un constructor que reciba como parámetro boolean esCerrado: //Constructor de Consulta, suponiendo que ya existe ese registro
    si esCerrado es false
        entonces llenar datos con periodo actual
                 al crear ese periodo se debe llenar en cascada su LibroMayor, dentro de este su lista de
                 DetalleTransaccion, y dentro de este su lista de Transaccion. El constructor de Transaccion le toca a Abi y sus dependencias tambien 
    sino
        entonces llenar datos con null
*/
/*3- Se necesita un metodo getUltimaTransaccion:devuelve int
    si libro mayor =! null entonces
        buscar en los correspondientes datos de los objetos en cascada (crear mas metodos de acceso en las clases que crean necesarias)
        hasta llegar a la ultima transaccion (id más alto) 
        y devolver su idTrans
    sino entonces
        devolver cero
*/

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
    private  LibroMayor libroMayor;
    private  Planilla planilla;
    private  ArrayList<Cuenta> catalogo; //Atributo Auxiliar que no aparece en el modelo
   
    // Constructor
    public PeriodoContable() {
        
    }
    
    // Para hacer pruebas nada más
    public static void main(String[] args) {
        PeriodoContable pc = new PeriodoContable(true);
    }
    
    // Constructor para cerrar o abrir el periodo contable
    public PeriodoContable(boolean esCerrado) {
        Conexion conexion = new Conexion();
        
        // Si es true que se abra el periodo contable, de lo contrario se cierra el actual
        if(esCerrado){
            try {
                // Crear la planilla
                planilla = new Planilla(true);
                System.out.println("El id de la nueva planilla es: "+planilla.getIdPlanilla());
                
                // Crear Registro del Libro Mayor
                libroMayor = new LibroMayor(true);
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
        } else {
            
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
        String query = "select codCuenta, nomCuenta, rubro, nivel from Cuenta";
        conexion.pst= conexion.conectar().prepareStatement(query);
        conexion.rs = conexion.pst.executeQuery();
        while (conexion.rs.next()){
            Cuenta cuenta = new Cuenta();
                cuenta.codCuenta = conexion.rs.getString("codCuenta");
                cuenta.nomCuenta =  conexion.rs.getString("nomCuenta");
                cuenta.rubro = conexion.rs.getInt("rubro");
                cuenta.nivel = conexion.rs.getInt("nivel");
                this.catalogo.add(cuenta);  
            }
        return true;
    }
    
    
    // Métodos getter y setter

    /**
     * @return the idPeriodo
     */
    public   int getIdPeriodo() {
        return idPeriodo;
    }

    /**
     * @param aIdPeriodo the idPeriodo to set
     */
    public   void setIdPeriodo(int aIdPeriodo) {
        idPeriodo = aIdPeriodo;
    }

    /**
     * @return the cerrado
     */
    public   boolean isCerrado() {
        return cerrado;
    }

    /**
     * @param aCerrado the cerrado to set
     */
    public   void setCerrado(boolean aCerrado) {
        cerrado = aCerrado;
    }

    /**
     * @return the inicio
     */
    public   Date getInicio() {
        return inicio;
    }

    /**
     * @param aInicio the inicio to set
     */
    public   void setInicio(Date aInicio) {
        inicio = aInicio;
    }

    /**
     * @return the fin
     */
    public   Date getFin() {
        return fin;
    }

    /**
     * @param aFin the fin to set
     */
    public   void setFin(Date aFin) {
        fin = aFin;
    }

    /**
     * @return the libroMayor
     */
    public   LibroMayor getLibroMayor() {
        return libroMayor;
    }

    /**
     * @param aLibroMayor the libroMayor to set
     */
    public   void setLibroMayor(LibroMayor aLibroMayor) {
        libroMayor = aLibroMayor;
    }

    /**
     * @return the planilla
     */
    public   Planilla getPlanilla() {
        return planilla;
    }

    /**
     * @param aPlanilla the planilla to set
     */
    public   void setPlanilla(Planilla aPlanilla) {
        planilla = aPlanilla;
    }

    /**
     * @return the catalogo
     */
    public   ArrayList<Cuenta> getCatalogo() {
        return catalogo;
    }

    /**
     * @param aCatalogo the catalogo to set
     */
    public   void setCatalogo(ArrayList<Cuenta> aCatalogo) {
        catalogo = aCatalogo;
    }

    
}
