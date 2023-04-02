package proyecto2.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import proyecto2.models.Personaje;
import proyecto2.utilities.AleatorioDescartando;
import proyecto2.utilities.GuardaPersonajes;

public class ModoHistoria {

	static ArrayList<Personaje> listaNPCS = new ArrayList<>();
/**
 * @param PErsonaje p1
 * Se llena un arraylist con los objetos personaje que hay en la carpeta baulNPCS, se hace que aparezcan todos ellos
 * en orden aleatorio sin repetirse, y se repite la secuencia de combate hasta que el personaje jugador muere
 * o vence a todos los npc*/
	public static void modoHistoria(Personaje p1) throws Exception {

		try {
			listaNPCS = GuardaPersonajes.cargarPNJS("/baulNPCS");
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("El baul está vacio o corrupto. Contacta con tu administrador.");
			e.printStackTrace();
		}

		AleatorioDescartando<Personaje> a1 = new AleatorioDescartando<Personaje>(listaNPCS);

		for (int i = 0; i < Math.min(listaNPCS.size(), 10); i++) {
			if (p1.isVivo()) {
				System.out.println("Empieza tu combate número " + i + "!!!");
				SecuenciaCombate.cicloCombate(p1, a1.darAleatorio(),true);
			} else {
				System.out.println("Lo siento, tu personaje ha muerto en su misión.");
				i = 100; // Salir del bucle.
			}
		}

		if (p1.isVivo()) {
			System.out.println("FELICIDADES! Has batido el modo historia.");
		}

	}

}
