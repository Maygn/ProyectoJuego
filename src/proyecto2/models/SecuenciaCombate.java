package proyecto2.models;

import proyecto2.utilities.utils;

public class SecuenciaCombate {
	
	public static void elegirMovimiento(Personaje p1) {
		String mov1=p1.getMov1().getNombre().toString();
		String mov2=p1.getMov2().getNombre().toString();
		String mov3=p1.getMov3().getNombre().toString();
		String mov4=p1.getMov4().getNombre().toString();
		System.out.println("Tus movimientos disponibles son: " + mov1 +"\n "
				+ mov2 +"\n"+mov3+ "\n" +mov4);
		
		switch (utils.leerDatoEntero("Cual de los ataques quieres usar? ", 1, 4)) {
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
		
		
	}
	
}
