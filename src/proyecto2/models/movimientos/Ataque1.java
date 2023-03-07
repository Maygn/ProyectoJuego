package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque1 extends MovimientoBase implements Realizable{

	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de Ataque, con una corta descripcion de lo que hace nuestro ataque
	 * el nivel de ataque  y que nuestro ataque se encarga de quitar vida a diferencia del Buff que no nos quita vida.
	 * 
	 */
	public Ataque1() {
		super("Golpe aplastante", "Reunes tu fuerza y, con un gran salto,golpeas al enemigo con tal fuerza "
				+ "que hace temblar el suelo y que aparezcan grietas bajo sus pies "
				, 30, "ataque");
		
	}

	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de quitarle vida al jugador Pasivo
	 * 
	 */
	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-30);
		
	}

}
