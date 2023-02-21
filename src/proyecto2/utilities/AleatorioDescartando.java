package proyecto2.utilities;

import java.util.ArrayList;

public class AleatorioDescartando<E> {
	ArrayList<E> recibidos;
	ArrayList<E> enviados;
	int min;
	int max;

	

	public AleatorioDescartando(int min, int max) {
		this.recibidos=new ArrayList<E>();
		this.enviados=new ArrayList<E>();
		for(Integer i=min;i<=max;i++) {
			recibidos.add((E)i);
		}
	}
	

	
	public AleatorioDescartando(ArrayList<E> lista) {
		this.recibidos=new ArrayList<E>();
		this.enviados=new ArrayList<E>();
		this.recibidos=lista;
	}
	


	public ArrayList<E> getEnviados() {
		return enviados;
	}



	public void setEnviados(ArrayList<E> enviados) {
		this.enviados = enviados;
	}



	public int getMin() {
		return min;
	}



	public void setMin(int min) {
		this.min = min;
	}



	public int getMax() {
		return max;
	}



	public void setMax(int max) {
		this.max = max;
	}


	/**
	 * Retorna un numero aleatorio entre el minimo y el maximo, siempre que
	 *  */
	public E darAleatorio() throws Exception {
		
		if(recibidos.size()<=0) {
			throw new Exception("No quedan opciones no elegidas (El array está lleno)");
		}
		
		
		int aleatorio = utils.aleatorio(0, recibidos.size()-1);
		
		E elegido=recibidos.get(aleatorio);	
		
		
		enviados.add(elegido);
		recibidos.remove(elegido);
		
		return elegido;
	}
}
