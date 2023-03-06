package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque2 extends MovimientoBase implements Realizable{

	public Ataque2() {
		super("Tormenta de hielo", "desata una tempestad de vientos helados y "
				+ "lanzas de hielo que se arremolinan alrededor del enemigo, "
				+ "congelando su piel y enfriando sus huesos hasta la médula.",
				10, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-50);
		
	}

}