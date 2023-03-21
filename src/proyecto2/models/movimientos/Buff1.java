package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff1 extends MovimientoBase implements Realizable{
	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de movimiento, con una corta descripcion de lo que hace nuestro movimiento
	 *  y si nu8estro movimiento nos afecta a nosotros o al enemigo
	 *   
	 */
	public Buff1() {//baja velocidad
		super("Congelación", "Desatas una tormenta congelante que deja al objetivo temblando y adormecido. "
				+ "La ráfaga helada rodea al objetivo, congelando todo a su paso. Tu enemigo está cubierto de escarcha"
				+ " y parece que le cuesta moverse"
				, 0, "buff");
		
	}
	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de modificar al Personaje pasivo, al personaje pasivo o a ambos.
	 * 
	 */
	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.getVelocidad().addModificadorPorcentual(new Modificador(0.3,2,"",0));
		
	}

}