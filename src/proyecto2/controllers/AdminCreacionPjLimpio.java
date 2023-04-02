package proyecto2.controllers;

import java.io.IOException;

import proyecto2.models.Personaje;
import proyecto2.services.CreacionPJ;
import proyecto2.utilities.GuardaPersonajes;
import proyecto2.utilities.utils;

public class AdminCreacionPjLimpio {
	public static void main(String[] args) {
		// eleccion 
		char[] opcs = { 'p', 'n' };
		switch (utils.leerCharEspecifico("Crear un [P]J o un [N]PC?", opcs)) {
		case 'P':
			crearPc();
			break;
		case 'N':
			crearNpc();
			break;
		}

	}
	//personaje de jugador, solo hacer el archivo en la carpeta correspondiente y almacenar el nombre
	private static void crearPc() {
		Personaje p1 = new Personaje();
		p1.setJugador(utils.pedirString("Nombre del jugador"));

		try {
			GuardaPersonajes.guardar(p1, "baulPersonajes");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("CREADO!");
	}
	// personaje no jugador, crea archivo en su carpeta y usa la secuencia de creacion misma que
	//usan los jugadores.
	private static void crearNpc() {
		Personaje p1 = new Personaje();
		p1.setJugador("NPC");
		
		CreacionPJ.creacionEnSerie(p1);
		p1.getVidaMaxima().setValorBase(p1.getVidaMaxima().getValorBase()/3);
		p1.actualizarAtributos();

		try {
			GuardaPersonajes.guardarPNJ(p1, "baulNPC");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("CREADO!");
	}

}
