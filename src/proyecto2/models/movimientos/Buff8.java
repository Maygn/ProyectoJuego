package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff8 extends MovimientoBase implements Realizable{

	public Buff8() {//mejora crit y atk
		super("Ira berserker", "Tus músculos se hinchan con una fuerza increíble, y tus ojos arden con un intenso resplandor "
				+ "de fuego. Pareces un animal salvaje, con colmillos y garras, listo para destrozar cualquier "
				+ "cosa que se cruce en tu camino"
				, 00, "buff");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		activo.getAtaque().addModificadorLineal(new Modificador(40,1,"",0));
		activo.getCritico().addModificadorPorcentual(new Modificador(1.4,1,"",0));


		
	}

}