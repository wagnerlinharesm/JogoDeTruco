package base;

import java.util.ArrayList;
/** Classe auxiliar que terá as cartas retiradas do baralho, para reposição, e as  cartas que foram jogadas pelos jogadores **/

public class Monte { 
	private static ArrayList<Cartas> Monte = new ArrayList<Cartas>(); // ArrayList com o Monte de cartas que é retirado do baralho durante distribuição
	private static ArrayList<Cartas> Jogadas = new ArrayList<Cartas>(); // ArrayList com as cartas que são jogadas durante a rodada.
	private static int contador = 0; // Contador utilizado para sincronizar as cartas que serão jogadas

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
		Monte.clear(); // Limpa o Monte após a devolução
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
	 *  Imprime as cartas jogadas até o momento
	 */
	public static void imprimeJogadas() { // Imprime as cartas jogadas até o momento

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
