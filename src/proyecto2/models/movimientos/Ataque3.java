package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque3 extends MovimientoBase implements Realizable{

	public Ataque3() {
		super("Puñalada mortal", "Te mueves  lanza hacia el oponente como un borrón hasta ponerte a su espalda y le clavas"
				+ "la daga hasta la empuñadura con un movimiento preciso y rápido", 40, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		
	}

}