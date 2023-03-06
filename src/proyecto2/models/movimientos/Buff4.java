package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff4 extends MovimientoBase implements Realizable{

	public Buff4() {
		super("Enlace del alma", "Místicamente, consigues enlazar tu alma con la de tu oponente. "
				+ "Ves como se forma una línea en el aire que os une y por la que viaja una corriente"
				+ "de energía que te fortalece mientras el enemigo parece cada vez mas débil"
				, 40, "buff");
		
	}

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		activo.getCritico().addModificadorPorcentual(new Modificador(1.3,1,"",0));
		pasivo.getCritico().addModificadorPorcentual(new Modificador(0.3,1,"",0));
		activo.getAtaque().addModificadorLineal(new Modificador(20,1,"",0));
		pasivo.getAtaque().addModificadorLineal(new Modificador(-20,1,"",0));

		
	}

}