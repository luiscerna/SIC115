/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Usuario;
import Modelo.Empleado;
import Modelo.Puesto;
import java.util.ArrayList;

/**
 *
 * @author Irene Delgado :D  <dh16001@ues.edu.sv>
 */
public class UsuarioControl {
    Usuario user =new Usuario();
    private Empleado emp;
    
    public boolean validarUsuario(String usuario, String contrasena){
        if(user.llenarUsuario(usuario)){//Si el usuario existe, llena los datos y retorna true
            if(user.getPassword().equals(contrasena)){//Comapara los datos obtenidos de la BD con la contraseña ingresada
                return true;
            }else return false;   
        }else return false;
    }
    
    public void crearUsuario(String usuario, String password, int nivel, int codEmpleado, String nombre, String apellido, int puesto){
        Usuario us = new Usuario(usuario, password, nivel, codEmpleado, nombre, apellido, puesto);
    }
    
    public void obtenerEmpleado(int codEmpleado){
        setEmp(new Empleado(codEmpleado));
    }
    
    public int obtenerNivelId(int i){
        if(i==0){
            return user.getNivelAcceso();
        }else return user.getIdUsuario();
    }
    
    public String obtenerNombreApellido(int n){
        if(n==1){
            return user.getNombreEmpleado();
        }else if(n==2){
            return user.getApellidoEmpleado();
        }else return "Ingresó mal el parámetro.";
        
    }
    
    public ArrayList<String> todosEmpleados(){
        Empleado emp = new Empleado();
        ArrayList<String> lol = emp.todosEmpleados();
        return lol;
    }
    
    public ArrayList<String> todosNivelAcceso(){
        Puesto psto = new Puesto();
        ArrayList<String> lol = psto.todosNivelAcceso();
        return lol;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }
}
