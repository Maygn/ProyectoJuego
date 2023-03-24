package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque10 extends MovimientoBase implements Realizable{

	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de Ataque, con una corta descripcion de lo que hace nuestro ataque
	 * el nivel de ataque  y que nuestro ataque se encarga de quitar vida a diferencia del Buff que no nos quita vida.
	 * 
	 */
	
	public Ataque10() {
		super("Colmillo vampirico", "Liberas tus colmillos y clavándolos profundamente en la carne del enemigo. "
				+ "Notas como la fuerza vital succionada te hace sentir más fuerte mientras "
				+ "el enemigo se retuerce para huir del toque helado de la muerte.",
				-10, "ataque");
		
	}
	
	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de quitarle vida al jugador Pasivo
	 * 
	 */

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-40);
		activo.setVidaActual(activo.getVidaActual().getValorBase()+40);
	}

}



