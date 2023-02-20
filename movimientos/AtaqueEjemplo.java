package com.example.models.movimientos;

import com.example.models.Personaje;

public class AtaqueEjemplo extends MovimientoBase implements Realizable{

    public AtaqueEjemplo(String nombre, String descripcion, double velocidadBase, String tipo) {
        super(nombre, descripcion, velocidadBase, tipo);
    }

    @Override
    public void realizar(Personaje activo, Personaje pasivo) {
        pasivo.recibirDaño(50);
        
    }

    
    
    

}
