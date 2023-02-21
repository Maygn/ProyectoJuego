package proyecto2.controllers;

import proyecto2.models.Personaje;
import proyecto2.utilities.utils;

public class AplicadorEquipo {
	public static void equipar(Personaje p) throws Exception {

		int opcionAleatoria = 0;
		int equipoElegido = 0;
		int equipoDescartado = 0;
		final int MAXEQUIPO = 1;
		int maximoDescarte = 1;

		// Clausulas escudo
		if (!p.isVivo()) {
			throw new Exception("No se puede equipar un personaje muerto/no creado.");
		}

		while (equipoElegido < MAXEQUIPO) {
			opcionAleatoria = utils.aleatorio(1, 3); // Habria que hacer un metodo de UTILS (o no) que te de aleatorios sin repetir

			switch (opcionAleatoria) {
			case 1:
				if (utils.leerCharEspecifico("Quieres un aumento de ataque? [s]/[n] (Elegidos :" + equipoElegido//que no pregunte si ya no puede descartar mas
						+ " ,descartados: " + equipoDescartado, new char[] { 'S', 'N' }) == 'S') {
					aumentarAtaque(p);
					equipoElegido++;
				} else {
					equipoDescartado++;
				}
				break;
			case 2:
				aumentarDefensa(p);
				break;

			case 3:
				duplicarVida(p);
				break;

			}
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
