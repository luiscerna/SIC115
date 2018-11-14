/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import java.sql.SQLException;
import java.util.ArrayList;
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
        this.periodoActual.llenarCatalogo();
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
    
    //Paso 3: El usuario selecciona la cuenta, indica si es Cargo/abono, el monto y presiona OK
   
  
    
}
