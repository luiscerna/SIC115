package ModeloTablas;

//importando librerias
import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Modelo.Catalogo;
import Modelo.Transaccion;
import Modelo.DetalleTransaccion;

public class TransaccionTableModel extends AbstractTableModel{
    
    //Lista de Registros que se van a colocar en la tabla del formulario transaccion
    ArrayList<DetalleTransaccion> detalleTransaccion= new ArrayList<DetalleTransaccion>();
    
    @Override 
    public int getRowCount() //Metodo para obtener numero de registros
    {
        return detalleTransaccion.size();
    }
    
    @Override
    public int getColumnCount() //Metodo para obtener el numero de columnas de la tabla
    {
        return 4; //columnas: codigo, nombre, rubro y nivel de la clase Catalogo
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        DetalleTransaccion det= detalleTransaccion.get(rowIndex);
        Object valor=null;
        switch(columnIndex){
            case 0: valor=det.getCatalogo().getCodCuenta();
            break;
            case 1: valor=det.getCatalogo().getNomCuenta();
            break;
            case 2: valor=det.getDebe();
            break;
            case 3: valor= det.getHaber();
            break;
        }
       return valor;
    }
}
