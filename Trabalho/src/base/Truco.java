package base;

import java.util.Scanner;
/** Classe Truco, classe que vai reger o jogo.
 * @author Wagner Linahres */
public class Truco {

	private Jogador[] jogadores; /** Vetor de jogadores */
	public static int pontosD1 = 0; /** Pontuação da primeira Dupla*/
	public static int pontosD2 = 0; /** Pontuação da segunda dupla */
	public static int rodadaD1 = 0;
	public static int rodadaD2 = 0;
	public static int T = 2;

	/** Construtor */ 
	public Truco(Jogador[] J) { 
		this.jogadores = J;

	}
	/** Metódo principal da classe truco*/
	public void partida() { 
		Scanner in = new Scanner(System.in); /** Scanner
		  Criação das Variáveis que serão utilizadas durante o jogo: */
		int vez = 0, n = 0, contador = 0,   primeiro = 0, maior1 = 0, maior2 = 0, p1 = 0, p2 = 0;
		 
		int cartaValor[] = new int[4];
		int ordem[] = new int[4];

		int j1 = 0, j2 = 0;

		int jogada = 0;

		while (pontosD1 < 12 && pontosD2 < 12) { /** While que mantem o jogo rodando até que alguma dupla alcance os 12
													 pontos */
			for (int k = 0; k < jogadores.length; k++) {
				jogadores[k].getMao().clear();
			}

			Baralho.getInstance().Embaralha();
			/** Distribui as cartas e salva no monte */
			Cartas.distribui_Cartas(jogadores);
			Monte.completaBaralho();   /** Retira do monte e devolve ao baralho */
			rodadaD1 = 0;  /** zera as rodadas*/ 
			rodadaD2 = 0;
			p1 = 0;
			p2 = 0;
			maior1 = 0;
			maior2 = 0;
			T = 2; /**   valor inicial da vitória do truco por rodada, esse valor é alterado de acordo
					   com o decorrer da rodada, caso haja truco.  */ 

			while (rodadaD1 != 2 && rodadaD2 != 2) { /**While que segura as rodadas até que alguma dupla vença duas. */  

				if (contador < 4) {

					System.out.println("Jogada do Jogador " + jogadores[vez].getNome());
					System.out.println(jogadores[vez].toString());

					System.out.println(
							"Digite a posição da carta que deseja jogar. Se deseja trucar, digite 3! (0/1/2/3)");
					n = Utilitario.readInt(0, 3); /**Utilitario para garantir integridade do que foi digitado */  
					if (n == 3) {
						if (pontosD1 == 10 || pontosD2 == 10) {
							verificaMao(vez);
							break;
						}
						T = trucou(vez);
					} else {

						cartaValor[vez] = jogadores[vez].jogada(n);  
						ordem[vez] = contador; /** Armazena a ordem da jogada */
						 
						vez++; 

						contador++;
						if (vez == 4) {
							vez = 0;
						}

					}

				} else { /**
				  Nenhuma das duplas pediram truco
					maior1 = 0; // Maior carta da dupla 1
					maior2 = 0; // Maior carta da dupla 2 */
					int i = 0;
					for (i = 0; i < cartaValor.length; i++) { 
						/** Percorre o vetor com os valores das cartas e
				         encontra o maior de cada dupla!
						 */

						if (i == 0 || i == 2) {
							if (maior1 <= cartaValor[i]) {

								maior1 = cartaValor[i];
								p1 = i;
								j1 = ordem[i];
			 
							}

						}
						if (i == 1 || i == 3) {
							if (maior2 <= cartaValor[i]) {
								maior2 = cartaValor[i];
								p2 = i;
								j2 = ordem[i];
							}
						}
						/**
						 * 	 Compara a quem pertence a maior carta e salva a posição de quem jogo, para
						 que este seja o próximo a jogar, se os maiores são iguais
						  A jogada é amarrada
						  Durante a jogada amarrada, no primeiro caso, onde amarra nas primeiras
						  rodadas, é possível pedir truco
						   Para isso, é verificado se já tem algum tipo de truco acontecedendo, e é
						  perguntado ao usuário o nível superior a o truco atual
						  Por exemplo, se tiver em seis, é perguntado as duplas se alguma quer pedir
						  nove.
						  Caso não haja nenhum truco em percurso, é perguntado as duplas se querem
						  pedir, a implementação é similar ao truco anterior.
						 */
					
					}
					if (maior1 > maior2) {
						 
						jogada = p1;

					}

					else if (maior1 < maior2) {
						 
						jogada = p2;

					}

					else if (maior1 == maior2) {

						System.out.println("Jogada Amarrada!");
						

						if (rodadaD1 == 0 && rodadaD2 == 0) {
							if (ordem[j1] > ordem[j2]) {
								jogada_Amarrada(ordem[j1]); /** Jogada amarra, passa a ordem do jogador que amarrou e inicia a Amarrada */
								break;
								 
							}
							else if (ordem[j2] > ordem[j1]) {
								jogada_Amarrada(ordem[j2]); /** Jogada amarra, passa a ordem do jogador que amarrou e inicia a Amarrada */
								break;
							 
							}
						}

						else {
							/** Nesse caso a jogada amarrou na segunda ou terceira rodada, se isso ocorre,
							  aquele que ganhou a primeira, sempre é armazenado na variável
							  "primeiro", então a vitória vai para dupla que venceu a primeira rodada. */

							if (primeiro == 0 || primeiro == 2) {
								jogada = primeiro;
								System.out.println(
										"Como a primeira dupla venceu a partida, vence novamente devido a jogada amarrada");
							} else if (primeiro == 1 || primeiro == 3) {
								jogada = primeiro;
								System.out.println(
										"Como a segunda dupla venceu a partida, vence novamente devido a jogada amarrada");
							}

						}
					}
					/** Verifica quem ganhou a rodada e atribui os pontos de Rodada a devida dupla. */
					if (jogada == 0 || jogada == 2 && (rodadaD1 <2 && rodadaD2 <2)) {

						System.out.println("A dupla " + jogadores[0].getNome() + " e " + jogadores[2].getNome()
								+ " Venceu a rodada!");
					 ;
						if (rodadaD1 == 0 && rodadaD2 == 0) {
							primeiro = jogada;
						}
						rodadaD1 += 1;
						vez = jogada; /** Vez recebe o valor de jogada, que é o jogador que venceu e iniciará a proxima
										  mão */
						contador = 0; /** Zera o contador para fila circular */

					}

					if (jogada == 1 || jogada == 3 && (rodadaD1 <2 && rodadaD2 <2)) {
						if (rodadaD1 == 0 && rodadaD2 == 0) {
							primeiro = jogada;
						}
						System.out.println("A dupla " + jogadores[1].getNome() + " e " + jogadores[3].getNome()
								+ " Venceu a rodada!");
						rodadaD2 += 1;
						 
						vez = jogada; /** Vez recebe o valor de jogada, que é o jogador que venceu e iniciará a proxima
										 mão */
						contador = 0; /**  Zera o contador para fila circular */

					}

				}
				 
			}
			/** Quando o while das rodadas acaba, é verificado qual dupla venceu duas rodadsa
			 e é atribuído os pontos decorrentes.*/
			if (rodadaD1 == 2) {
				contador = 0;
				pontosD1 += T;
				if (pontosD2 > 12 || pontosD1 > 12) {
					if (pontosD1 > 12) {
						pontosD1 = 12;
					}
					if (pontosD2 > 12) {
						pontosD2 = 12;
					}
				}
				System.out.println("\nPontuação atual:\n " + jogadores[0].getNome() + " e " + jogadores[2].getNome()
						+ " : " + pontosD1 + "\n" + jogadores[1].getNome() + " e " + jogadores[3].getNome() + ": "
						+ pontosD2 + "\n");

			}

			if (rodadaD2 == 2) {
				contador = 0;
				pontosD2 += T;
				if (pontosD2 > 12 || pontosD1 > 12) {
					if (pontosD1 > 12) {
						pontosD1 = 12;
					}
					if (pontosD2 > 12) {
						pontosD2 = 12;
					}
				}
				System.out.println("\nPontuação atual:\n " + jogadores[0].getNome() + " e " + jogadores[2].getNome()
						+ " : " + pontosD1 + "\n" + jogadores[1].getNome() + " e " + jogadores[3].getNome() + ": "
						+ pontosD2 + "\n");

			}
		}
		in.close();
	}

	public Jogador[] getJ() {/**Getter */
		return jogadores;
	}

	public void setJ(Jogador[] j) { /**Setter */
		jogadores = j;
	}
	/** Verifica se o jogo está em mão de 10*/
	public static void verificaMao(int vez) { 
 
			System.out.println("BINGO! se trucar na mão de 10 você perde a rodada, seu distraído!");
			if (vez == 0 || vez == 2) {
				rodadaD1 =2;
			}
			else if ( vez == 1 || vez == 3 ) {
				rodadaD2 = 2;
			}
	}
	/**Método que realiza o truco */
	public int trucou(int i) { 
		int truco = 0, vez = 0;
		System.out.println("O jogador " + jogadores[i].getNome() + " trucou");
		if (T == 2) {
			if (i == 3) {
				vez = 0;
			}
			else {
				vez = i+1;
			}
			
			System.out.println(jogadores[vez].toString());
			System.out.println(jogadores[vez].getNome() + " Você vai aceitar, correr, ou pedir seis? ( 1 / 2 / 3 )");
			truco = Utilitario.readInt(1, 3); /** Utilitario para garantir integridade do que foi digitado */
			if (truco == 1) {
				T = 4;
			} else if (truco == 2) {
				if (i == 0 || i == 2) {
					Truco.rodadaD1 = 2;
				} else if (i == 1 || i == 3) {
					Truco.rodadaD2 = 2;
				}

			} else if (truco == 3) {
				if (i + 1 == 4) {
					vez = 0;
				}
				else {
					vez = i+1;
				}
				
			 
				System.out.println("O jogador " + jogadores[vez].getNome() + " pediu seis");
				System.out.println(jogadores[i].toString());
				System.out.println(jogadores[i].getNome() + " Você vai aceitar, correr, ou pedir nove? ( 1 / 2 / 3 )");
				truco = Utilitario.readInt(1, 3); /** Utilitario para garantir integridade do que foi digitado */
				if (truco == 1) {
					T = 8;
				} else if (truco == 2) {
					if (vez == 0 || vez == 2) {
						T = 4;
						Truco.rodadaD1 = 2;
					} else if (vez == 1 || vez == 3) {
						T = 4;

						Truco.rodadaD2 = 2;
					}

				} else if (truco == 3) {
					System.out.println("O jogador " + jogadores[i].getNome() + " pediu NOVE");
					if (i + 1 == 4) {
						vez = 0;
					}
					else {
						vez = i+1;
					}
					
					System.out.println(jogadores[vez].toString());
					System.out.println(
							jogadores[vez].getNome() + " Você vai aceitar, correr, ou pedir DOZE? ( 1 / 2 / 3 )");
					truco = Utilitario.readInt(1, 3); /** Utilitario para garantir integridade do que foi digitado */
					if (truco == 1) {
						T = 10;
					} else if (truco == 2) {
						if (i == 0 || i == 2) {
							T = 8;
							Truco.rodadaD1 = 2;
						} else if (i == 1 || i == 3) {
							T = 8;
							Truco.rodadaD2 = 2;
						}
					}

					else if (truco == 3) {
						if (i + 1 == 4) {
							vez = 0;
						}
						else {
							vez = i+1;
						}
						
						System.out.println("O jogador " + jogadores[vez].getNome() + " pediu DOZE");
						System.out.println(jogadores[i].toString());
						System.out.println(jogadores[i].getNome() + " Você vai aceitar ou vai correr? ( 1 / 2  )");
						truco = Utilitario.readInt(1, 2); /** Utilitario para garantir integridade do que foi
															digitado */
						if (truco == 1) {
							T = 12;
						} else if (truco == 2) {
							if (vez == 0 || vez == 2) {
								T = 10;
								Truco.rodadaD1 = 2;
							} else if (vez == 1 || vez == 3) {
								T = 10;
								Truco.rodadaD2 = 2;
							}
						}

					}
				}

			}

		}

		else if (T == 4) {
			if (i + 1 == 4) {
				vez = 0;
			}
			else {
				vez = i+1;
			}
			
			System.out.println("O jogador " + jogadores[i].getNome() + " pediu seis");
			System.out.println(jogadores[vez].toString());
			System.out.println(jogadores[vez].getNome() + " Você vai aceitar, correr, ou pedir nove? ( 1 / 2 / 3 )");
			truco = Utilitario.readInt(1, 3); /** Utilitario para garantir integridade do que foi digitado */
			if (truco == 1) {
				T = 8;
			} else if (truco == 2) {
				if (i == 0 || i == 2) {
					T = 4;
					Truco.rodadaD1 = 2;
				} else if (i == 1 || i == 3) {
					T = 4;
					Truco.rodadaD2 = 2;
				}

			} else if (truco == 3) {
				if (i + 1 == 4) {
					vez = 0;
				}
				else {
					vez = i+1;
				}
				
				System.out.println("O jogador " + jogadores[vez].getNome() + "pediu NOVE");
				System.out.println(jogadores[i].toString());
				System.out.println(jogadores[i].getNome() + " Você vai aceitar, correr, ou pedir DOZE? ( 1 / 2 / 3 )");
				truco = Utilitario.readInt(1, 3); /** Utilitario para garantir integridade do que foi digitado */
				if (truco == 1) {
					T = 10;
				} else if (truco == 2) {
					if (vez == 0 || vez == 2) {
						T = 8;
						Truco.rodadaD1 = 2;
					} else if (vez == 1 || vez == 3) {
						T = 8;
						Truco.rodadaD2 = 2;
					}
				}

				else if (truco == 3) {
					if (i + 1 == 4) {
						vez = 0;
					}
					else {
						vez = i+1;
					}
					
					System.out.println("O jogador " + jogadores[i].getNome() + " pediu DOZE");

					System.out.println(jogadores[vez].toString());
					System.out
							.println(jogadores[vez].getNome() + " Você vai aceitar, correr, ou pedir seis? ( 1 / 2  )");
					truco = Utilitario.readInt(1, 2); /** Utilitario para garantir integridade do que foi digitado */
					if (truco == 1) {
						T = 12;
					} else if (truco == 2) {
						if (i == 0 || i == 2) {
							T = 10;
							Truco.rodadaD1 = 2;

						} else if (i == 1 || i == 3) {
							T = 10;
							Truco.rodadaD2 = 2;
						}
					}
				}
			}

		} else if (T == 8) {
			if (i + 1 == 4) {
				vez = 0;
			}
			else {
				vez = i+1;
			}
			
			System.out.println("O jogador " + jogadores[i].getNome() + "pediu NOVE");
			System.out.println(jogadores[vez].toString());
			System.out.println(jogadores[vez].getNome() + " Você vai aceitar, correr, ou pedir DOZE? ( 1 / 2 / 3 )");
			truco = Utilitario.readInt(1, 3); /** Utilitario para garantir integridade do que foi digitado */
			if (truco == 1) {
				T = 10;
			} else if (truco == 2) {
				if (i == 0 || i == 2) {
					T = 8;
					Truco.rodadaD1 = 2;
				} else if (i == 1 || i == 3) {
					T = 8;
					Truco.rodadaD2 = 2;
				}
			}

			else if (truco == 3) {
				if (i + 1 == 4) {
					vez = 0;
				}
				else {
					vez = i+1;
				}
				
				System.out.println("O jogador " + jogadores[vez].getNome() + " pediu DOZE");
				System.out.println(jogadores[i].toString());
				System.out.println(jogadores[i].getNome() + " Você vai aceitar, correr, ou pedir seis? ( 1 / 2  )");
				truco = Utilitario.readInt(1, 2); /** Utilitario para garantir integridade do que foi digitado */
				if (truco == 1) {
					T = 12;
				} else if (truco == 2) {
					if (vez == 0 || vez == 2) {
						T = 10;
						Truco.rodadaD1 = 2;
					} else if (vez == 1 || vez == 3) {
						T = 10;
						Truco.rodadaD2 = 2;
					}
				}
			}
		}

		else if (T == 10) {
			if (i + 1 == 4) {
				vez = 0;
			}
			else {
				vez = i+1;
			}
			
			System.out.println("O jogador " + jogadores[i].getNome() + " pediu DOZE");
			System.out.println(jogadores[vez].toString());
			System.out.println(jogadores[vez].getNome() + " Você vai aceitar, correr, ou pedir seis? ( 1 / 2  )");
			truco = Utilitario.readInt(1, 2); /** Utilitario para garantir integridade do que foi digitado */
			if (truco == 1) {
				T = 12;
			} else if (truco == 2) {
				if (i == 0 || i == 2) {
					T = 10;
					Truco.rodadaD1 = 2;
				}
				else if (i == 1 || i == 3) {
					T = 10;
					Truco.rodadaD2 = 2;
				}
			} 
		}
		return T;
	}
	/** Método que realiza a jogada Amarrada*/
	public void jogada_Amarrada(int vez) { 
		int CartaValor[] = new int[4]; /** Armazena o valro da maior carta */
		int ordem[] = new int[4];
		int in=0, maior1 = 0, maior2 = 0,j1 = 0, j2 = 0;;
		for (int contador = 0; contador< jogadores.length ; contador++) {
			
			System.out.println(jogadores[vez].getNome() + " Deseja trucar na jogada Amarrada, ou prosseguir e mostrar a maior carta?(1/2)");
			in = Utilitario.readInt(1, 2);
			
			if (in == 1) {
				T = trucou(vez);
			}
			CartaValor[vez] = jogadores[vez].retornaMaior();
			ordem[vez] = contador;
			vez++;
			if (vez == 4) {
				vez = 0;
			}	
		}
			
			
		maior1 = 0; /** Maior carta da dupla 1 */
		maior2 = 0; /**Maior carta da dupla 2 */
		int i = 0;
		for (i = 0; i < CartaValor.length; i++) { /** Percorre o vetor com os valores das cartas e
													 encontra o maior de cada dupla! */

			if (i == 0 || i == 2) {
				if (maior1 <= CartaValor[i]) {

					maior1 = CartaValor[i];
					
					j1 = ordem[i];
				}

			}
			if (i == 1 || i == 3) {
				if (maior2 <= CartaValor[i]) {
					maior2 = CartaValor[i];
			
					j2 = ordem[i];
				}
			}
 
		}
		if (maior1 > maior2) {
			System.out.println( "A dupla " + jogadores[0].getNome() + " e " + jogadores[2].getNome() + " Vencenram a rodada Amarrada! ");
			Truco.rodadaD1 = 2; /** Pontua a equipe vencedora. */
	
		}

		else if (maior1 < maior2) {
			System.out.println( "A dupla " + jogadores[1].getNome() + " e " + jogadores[3].getNome() + " Vencenram a rodada Amarrada! ");
			Truco.rodadaD2 = 2; /** Pontua a equipe vencedora.*/
			
		}
		else if (maior1 == maior2) {
			if (jogadores[0].getMao().isEmpty() == true) { /** reinicia o jogo caso as mãos estejam vazias */
				System.out.println("Mãos vazias, a rodada deve recomeçar!");
				partida();
				 
			}
			else { /** Caso a jogada amarre de novo: */
				if (ordem[j1] > ordem[j2]) {
					jogada_Amarrada(ordem[j1]);
				}
				else {
					jogada_Amarrada(ordem[j2]);
				}	
			}
		
		}
		
		
	}
}
