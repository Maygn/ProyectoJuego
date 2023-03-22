package proyecto2.utilities;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import proyecto2.models.Personaje;

public class GuardaPersonajes {

	public static void guardar(Personaje p, String destino) throws IOException {
		FileOutputStream guardaTexto = new FileOutputStream(new File(destino + "/personaje.pj"), false);
		ObjectOutputStream guardaObjetos = new ObjectOutputStream(guardaTexto);

		guardaObjetos.writeObject(p);
		guardaObjetos.close();
	}

	public static void guardarPNJ(Personaje p, String destino) throws IOException {
		FileOutputStream guardaTexto = new FileOutputStream(new File(destino + "/" + p.getNombre()), false);
		ObjectOutputStream guardaObjetos = new ObjectOutputStream(guardaTexto);

		guardaObjetos.writeObject(p);
		guardaObjetos.close();
	}

	public static Personaje cargar(String destino) throws ClassNotFoundException, IOException {
		FileInputStream leeTexto = new FileInputStream(new File(destino + "/personaje.pj"));
		ObjectInputStream leeObjetos = new ObjectInputStream(leeTexto);

		Personaje pr1 = (Personaje) leeObjetos.readObject();

		leeObjetos.close();
		leeTexto.close();

		return pr1;
	}

	public static ArrayList<Personaje> cargarPNJS(String destino) throws ClassNotFoundException, IOException {
		
		File carpetaPnjs=new File("baulNPC");
		File[] todosLosPnjs=carpetaPnjs.listFiles();
		ArrayList<Personaje> npcs = new ArrayList<>();
		
		if(todosLosPnjs!=null) {
			for(File pnj:todosLosPnjs) {
				FileInputStream leeTexto = new FileInputStream(pnj);
				ObjectInputStream leeObjetos = new ObjectInputStream(leeTexto);
				npcs.add((Personaje) leeObjetos.readObject());
				leeObjetos.close();
				leeTexto.close();
			}
		}
		
		return npcs;

	}
}
