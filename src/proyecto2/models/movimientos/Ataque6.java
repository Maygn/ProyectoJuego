package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque6 extends MovimientoBase implements Realizable{

	public Ataque6() {
		super("Tormenta de arena", "Convocas una poderosa ráfaga de viento que mueve la"
				+ " arena, que se levanta desde el suelo, envolviendo al oponente en una "
				+ "nube de polvo.", 30, "ataque");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		pasivo.getPunteria().addModificadorLineal(new Modificador(-10,1,"",0));
		
	}

}