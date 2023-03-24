package proyecto2.models.movimientos;

import proyecto2.models.Modificador;
import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class Ataque3 extends MovimientoBase implements Realizable{
	/**
	 * 
	 * Este constructor nos encarga de mostrar el nombre de Ataque, con una corta descripcion de lo que hace nuestro ataque
	 * el nivel de ataque  y que nuestro ataque se encarga de quitar vida a diferencia del Buff que no nos quita vida.
	 * 
	 */
	public Ataque3() {
		super("Puñalada mortal", "Te mueves  lanza hacia el oponente como un boron hasta ponerte a su espalda y le clavas"
				+ "la daga hasta la empuñadura con un movimiento preciso y rapido", 10, "ataque");
		
	}
	/**
	 * @param Personaje Activo y Personaje Pasivo
	 * 
	 * Este metodo se encarga de quitarle vida al jugador Pasivo
	 * 
	 */
	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		pasivo.setVidaActual(pasivo.getVidaActual().getValorBase()-20);
		/**supuesto ataque estilo veneno, quita 10 de vida el primer turno, 
		 * 10+5 el segundo y 10+5+5 el tercero*/
		pasivo.getVidaActual().addModificadorLineal(new Modificador(-10,3,"",5));

	}

}