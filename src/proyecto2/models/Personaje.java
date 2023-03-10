package proyecto2.models;

import java.util.ArrayList;

public class Personaje {
    private String jugador;

    private boolean vivo;

    private String nombre;
    private String descripcion; 

    private Atributo vidaMaxima;
    private Atributo vidaActual;

    private Atributo ataque;
    private Atributo defensa;
    private Atributo velocidad;
    private Atributo punteria;
    private Atributo critico;
    
    private MovimientoBase mov1;
    private MovimientoBase mov2;
    private MovimientoBase mov3;
    private MovimientoBase mov4;
    private MovimientoBase movElegido;
    
    private ArrayList nombresUsados;
    private ArrayList derrotados;
    private ArrayList baneados;
    
    
    
    
    
    public Personaje() {
    	this.vidaMaxima=new Atributo(1000);
    	this.vidaActual=new Atributo(1000);
		this.ataque=new Atributo(200);
		this.defensa=new Atributo(500);
		this.velocidad=new Atributo(50);
		this.punteria=new Atributo(0.8);
		this.critico=new Atributo(1.3);
		
	}
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
    public void setVidaActual(double vidaActual) {   //setter sobrecargado porque es mas rápido para TODOS los ataques
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
		return mov3;
	}
	public void setMov3(MovimientoBase mov3) {
		this.mov3 = mov3;
	}
	public ArrayList getNombresUsados() {
        return nombresUsados;
    }
    public void setNombresUsados(ArrayList nombresUsados) {
        this.nombresUsados = nombresUsados;
    }
    public ArrayList getDerrotados() {
        return derrotados;
    }
    public void setDerrotados(ArrayList derrotados) {
        this.derrotados = derrotados;
    }
    public ArrayList getBaneados() {
        return baneados;
    }
    public void setBaneados(ArrayList baneados) {
        this.baneados = baneados;
    }

    /** Recibe un valor y lo reduce de la base de la vida actual
     * CUIDADO: Retorna el valor final (quitando venenos) de la vida actual.
     */
    public double recibirDaño(double daño){
        this.vidaActual.setValorBase(this.vidaActual.getValorBase()-daño);

        return this.vidaActual.getValorFinal();
    }

    public void actualizarAtributos(){
        this.ataque.calcularFinal();
        this.defensa.calcularFinal();
        this.critico.calcularFinal();
        this.punteria.calcularFinal();
        this.critico.calcularFinal();
        this.vidaActual.calcularFinal();
        this.vidaMaxima.calcularFinal();
    }

    @Override
    public String toString() {
        return "Personaje [jugador=" + jugador + ", vivo=" + vivo + ", nombre=" + nombre + ", descripcion="
                + descripcion + ", vidaMaxima=" + vidaMaxima + ", vidaActual=" + vidaActual + ", ataque=" + ataque
                + ", defensa=" + defensa + ", velocidad=" + velocidad + ", punteria=" + punteria + ", critico="
                + critico + ", nombresUsados=" + nombresUsados + ", derrotados=" + derrotados + ", baneados=" + baneados + ", ataques: "+mov1.getNombre()+" "+mov2.getNombre()+" "+ mov3.getNombre() +" "+mov4
                + "]";
    }

    
    

    

    

    

    
}
