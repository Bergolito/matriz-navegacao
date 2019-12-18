package br.com.bbb.game.lines;

public class JogoTest {

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
	}
	
	/**
	[ VD 00 00 LA LA 00 ]
	[ RS 00 00 00 00 00 ]
	[ AM VM 00 00 00 RX ]
	[ 00 00 RX VM 00 VD ]
	[ 00 00 RX 00 00 00 ]
	[ 00 00 00 AZ AZ AZ ]
	 */
	private void testaTrinca02() {
		Celula[][] matriz1 = new Celula[6][6];
		//[ VD 00 00 LA LA 00 ]
		matriz1[0][0] = new Celula(0, 0, null, "VD");
		matriz1[0][1] = new Celula(0, 0, null, "00");
		matriz1[0][2] = new Celula(0, 0, null, "00");
		matriz1[0][3] = new Celula(0, 0, null, "LA");
		matriz1[0][4] = new Celula(0, 0, null, "LA");
		matriz1[0][5] = new Celula(0, 0, null, "00");
		//[ RS 00 00 00 00 00 ]
		matriz1[1][0] = new Celula(0, 0, null, "RS");
		matriz1[1][1] = new Celula(0, 0, null, "00");
		matriz1[1][2] = new Celula(0, 0, null, "00");
		matriz1[1][3] = new Celula(0, 0, null, "00");
		matriz1[1][4] = new Celula(0, 0, null, "00");
		matriz1[1][5] = new Celula(0, 0, null, "00");
		//[ AM VM 00 00 00 RX ]
		matriz1[2][0] = new Celula(0, 0, null, "AM");
		matriz1[2][1] = new Celula(0, 0, null, "VM");
		matriz1[2][2] = new Celula(0, 0, null, "00");
		matriz1[2][3] = new Celula(0, 0, null, "00");
		matriz1[2][4] = new Celula(0, 0, null, "00");
		matriz1[2][5] = new Celula(0, 0, null, "RX");
		//[ 00 00 RX VM 00 VD ]
		matriz1[3][0] = new Celula(0, 0, null, "00");
		matriz1[3][1] = new Celula(0, 0, null, "00");
		matriz1[3][2] = new Celula(0, 0, null, "RX");
		matriz1[3][3] = new Celula(0, 0, null, "VM");
		matriz1[3][4] = new Celula(0, 0, null, "00");
		matriz1[3][5] = new Celula(0, 0, null, "VD");
		//[ 00 00 RX 00 00 00 ]
		matriz1[4][0] = new Celula(0, 0, null, "00");
		matriz1[4][1] = new Celula(0, 0, null, "00");
		matriz1[4][2] = new Celula(0, 0, null, "RX");
		matriz1[4][3] = new Celula(0, 0, null, "00");
		matriz1[4][4] = new Celula(0, 0, null, "00");
		matriz1[4][5] = new Celula(0, 0, null, "00");
		//[ 00 00 00 AZ AZ AZ ]
		matriz1[5][0] = new Celula(0, 0, null, "00");
		matriz1[5][1] = new Celula(0, 0, null, "00");
		matriz1[5][2] = new Celula(0, 0, null, "00");
		matriz1[5][3] = new Celula(0, 0, null, "AZ");
		matriz1[5][4] = new Celula(0, 0, null, "AZ");
		matriz1[5][5] = new Celula(0, 0, null, "AZ");
		
		//System.out.println("\nExiste trinca? "+verificaTrinca(matriz1));
		
	}
	
	private void testaTrinca01() {
		//VM,00,AZ
		/** 
		[ 00 00 RS CI AM 00 ]
		[ 00 00 00 00 LA 00 ]
		[ RS VD VM LA AM 00 ]
		[ RX VD LA CI 00 00 ]
		[ 00 00 VM 00 00 00 ]
		[ 00 CI 00 00 00 00 ]		
		 */
		Celula[][] matriz1 = new Celula[6][6];
		//[ 00 00 RS CI AM 00 ]
		matriz1[0][0] = new Celula(0, 0, null, "00");
		matriz1[0][1] = new Celula(0, 0, null, "00");
		matriz1[0][2] = new Celula(0, 0, null, "RS");
		matriz1[0][3] = new Celula(0, 0, null, "CI");
		matriz1[0][4] = new Celula(0, 0, null, "AM");
		matriz1[0][5] = new Celula(0, 0, null, "00");
		//[ 00 00 00 00 LA 00 ]
		matriz1[1][0] = new Celula(0, 0, null, "00");
		matriz1[1][1] = new Celula(0, 0, null, "00");
		matriz1[1][2] = new Celula(0, 0, null, "00");
		matriz1[1][3] = new Celula(0, 0, null, "00");
		matriz1[1][4] = new Celula(0, 0, null, "LA");
		matriz1[1][5] = new Celula(0, 0, null, "00");
		//[ RS VD VM LA AM 00 ]		
		matriz1[2][0] = new Celula(0, 0, null, "RS");
		matriz1[2][1] = new Celula(0, 0, null, "VD");
		matriz1[2][2] = new Celula(0, 0, null, "VM");
		matriz1[2][3] = new Celula(0, 0, null, "LA");
		matriz1[2][4] = new Celula(0, 0, null, "AM");
		matriz1[2][5] = new Celula(0, 0, null, "00");
	    //[ RX VD LA CI 00 00 ]
		matriz1[3][0] = new Celula(0, 0, null, "RX");
		matriz1[3][1] = new Celula(0, 0, null, "VD");
		matriz1[3][2] = new Celula(0, 0, null, "LA");
		matriz1[3][3] = new Celula(0, 0, null, "CI");
		matriz1[3][4] = new Celula(0, 0, null, "00");
		matriz1[3][5] = new Celula(0, 0, null, "00");
		//[ 00 00 VM 00 00 00 ]
		matriz1[4][0] = new Celula(0, 0, null, "00");
		matriz1[4][1] = new Celula(0, 0, null, "00");
		matriz1[4][2] = new Celula(0, 0, null, "VM");
		matriz1[4][3] = new Celula(0, 0, null, "00");
		matriz1[4][4] = new Celula(0, 0, null, "00");
		matriz1[4][5] = new Celula(0, 0, null, "00");
		//[ 00 CI 00 00 00 00 ]
		matriz1[5][0] = new Celula(0, 0, null, "00");
		matriz1[5][1] = new Celula(0, 0, null, "CI");
		matriz1[5][2] = new Celula(0, 0, null, "00");
		matriz1[5][3] = new Celula(0, 0, null, "00");
		matriz1[5][4] = new Celula(0, 0, null, "00");
		matriz1[5][5] = new Celula(0, 0, null, "00");
		
		//System.out.println("Existe trinca? "+verificaTrinca(matriz1));
	}

}
