package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff3 extends MovimientoBase implements Realizable{

	public Buff3() {//cura
		super("Colibrí de vida", "En un movimiento de tu mano, aparece un pequeño pájaro hecho de pura energía verde. "
				+ "Vuela hasta tu cabeza y se posa entre tu pelo, haciendo que de repente dejes de sentir dolor"
				+ "y que te sientas lleno de energía"
				, 40, "buff");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		activo.setVidaActual(activo.getVidaActual().getValorBase()+30);
		
	}

}