package base;

import java.util.Scanner;

public class Main {

	
	/** Método Main **/
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		String nome;
		Dados_Cartas d = new Dados_Cartas(); // Instancia o auxiliar para criação de cartas
		Scanner in = new Scanner(System.in); // Cria um Scanner
		Cartas[] c = d.cadastra_cartas(); // Cria o vetor com todas as cartas
		Baralho.preencheBaralho(c); // Preenche o baralho com as cartas criadas
		Jogador J[] = new Jogador[4]; // Array de jogador com 4 jogadores, nos quais serão preenchidos abaixo
	 System.out.println("**********************BEM VINDO AO JOGO DE TRUCO MINEIRO*************************************************");
		
		System.out.println("Para iniciar a jogatina, inicialmente digite o nome do primeiro integrante da Dupla 1!");
		nome = in.nextLine();
		J[0] = new Jogador(nome);
		System.out.println("Agora, digite o nome do outro integrante da Dupla 1 !");
		nome = in.next();
		J[2] = new Jogador (nome);
		
		System.out.println("Agora é a vez da Dupla 2!! \n Digite o nome do primeiro integrante!");
		nome  = in.next();
		J[1] = new Jogador(nome);
		
		System.out.println("Por fim, Digite o outro integrante da Dupla 2!");
		nome = in.next();
		J[3] = new Jogador (nome);  
		 
		
		Truco T = new Truco(J); // Instancia um jogo Truco
		T.partida(); // Inicia a partida!
		in.close();
		
	}


	
}

