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
/**
 * @param Personaje p
 * @param String destino
 * Primero genera un archivo en la carpeta indicada (Destino) llamado personaje.pj (la extension
 * no sirve para nada, pero queda chula). El false indica que no añada el contenido al final, sino
 * que sobreescriba.
 * Después mete el contenido del personaje dentro del archivo que ha creado.*/
	public static void guardar(Personaje p, String destino) throws IOException {
		FileOutputStream guardaTexto = new FileOutputStream(new File(destino + "/personaje.pj"), false);
		ObjectOutputStream guardaObjetos = new ObjectOutputStream(guardaTexto);

		guardaObjetos.writeObject(p);
		guardaObjetos.close();
	}
/**
 * @param Personaje p
 * @param String destino
 * Funciona exactamente igual que el anterior pero automatizamos que les ponga diferente nombre a los
 * archivos. Esto es porque solo queremos un personaje jugable (si siempre le pone el mismo nombre al
 * archivo no va a poder crear varios) pero en el caso de pnj necesito poner un archivo para cada uno 
 * en la misma carpeta*/
	public static void guardarPNJ(Personaje p, String destino) throws IOException {
		FileOutputStream guardaTexto = new FileOutputStream(new File(destino + "/" + p.getNombre()), false);
		ObjectOutputStream guardaObjetos = new ObjectOutputStream(guardaTexto);

		guardaObjetos.writeObject(p);
		guardaObjetos.close();
	}
/**
 * @param String destino
 * @return personaje pr1
 * coge el archivo del personaje jugable de la carpeta y lee el personaje, luego returna el
 * personaje como objeto*/
	public static Personaje cargar(String destino) throws ClassNotFoundException, IOException {
		FileInputStream leeTexto = new FileInputStream(new File(destino + "/personaje.pj"));
		ObjectInputStream leeObjetos = new ObjectInputStream(leeTexto);

		Personaje pr1 = (Personaje) leeObjetos.readObject();

		leeObjetos.close();
		leeTexto.close();

		return pr1;
	}
/**
 * @param String destino
 * @return ArrayList<Personaje> npcs
 * Coge uno por uno los archivos de los npc que están en la carpeta de los npc, lee los objetos
 * y crea un arraylist de objetos personaje con todos los npc */
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
