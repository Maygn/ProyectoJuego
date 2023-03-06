package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque8 extends MovimientoBase implements Realizable{

	public Ataque8() {
		super("Onda psíquica", " Una ondulante ola de energía de otro mundo emana de ti, "
				+ "doblando la realidad y aplastando las mentes de tus enemigos.",
				60, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		
	}

}