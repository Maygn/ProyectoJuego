package proyecto2.models;

import java.io.Serializable;

public class Modificador implements Serializable{
	/**cantidad de modificador en inicio*/
    private double cantidad;
	/**duracion del modificador*/
    private int turnos;
    /**para saber de que movimiento procede el modificador*/
    private String origen;
    /**incremento del modificador inicial en turnos sucesivos
     * En realidad necesito dos valores para que no se haga exponencial, aunque
     * el valor de aqui sea el mismo que el de la cantidad inicial*/
    private double basePeriodica;

/**Constructor con parámetros
 * */
    public Modificador(double cantidad, int turnos, String origen, double basePeriodica) {
    	this.cantidad = cantidad;
        this.turnos = turnos;
        this.origen = origen;
        this.basePeriodica = basePeriodica;
    }


    public Modificador(Modificador m) {
        this.cantidad=m.cantidad;
        this.turnos=m.turnos;
        this.origen=m.origen;
        this.basePeriodica=m.basePeriodica;
    }
/**gtter y setter*/
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public int getTurnos() {
        return turnos;
    }
    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }
    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public double getBasePeriodica() {
        return basePeriodica;
    }
    public void setBasePeriodica(double basePeriodica) {
        this.basePeriodica = basePeriodica;
    }
    /**Añade modificador de turnos posteriores al modificador inicial*/
    public void actualizarPeriodico(){
        if(this.getBasePeriodica()!=0){
            this.cantidad= this.cantidad+this.basePeriodica;
        }
    }


    
}
