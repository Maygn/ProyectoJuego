package proyecto2.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import proyecto2.utilities.AleatorioDescartando;
import proyecto2.utilities.GuardaPersonajes;

public class ModoHistoria {

ArrayList<Personaje> listaNPCS = new ArrayList<>();

public void modoHistoria() {
	
	
	try {
		listaNPCS=GuardaPersonajes.cargarPNJS("/baulNPCS");
	} catch (ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}

}
