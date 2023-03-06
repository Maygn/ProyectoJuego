package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque9 extends MovimientoBase implements Realizable{

	public Ataque9() {
		super("Vórtice de tierra", "Liberas el poder de la naturaleza creando un poderoso "
				+ "torbellino de rocas y tierra, que absorbe y destruye todo a su paso"
				, 00, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-50);
		
	}

}