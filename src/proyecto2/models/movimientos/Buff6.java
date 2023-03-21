package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff6 extends MovimientoBase implements Realizable{
	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de movimiento, con una corta descripcion de lo que hace nuestro movimiento
	 *  y si nu8estro movimiento nos afecta a nosotros o al enemigo
	 *   
	 */
	public Buff6() {//mejora def
		super("Resistencia de hierro", "un brillante escudo plateado te envuelve, emitiendo un zumbido metálico profundo "
				+ "que resuena en el aire. El escudo tiene un aspecto resistente e industrial, "
				+ "con remaches y pernos que lo mantienen unido."
				, 60, "buff");
		
	}
	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de modificar al Personaje Activo
	 * 
	 */
	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		activo.getDefensa().addModificadorPorcentual(new Modificador(1.5,1,"",0));

		
	}

}