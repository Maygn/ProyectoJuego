package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque5 extends MovimientoBase implements Realizable{

	public Ataque5() {
		super("Mordisco Salvaje", "El personaje salta sobre el oponente y le muerde ferozmente, con sus afilados dientes"
				+ " hundiéndose en su piel y desgarrando sus músculos.", 40, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		
	}

}