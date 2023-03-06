package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque4 extends MovimientoBase implements Realizable{

	public Ataque4() {
		super("Patada voladora", "carga y salta en el aire, propinando una patada"
				+ " devastadora que envía ondas de choque a través del suelo. Al "
				+ "aterrizar, una ráfaga de energía explota desde sus pies, "
				+ "dejando un rastro de energía brillante a su paso.",
				40, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-30);
		
	}

}