package proyecto2.utilities;

import java.util.ArrayList;

public class AleatorioDescartando<E> {
	ArrayList<E> recibidos; 
	ArrayList<E> enviados;
	int min;
	int max;

	
	//para cuando el arraylist es una lista enorme de números, aqui le das los extremos y te hace el arraylist el solo.
	public AleatorioDescartando(int min, int max) {
		//crea los arraylist de atributos
		this.recibidos=new ArrayList<E>();
		this.enviados=new ArrayList<E>();
		//llena el arraylist de numeros correlativos
		for(Integer i=min;i<=max;i++) {
			recibidos.add((E)i);
		}
	}
	

	//cuando le vas a mandar el arraylist directamente
	public AleatorioDescartando(ArrayList<E> lista) {
		//crea ambas arraylist que estan declarados en los atributos de la clase.
		this.recibidos=new ArrayList<E>(); 
		this.enviados=new ArrayList<E>();
		this.recibidos=lista;//guarda el arraylist que se le manda por cabecera en recibidos
	}
	
//getters y setters

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
	 * Retorna un numero aleatorio entre el minimo y el maximo, hasta que se te hayan ofrecido todas las opciones existentes.
		@return elegido
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
