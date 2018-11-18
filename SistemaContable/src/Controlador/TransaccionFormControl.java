package Controlador;

import Modelo.Prueba;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*Descripcion:
  Equipo esta clase es para tratar de generalizar las operaciones de los botones
  y demas componentes de las pestañas del formulario de transaccion con el propo
  sito de evitar repetir codigo y tener mayores facilidades en la correcion.

    -Con cariño Moto :)-
*/


public class TransaccionFormControl {
    
    public static void agregarElementoTabla(String codigo,String nombre,String monto, boolean esCargo, JTable tabla, ArrayList lista)
    {   
        //Por el momento es simbolico pero luego se trabajara con la clase real
        Prueba prueba= new Prueba();
        prueba.setNombre(nombre);
        prueba.setNumero(codigo);
        if(esCargo)
        {
            prueba.setDebe(Double.parseDouble(monto));
            prueba.setHaber(0.00);
        }
        else
        {
            prueba.setHaber(Double.parseDouble(monto));
            prueba.setDebe(0.00);
        }
        
        //Agregar elemento del registro de la tabla
        Object [] registro= new Object[4];
        registro[0]=prueba.getNumero();
        registro[1]= prueba.getNombre();
        registro[2]=prueba.getDebe();
        registro[3]=prueba.getHaber();
        
        //Objeteniendo el modelo de la tabla
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
        modelo.addRow(registro);
        tabla.setModel(modelo);
        lista.add(prueba);
    }
    
    public static void calcularTotalesYDiferencia(Double []total, ArrayList<Prueba> lista, JLabel debe, JLabel haber, JLabel diferencia)
    {
        //inicializando acumuladores y diferencia
        Double totalDebe=0.00, totalHaber=0.00, diferenciaTotal=0.00;
        
        for(Prueba o: lista)
        {
            totalDebe+= o.getDebe();
            totalHaber+= o.getHaber();
        }
        
        diferenciaTotal= totalDebe - totalHaber;       
            debe.setText("$"+totalDebe);
            haber.setText("$"+totalHaber);
            diferencia.setText("$"+diferenciaTotal);
    }
    
    public static boolean validadorPartidaDoble(JLabel lbl)
    {
        //Double diferencia= total[0]-total[1];
        Double diferencia=Double.parseDouble(lbl.getText().substring(1));
        boolean respuesta= false;
        if(diferencia == 0)
           respuesta= true;
        else 
            respuesta=false;
        
        return respuesta;
    }
    
}
