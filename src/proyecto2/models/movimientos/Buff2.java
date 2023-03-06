package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff2 extends MovimientoBase implements Realizable{

	public Buff2() {//baja atk y punteria
		super("Niebla mental", "Envuelves la mente del objetivo en una densa niebla, haciéndolo tambalearse y"
				+ " perder la concentración. ¡Parece haber olvidado hasta su propio nombre."
				, 20, "buff");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.getAtaque().addModificadorLineal(new Modificador(-30,2,"",0));
		pasivo.getPunteria().addModificadorPorcentual(new Modificador(0.3,2,"",0));


		
	}

}