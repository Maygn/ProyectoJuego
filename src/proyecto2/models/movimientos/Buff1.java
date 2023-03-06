package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff1 extends MovimientoBase implements Realizable{

	public Buff1() {//baja velocidad
		super("Congelacion", "Desatas una tormenta congelante que deja al objetivo temblando y adormecido. "
				+ "La ráfaga helada rodea al objetivo, congelando todo a su paso. Tu enemigo está cubierto de escarcha"
				+ " y parece que le cuesta moverse"
				, 40, "buff");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		activo.getAtaque().addModificadorPorcentual(new Modificador(0.3,99,"",0));
		
	}

}