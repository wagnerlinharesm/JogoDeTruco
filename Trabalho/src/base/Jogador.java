package base;

import java.util.ArrayList;
import java.util.Scanner;
/** Classe Jogador, que possui as informa��es do Jogador 
 * @author Wagner
 * */

public class Jogador { 

	private String nome;
	private ArrayList<Cartas> mao = new ArrayList<Cartas>(); // Arraylist que ser� a m�o do jogador, ou seja, ter� 3 cartas para cada jogador.
	private Scanner in;
 
	/**Construtor que recebe a string como par�metro */
	public Jogador(String nome) { 
		this.setNome(nome);
	}

	
	public ArrayList<Cartas> getMao() {
		return mao;
	}

	public void setMao(ArrayList<Cartas> mao) {
		this.mao = mao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	/**   M�todo toString sobreescrito para a classe Jogador! */
	
	public String toString() { 
		String s = "";
	 
		System.out.println("M�o do jogador " + this.nome);
		for (int i=0; i<mao.size() ; i++) {
			System.out.println( mao.get(i).getNumero() + " de "  + mao.get(i).getNaipe());
		} 
		return s;
		}
	
	
	/** Essa � a fun��o utilizada para jogar uma carta, ela limpa a tela,  diz qual carta foi jogada, e passa para o Monte Cartas jogadas
	// Feito isso, ela imprime todas cartas jogadas at� o momento. */
	public int jogada(int i ) { 
		in = new Scanner(System.in);
		int n = 0,k = 0;
		Utilitario.cls();
		do {
			try { // Verifica se existe uma carta na posi��o digitada, caso haja exce��o, pede para digitar novamente.
				
				System.out.println("A Carta " +    mao.get(i).getNumero() + " de " + mao.get(i).getNaipe() + " Foi jogada!");
				 k = mao.get(i).getValor();	
				Monte.cartasJogadas(mao.get(i));
				mao.remove(i);
				Monte.imprimeJogadas();
				
				return k;
				
			 
			} catch (Exception c) { // o Valor enviado foi errado, logo causou exce��o e o usu�rio tem que digitar novamente.
				
				System.out.println("Valor invalido");	
				System.out.println("Digite uma posi��o v�lida para as cartas!");
				n = in.nextInt();
				i = n;
			}
			
			
		}while(true);
		
		
	}
	
	/** Fun��o utilizada quando a jogada Amarra, ela retorna a maior carta da m�o do jogador. */
	public int retornaMaior() { 
		int maior = 0;
		if (mao.isEmpty() == false) {
		for (int i = 0; i < mao.size(); i ++) {
			if (maior < mao.get(i).getValor()) {
				maior = mao.get(i).getValor();
				
			}
		}
		return maior;
		}
		else {
			System.out.println("M�OS VAZIAS");
			return 0;
		}
	}

	
	

}
