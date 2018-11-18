package Modelo;


public class Prueba {
    private String numero;
    private String nombre;
    private Double debe;
    private Double haber;

    public Prueba(String numero, String nombre, Double debe, Double haber) {
        this.numero = numero;
        this.nombre = nombre;
        this.debe = debe;
        this.haber = haber;
    }
    public Prueba(){
        //constructor vacio
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDebe() {
        return debe;
    }

    public void setDebe(Double debe) {
        this.debe = debe;
    }

    public Double getHaber() {
        return haber;
    }

    public void setHaber(Double haber) {
        this.haber = haber;
    }

    @Override
    public String toString() {
        return "Prueba{" + "numero=" + numero + ", nombre=" + nombre + ", debe=" + debe + ", haber=" + haber + '}';
    }
    
    
}
