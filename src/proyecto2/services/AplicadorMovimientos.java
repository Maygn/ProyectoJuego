package proyecto2.services;

import java.util.ArrayList;
import java.util.Arrays;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.movimientos.*;

import proyecto2.utilities.AleatorioDescartando;
import proyecto2.utilities.utils;

public class AplicadorMovimientos {
	
	
	/**
	 * los movimientos los agrupo en dos arrays distintos, el de los ataques
	 * agresivos (es necesario que todos los personajes tengan alguno) y el resto de
	 * movimientos (curas buff o lo que sean)
	 */
	

	static MovimientoBase[] opcionesAtaque=new MovimientoBase[3];
	
	static MovimientoBase a1=new Ataque1();
	static MovimientoBase a2=new Ataque2();
	static MovimientoBase a3=new Ataque3();
	static MovimientoBase a4=new Ataque4();
	static MovimientoBase a5=new Ataque5();
	static MovimientoBase a6=new Ataque6();
	static MovimientoBase a7=new Ataque7();
	static MovimientoBase a8=new Ataque8();
	static MovimientoBase a9=new Ataque9();
	static MovimientoBase a10=new Ataque10();
	
	static MovimientoBase b1=new Buff1();
	static MovimientoBase b2=new Buff2();
	static MovimientoBase b3=new Buff3();
	static MovimientoBase b4=new Buff4();
	static MovimientoBase b5=new Buff5();
	static MovimientoBase b6=new Buff6();
	static MovimientoBase b7=new Buff7();
	static MovimientoBase b8=new Buff8();
	static MovimientoBase b9=new Buff9();
	static MovimientoBase b10=new Buff10();
	
	static ArrayList<MovimientoBase> ataques=new ArrayList<>(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10));
	static ArrayList<MovimientoBase> buffs=new ArrayList<>(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10));

	
/**
 * @param Personaje p
 * Permite elegir cuatro movimientos, dos de ellos del array de ataques agresivos y otros dos de los que no pegan.
 * Te deja elegir uno de entre tres para cada caso.*/

	public static void darEleccion(Personaje p) throws Exception {
		MovimientoBase[] arrayMovs = new MovimientoBase[4];
		AleatorioDescartando<MovimientoBase> elegirAtaques = new AleatorioDescartando<>(ataques);
		AleatorioDescartando<MovimientoBase> elegirNopegar = new AleatorioDescartando<>(buffs);

		for (int lcv = 0; lcv < arrayMovs.length; lcv++) {
			for (int i = 0; i < 3; i++) {
				
				MovimientoBase sacado;
				
				if (lcv < 2) {
					sacado = elegirAtaques.darAleatorio();
				} else {
					sacado = elegirNopegar.darAleatorio();
				}

				opcionesAtaque[i] = sacado;
				System.out.println("Opcion " + (i + 1) + sacado.getNombre());
			}

			arrayMovs[lcv] = opcionesAtaque[utils.leerDatoEntero("Cual de los tres movimientos ofrecidos quieres?", 1, 3) - 1];

		}

		
		p.setMovimientos(arrayMovs);
	}

}
