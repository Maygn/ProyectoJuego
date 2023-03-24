package proyecto2.services;

import proyecto2.models.Personaje;
import proyecto2.utilities.AleatorioDescartando;
import proyecto2.utilities.utils;
/**
 * @param Personaje p
 * El método te da opciones de equipo, permitiendo que rechaces hasta tres de ellas y quedándote al final con otras tres. Estas
 * modificarán los atributos básicos del personaje.*/
public class AplicadorEquipo {
	public static void equipar(Personaje p) throws Exception {

		int opcionAleatoria = 0;
		int[] equipoElegidoDescartado = {0,0}; //Posicion 0 guarda el numero de elegidos, posicion 1 guarda la cantidad de descartados
		final int MAXEQUIPO = 3;
		int maximoDescarte = 3;
		String nombreEquipo;


		AleatorioDescartando<Integer> i1=new AleatorioDescartando<>(1,15);

		while (equipoElegidoDescartado[0] < MAXEQUIPO) {
			
			opcionAleatoria = i1.darAleatorio(); 

			switch (opcionAleatoria) {
			case 1:
				nombreEquipo="un aumento de ataque.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 2:
				nombreEquipo="un aumento de defensa.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;

			case 3:
				nombreEquipo="un aumento de vida.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 4:
				nombreEquipo="perder ataque a cambio de ganar defensa.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
				
			case 5:
				nombreEquipo="perder defensa a cambio de ganar ataque.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 6:
				nombreEquipo="un aumento de critico.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 7:
				nombreEquipo="un aumento de punteria.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			
			case 8:
				nombreEquipo="perder vida a cambio de ganar defensa.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 9:
				nombreEquipo="perder defensa a cambio de ganar vida.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 10:
				nombreEquipo="perder velocidad a cambio de ganar punteria.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 11:
				nombreEquipo="perder punteria a cambio de ganar velocidad.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 12:
				nombreEquipo="perder critico a cambio de ganar punteria.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 13:
				nombreEquipo="perder punteria a cambio de ganar critico.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 14:
				nombreEquipo="perder critico a cambio de ganar velocidad.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 15:
				nombreEquipo="perder velocidad a cambio de ganar critico.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;

			}
			
		}
		p.actualizarAtributos();
	}
	/**
	 * @param Personaje p
	 * @param int[] equipoElegidoDEscartado
	 * @param int maximoDescarte
	 * @param String nombreEquipo
	 * @return int[] equipoElegidoDEscartado
	 * El metodo te ofrece la opcion de aplicar una modificacion a los atributos del personaje, que puedes aceptar o rechazar un número limitado
	 * de veces.
	 * */
	public static int[] preguntarPasiva(Personaje p, int opcionAleatoria, int[] equipoElegidoDescartado, int maximoDescarte, String nombreEquipo) {
		if (utils.leerCharEspecifico(" Quieres  "+ nombreEquipo +"? [s]/[n] (Elegidos :" + equipoElegidoDescartado[0]//que no pregunte si ya no puede descartar mas
				+ " ,descartados: " + equipoElegidoDescartado[1], new char[] { 'S', 'N' }) == 'S') {
			aplicarPasiva(p, opcionAleatoria);
			equipoElegidoDescartado[0]++;
		} else {
			if (equipoElegidoDescartado[1]<maximoDescarte) {
				equipoElegidoDescartado[1]++;
				System.out.println("Equipo descartado.");
			}
			else {
				System.out.println("No te quedan descartes!");
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);
			}
		}
		
		return equipoElegidoDescartado;
	}
	/**
	 * @param Personaje p
	 * @param int opcionAleatoria
	 * El método recibe la opción que tiene que aplicar sobre los atributos del personaje y llama 
	 * al método que realiza los cambios sobre estos.*/
	private static void aplicarPasiva(Personaje p, int opcionAleatoria) {
		switch(opcionAleatoria) {
		case 1:
			aumentarAtaque(p);
			break;
		case 2:
			aumentarDefensa(p);
			break;
		case 3:
			duplicarVida(p);
			break;
		case 4:
			defensaPorAtaque(p);
			break;
		case 5:
			ataquePorDefensa(p);
			break;
		case 6:
			duplicarCritico(p);
			break;
		case 7:
			aumentarPunteria(p);
			break;
		case 8:
			vidaPorDefensa(p);
			break;
		case 9:
			defensaPorVida(p);
			break;
		case 10:
			velocidadPorPunteria(p);
			break;
		case 11:
			punteriaPorVelocidad(p);
			break;
		case 12:
			criticoPorPunteria(p);
			break;
		case 13:
			punteriaPorCritico(p);
			break;
		case 14:
			criticoPorVelocidad(p);
			break;
		case 15:
			velocidadPorCritico(p);
			break;
		}
		
	}
/** TODOS LOS MÉTODOS SIGUIENTES son variantes del mismo proceso aplicadas a atributos similares.
 * @param Personaje p
 * Son un listado de métodos que aplican modificaciones permanentes sobre el valor base de los atributos del personaje
 * */
	public static void aumentarAtaque(Personaje p) {
		p.getAtaque().setValorBase(p.getAtaque().getValorBase() + 100);
	}
	
	public static void aumentarDefensa(Personaje p) {
		p.getDefensa().setValorBase(p.getDefensa().getValorBase() + 100);
	}

	public static void duplicarVida(Personaje p) {
		p.getVidaMaxima().setValorBase(p.getVidaMaxima().getValorBase() * 2);
	}
	public static void defensaPorAtaque(Personaje p) {
		p.getAtaque().setValorBase(p.getAtaque().getValorBase() -150);
		p.getDefensa().setValorBase(p.getDefensa().getValorBase() + 300);
	}
	public static void ataquePorDefensa(Personaje p) {
		p.getAtaque().setValorBase(p.getAtaque().getValorBase() +300);
		p.getDefensa().setValorBase(p.getDefensa().getValorBase() -150);
	}
	public static void duplicarCritico(Personaje p) {
		p.getCritico().setValorBase(p.getCritico().getValorBase() * 2);
	}
	public static void aumentarPunteria(Personaje p) {
		p.getPunteria().setValorBase(p.getPunteria().getValorBase() +0.5);
	}
	public static void vidaPorDefensa(Personaje p) {
		p.getVidaMaxima().setValorBase(p.getVidaMaxima().getValorBase() -150);
		p.getDefensa().setValorBase(p.getDefensa().getValorBase() + 300);
	}
	public static void defensaPorVida(Personaje p) {
		p.getVidaMaxima().setValorBase(p.getVidaMaxima().getValorBase() +300);
		p.getDefensa().setValorBase(p.getDefensa().getValorBase() -150);
	}
	public static void velocidadPorPunteria(Personaje p) {
		p.getVelocidad().setValorBase(p.getVelocidad().getValorBase() -20);
		p.getPunteria().setValorBase(p.getPunteria().getValorBase() + 0.3);
	}
	public static void punteriaPorVelocidad(Personaje p) {
		p.getVelocidad().setValorBase(p.getVelocidad().getValorBase() +15);
		p.getPunteria().setValorBase(p.getPunteria().getValorBase() - 0.2);
	}
	public static void criticoPorPunteria(Personaje p) {
		p.getCritico().setValorBase(p.getCritico().getValorBase() -0.3);
		p.getPunteria().setValorBase(p.getPunteria().getValorBase() + 0.3);
	}
	public static void punteriaPorCritico(Personaje p) {
		p.getCritico().setValorBase(p.getCritico().getValorBase() +0.3);
		p.getPunteria().setValorBase(p.getPunteria().getValorBase() - 0.2);
	}
	public static void criticoPorVelocidad(Personaje p) {
		p.getCritico().setValorBase(p.getCritico().getValorBase() -0.3);
		p.getVelocidad().setValorBase(p.getVelocidad().getValorBase() +20);
	}
	public static void velocidadPorCritico(Personaje p) {
		p.getCritico().setValorBase(p.getCritico().getValorBase() +0.3);
		p.getVelocidad().setValorBase(p.getVelocidad().getValorBase() - 20);
	}
}
