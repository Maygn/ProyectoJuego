package proyecto2.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import proyecto2.models.MovimientoBase;
import proyecto2.models.Personaje;
import proyecto2.models.movimientos.Ataque1;
import proyecto2.models.movimientos.Ataque10;
import proyecto2.models.movimientos.Ataque2;
import proyecto2.models.movimientos.Ataque3;
import proyecto2.models.movimientos.Ataque4;
import proyecto2.models.movimientos.Ataque5;
import proyecto2.models.movimientos.Ataque6;
import proyecto2.models.movimientos.Ataque7;
import proyecto2.models.movimientos.Ataque8;
import proyecto2.models.movimientos.Ataque9;
import proyecto2.utilities.AleatorioDescartando;
import proyecto2.utilities.utils;

public class AplicadorMovimientos {
	
	
	/**
	 * los movimientos los agrupo en dos arrays distintos, el de los ataques
	 * agresivos (es necesario que todos los personajes tengan alguno) y el resto de
	 * movimientos (curas buff o lo que sean)
	 */
	
	static ArrayList<MovimientoBase> noPegar=new ArrayList<>();
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
	
	static ArrayList<MovimientoBase> ataques=new ArrayList<>(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10));





	public static void darEleccion(Personaje p) throws Exception {
		MovimientoBase[] arrayMovs = new MovimientoBase[3];
		AleatorioDescartando<MovimientoBase> elegirAtaques = new AleatorioDescartando<>(ataques);
		AleatorioDescartando<MovimientoBase> elegirNopegar = new AleatorioDescartando<>(noPegar);

		for (int lcv = 0; lcv < arrayMovs.length; lcv++) {
			for (int i = 0; i < 3; i++) {
				
				MovimientoBase sacado;
				
				if (lcv < 4) {
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
