package proyecto2.models;

public class Modificador {
    private double cantidad;
    private int turnos;
    private String origen;
    private double basePeriodica;


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
    
    public void actualizarPeriodico(){
        if(this.getBasePeriodica()!=0){
            this.cantidad= this.cantidad+this.basePeriodica;
        }
    }


    
}
