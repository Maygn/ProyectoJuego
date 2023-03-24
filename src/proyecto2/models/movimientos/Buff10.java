package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff10 extends MovimientoBase implements Realizable{

	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de movimiento, con una corta descripcion de lo que hace nuestro movimiento
	 *  y si nu8estro movimiento nos afecta a nosotros o al enemigo
	 *   
	 */
	public Buff10() {//incremento punteria
		super("Concentracion extrema", "Abres los ojos de par en par al asombrarte mientras el mundo a su alrededor se ralentiza. "
				+ "Puedes ver cada movimiento que hacen sus enemigos con una precisión increible. Tu arma parece convertirse "
				+ "en una extension de tu brazo golpeando a tus enemigos con una precisión infalible"
				, 40, "buff");
		
	}
	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de modificar al Personaje Activo
	 * 
	 */
	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		activo.getPunteria().addModificadorPorcentual(new Modificador(1.5,2,"",0));

		
	}

}