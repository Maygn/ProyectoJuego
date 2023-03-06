package proyecto2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import proyecto2.controllers.AplicadorEquipo;
import proyecto2.controllers.CreacionPJ;
import proyecto2.models.Atributo;
import proyecto2.models.Personaje;
import proyecto2.models.Realizable;
import proyecto2.models.movimientos.AtaqueEjemplo;
import proyecto2.utilities.AleatorioDescartando;


public class App {
    public static void main(String[] args) {
        
    	Personaje p1=new Personaje();
        
        CreacionPJ.elegirMovimientos(p1);
        
        System.out.println(p1.toString());

    }
}
