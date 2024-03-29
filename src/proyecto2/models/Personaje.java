package proyecto2.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Personaje implements Serializable{ 
	//atributos
	
    private String jugador;//No se usa en la creacion que se ofrece al jugador, es el equivalente a vincular el personaje a 
    					// una cuenta de correo en un servidor de verdad

    private boolean vivo;

    private String nombre;
    private String descripcion; 
    /*los atributos del personaje son objetos de tipo atributo en los que se ha puesto por separado
	 * el valor base  y posibles variaciones de este, de forma que se pueden almacenar las variaciones temporales
	 * sin sustituir el valor original del atributo*/
    private Atributo vidaMaxima;
    private Atributo vidaActual;

    private Atributo ataque;
    private Atributo defensa;
    private Atributo velocidad;
    private Atributo punteria;
    private Atributo critico;
    /*Son objetos con sus propios atributos*/
    private MovimientoBase mov1;
    private MovimientoBase mov2;
    private MovimientoBase mov3;
    private MovimientoBase mov4;
    private MovimientoBase movElegido;//aqui se guarda el que se ha elegido para usar en cada turno, de los cuatro anteriores
    
    /*para que no puedas hacer copia de seguridad de tu archivo de personaje y usarlo despues de muerto*/
    private ArrayList<String> nombresUsados;
    private ArrayList<String> derrotados;
    private ArrayList<String> baneados;
    
    
    
    //constructor con valores de inicio
    public Personaje() {
    	this.vidaMaxima=new Atributo(300);
    	this.vidaActual=new Atributo(300);
		this.ataque=new Atributo(100);
		this.defensa=new Atributo(100);
		this.velocidad=new Atributo(50);
		this.punteria=new Atributo(0.8);
		this.critico=new Atributo(1.3);
		
		this.nombresUsados=new ArrayList<String>();
		this.derrotados=new ArrayList<String>();
		this.baneados=new ArrayList<String>();
	}
    
    //getters y setters
	public String getJugador() {
        return jugador;
    }
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
    public boolean isVivo() {
        return vivo;
    }
    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Atributo getVidaMaxima() {
        return vidaMaxima;
    }
    public void setVidaMaxima(Atributo vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }
    public Atributo getVidaActual() {
        return vidaActual;
    }
    public void setVidaActual(Atributo vidaActual) {
        this.vidaActual=vidaActual;
    }
    public void setVidaActual(double vidaActual) {   //setter sobrecargado porque es mas rápido para crear TODOS los ataques
        this.vidaActual.setValorBase(vidaActual);
    }
    public Atributo getAtaque() {
        return ataque;
    }
    public void setAtaque(Atributo ataque) {
        this.ataque = ataque;
    }
    public Atributo getDefensa() {
        return defensa;
    }
    public void setDefensa(Atributo defensa) {
        this.defensa = defensa;
    }
    public Atributo getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(Atributo velocidad) {
        this.velocidad = velocidad;
    }
    public Atributo getPunteria() {
        return punteria;
    }
    public void setPunteria(Atributo punteria) {
        this.punteria = punteria;
    }
    public Atributo getCritico() {
        return critico;
    }
    public void setCritico(Atributo critico) {
        this.critico = critico;
    }
    
    public void setMovimientos(MovimientoBase[] arrayMovs) {
    	this.mov1=arrayMovs[0];
    	this.mov2=arrayMovs[1];
    	this.mov3=arrayMovs[2];
    	this.mov4=arrayMovs[3];
    }
    
      
    public MovimientoBase getMovElegido() {
		return movElegido;
	}
	public void setMovElegido(MovimientoBase movElegido) {
		this.movElegido = movElegido;
	}
	public MovimientoBase getMov1() {
		return mov1;
	}
	public void setMov1(MovimientoBase mov1) {
		this.mov1 = mov1;
	}
	public MovimientoBase getMov2() {
		return mov2;
	}
	public void setMov2(MovimientoBase mov2) {
		this.mov2 = mov2;
	}
	public MovimientoBase getMov3() {
		return mov3;
	}
	public void setMov4(MovimientoBase mov3) {
		this.mov3 = mov3;
	}
	public MovimientoBase getMov4() {
		return mov4;
	}
	public void setMov3(MovimientoBase mov3) {
		this.mov3 = mov3;
	}
	public ArrayList<String> getNombresUsados() {
        return nombresUsados;
    }
    public void setNombresUsados(ArrayList<String> nombresUsados) {
        this.nombresUsados = nombresUsados;
    }
    public ArrayList<String> getDerrotados() {
        return derrotados;
    }
    public void setDerrotados(ArrayList<String> derrotados) {
        this.derrotados = derrotados;
    }
    public ArrayList<String> getBaneados() {
        return baneados;
    }
    public void setBaneados(ArrayList<String> baneados) {
        this.baneados = baneados;
    }

    /**@param double daño
     * @return this.vidaActual.getValorFinal(); 
     * 
     * Recibe un valor de daño y lo reduce de la vida actual
     * CUIDADO: Retorna el valor final (quitando venenos) de la vida actual.
     */
    public double recibirDaño(double daño){
        this.vidaActual.setValorBase(this.vidaActual.getValorBase()-daño);

        return this.vidaActual.getValorFinal();
    }

    
    /*calcula el estado de los valores de los atributos teniendo
     * en cuenta los modificadores que se les apliquen en el momento dado. */
    
    public void actualizarAtributos(){
        this.ataque.calcularFinal();
        this.defensa.calcularFinal();
        this.critico.calcularFinal();
        this.punteria.calcularFinal();
        this.critico.calcularFinal();
        this.vidaActual.calcularFinal();
        this.vidaMaxima.calcularFinal();
        this.velocidad.calcularFinal();
    }
    
    public void bajarConteos(){
        this.ataque.bajarConteos();
        this.defensa.bajarConteos();
        this.critico.bajarConteos();
        this.punteria.bajarConteos();
        this.critico.bajarConteos();
        this.vidaActual.bajarConteos();
        this.vidaMaxima.bajarConteos();
        this.velocidad.bajarConteos();
    }

    @Override
    public String toString() {
        return "Personaje "
        		+ "\n[jugador=" + jugador + ", \n vivo=" + vivo + ", \n nombre=" + nombre + ", \n descripcion="
                + descripcion + ", \n vidaMaxima=" + vidaMaxima + ", \n vidaActual=" + vidaActual + ", \n ataque=" + ataque
                + ", \n defensa=" + defensa + ", \n velocidad=" + velocidad + ", \n punteria=" + punteria + ", \n critico="
                + critico +  ",\n ataques: "+mov1.getNombre()+", "+ mov1.getDescripcion()
                +"\n "+mov2.getNombre()+" "+ mov2.getDescripcion()+
                "\n "+ mov3.getNombre()+" "+ mov3.getDescripcion() +"\n "+mov4.getNombre()+" "+ mov4.getDescripcion()
                + "]";
    }

    
    

    

    

    

    
}
