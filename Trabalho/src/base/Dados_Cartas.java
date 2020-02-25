package base;

/**
 * *Classe auxiliar para preenchimento do Baralho!
 * @author Wagner
 * @since 20/08/2017
 * @version 0.1
 */
public class Dados_Cartas {  

	/** Método para cadastrar as cartas */
	public Cartas[] cadastra_cartas() { 
		Cartas[] c = new Cartas[40];
		c[0] = new Cartas(0,"Espada","4");
		c[1] = new Cartas(0,"Ouro","4");
		c[2] = new Cartas (0,"Copas", "4");
		
		c[3] = new Cartas (1,"Paus", "5");
		c[4] = new Cartas (1,"Ouro", "5");
		c[5] = new Cartas (1,"Copas", "5");
	    c[6] = new Cartas (1, "Espada", "5");
		
	    c[7] = new Cartas (2, "Paus", "6");
	    c[8] = new Cartas (2, "Ouro", "6");
	    c[9] = new Cartas (2, "Copas", "6");
	    c[10] = new Cartas (2, "Espada", "6");
	    
	    c[11] = new Cartas (3, "Paus", "7");
	    c[12] = new Cartas (3, "Espada", "7");
	    
	    c[13] = new Cartas (4, "Paus", "Q");
	    c[14] = new Cartas (4,"Ouro", "Q");
	    c[15] = new Cartas (4, "Copas","Q");
	    c[16] = new Cartas (4, "Espada","Q");
	    
	    c[17] = new Cartas (5, "Paus", "J");
	    c[18] = new Cartas (5, "Ouro", "J");
	    c[19] = new Cartas (5, "Copas", "J");
	    c[20] = new Cartas (5, "Espada", "J");
	    
	    c[21] = new Cartas (6,"Paus", "K");
	    c[22] = new Cartas (6,"Ouro", "K");
	    c[23] = new Cartas (6,"Copas", "K");
	    c[24] = new Cartas (6,"Espada", "K");
	    
	    c[25] = new Cartas (7,"Paus","A");
	    c[26] = new Cartas (7,"Ouro","A");
	    c[27] = new Cartas (7,"Copas","A");
	    
	    c[28] = new Cartas(8, "Paus", "2");
	    c[29] = new Cartas(8, "Ouro", "2");
	    c[30] = new Cartas(8, "Copas", "2");
	    c[31] = new Cartas(8, "Espada", "2");
	    
	    c[32] = new Cartas(9,"Paus", "3");
	    c[33] = new Cartas(9,"Ouro", "3");
	    c[34] = new Cartas(9,"Copas", "3");
	    c[35] = new Cartas(9,"Espada", "3");
	    
	    // MANILHAS
	    c[36] = new Cartas(10,"Ouros","7");
	    c[37] = new Cartas(11, "Espada", "A");
	    c[38] = new Cartas(12,"Copas", "7");
	    c[39] = new Cartas(13, "Paus", "4");
	    
	    return c;
	    
	    
	    
	}

 

}
