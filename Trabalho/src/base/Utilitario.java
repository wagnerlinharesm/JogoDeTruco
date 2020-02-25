package base;

import java.util.Scanner;
/**Classe Utilitária para garantir a integridade da leitura dos argumentos solicitados. 
 * @author Wagner
 */ 
public class Utilitario{ 
	
	private static Scanner in = new Scanner(System.in);
	
	public static int readInt (int min, int max) {
		do {
			try {
				String x = in.nextLine();
				/** cast para caso o usuário tenha digitado String */
				int retorno = Integer.parseInt(x); 
				validaRetorno(retorno, min, max);
				
				return retorno;
			} catch (Exception c) { // o Valor enviado foi errado, logo causou exceção e o usuário tem que digitar novamente.
				System.out.println("Valor invalido");	
				System.out.println("Digite novamente!");
			}
			
		}while(true);

}
	
	private static void  validaRetorno( int retorno, int min, int max) throws Exception  { // Lança uma exceção se esta ocorrer
		
		if (retorno < min || retorno > max) {
			throw new Exception("Invalid value");
			
		}
	}
	/** O comportamento desse método é similar ao cls em C, ele vai "limpar" a tela. */
	public static void cls(){ 
    
            for(int i = 0; i < 25; i++)
            System.out.println("");
    }
}