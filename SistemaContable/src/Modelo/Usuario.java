package Modelo;


import java.util.ArrayList;

public class Usuario extends Empleado {
    // Atributos
    private int idUsuario;
    private String usuario;
    private String password;
    private int nivelAcceso;
    private ArrayList<Cardex> cardex;

    // Constructor
    public Usuario() {
        
    }
    //Constructor de Consulta
    public Usuario(int idUsuario) {
        
    }
    
    //Constructor de Nuevo Registro
    public Usuario(String usuario, String password, int nivel){
        
    }
    
    // Métodos getter y setter
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public ArrayList<Cardex> getCardex() {
        return cardex;
    }

    public void setCardex(ArrayList<Cardex> cardex) {
        this.cardex = cardex;
    }
}
