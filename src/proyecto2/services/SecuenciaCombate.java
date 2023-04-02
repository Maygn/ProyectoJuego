package proyecto2.services;

import java.io.Console;

import proyecto2.models.Personaje;
import proyecto2.utilities.utils;

public class SecuenciaCombate {
	
	//TODO: Comprobar si ambos personajes estan vivos (Muy probablemente desde los llamadores)
	
	
	/**@param Personaje p1
	 * Te informa del nombre de los ataques que puedes elegir, te permite elegir uno
	 * y lo almacena en el "movimientoElegido" del personaje*/
	public static void elegirMovimiento(Personaje p1) {
		
		System.out.println("El personaje " + p1.getNombre()+" está eligiendo movimiento.");
		
		String mov1=p1.getMov1().getNombre().toString();
		String mov2=p1.getMov2().getNombre().toString();
		String mov3=p1.getMov3().getNombre().toString();
		String mov4=p1.getMov4().getNombre().toString();
		System.out.println("Tus movimientos disponibles son: \n 1-" + mov1 +"\n 2-"
				+ mov2 +"\n 3-"+mov3+ "\n 4-" +mov4);
		
		
//		CAMBIAR UNA VEZ TERMINEMOS Y SE VAYA A COMPILAR
//		LA CONSOLA DE ECLIPSE NO TOLERA System.console()
		
		Console cs1=System.console(); //Define la consola actual
		boolean fuera=false;
		int elegido=0;
		char [] arr1=new char[1];
		
		
		if(cs1!=null) {//Si el entorno tiene consola (No en eclipse, por ejemplo)
		while(!fuera) {
			char[] arrTemporal=cs1.readPassword("Cual de los ataques quieres usar?");
			
			if(arrTemporal.length>0) { //Si el array temporal tiene valor (El usuario no le ha dado directamente a enter)
				arr1=arrTemporal;
			}
			//arr1=cs1.readPassword("Cual de los ataques quieres usar?"); //Usa la consola para leer el movimiento, sin mostrar lo que escribe el usuario
			elegido=Character.getNumericValue(arr1[0]); // Lo convierte en valor numérico.
			
			
			if(elegido>0 && elegido <5) {
				fuera=true;
			}
			else {
				System.out.println("Ese número no es uno de tus cuatro movimientos. ");
				System.out.println("Tus movimientos disponibles son: 1-" + mov1 +"\n 2-"
						+ mov2 +"\n 3-"+mov3+ "\n 4-" +mov4);
			}
		}
		}
		else {
			elegido=utils.leerDatoEntero("Cual de los ataques quieres usar?", 1, 4);
		}
        
        
		
		switch (elegido) { //CAMBIAR POR elegido CUANDO SE COMPILE
		case 1:
			p1.setMovElegido(p1.getMov1());
			break;
		case 2:
			p1.setMovElegido(p1.getMov2());
			break;
		case 3:
			p1.setMovElegido(p1.getMov3());
			break;
		case 4:
			p1.setMovElegido(p1.getMov4());
			break;
		}
	}
/**@param Personaje p1
 * @param Personaje p2
 * El método calcula la velocidad a la que sale el ataque elegido por cada jugador, en base a eso
 * realiza los ataques en el orden que corresponda*/
	public static void hacerAtaques(Personaje p1, Personaje p2) {
		
		double velocidadTotalP1=p1.getVelocidad().getValorFinal()+p1.getMovElegido().getVelocidadBase();
		double velocidadTotalP2=p2.getVelocidad().getValorFinal()+p1.getMovElegido().getVelocidadBase();
	
		if(velocidadTotalP1>velocidadTotalP2) {
				p1.getMovElegido().realizar(p1,p2);
				p2.getVidaActual().calcularFinal();
				if (p2.getVidaActual().getValorFinal()>0) { //Condicionamos el segundo ataque a que la persona quede con vida.
					p2.getMovElegido().realizar(p2,p1);
				}
				
		}else {
			p2.getMovElegido().realizar(p2,p1);
			p1.getVidaActual().calcularFinal();
			if (p1.getVidaActual().getValorFinal()>0) {
				p1.getMovElegido().realizar(p1,p2);
			}
		}
		
	}
	/**
	 * @param Personaje p1
	 * @param Personaje p2
	 * 
	 * Se aplican actualizaciones de modificadores de atributos
	 * Se comprueba si ha muerto alguno de los personajes, se bajan conteos (duracion de turnos de cosas que 
	 * duran varios y se aplican sus bajadas de vida si corresponde, despues se vuelve a comprobar si han muerto
	 * alguno por esta causa
	 * Informa a los jugadores de la vida que les queda.*/
	public static void comprobarCosas(Personaje p1, Personaje p2) {
		
		p1.actualizarAtributos();
		p2.actualizarAtributos();
		
		if(!comprobarMuerte(p1,p2)) {
			p1.bajarConteos();
			p2.bajarConteos();
			comprobarMuerte(p1,p2);
		}
		System.out.println(p1.getNombre()+" estas en este momento en "+p1.getVidaActual().getValorFinal() + " puntos de vida.");
		System.out.println(p2.getNombre()+" estas en este momento en "+p2.getVidaActual().getValorFinal() + " puntos de vida.");
	}
	
	/**
	 * @param Personaje p1
	 * @param Personaje p2
	 *  Se comprueba para cada jugador si su vida ha caido por debajo de cero, en ese caso se cambia el boolean
	 *  a muerto, lo que impide que el personaje se pueda seguir usando y se añade a la lsita de jugadores derrotados
	 *  por del oponente*/
	private static boolean comprobarMuerte(Personaje p1, Personaje p2) {
		boolean caido=false;
		
		if (p1.getVidaActual().getValorFinal()<=0) {
			p1.setVivo(false);
			System.err.println(p1.getNombre() + " ha sido derrotado." );
			if (p1.getJugador()!="NPC") {
				p2.getDerrotados().add(p1.getNombre());
			}
			caido=true;
		}
		
		if (p2.getVidaActual().getValorFinal()<=0) { // Lo mismo pero con el otro jugador.
			p2.setVivo(false);
			System.err.println(p2.getNombre() + " ha sido derrotado." );
			if (p1.getJugador()!="NPC") {
				p2.getDerrotados().add(p1.getNombre());
			}
			caido=true;
		}
		
		if(caido) {
			comprobarVictoria(p1,p2);
		}
		
		return caido;
		
	}
	/**
	 * @param Personaje p1
	 * @param Personaje p2
	 * Se comprueba quien ha muerto y se devuelve la vida del que ha ganado
	 * a su valor base completo para el siguiente combate*/
	private static void comprobarVictoria(Personaje p1, Personaje p2) {
		if(!p1.isVivo()&&!p2.isVivo()) {
			System.out.println("Ambos guerreros han caido a la vez.");
		}
		else if (!p1.isVivo()) {
			System.out.println(p2.getNombre() + " es el ganador de este combate!");
			p2.getVidaActual().setValorBase(p2.getVidaMaxima().getValorBase());
		}
		else {
			System.out.println(p1.getNombre() + " es el ganador de este combate!");
			p1.getVidaActual().setValorBase(p1.getVidaMaxima().getValorBase());
		}
	}
	/**
	 * @param Personaje p1
	 * @param Personaje p2
	 * @param boolean npc
	 * Se usa la secuencia de metodos para realizar en combate, se comprueba si uno de los personajes es un npc
	 * o no, para si lo es utilizar el aleatorizador de movimientos elegidos
	 * */
	public static void cicloCombate(Personaje p1, Personaje p2, boolean npc) {
		while(p1.isVivo()&&p2.isVivo()) {
			elegirMovimiento(p1);
			
			if(npc==false) {
			elegirMovimiento(p2);
			}
			else {
				movimientoAleatorio(p2);
			}
			hacerAtaques(p1, p2);
			
			comprobarCosas(p1, p2);
		}
		System.out.println("Fin del combate.");
	}
	/**
	 * Aleatoriza los movimientos elegidos por los npc en combate.*/
	private static void movimientoAleatorio(Personaje p1) {
		switch (utils.aleatorio(1, 4)) { 
		case 1:
			p1.setMovElegido(p1.getMov1());
			break;
		case 2:
			p1.setMovElegido(p1.getMov2());
			break;
		case 3:
			p1.setMovElegido(p1.getMov3());
			break;
		case 4:
			p1.setMovElegido(p1.getMov4());
			break;
		}
	}
	
}
