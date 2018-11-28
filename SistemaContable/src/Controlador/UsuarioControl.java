/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Usuario;

/**
 *
 * @author Irene Delgado :D  <dh16001@ues.edu.sv>
 */
public class UsuarioControl {
    Usuario user =new Usuario();
    
    public boolean validarUsuario(String usuario, String contrasena){
        if(user.llenarUsuario(usuario)){//Si el usuario existe, llena los datos y retorna true
            System.out.println("Contraseña correcta: "+user.getPassword()+"\nContraseña ingresada: "+contrasena);
            if(user.getPassword().equals(contrasena)){//Comapara los datos obtenidos de la BD con la contraseña ingresada
                return true;
            }else return false;   
        }else return false;
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
}
