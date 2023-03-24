package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Buff8 extends MovimientoBase implements Realizable{
	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de movimiento, con una corta descripcion de lo que hace nuestro movimiento
	 *  y si nu8estro movimiento nos afecta a nosotros o al enemigo
	 *   
	 */
	public Buff8() {//mejora crit y atk
		super("Ira berserker", "Tus musculos se hinchan con una fuerza increible, y tus ojos arden con un intenso resplandor "
				+ "de fuego. Pareces un animal salvaje, con colmillos y garras, listo para destrozar cualquier "
				+ "cosa que se cruce en tu camino"
				, 00, "buff");
		
	}
	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de modificar al Personaje Activo
	 * 
	 */
	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		activo.getAtaque().addModificadorLineal(new Modificador(40,1,"",0));
		activo.getCritico().addModificadorPorcentual(new Modificador(1.4,1,"",0));


		
	}

}