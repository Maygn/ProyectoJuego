package proyecto2.services;

import proyecto2.models.Personaje;
import proyecto2.utilities.AleatorioDescartando;
import proyecto2.utilities.utils;

public class AplicadorEquipo {
	public static void equipar(Personaje p) throws Exception {

		int opcionAleatoria = 0;
		int[] equipoElegidoDescartado = {0,0}; //Posicion 0 guarda el numero de elegidos, posicion 1 guarda la cantidad de descartados
		final int MAXEQUIPO = 3;
		int maximoDescarte = 3;
		String nombreEquipo;

		// Clausulas escudo

		AleatorioDescartando<Integer> i1=new AleatorioDescartando<>(1,15);

		while (equipoElegidoDescartado[0] < MAXEQUIPO) {
			
			opcionAleatoria = i1.darAleatorio(); // Habria que hacer un metodo de UTILS (o no) que te de aleatorios sin repetir

			switch (opcionAleatoria) {
			case 1:
				nombreEquipo="aumento de ataque.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 2:
				nombreEquipo="aumento de defensa.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;

			case 3:
				nombreEquipo="aumento de vida.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 4:
				nombreEquipo="pierde ataque a cambio de defensa.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
				
			case 5:
				nombreEquipo="pierde defensa a cambio de ataque.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 6:
				nombreEquipo="aumento de crítico.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 7:
				nombreEquipo="aumento de puntería.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			
			case 8:
				nombreEquipo="pierde vida a cambio de defensa.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 9:
				nombreEquipo="pierde defensa a cambio de vida.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 10:
				nombreEquipo="pierde velocidad a cambio de puntería.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 11:
				nombreEquipo="pierde puntería a cambio de velocidad.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 12:
				nombreEquipo="pierde crítico a cambio de puntería.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 13:
				nombreEquipo="pierde puntería a cambio de crítico.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 14:
				nombreEquipo="pierde crítico a cambio de velocidad.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;
			case 15:
				nombreEquipo="pierde velocidad a cambio de crítico.";
				equipoElegidoDescartado=preguntarPasiva(p, opcionAleatoria, equipoElegidoDescartado, maximoDescarte, nombreEquipo);	
				break;

			}
			
		}
		p.actualizarAtributos();
	}
	
	public static int[] preguntarPasiva(Personaje p, int opcionAleatoria, int[] equipoElegidoDescartado, int maximoDescarte, String nombreEquipo) {
		if (utils.leerCharEspecifico("Quieres un "+ nombreEquipo +"? [s]/[n] (Elegidos :" + equipoElegidoDescartado[0]//que no pregunte si ya no puede descartar mas
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
