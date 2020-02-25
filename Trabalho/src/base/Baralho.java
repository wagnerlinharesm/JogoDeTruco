package base;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Classe Baralho, onde tem as informações e o ArrayList de 40 cartas 
 * @author Wagner Linhares
 */
 
public class Baralho { 
	
	private static Baralho instancia;
	private	static ArrayList<Cartas> lista = new ArrayList<Cartas>(); //Cria um Arraylist de Cartas.
	
	/** Construtor privado, pois o Baralho é um singleton*/
	private Baralho() { 
		
	}
	/** Singleton, o uso do Synchronized é para que a execução desse método seja realizada apenas por uma Thread por vez. */
	public static  Baralho getInstance() { 
		if (instancia == null) {
			instancia = new Baralho();
			
		}
		return instancia;
	}
	
	/** Preenche o Baralho, */
	public static void preencheBaralho(Cartas c[]) { 
		
		for (int i=0 ; i<c.length ; i++) {
		lista.add(c[i]);
		
		}
	}
	/** Imprime o baralho // */
		public static void imprimeB() { 
		for (int i = 0 ; i < lista.size() ; i++) {
			System.out.println(lista.get(i).getValor());
			
		}
	}
		
		/** Embaralha as cartas */
	public void Embaralha( ) {  
		Collections.shuffle(instancia.getLista());

	}
	// Get e Setters ;

	public ArrayList<Cartas> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Cartas> lista) {
		Baralho.lista = lista;
	}
	
	
	

}
