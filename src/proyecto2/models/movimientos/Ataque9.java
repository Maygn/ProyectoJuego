package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque9 extends MovimientoBase implements Realizable{
	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de Ataque, con una corta descripcion de lo que hace nuestro ataque
	 * el nivel de ataque  y que nuestro ataque se encarga de quitar vida a diferencia del Buff que no nos quita vida.
	 * 
	 */
	public Ataque9() {
		super("Vortice de tierra", "Liberas el poder de la naturaleza creando un poderoso "
				+ "torbellino de rocas y tierra, que absorbe y destruye todo a su paso"
				, 00, "ataque");
		
	}
	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de quitarle vida al jugador Pasivo
	 * 
	 */
	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-50);
		
	}

}