package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff4 extends MovimientoBase implements Realizable{

	public Buff4() {//sube y baja ataque y crit respectivamente
		super("Enlace del alma", "Místicamente, consigues enlazar tu alma con la de tu oponente. "
				+ "Ves como se forma una línea en el aire que os une y por la que viaja una corriente"
				+ "de energía que te fortalece mientras el enemigo parece cada vez mas débil"
				, 40, "buff");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		
	}

}