/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 * @author Irene Delgado :D  <dh16001@ues.edu.sv>
 */
public class MayorizacionControl {
    
    private PeriodoContable periodo;
    
    public MayorizacionControl() throws SQLException{
        this.periodo=new PeriodoContable();
        this.periodo.PeriodoContableAbierto();  
    }
    
    //Obtiene el listado de todas las Cuentas de Mayor Utilizadas en este periodo
    public  String[][] obtenerCuentasMayores() throws SQLException{ 
        HashSet setCuentasM= new HashSet();//Contiene los CodMayor (int)
        double debe=0,haber=0,saldo=0;
        

        ArrayList<DetalleTransaccion> auxDetalles=this.periodo.getDetallesDelPeriodo();
        for(DetalleTransaccion detalle : auxDetalles){//agregar al HashSet cada cod cuenta sin repetidos
            setCuentasM.add(detalle.getCodMayor());
        }
        
       
        String[][] cuentasM=new String[setCuentasM.size()][5];
        
        int i=0,m=0;
        Iterator<Integer> iter= setCuentasM.iterator();
        while(iter.hasNext()){//Por cada codMayor obtener su nombre y codigo del catálogo codigo en 0 y nombre en 1
            m=iter.next();
            
            for(DetalleTransaccion detalle : auxDetalles){//agregar al HashSet cada cod cuenta sin repetidos
                if (detalle.getCodMayor()==m){
                    debe+=detalle.getDebe();
                    haber+=detalle.getHaber();
                }
            }
            
            //calcular saldo segun rubro
            int rubro=(new Cuenta(m)).getRubro();
            if(rubro==1||rubro==4)
               saldo=debe-haber;
            else saldo=haber-debe;
            
            cuentasM[i][0]=new Cuenta(m).getCodCuenta();
            cuentasM[i][1]=new Cuenta(m).getNomCuenta();
            cuentasM[i][2]=String.valueOf(debe);
            cuentasM[i][3]=String.valueOf(haber);
            cuentasM[i][4]=String.valueOf(saldo);
            debe=0;haber=0;saldo=0;
            i++;
        }
        return cuentasM;
        
    }
    //Devuelde los detalles de la mayorizacion de una cuenta Mayor segun su codigo de cuenta
    public String[][] obtenerPartidas( String codigoMayor) throws SQLException{
        int codMayor=new Cuenta(codigoMayor).getId();
        String[][] detalles=null; //Contiene los detalles de las partidas de la cuentaM
        HashSet listaTransacciones= new HashSet(); //Contiene las transacciones sin repetidos
        double debe=0, haber=0, saldo=0;//variables auxiliares
        
        //Obtener toda la lista de transacciones para esa cuenta
        for(DetalleTransaccion detalle : this.periodo.getDetallesDelPeriodo()){
            if(detalle.getCodMayor()==codMayor)
                listaTransacciones.add(detalle.getTransaccion());
        }
        
        detalles=new String[listaTransacciones.size()][6];//Por cada partida se llenaran 6 campos
        Iterator<Transaccion> iterarTrans=listaTransacciones.iterator();
        int i=0;
        while(iterarTrans.hasNext()){//Recorre la lista de numPartidas
            Transaccion auxTrans=iterarTrans.next();
            for(DetalleTransaccion detalle : this.periodo.getDetallesDelPeriodo()){
                //Si la transaccion es igual a la actual y si pertenece a la cuenta mayor
                if(auxTrans.equals(detalle.getTransaccion())&&detalle.getCodMayor()==codMayor){
                    //acumular cargos y abonos por Transaccion
                    debe+=detalle.getDebe();
                    haber+=detalle.getHaber();
                }
            }
            
          //calcular saldo segun rubro
            int rubro=(new Cuenta(codMayor)).getRubro();
           if(rubro==1||rubro==4)
               saldo=debe-haber;
           else saldo=haber-debe;
           
           //llenar campos segun num partida
           detalles[i][0]=new SimpleDateFormat("dd/MM/yyyy").format(auxTrans.getFechaTrans());//fecha
           detalles[i][1]=String.valueOf(auxTrans.getNumeroPartida());//numPartida
           detalles[i][2]=auxTrans.getConcepto();//concepto
           detalles[i][3]=String.valueOf(debe);//debe
           detalles[i][4]=String.valueOf(haber);//haber
           detalles[i][5]=String.valueOf(saldo);//saldo
           debe=0;haber=0;saldo=0;
           i++;
        }
        
        return detalles;
    }
}
