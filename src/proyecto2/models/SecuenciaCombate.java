package proyecto2.models;

import java.io.Console;

import proyecto2.utilities.utils;

public class SecuenciaCombate {
	
	//TODO: Comprobar si ambos personajes estan vivos (Muy probablemente desde los llamadores)
	
	
	/**@param Personaje p1
	 * Te informa del nombre de los ataques que puedes elegir, te permite elegir uno
	 * y lo almacena en el "movimientoElegido" del personaje*/
	public static void elegirMovimiento(Personaje p1) {
		String mov1=p1.getMov1().getNombre().toString();
		String mov2=p1.getMov2().getNombre().toString();
		String mov3=p1.getMov3().getNombre().toString();
		String mov4=p1.getMov4().getNombre().toString();
		System.out.println("Tus movimientos disponibles son: 1-" + mov1 +"\n 2-"
				+ mov2 +"\n 3-"+mov3+ "\n 4-" +mov4);
		
		
//		CAMBIAR UNA VEZ TERMINEMOS Y SE VAYA A COMPILAR
//		LA CONSOLA DE ECLIPSE NO TOLERA System.console()
		
//		Console cs1=System.console(); //Define la consola actual
//		boolean fuera=false;
//		int elegido=0;
//		
//		while(!fuera) {
//			char[] arr1=cs1.readPassword("Cual de los ataques quieres usar?"); //Usa la consola para leer el movimiento, sin mostrar lo que escribe el usuario
//			elegido=Character.getNumericValue(arr1[0]); // Lo convierte en valor numérico.
//			
//			if(elegido>0 && elegido <5) {
//				fuera=true;
//			}
//			else {
//				System.out.println("Ese número no es uno de tus cuatro movimientos. ");
//				System.out.println("Tus movimientos disponibles son: 1-" + mov1 +"\n 2-"
//						+ mov2 +"\n 3-"+mov3+ "\n 4-" +mov4);
//			}
//		}
		
        
        
		
		switch (utils.leerDatoEntero("Elige el movimiento", 1, 4)) { //CAMBIAR POR elegido CUANDO SE COMPILE
		case 1:
			p1.setMovElegido(p1.getMov1());
			break;
		case 2:
			p1.setMovElegido(p1.getMov2());
			break;
		case 3:
			p1.setMovElegido(p1.getMov3());
			break;
		case 4:
			p1.setMovElegido(p1.getMov4());
			break;
		}
	}
/**@param Personaje p1
 * @param Personaje p2
 * El método calcula la velocidad a la que sale el ataque elegido por cada jugador, en base a eso
 * realiza los ataques en el orden que corresponda*/
	public static void hacerAtaques(Personaje p1, Personaje p2) {
		
		double velocidadTotalP1=p1.getVelocidad().getValorFinal()+p1.getMovElegido().getVelocidadBase();
		double velocidadTotalP2=p2.getVelocidad().getValorFinal()+p1.getMovElegido().getVelocidadBase();
	
		if(velocidadTotalP1>velocidadTotalP2) {
				p1.getMovElegido().realizar(p1,p2);
				p2.getMovElegido().realizar(p2,p1);
		}else {
			p2.getMovElegido().realizar(p2,p1);
			p1.getMovElegido().realizar(p1,p2);
		}
		
	}
	
	public static void comprobarCosas(Personaje p1, Personaje p2) {
		//Actualizar atributos
		//Bajar tickeos
		//Comprobar muerte y victoria
		//Añadir a lista de derrotados si el Jugador no es NPC
		
	}
	
}
