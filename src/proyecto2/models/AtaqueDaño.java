package proyecto2.models;

import proyecto2.models.Personaje;

public class AtaqueDaño extends MovimientoBase implements Realizable{

    public AtaqueDaño(String nombre, String descripcion, double velocidadBase, String tipo) {
        super(nombre, descripcion, velocidadBase, tipo);
    }

	@Override
	public void realizar(Personaje activo, Personaje pasivo) {
		// TODO Esbozo de método generado automáticamente
		
	}
	
	AtaqueDaño AtaqueRayo = new AtaqueDaño ( "Ataque Rayo","Ataque to pepino que te deja como el pescaito del lunes de feria" , 0, "Electrico");
	
	AtaqueDaño Avalancha = new AtaqueDaño ("Avalancha", "vas andando y pum, comenzo la guerra, se te cae encima una piedra to gorda", 0, "Tierra");
	
	AtaqueDaño Salpicadura = new AtaqueDaño ("Salpicadura", "la malvada reina May, te lanzo un echizo y ahora eres un simple magikart mas", 0, "Agua");
	
	AtaqueDaño Lenguetazo = new AtaqueDaño ("Lenguetazo", "Tienes complejo de peluquero y de vaca, te gusta peinar a la gente", 0, "Asco");
	
	AtaqueDaño Embestida = new AtaqueDaño ("Embestida", "Un toro bravo, primo de nacho vidal te llega por detra y te parte to el *", 0, "Campo");
	
	AtaqueDaño Tormenta = new AtaqueDaño ("Tormenta", "te llega la tia de los x-men y te deja como un salmon de noruega en invierno, to pingüino", 0, "Agua");

}
