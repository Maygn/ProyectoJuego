package proyecto2.controllers;

import proyecto2.models.Personaje;
import proyecto2.utilities.utils;

public class CreacionPJ {

	

	public static void datosFijos(Personaje p) {
		System.out.println("Vamos a crear un personaje");
		p.setJugador(utils.pedirString("Como te llamas?"));
		p.setNombre(utils.pedirString("Y como quieres que se llame tu personaje?"));
		p.setDescripcion(utils.pedirString("Describe tu especie, profesion o lo que quieras"));
	}
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
	}
	public static void ponerEquipo(Personaje p)  {
		try {
			AplicadorEquipo.equipar(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void elegirMovimientos(Personaje p) {
		try {
			AplicadorMovimientos.darEleccion(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
