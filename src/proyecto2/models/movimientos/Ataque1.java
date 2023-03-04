package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque1 extends MovimientoBase implements Realizable{

	public Ataque1() {
		super("Golpe aplastante", "Reunes tu fuerza y, con un gran salto,golpeas al enemigo con tal fuerza "
				+ "que hace temblar el suelo y que aparezcan grietas bajo sus pies "
				, 20, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-30);
		
	}

}
