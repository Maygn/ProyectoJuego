package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff5 extends MovimientoBase implements Realizable{
	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de movimiento, con una corta descripcion de lo que hace nuestro movimiento
	 *  y si nu8estro movimiento nos afecta a nosotros o al enemigo
	 *   
	 */
	public Buff5() {//jode def enemigo
		super("Maldicion elemental", "Recurres al poder de los elementos de la naturaleza para maldecir a tu oponente. "
				+ "Viento, arena, niebla o el sol le ciegan. ¡Aprovecha este momento para que no vea venir tu ataque!"
				, 20, "buff");
		
	}
	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de modificar al Personaje Activo
	 * 
	 */
	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.getDefensa().addModificadorPorcentual(new Modificador(0.2,2,"",0));

		
	}

}