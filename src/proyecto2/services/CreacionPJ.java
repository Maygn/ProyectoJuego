package proyecto2.services;

import proyecto2.models.Personaje;
import proyecto2.utilities.utils;

public class CreacionPJ {

	/**
	 * @param Personaje p
	 * Coge un objeto personaje vacío y setea los atributos que van a ser fijos (variables, no otros objetos)*/
	public static void datosFijos(Personaje p) {
		System.out.println("Vamos a crear un personaje");
		String nombrePj="";
		boolean fuera=false;
		
		while(!fuera) {
			nombrePj=utils.pedirString("Como quieres que se llame tu personaje?");
			if(p.getNombresUsados().contains(nombrePj)) {
				System.out.println("Ese nombre ya lo has usado.");
			}
			else {
				fuera=true;
			}
		}
		
		
		p.setNombre(nombrePj);
		p.getNombresUsados().add(nombrePj);
		
		p.setDescripcion(utils.pedirString("Describe tu especie, profesion o lo que quieras"));
	}
	/**
	 * @param Personaje p
	 * Sobre los valores básicos por defecto para las caracteristicas de personajes,
	 * el método te ofrece una serie de opciones binarias para elegir que caracteristicas
	 * quieres potenciar*/
	public static void datosVariables(Personaje p) {
		
		if(utils.leerCharEspecifico("que prefieres, [a]taque o [d]ef", new char[] {'a','d'})=='a') {
			p.getAtaque().setValorBase(p.getAtaque().getValorBase() + 100);
		}
		else {	p.getDefensa().setValorBase(p.getDefensa().getValorBase() + 100);}
		
		if(utils.leerCharEspecifico("que prefieres, [v]elocidad o [c]orpulencia", new char[] {'v','c'})=='v') {
			p.getVelocidad().setValorBase(p.getVelocidad().getValorBase() + 100);
		}
		else {	p.getVidaMaxima().setValorBase(p.getVidaMaxima().getValorBase() + 100);}
		
		if(utils.leerCharEspecifico("que prefieres, [p]unteria o [c]ritico", new char[] {'p','c'})=='p') {
			p.getPunteria().setValorBase(p.getPunteria().getValorBase() + 100);
		}
		else {	p.getCritico().setValorBase(p.getCritico().getValorBase() + 100);}
		
		p.actualizarAtributos();
	}
	/**@oaram Personaje p
	 * Solo llama al método que pone el equipo y asegura las excepciones posibles*/
	public static void ponerEquipo(Personaje p)  {
		try {
			AplicadorEquipo.equipar(p);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	/**@oaram Personaje p
	 * Solo llama al método que permite elegir movimientos y asegura las excepciones posibles*/
	public static void elegirMovimientos(Personaje p) {
		try {
			AplicadorMovimientos.darEleccion(p);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	//Solo es la secuencia de métodos de esta clase para llamarla desde el main con uno solo.
	public static void creacionEnSerie(Personaje p) {
		datosFijos(p);
		datosVariables(p);
		ponerEquipo(p);
		elegirMovimientos(p);
		p.setVivo(true);// ESTA VIVOOOOOOO. Es el último paso y lo usamos de control para que no sea posible lanzar al juego
						//personajes que no estén correctamente creados
	}
	

}
