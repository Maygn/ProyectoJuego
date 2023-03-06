package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff5 extends MovimientoBase implements Realizable{

	public Buff5() {//jode def enemigo
		super("Maldicion elemental", "Recurres al poder de los elementos de la naturaleza para maldecir a tu oponente. "
				+ "Viento, arena, niebla o el sol le ciegan. ¡Aprovecha este momento para que no vea venir tu ataque!"
				, 40, "buff");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		
	}

}