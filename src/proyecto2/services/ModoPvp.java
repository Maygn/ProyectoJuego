package proyecto2.services;

import java.io.IOException;

import proyecto2.controllers.App;
import proyecto2.models.Personaje;
import proyecto2.utilities.GuardaPersonajes;

public class ModoPvp {
	/**
	 * @param Personaje p1
	 * Primero carga el personaje visitante (el local simplemente lo recibe por cabecera)
	 * Comprueba si estan vivos, realiza el ciclo de combate y avisa cuando uno muera. Guarda el resultado
	 * en los archivos de personajes */
	
	public static void combatePvp(Personaje p1) throws ClassNotFoundException, IOException {
		
		Personaje p2=GuardaPersonajes.cargar("visitante");
		
		
		if(p2.isVivo()) {
		System.out.println("Empieza el combate!");
		SecuenciaCombate.cicloCombate(p1, p2, false);
		
		if(!p1.isVivo()) {
			System.out.println(p1.getNombre() +  " ha muerto.");
			GuardaPersonajes.guardar(p1, "personaje");
		}
		
		if(!p2.isVivo()) {
			System.out.println(p2.getNombre() +  " ha muerto.");
			GuardaPersonajes.guardar(p2, "visitante");
		}
		}
		else {
			System.out.println("Asegurate de que el personaje visitante está vivo.");
		}
		
	}
	
}
