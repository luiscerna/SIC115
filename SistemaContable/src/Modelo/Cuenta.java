package Modelo;
/*Crear constructor Cuenta(codCuenta)

*/
public class Cuenta {
    // Atributos
    String codCuenta;
    int rubro;
    int nivel;
    String nomCuenta;
    
    // Constructor
    public Cuenta()
    {
           
        
    }

    // Métodos getter y setter
    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public int getRubro() {
        return rubro;
    }

    public void setRubro(int rubro) {
        this.rubro = rubro;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNomCuenta() {
        return nomCuenta;
    }

    public void setNomCuenta(String nomCuenta) {
        this.nomCuenta = nomCuenta;
    }
}
