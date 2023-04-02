							package proyecto2.controllers;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import proyecto2.models.Atributo;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;
import proyecto2.services.AplicadorEquipo;
import proyecto2.services.CreacionPJ;
import proyecto2.services.ModoHistoria;
import proyecto2.services.ModoPvp;
import proyecto2.services.SecuenciaCombate;
import proyecto2.utilities.AleatorioDescartando;
import proyecto2.utilities.GuardaPersonajes;
import proyecto2.utilities.utils;


public class App {
    public static void main(String[] args) throws Exception {
    	boolean salir=false;
    	
    	Personaje p1=null;

    	
    	try {
			p1=comprobarPersonaje();
		} catch (ClassNotFoundException e) {
			salir=true;
			System.out.println("Tu personaje está corrupto. Pídele al administrador un nuevo personaje.");
		} catch (IOException e) {
			salir=true;
			System.out.println("No tienes un personaje válido, pon tu personaje en la carpeta 'personaje'.");
		}
    	
    	
    	if(!salir) {
    		menuPrincipal(p1);
    		
    		
    		
    	}
    	
        
        

    }
    
    private static Personaje comprobarPersonaje() throws ClassNotFoundException, IOException{
    	Personaje p1=null;
    	/*Primero intenta cargar un personaje (ya esta hecho, en un archivo con su boolean vivo =true). Si lo encuentra, salta al menú de combate, 
    	 * si no existe ninguno que esté vivo, ya sea porque es un pj nonato o fallecido, es indiferente, te pone a crear uno*/
        
        	try {
				p1=GuardaPersonajes.cargar("personaje");
			} catch (ClassNotFoundException e1) {
				throw new ClassNotFoundException();
			} catch (IOException e1) {
				throw new IOException();
			}
		
        
        
        
        if(!p1.isVivo()) { //Potencial nullpointer
        	
        	CreacionPJ.creacionEnSerie(p1);    
        	
            try {
    			GuardaPersonajes.guardar(p1, "personaje");
    		} catch (IOException e) {
    			System.out.println("Error en el guardado.");
    			e.printStackTrace();
    		}
        }
            	
    	return p1;
    }
    /**@param Personaje p1
     * Permite ver las opciones del juego y seleccionar la que quieras. En todos los casos antes de acceder te comprueba 
     * y avisa si te has cargado algo en el sistema de archivos.*/
    private static void menuPrincipal(Personaje p1) throws Exception{
    	boolean fueraDelMenu=false;
    	while(!fueraDelMenu) {
    		System.out.println("Hola, "+ p1.getJugador() + "! Elige la opción que quieres para "+ p1.getNombre());
    		System.out.println("1- Ver los atributos de "+p1.getNombre());
    		System.out.println("2- Entrar en el coliseo, modo historia, contra la máquina.");
    		System.out.println("3- Entrar en un duelo contra otro jugador.");
    		System.out.println("4- Hacer un nuevo personaje.");
    		System.out.println("5- Salir.");
    		
    		switch(utils.leerDatoEntero("Elige la opción que deseas.", 1, 5)) {
    		case 1:
    			System.out.println(p1.toString()); 
    			break;
    		case 2:
    			
    			if(p1.isVivo()) {
    			ModoHistoria.modoHistoria(p1);
    			}
    			else {
    				System.out.println("Lo siento, tu personaje ha muerto. Crea un nuevo personaje.");
    			}
    			break;
    		case 3:
    			if(p1.isVivo()) {
    				
    				try {
						ModoPvp.combatePvp(p1);
					} catch (ClassNotFoundException | IOException e) {
						System.out.println("Asegúrate de que hay un Personaje en la carpeta 'visitante'");
					}
    			
    			}
    			else {
    				System.out.println("Lo siento, tu personaje ha muerto. Crea un nuevo personaje.");
    			}
    			break;
    		case 4:
    			if(p1.isVivo()) {
    				if(utils.pedirString("Para rehacer un personaje que no ha muerto, escribe 'estoy seguro'").equalsIgnoreCase("Estoy seguro")) {
    					p1.setVivo(false);
    					CreacionPJ.creacionEnSerie(p1);
    				}
    			}
    			else {
    				CreacionPJ.creacionEnSerie(p1);
    			}
    			break;
    		case 5:
    			fueraDelMenu=true;
    			System.out.println("Hasta pronto!");
    		
    		
    		
    		
    	}
    }
    
    
    }}
