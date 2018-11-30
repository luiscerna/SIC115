/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
    private ArrayList<DetalleTransaccion> listaDetalles;
    private ArrayList<Cuenta> nuevoCatalogo; //atrib auxiliar 
    private ArrayList<Cuenta> catalogoAcopashe; //atrib auxiliar
    
//Constructor
    public TransaccionControl() throws SQLException{
        periodoActual=new PeriodoContable();
        periodoActual.llenarCatalogo();
        periodoActual.PeriodoContableAbierto();//Se obtiene el Periodo actual
        this.catalogoAcopashe=periodoActual.getCatalogo();
        this.nuevoCatalogo=new ArrayList<Cuenta>();
        this.transaccionNueva=new Transaccion();
        
    } 
    
    //Flujo para una Transaccion Normal
    //Paso 1: mostrar al usuario el num de partida (en esta capa) y la fecha actual (desde la capa Vista)
    //Metodo que obtine el numero de partida actual dentro del periodo actual (se obtine con metodo de clase periodo)
    //Nota: este met es pa evitar acceder directamente a la capa modelo.
    public int siguienteNumPartida(){
        return this.periodoActual.getUltimoNumPartida()+1;
    }
    
    //Paso 2: Se llena la lista de del catálogo que aparece en el form solo con codCuenta y nombreCuenta SOLAMENTE CUENTAS DETALLE
    public String[][] obtenerCuentasCatalogo(int rubro) throws SQLException{
        String[][] cuentas=new String[catalogoAcopashe.size()][2];
        int a=0;
        int i=0;
        switch(rubro){
            case 0: {
                    for(Cuenta cuenta: this.catalogoAcopashe){
                        if(i<(this.catalogoAcopashe.size()-2)){
                            if(this.catalogoAcopashe.get(i+1).getNivel()<=cuenta.getNivel()){
                            cuentas[a][0]=cuenta.getCodCuenta();
                            cuentas[a][1]=cuenta.getNomCuenta();
                            a++;
                            }
                        }
                        i++;
                       }
                        return cuentas;
                    }
            default:{
                    for(Cuenta cuenta: this.catalogoAcopashe){
                        if(i<(this.catalogoAcopashe.size()-2)&&(cuenta.getRubro()==rubro)){
                            if(this.catalogoAcopashe.get(i+1).getNivel()<=cuenta.getNivel()){
                            cuentas[a][0]=cuenta.getCodCuenta();
                            cuentas[a][1]=cuenta.getNomCuenta();
                            a++;
                            }
                        }
                        i++;
                       }
                    return cuentas;    
            } 
    }
    
}
    
    /*Paso 3: El usuario selecciona la cuenta, indica si es Cargo/abono, el monto y presiona OK los datos de la cuenta se guardan de forma temporal dentro de 
    del form, luego de validar que se cumpla partida doble se pasa el listado de datos al siguiente metodo
    */

 
    public boolean registrarTransaccion (int idUsuario, int tipo, Date fecha, String concepto,int numPartida, double montoT, ArrayList <AuxiliarTransaccion> cuentas ){    
        try{
            this.transaccionNueva=new Transaccion(idUsuario,tipo,fecha,montoT,concepto,numPartida); //Se crea la nueva transaccion Primero
            for(AuxiliarTransaccion cuenta:cuentas){
                periodoActual.agregarDetalleTransaccion(transaccionNueva, cuenta.getCodigoCuenta(), cuenta.getDebe(), cuenta.getHaber());
            }
            return true;
        }catch(Exception e){
            return false;
        }   
    }
    
    public boolean registrarDetalleGastoA(int mesesPagados, double valTotal){
        try{
            DetalleGastoAdelantado detalle=new DetalleGastoAdelantado(this.transaccionNueva, mesesPagados, valTotal);
            return true;
        }catch(Exception e){
            return false;
        } 
    }
    
    public boolean registrarDetalleInteresesAcum(double valorPresente, double tasaAnual){
        try{
            DetalleInteresesAcum detalle=new DetalleInteresesAcum(this.transaccionNueva, valorPresente, tasaAnual);
            return true;
        }catch(Exception e){
            return false;
        } 
    }
    
    public boolean registrarDetalleActivoF( double valPresente, double valSalvamento, int vidaUtil){
        try{
            DetalleActivoFijo detalle=new DetalleActivoFijo(this.transaccionNueva, valPresente, valSalvamento, vidaUtil);
            return true;
        }catch(Exception e){
            return false;
        } 
    }
    
    //Metodo para validar que existe la cuenta antes de agregarla a la Tabla de Registros
    public boolean existeCuenta(String codCuenta) throws SQLException{
        if(((new Cuenta(codCuenta)).getNomCuenta())!=null){
            return true;
        }else{
            return false;
        }
    }
    //Metodo con nombre automático
    public static void agregarElementoTablaCampo(String concepto,String codigo,String monto, boolean esCargo, JTable tabla, ArrayList lista) throws SQLException
    {   
        //Por el momento es simbolico pero luego se trabajara con la clase real
        AuxiliarTransaccion auxiliar= new AuxiliarTransaccion();
        if((new Cuenta(codigo)).getNomCuenta()!= null)
        {
            auxiliar.setNombreCuenta((new Cuenta(codigo)).getNomCuenta());
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
        }else{
            JOptionPane.showMessageDialog(null,"Parece que la cuenta solicitada no existe!\nPor favor ingresar nuevamente o auxiliarse\ndel boton de CATALOGO ");
        }
    }
    
    //Metodeo de Moto
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
    
    public static void eliminarFila(JTable tabla, ArrayList<AuxiliarTransaccion> lista)
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
                lista.remove(calcularPosicionLista(lista,tabla.getValueAt(fila,0)));
                modelo.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }
        
       

    
    }
    
    private static int calcularPosicionLista(ArrayList<AuxiliarTransaccion> lista, Object codigo)
    {
        int valor=0;
        int contador=0;
        for(AuxiliarTransaccion elemento: lista)
        {
            if(elemento.getCodigoCuenta()== codigo.toString())
                valor=contador;
            contador++;
        }
        return valor;
    }
    
    //Para las operaciones de IVA
    public static void agregarElementoTablaIVA(String concepto,String codigo,String nombre,String monto, boolean esCargo, JTable tabla, ArrayList lista,boolean esCompra,Double [] IVA)
    {   
        //si es compra
        if(esCompra)
        {
            AuxiliarTransaccion auxiliar= new AuxiliarTransaccion();
            auxiliar.setNombreCuenta(nombre);
            auxiliar.setCodigoCuenta(codigo);
            auxiliar.setConceptoGeneral(concepto);
            if(esCargo)
            {
                auxiliar.setDebe(Double.parseDouble(monto));
                auxiliar.setHaber(0.00);
                IVA[0]+=Double.parseDouble(monto)*0.13;
            }
            else
            {
                //auxiliar.setHaber(Double.parseDouble(monto));
                auxiliar.setDebe(0.00);
                if(IVA[0]==0)
                  auxiliar.setHaber(Double.parseDouble(monto)*1.13);
                else{
                    auxiliar.setHaber(Double.parseDouble(monto)+IVA[0]);
                    IVA[0]=0.0;
                }
                
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
        else
        {
            AuxiliarTransaccion auxiliar= new AuxiliarTransaccion();
            auxiliar.setNombreCuenta(nombre);
            auxiliar.setCodigoCuenta(codigo);
            auxiliar.setConceptoGeneral(concepto);
            if(esCargo)
            {
                //auxiliar.setDebe(Double.parseDouble(monto));
                auxiliar.setHaber(0.00);
                if(IVA[1]==0)
                    auxiliar.setDebe(Double.parseDouble(monto)*1.13);
                else{
                    auxiliar.setDebe(Double.parseDouble(monto)+ IVA[1]);
                    IVA[1]=0.0;
                }
            }
            else
            {
                //auxiliar.setHaber(Double.parseDouble(monto));
                auxiliar.setDebe(0.00);
                auxiliar.setHaber(Double.parseDouble(monto));
                IVA[1]+=Double.parseDouble(monto)*0.13;
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
    }
    
    public static void agregarElementoTablaCampoIVA(String concepto,String codigo,String monto, boolean esCargo, JTable tabla, ArrayList lista,boolean esCompra, Double []IVA) throws SQLException
    {   
        //Por el momento es simbolico pero luego se trabajara con la clase real
        if(esCompra){
            AuxiliarTransaccion auxiliar= new AuxiliarTransaccion();
            if((new Cuenta(codigo)).getNomCuenta()!= null)
            {
                auxiliar.setNombreCuenta((new Cuenta(codigo)).getNomCuenta());
                auxiliar.setCodigoCuenta(codigo);
                auxiliar.setConceptoGeneral(concepto);
                if(esCargo)
                {
                    auxiliar.setDebe(Double.parseDouble(monto));
                    auxiliar.setHaber(0.00);
                    IVA[0] += Double.parseDouble(monto)*0.13;
                }
                else
                {
                    //auxiliar.setHaber(Double.parseDouble(monto));
                    auxiliar.setDebe(0.00);
                    if(IVA[0]==0)
                    {
                        auxiliar.setHaber(Double.parseDouble(monto)*1.13);
                    }
                    else
                    {
                        auxiliar.setHaber(Double.parseDouble(monto)+IVA[0]);
                        IVA[0]=0.0;
                    }
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
            }else{
                JOptionPane.showMessageDialog(null,"Parece que la cuenta solicitada no existe!\nPor favor ingresar nuevamente o auxiliarse\ndel boton de CATALOGO ");
            }
        }
        else
        {
            AuxiliarTransaccion auxiliar= new AuxiliarTransaccion();
            if((new Cuenta(codigo)).getNomCuenta()!= null)
            {
                auxiliar.setNombreCuenta((new Cuenta(codigo)).getNomCuenta());
                auxiliar.setCodigoCuenta(codigo);
                auxiliar.setConceptoGeneral(concepto);
                if(esCargo)
                {
                    //auxiliar.setDebe(Double.parseDouble(monto));
                    auxiliar.setHaber(0.00);
                    if(IVA[1]==0)
                    {
                        auxiliar.setDebe(Double.parseDouble(monto)*1.13);
                    }
                    else
                    {
                        auxiliar.setDebe(Double.parseDouble(monto)+IVA[1]);
                        IVA[1]=0.0;
                    }
                }
                else
                {
                    auxiliar.setHaber(Double.parseDouble(monto));
                    auxiliar.setDebe(0.00);
                    IVA[1]+= Double.parseDouble(monto)*0.13;
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
            }else{
                JOptionPane.showMessageDialog(null,"Parece que la cuenta solicitada no existe!\nPor favor ingresar nuevamente o auxiliarse\ndel boton de CATALOGO ");
            }
        }
    }
    //este metodo actualizara los valores del debe y haber una vez calculado el IVA
    public static void incluirIVATotal(Double []IVA,ArrayList<AuxiliarTransaccion> lista, JTable tabla)
    {
        AuxiliarTransaccion cuentaIVA = new AuxiliarTransaccion();
        if(IVA[0]>0){
            cuentaIVA.setNombreCuenta("IVA Credito Fiscal");
            cuentaIVA.setDebe(IVA[0]);
            cuentaIVA.setHaber(0.0);
            cuentaIVA.setCodigoCuenta("11060203");
            lista.add(cuentaIVA);
            
        }
        else if(IVA[1]>0)
        {
            cuentaIVA.setNombreCuenta("IVA Debito Fiscal");
            cuentaIVA.setHaber(IVA[1]);
            cuentaIVA.setDebe(0.0);
            cuentaIVA.setCodigoCuenta("11060204");
            lista.add(cuentaIVA);
        }
        
        if(IVA[1]!=0.0 || IVA[0]!=0.0){
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            Object [] registro= new Object[4];
            registro[0]=cuentaIVA.getCodigoCuenta();
            registro[1]=cuentaIVA.getNombreCuenta();
            registro[2]=cuentaIVA.getDebe();
            registro[3]=cuentaIVA.getHaber();
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
}