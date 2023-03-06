package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff10 extends MovimientoBase implements Realizable{

	public Buff10() {//incremento punteria
		super("Concentración extrema", "Abres los ojos de par en par al asombrarte mientras el mundo a su alrededor se ralentiza. "
				+ "Puedes ver cada movimiento que hacen sus enemigos con una precisión increíble. Tu arma parece convertirse "
				+ "en una extensión de tu brazo golpeando a tus enemigos con una precisión infalible"
				, 40, "buff");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		
	}

}