package proyecto2.controllers;

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
		if (!p.isVivo()) {
			throw new Exception("No se puede equipar un personaje muerto/no creado.");
		}
		AleatorioDescartando<Integer> i1=new AleatorioDescartando<>(1,3);

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

			}
			
			System.out.println(p.toString());
		}
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

}
