package Modelo;


public class AuxiliarTransaccion {
    private String conceptoGeneral;
    private String codigoCuenta;
    private String nombreCuenta;
    private Double debe;
    private Double haber;

    public AuxiliarTransaccion(String conceptoGeneral, String codigoCuenta, String nombreCuenta, Double debe, Double haber) {
        this.conceptoGeneral = conceptoGeneral;
        this.codigoCuenta = codigoCuenta;
        this.nombreCuenta = nombreCuenta;
        this.debe = debe;
        this.haber = haber;
    }

    public AuxiliarTransaccion() {
    }

    public String getConceptoGeneral() {
        return conceptoGeneral;
    }

    public void setConceptoGeneral(String conceptoGeneral) {
        this.conceptoGeneral = conceptoGeneral;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
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
        return "AuxiliarTransaccion{" + "conceptoGeneral=" + conceptoGeneral + ", codigoCuenta=" + codigoCuenta + ", nombreCuenta=" + nombreCuenta + ", debe=" + debe + ", haber=" + haber + '}';
    }
}
