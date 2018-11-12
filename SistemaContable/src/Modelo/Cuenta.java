package Modelo;
/*Crear constructor Cuenta(codCuenta)

*/
public class Cuenta {
    // Atributos
    private String codCuenta;
    private String rubro;
    private int nivel;
    private String nomCuenta;
    
    // Constructor
    public Cuenta(){
            
    }

    // Métodos getter y setter
    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
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
