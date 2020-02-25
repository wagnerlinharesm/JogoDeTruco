package base;
/** Informações das Cartas, onde o valor é um inteiro 
 * que vai indentificar qual carta é mais "forte" que a outra
 * @author Wagner
 */
public class Cartas   { 
	
	private int valor;
	private String naipe;
	private String numero;
	/**
	 * Construtor
	 * @param valor
	 * @param naipe
	 * @param numero
	 */
	public Cartas (int valor, String naipe, String numero) {
		this.setValor(valor);
		this.setNaipe(naipe);
		this.setNumero(numero);
		 
	}
	
	
	
	//Get e Setters
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}



	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 *  Método toString sobreescrito para a classe Cartas.
	 */
	public String toString() {
		System.out.println(getNumero() +" de " +  getNaipe());
				
 
		
		
		return " ";
	}
	/** Método para distribuir as cartas aos jogadores */
	public static void distribui_Cartas(Jogador[] J) { 
		for (int j = 0; j <= 3; j++) {
			for (int i = 0; i < 3; i++) {
				J[j].getMao().add(Baralho.getInstance().getLista().get(i));
				Monte.adicionaC(Baralho.getInstance().getLista().get(i));
				Baralho.getInstance().getLista().remove(i);

			}
		}

	}
 
	
	
}
