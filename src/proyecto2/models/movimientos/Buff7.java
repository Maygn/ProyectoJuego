package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff7 extends MovimientoBase implements Realizable{
	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de movimiento, con una corta descripcion de lo que hace nuestro movimiento
	 *  y si nu8estro movimiento nos afecta a nosotros o al enemigo
	 *   
	 */
	public Buff7() { //mejora de def y velocidad
		super("Paso de sombra", "Te mueves a una velocidad inhumana, parece que desaparezcas de un lugar dejando una nube"
				+ "de humo en tu lugar y apareciendo unos pasos mas alla en otra nube de humo que "
				+ "permanece unos segundos crepitando con energia oscura, mientras tus ojos brillan con una siniestra luz roja."
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
		activo.getVelocidad().addModificadorLineal(new Modificador(30,1,"",0));
		activo.getDefensa().addModificadorLineal(new Modificador(30,1,"",0));


		
	}

}