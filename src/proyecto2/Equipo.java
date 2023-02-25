package proyecto2;

import proyecto2.models.Personaje;

public class Equipo {

		public void aplicarEquipo(Personaje p1){
			int random = (int)(Math.random()*10+1);
			 
			switch(random){
			case 1:
				p1.getAtaque().setValorBase(p1.getAtaque().getValorBase()+190);
				break;
			case 2:
				p1.defensa=p1.defensa-10;
				p1.ataque+=20;
				break;
			case 3:
				p1.ataque=p1.ataque+5;
				p1.defensa=p1.defensa-3;
				p1.velocidad=p1.velocidad+50;
				p1.punteria=p1.punteria+78;
				break;
			case 4:
				p1.ataque=p1.ataque+10;
				p1.defensa=p1.defensa-2;
				p1.velocidad=p1.velocidad+70;
				p1.punteria=p1.punteria+58;
				break;
				
			case 5:
				p1.ataque=p1.ataque+9;
				p1.defensa=p1.defensa-3;
				p1.velocidad=p1.velocidad+90;
				p1.punteria=p1.punteria+98;	
				break;
				
			case 6:
				p1.ataque=p1.ataque+2;
				p1.defensa=p1.defensa-6;
				p1.velocidad=p1.velocidad+40;
				p1.punteria=p1.punteria+90;	
				break;
				
			case 7:
				p1.ataque=p1.ataque+5;
				p1.defensa=p1.defensa-5;
				p1.velocidad=p1.velocidad+30;
				p1.punteria=p1.punteria+48;	
				break;
				
			case 8:
				p1.ataque=p1.ataque+4;
				p1.defensa=p1.defensa-1;
				p1.velocidad=p1.velocidad+10;
				p1.punteria=p1.punteria+38;	
				break;
			
			case 9:
				p1.ataque=p1.ataque+6;
				p1.defensa=p1.defensa-3;
				p1.velocidad=p1.velocidad+60;
				p1.punteria=p1.punteria+68;	
				break;
				
			case 10:
				p1.ataque=p1.ataque+10;
				p1.defensa=p1.defensa-2;
				p1.velocidad=p1.velocidad+100;
				p1.punteria=p1.punteria+98;	
				break;
			}
			
	    }
}

