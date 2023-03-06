package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff9 extends MovimientoBase implements Realizable{

	public Buff9() {//aumento crit
		super("Carga mortal", "Estrechas tus ojos, fijos en tu enemigo, mientras te abalanzas hacia la batalla. "
				+ "Cada golpe tiene una precisión y fuerza incomparables. Pareces anticipar cada movimiento de "
				+ "tus enemigos. El aire zumba con el sonido de tu arma cortando el aire."
				, 40, "buff");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		
	}

} 