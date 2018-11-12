package Modelo;
/*2-Se necesita un constructor que reciba como parámetro boolean cerrado:
    si cerrado es true
        entonces llenar datos con periodo actual
                 al crear ese periodo se debe llenar en cascada su LibroMayor, dentro de este su lista de
                 DetalleTransaccion, y dentro de este su lista de Transaccion.
    sino
        entonces llenar datos con null
*/
/*3- Se necesita un metodo getUltimaTransaccion:devuelve int
    si libro mayor =! null entonces
        buscar en los correspondientes datos de los objetos en cascada (crear mas metodos de acceso en las clases que crean necesarias)
        hasta llegar a la ultima transaccion (id más alto) 
        y devolver su idTrans
    sino entonces
        devolver cero
*/

import java.util.Date;

public class PeriodoContable {
    // Atributos
    private int idPeriodo;
    private boolean cerrado;
    private Date inicio;
    private Date fin;
    private LibroMayor libroMayor;
    private Planilla planilla;

    // Constructor
    public PeriodoContable() {
        planilla = new Planilla();
    }
    
    // Métodos getter y setter
    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public boolean isCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public LibroMayor getLibroMayor() {
        return libroMayor;
    }

    public void setLibroMayor(LibroMayor libroMayor) {
        this.libroMayor = libroMayor;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }
}
