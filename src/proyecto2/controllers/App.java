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
import proyecto2.utilities.AleatorioDescartando;
import proyecto2.utilities.GuardaPersonajes;


public class App {
    public static void main(String[] args) {
    	
    	
    	//Ejemplo de coger NPCs y mostrarlos
    	ArrayList<Personaje> npcs=null;
    	try {
			npcs=GuardaPersonajes.cargarPNJS("baulNPC");
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    	for(Personaje npc:npcs) {
    		System.out.println(npc.toString());
    	}
    	
    	
    	
    	Personaje p1=null;
    	/*Primero intenta cargar un personaje (ya esta hecho, en un archivo con su boolean vivo =true). Si lo encuentra, salta al menú de combate, 
    	 * si no existe ninguno que esté vivo, ya sea porque es un pj nonato o fallecido, es indiferente, te pone a crear uno*/
        try {
        	p1=GuardaPersonajes.cargar("personaje");
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("No tienes un personaje válido, o tu personaje está corrupto. Pídele al administrador un nuevo personaje.");
			e.printStackTrace();
		}
        
        if(!p1.isVivo()) { //Potencial nullpointer
        	CreacionPJ.creacionEnSerie(p1);
        	
        	System.out.println(p1.toString());
            
            try {
    			GuardaPersonajes.guardar(p1, "personaje");
    		} catch (IOException e) {
    			System.out.println("Error en el guardado.");
    			e.printStackTrace();
    		}
        }
        else {
        	System.out.println("Aqui va el menu de combate.");
        	System.out.println(p1.toString());
        }
        
        

    }
    
    
}
