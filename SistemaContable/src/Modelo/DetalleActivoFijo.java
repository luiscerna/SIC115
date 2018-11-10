package Modelo;

public class DetalleActivoFijo {
    // Atributos
    private int idDesgaste;
    private double valor;
    private int vidaUtil;
    private double valorSalvamento;
    private String tipoActivo;
    private double desgasteAnual;
    private double desgasteMensual;

    // Constructor
    public DetalleActivoFijo() {
    }
    
    // Métodos getter y setter
    public int getIdDesgaste() {
        return idDesgaste;
    }

    public void setIdDesgaste(int idDesgaste) {
        this.idDesgaste = idDesgaste;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public double getValorSalvamento() {
        return valorSalvamento;
    }

    public void setValorSalvamento(double valorSalvamento) {
        this.valorSalvamento = valorSalvamento;
    }

    public String getTipoActivo() {
        return tipoActivo;
    }

    public void setTipoActivo(String tipoActivo) {
        this.tipoActivo = tipoActivo;
    }

    public double getDesgasteAnual() {
        return desgasteAnual;
    }

    public void setDesgasteAnual(double desgasteAnual) {
        this.desgasteAnual = desgasteAnual;
    }

    public double getDesgasteMensual() {
        return desgasteMensual;
    }

    public void setDesgasteMensual(double desgasteMensual) {
        this.desgasteMensual = desgasteMensual;
    }
}
