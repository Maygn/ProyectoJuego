package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque10 extends MovimientoBase implements Realizable{

	public Ataque10() {
		super("Colmillo vampírico", "Liberas tus colmillos y clavándolos profundamente en la carne del enemigo. "
				+ "Notas como la fuerza vital succionada te hace sentir más fuerte mientras "
				+ "el enemigo se retuerce para huir del toque helado de la muerte.",
				-10, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-40);
		activo.setVidaActual(activo.getVidaActual().getValorBase()+40);
	}

}



