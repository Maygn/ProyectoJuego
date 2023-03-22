package proyecto2.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Atributo implements Serializable{
    private double valorBase;
    private double valorFinal;
    private ArrayList<Modificador> modificadoresLineales;
    private ArrayList<Modificador> modificadoresPorcentuales;
    
 //constructor
    public Atributo(double valorBase) {
        this.valorBase = valorBase;
        this.modificadoresPorcentuales=new ArrayList<>();
        this.modificadoresLineales=new ArrayList<>();
        }

    
//getters y setters
    public double getValorBase() {
        return valorBase;
    }
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
    public double getValorFinal() {
        return valorFinal;
    }
    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    //añadidores y getters de arraylists
    public ArrayList<Modificador> getModificadoresLineales() {
        return modificadoresLineales;
    }
    public ArrayList<Modificador> getModificadoresPorcentuales() {
        return modificadoresPorcentuales;
    }
    public void addModificadorPorcentual(Modificador m){
        this.modificadoresPorcentuales.add(m);
    }

    public void addModificadorLineal(Modificador m){
        this.modificadoresLineales.add(m);
    }


    /**
     * Calcula el atributo final cada turno, tomando la base y añadiendole las sumas de los modificadores.
     */
    public void calcularFinal(){
        double sumaPorcentual=1;
        for (Modificador modificador : modificadoresPorcentuales) {
            sumaPorcentual=sumaPorcentual+modificador.getCantidad();
        }

        this.valorFinal=this.valorBase*sumaPorcentual;

        double sumaLineal=0;
        for (Modificador modificador : modificadoresLineales) {
            sumaLineal=sumaLineal+modificador.getCantidad();
        }

        this.valorFinal=this.valorFinal+sumaLineal;
        
        bajarConteos(); //PUEDE FALLAR, CUIDADO
    }

    /**
     * Coge todos los modificadores y les baja la duración en 1, eliminandolos del ArrayList si su duración llega a 0.
     * Además llama al método ActualizarPeriodico del propio modificador.
     */
    public void bajarConteos(){
        ArrayList<Modificador> todosLosModificadores=new ArrayList<>();
        todosLosModificadores.addAll(modificadoresLineales);
        todosLosModificadores.addAll(modificadoresPorcentuales);

        for (Modificador modificador : todosLosModificadores) {
            modificador.setTurnos(modificador.getTurnos()-1);

            if(modificador.getTurnos()==0){
                
                modificadoresLineales.remove(modificador);
                modificadoresPorcentuales.remove(modificador);
            }

            modificador.actualizarPeriodico();
        }

    }

   

    @Override
    public String toString() {
        return "Atributo [valorBase=" + valorBase + ", valorFinal=" + valorFinal + "]";
    }

    
    
}
