package base;

import java.util.ArrayList;
/** Classe auxiliar que ter� as cartas retiradas do baralho, para reposi��o, e as  cartas que foram jogadas pelos jogadores **/

public class Monte { 
	private static ArrayList<Cartas> Monte = new ArrayList<Cartas>(); // ArrayList com o Monte de cartas que � retirado do baralho durante distribui��o
	private static ArrayList<Cartas> Jogadas = new ArrayList<Cartas>(); // ArrayList com as cartas que s�o jogadas durante a rodada.
	private static int contador = 0; // Contador utilizado para sincronizar as cartas que ser�o jogadas

	public Monte() {
		// TODO Auto-generated constructor stub
	}
	/**Adiciona cartas ao Monte
	 * 
	 * 
	 */
	public static void adicionaC(Cartas c) { //  

		Monte.add(c);

	}
	/**
	 * Volta as cartas ao baralho
	 */
	public static void completaBaralho() { // 
		for (int i = 0; i < Monte.size(); i++) {
			Baralho.getInstance().getLista().add(Monte.get(i));

		}
		Monte.clear(); // Limpa o Monte ap�s a devolu��o
	}
	// Get 
	public ArrayList<Cartas> getMonte() {
		return Monte;
	}
	/**
	 * Adiciona as cartas jogadas a Jogadas
	 * @param c
	 */
	public static void cartasJogadas(Cartas c) { // Adiciona as cartas jogadas a Jogadas
		Jogadas.add(c);
	}
	/**
	 *  Imprime as cartas jogadas at� o momento
	 */
	public static void imprimeJogadas() { // Imprime as cartas jogadas at� o momento

		if (contador <= 3) {
			System.out.println("As cartas jogadas foram:");
			for (int i = 0; i < Jogadas.size(); i++) {

				System.out.println(Jogadas.get(i).toString());
				
			}
		}
		contador++;
		if (contador == 4) {
			Jogadas.clear();
			contador = 0;
		}
	 
	}
}
