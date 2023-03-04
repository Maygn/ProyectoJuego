package proyecto2.models.movimientos;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;

public class AtaqueEjemplo extends MovimientoBase implements Realizable{

    public AtaqueEjemplo(String nombre, String descripcion, double velocidadBase, String tipo) {
        super(nombre, descripcion, velocidadBase, tipo);
    }

    @Override
    public void realizar(Personaje activo, Personaje pasivo) {
        pasivo.recibirDaño(50);
        
    }


    
    
    

}
