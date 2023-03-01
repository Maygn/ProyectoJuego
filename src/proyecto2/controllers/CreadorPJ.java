package proyecto2.controllers;

import java.util.Scanner;

import proyecto2.models.Personaje;
import proyecto2.utilities.utils;

public class CreadorPJ {
public static void atributosBasicos(Personaje p1) {
	p1.setJugador(utils.pedirString("Dime tu nombre"));
	p1.setNombre(utils.pedirString("Dime el nombre de tu personaje"));
	p1.setDescripcion(utils.pedirString("Describe a tu personaje como quieras, profesion, especie..."));
	
}
public static void atributosCombate(Personaje p1) {
	
	char vida= utils.leerCharEspecifico("Que prefieres, personaje (c)orpulento y fuerte o (a)gil y rápido?",'c', 'a');
	if(vida=='a') {p1.setVelocidad(p1.getVelocidad()+10);}
	else{p1.setVidaMaxima(p1.getVidaMaxima()+30);};

	char ataque= utils.leerCharEspecifico("Que prefieres, personaje (o)fensivo  o (d)efensivo",'o', 'd');
	if(vida=='o') {p1.setAtaque(p1.getAtaque()+10);}
	else{p1.setDefensa(p1.getDefensa()+20);};

	
}

}
