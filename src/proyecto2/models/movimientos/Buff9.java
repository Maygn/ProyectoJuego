package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff9 extends MovimientoBase implements Realizable{
	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de movimiento, con una corta descripcion de lo que hace nuestro movimiento
	 *  y si nu8estro movimiento nos afecta a nosotros o al enemigo
	 *   
	 */
	public Buff9() {//aumento crit
		super("Carga mortal", "Estrechas tus ojos, fijos en tu enemigo, mientras te abalanzas hacia la batalla. "
				+ "Cada golpe tiene una precisión y fuerza incomparables. Pareces anticipar cada movimiento de "
				+ "tus enemigos. El aire zumba con el sonido de tu arma cortando el aire."
				, 30, "buff");
		
	}
	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de modificar al Personaje Activo
	 * 
	 */
	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		activo.getCritico().addModificadorPorcentual(new Modificador(1.4,1,"",0));
		
	}

} 