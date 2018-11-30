package Controlador;
import Modelo.Empleado;
import Modelo.Puesto;
import Modelo.Usuario;
import java.util.ArrayList;


public class EmpleadoControl {
    
    // Constructor
    public EmpleadoControl(){
        
    }
    
     public static void main(String[] args) {
         
     
     }
    
    //Para llenar ComboBox´s
     
     //Empleados
    public ArrayList<String[]> obtenerEmpleados(){
        ArrayList<String[]> empleados=new ArrayList<String[]>();
        Empleado empleado=new Empleado();
        String[] apellidoNombre;
        for(Integer i: empleado.codsEmpleados()){
            Empleado emple=new Empleado((int)i);
            if(!emple.getApellidoEmpleado().isEmpty()){
                apellidoNombre= new String[4];
                apellidoNombre[0]=emple.getApellidoEmpleado();
                apellidoNombre[1]=emple.getNombreEmpleado();
                apellidoNombre[2]=String.valueOf(emple.getCodEmpleado());
                apellidoNombre[3]=emple.getPuesto().getNombrePuesto();
                empleados.add(apellidoNombre);
            }
        }
        return empleados;
    }
        //Puestos
    public ArrayList<String[]> obtenerPuestos(){
        ArrayList<String[]> puestos=new ArrayList<String[]>();
        Puesto puesto=new Puesto();
        String[] nombreSueldo;
        for(Integer i: puesto.codsPuesto()){
            Puesto pue=new Puesto((int)i);
            if(!pue.getNombrePuesto().isEmpty()){
                nombreSueldo= new String[3];
                nombreSueldo[0]=String.valueOf(pue.getNombrePuesto());
                nombreSueldo[1]=String.valueOf(pue.getSueldoBase());
                nombreSueldo[2]=String.valueOf(pue.getCodPuesto());
                puestos.add(nombreSueldo);
            }  
        }
        return puestos;
    }
    
    //Gestionar Empleado
    public boolean gestionarEmpleado(String cod, int gestion, String apellidos, String nombre, String codPuesto){
        boolean exito=false;
        Empleado empleadoEditor=new Empleado();
        if(gestion==0){//Actualizar
            boolean obrero;
            if(Integer.parseInt(codPuesto)==6)
                obrero=true;
            else obrero=false;
            exito=empleadoEditor.actualizarEmpleado(Integer.parseInt(cod), nombre, apellidos, obrero, Integer.parseInt(codPuesto));
        }else{//eliminar
            exito=empleadoEditor.eliminarEmpleado(Integer.parseInt(cod));
        }
        return exito;
    }
    
    //Nuevo Registro
    public boolean nuevoPuestoEmpleado(int gestion, String nombre, String apellidoSueldo, String codPuestoNivel){
        if(gestion==0){
            boolean obrero=false;
            if(Integer.parseInt(codPuestoNivel)==6)
                obrero=true;
            Empleado emp= new Empleado(nombre,apellidoSueldo,obrero,Integer.parseInt(codPuestoNivel));
        }else{
            Puesto p=new Puesto(nombre,Double.parseDouble(apellidoSueldo),Integer.parseInt(codPuestoNivel));
        }
        return true;
    }
    
}
