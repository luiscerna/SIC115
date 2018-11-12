package Modelo;
/*Crear metodo boolean llenarCatalogo() que llene el catalo con todos los registros de dicha tabla
    si el llenado se finalizo con exito entonces
        devolver true
    sino 
        devolver false
*/

/*Crear metodo bolean asignarCuentaMayor(string codCuenta) que llene (accediendo a la BD):
    1- cuentaMayor: con el nombre de la cuenta mayor a la que pertenece laa cuenta detalle que corresponde al codCuenta (crear una var auxiliar Cuenta)
    2-codCuentaMayor: con el cod de la Cuenta mayor del paso anterior
devolver true si se puede sino devolver false jeje
*/
import java.util.ArrayList;

public class DetalleTransaccion {
    // Atributos
    private int idDetalle;
    private String cuentaMayor;
    private String idCuentaMayor; //encapsular
    private double debe;
    private double haber;
    private ArrayList<Cuenta> catalogo;
    private ArrayList<Transaccion> transaccion;
    
    // Constructor
    public DetalleTransaccion(){
        
    }
    
    //Métodos getter y setter
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getCuentaMayor() {
        return cuentaMayor;
    }

    public void setCuentaMayor(String cuentaMayor) {
        this.cuentaMayor = cuentaMayor;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public ArrayList<Cuenta> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Cuenta> catalogo) {
        this.catalogo = catalogo;
    }

    public ArrayList<Transaccion> getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(ArrayList<Transaccion> transaccion) {
        this.transaccion = transaccion;
    }
}
