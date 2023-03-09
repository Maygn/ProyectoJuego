package proyecto2.models;

import proyecto2.models.Personaje;

public class AtaqueDefensa extends MovimientoBase implements Realizable{

    public AtaqueDefensa(String nombre, String descripcion, double velocidadBase, String tipo) {
        super(nombre, descripcion, velocidadBase, tipo);
    }

    @Override
    public void realizar(Personaje activo, Personaje pasivo) {
        pasivo.recibirDaño(50);
        
    }
    
    AtaqueDefensa SetaAlucinogena = new AtaqueDefensa ( "Seta Alucinogena","Si te la comes visitas a lo alliens y si se la tiras a tu rival vienen ellos" , 0, "Veneno");

    AtaqueDefensa TeDeRosas = new AtaqueDefensa ("té de Rosas", "Un rico té que restablece puntos de salud, pero mientras que lo preparas y no te pueden matar, pero pareceras la priamguapa de la reina de inglaterra", 0, "Salud");
    
    AtaqueDefensa Enredaderas = new AtaqueDefensa ("Enredaderas", "Ataque super poderoso que no hace nada, solo atrapa a tus enemigos, si no quieres pelear puedes aprovachar para salir por patas", 0, "Debuffo");
    
    AtaqueDefensa RedBull = new AtaqueDefensa ("RedBull", "Te pone to cheto para la pelea por eso se llama redBull", 0, "+Ataque");

    AtaqueDefensa Bloqueo = new AtaqueDefensa ("Bloqueo", "Si necesitas que te explique lo que hace este movimiento mejor vuelve a jugar pokemon", 0, "Defensa");
    
    AtaqueDefensa Espejo = new AtaqueDefensa ("Espejo", "Pues eso, generas un espejo y le revota el atauqe al enemigo, no hay mucho que explicar lumbreras", 0, "Defensa");
    
    
}
