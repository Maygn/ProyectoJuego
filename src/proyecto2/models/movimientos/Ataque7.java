package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque7 extends MovimientoBase implements Realizable{

	public Ataque7() {
		super("Flercha venenosa", "Lanzas una flecha verde oscuro "
				+ "con punta enormemente afilada que deja a su paso una estela de neblina "
				+ "morada conforme atraviesa el aire"
				, 40, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		
	}

}