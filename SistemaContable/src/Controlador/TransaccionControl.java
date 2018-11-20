/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/*Crear constructor TransaccionControl(idUsuario) que llene usuarioActual, periodoActual, mayorActual
y cree un objeto nuevoCatalogo y llene el catalogoAcopashe de la sig manera:
    1-crear variable DetalleTransaccion detalle
    2-ejecutar detalle.llenarCatalogo;
    3-hacer catalogoAcopashe= detalle.getCatalogo();
Tambien que cree el objeto transaccionNueva(periodoActual.getUltimaTransaccion+1) y le asigne su numeroPartida
con el metodo local getNumSiguientePartida y le asigne la fecha acutual.
*/

/**
 *
 * @author Irene Delgado :D  <dh16001@ues.edu.sv>
 */
public class TransaccionControl {
    //atributos
    private Usuario usuarioActual;
    private Transaccion transaccionNueva;
    private PeriodoContable periodoActual;
    private LibroMayor mayorActual;
    private ArrayList<DetalleTransaccion> listaDetalles;
    private ArrayList<Cuenta> nuevoCatalogo; //atrib auxiliar 
    private ArrayList<Cuenta> catalogoAcopashe; //atrib auxiliar
    
    
    //Flujo para una Transaccion Normal
    //Paso 1: mostrar al usuario el num de partida (en esta capa) y la fecha actual (desde la capa Vista)
    //Metodo que obtine el numero de partida actual dentro del periodo actual (se obtine con metodo de clase periodo)
    //Nota: este met es pa evitar acceder directamente a la capa modelo.
    /*public static int getNumSiguientePartida(){
        1- obtener int de ultima transaccion con peridoActual.getUltimaTransaccion 
        2- con el dato anterior obteniedo crear variable de tipo Transaccion tran1
        3- devolver tran1.getNumeroPartida+1;
    }
    */
    
    //Paso 2: Se llena la lista de del catálogo que aparece en el form solo con codCuenta y nombreCuenta
    public String[][] obtenerCuentasCatalogo() throws SQLException{
        //this.periodoActual.llenarCatalogo();
        this.catalogoAcopashe=periodoActual.getCatalogo();
        String[][] cuentas=new String[catalogoAcopashe.size()][2];
        int a=0;
        for(Cuenta cuenta: this.catalogoAcopashe){
            cuentas[a][0]=cuenta.getCodCuenta();
            cuentas[a][1]=cuenta.getNomCuenta();
            a++;
        }
        return cuentas;
    }
    
    /*Paso 3: El usuario selecciona la cuenta, indica si es Cargo/abono, el monto y presiona OK los datos de la cuenta se guardan de forma temporal dentro de 
    del form, luego de validar que se cumpla partida doble se pasa el listado de datos al siguiente metodo
    */
    /**
     * 
     * @param idTipo
     * @param idUsuario
     * @param monto
     * @param codCuentasCargos
     * @param cargos
     * @param codCuentasAbonos
     * @param abonos
     * @return 
     */
    public boolean registrarTransaccion (int idTipo, int idUsuario, double monto, String[] codCuentasCargos, double[] cargos, String[] codCuentasAbonos, double[] abonos){
        
        return true;
    }
   /**
    * 
    * @param tipo
    * @param idUsuario
    * @param monto
    * @param codCuentas
    * @param cantidad
    * @param esCargo
    * @param detalles
    * @return 
    */
    public boolean registrarTransaccion (int tipo, int idUsuario, double monto, String[] codCuentas, double[] cantidad, boolean[] esCargo){
        
        return true;
    }
    
    
    
    public static void agregarElementoTabla(String concepto,String codigo,String nombre,String monto, boolean esCargo, JTable tabla, ArrayList lista)
    {   
        //Por el momento es simbolico pero luego se trabajara con la clase real
        AuxiliarTransaccion auxiliar= new AuxiliarTransaccion();
        auxiliar.setNombreCuenta(nombre);
        auxiliar.setCodigoCuenta(codigo);
        auxiliar.setConceptoGeneral(concepto);
        if(esCargo)
        {
            auxiliar.setDebe(Double.parseDouble(monto));
            auxiliar.setHaber(0.00);
        }
        else
        {
            auxiliar.setHaber(Double.parseDouble(monto));
            auxiliar.setDebe(0.00);
        }
        
        //Agregar elemento del registro de la tabla
        Object [] registro= new Object[4];
        registro[0]=auxiliar.getCodigoCuenta();
        registro[1]= auxiliar.getNombreCuenta();
        registro[2]=auxiliar.getDebe();
        registro[3]=auxiliar.getHaber();
        
        //Objeteniendo el modelo de la tabla
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.addRow(registro);
        tabla.setModel(modelo);
        lista.add(auxiliar);
    }
    
    public static void calcularTotalesYDiferencia(Double []total, ArrayList<AuxiliarTransaccion> lista, JLabel debe, JLabel haber, JLabel diferencia)
    {
        //inicializando acumuladores y diferencia
        Double totalDebe=0.00, totalHaber=0.00, diferenciaTotal=0.00;
        
        for(AuxiliarTransaccion o: lista)
        {
            totalDebe+= o.getDebe();
            totalHaber+= o.getHaber();
        }
        
        //asignado valores a array de transaccion de montos
        total[0]=totalDebe;
        total[1]=totalHaber;
        
        //asignando valores a Labels de totalizacion en formulario
        diferenciaTotal= totalDebe - totalHaber;       
            debe.setText("$"+totalDebe);
            haber.setText("$"+totalHaber);
            diferencia.setText("$"+diferenciaTotal);
    }
    
    public static void validadorPartidaDoble(Double [] monto, JButton boton)
    {
        Double diferencia= monto[0]-monto[1];       
        if(diferencia == 0)
           boton.setEnabled(true);
        else 
            boton.setEnabled(false);
    }
    
    public static void eliminarFila(JTable tabla)
    {
        //obtenemos modelo de la tabla
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        int fila = tabla.getSelectedRow();
        //condicion para ver si ha seleccionado o no una fila
        if (fila<0)
        {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila de la tabla");
        }
        else
        {
            //cuadro de confirmacion que pedira si quiere eliminar o no
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el registro?");
            
            if(JOptionPane.OK_OPTION==confirmar)
            {
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
        
       

    
    }
}