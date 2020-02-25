package base;

import java.util.Scanner;
/**Classe Utilit�ria para garantir a integridade da leitura dos argumentos solicitados. 
 * @author Wagner
 */ 
public class Utilitario{ 
	
	private static Scanner in = new Scanner(System.in);
	
	public static int readInt (int min, int max) {
		do {
			try {
				String x = in.nextLine();
				/** cast para caso o usu�rio tenha digitado String */
				int retorno = Integer.parseInt(x); 
				validaRetorno(retorno, min, max);
				
				return retorno;
			} catch (Exception c) { // o Valor enviado foi errado, logo causou exce��o e o usu�rio tem que digitar novamente.
				System.out.println("Valor invalido");	
				System.out.println("Digite novamente!");
			}
			
		}while(true);

}
	
	private static void  validaRetorno( int retorno, int min, int max) throws Exception  { // Lan�a uma exce��o se esta ocorrer
		
		if (retorno < min || retorno > max) {
			throw new Exception("Invalid value");
			
		}
	}
	/** O comportamento desse m�todo � similar ao cls em C, ele vai "limpar" a tela. */
	public static void cls(){ 
    
            for(int i = 0; i < 25; i++)
            System.out.println("");
    }
}