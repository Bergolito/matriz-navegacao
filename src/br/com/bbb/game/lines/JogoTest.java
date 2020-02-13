package br.com.bbb.game.lines;

public class JogoTest {

	public static void main(String[] args) {
		Celula[][] matriz = matrizTeste01();
		int trinca = 3;
		Jogo jogoLines = new Jogo(matriz.length, matriz.length, trinca);
		boolean existeTrinca = jogoLines.verificaTrinca(matriz).size() >= trinca; 
		System.out.println("Existe trinca? "+existeTrinca);
		for (int i = 0; i < jogoLines.verificaTrinca(matriz).size(); i++) {
			System.out.print(" "+jogoLines.verificaTrinca(matriz).get(i));
		}
	}
	
	/**
	[ VD 00 00 LA LA LA ]
	[ RS 00 00 00 00 00 ]
	[ AM VM 00 00 00 RX ]
	[ 00 00 RX VM 00 VD ]
	[ 00 00 RX 00 00 00 ]
	[ 00 00 RX AZ AZ AZ ]
	 */
	public static Celula[][] matrizTeste01() {
		Celula[][] matriz1 = new Celula[6][6];
		//[ VD 00 00 LA LA 00 ]
		matriz1[0][0] = new Celula(0, 0, null, "VD");
		matriz1[0][1] = new Celula(0, 1, null, "00");
		matriz1[0][2] = new Celula(0, 2, null, "00");
		matriz1[0][3] = new Celula(0, 3, null, "LA");
		matriz1[0][4] = new Celula(0, 4, null, "LA");
		matriz1[0][5] = new Celula(0, 5, null, "LA");
		//[ RS 00 00 00 00 00 ]
		matriz1[1][0] = new Celula(1, 0, null, "RS");
		matriz1[1][1] = new Celula(1, 1, null, "00");
		matriz1[1][2] = new Celula(1, 2, null, "00");
		matriz1[1][3] = new Celula(1, 3, null, "00");
		matriz1[1][4] = new Celula(1, 4, null, "00");
		matriz1[1][5] = new Celula(1, 5, null, "00");
		//[ AM VM 00 00 00 RX ]
		matriz1[2][0] = new Celula(2, 0, null, "AM");
		matriz1[2][1] = new Celula(2, 1, null, "VM");
		matriz1[2][2] = new Celula(2, 2, null, "00");
		matriz1[2][3] = new Celula(2, 3, null, "00");
		matriz1[2][4] = new Celula(2, 4, null, "00");
		matriz1[2][5] = new Celula(2, 5, null, "RX");
		//[ 00 00 RX VM 00 VD ]
		matriz1[3][0] = new Celula(3, 0, null, "00");
		matriz1[3][1] = new Celula(3, 1, null, "00");
		matriz1[3][2] = new Celula(3, 2, null, "RX");
		matriz1[3][3] = new Celula(3, 3, null, "VM");
		matriz1[3][4] = new Celula(3, 4, null, "00");
		matriz1[3][5] = new Celula(3, 5, null, "VD");
		//[ 00 00 RX 00 00 00 ]
		matriz1[4][0] = new Celula(4, 0, null, "00");
		matriz1[4][1] = new Celula(4, 1, null, "00");
		matriz1[4][2] = new Celula(4, 2, null, "RX");
		matriz1[4][3] = new Celula(4, 3, null, "00");
		matriz1[4][4] = new Celula(4, 4, null, "00");
		matriz1[4][5] = new Celula(4, 5, null, "00");
		//[ 00 00 00 AZ AZ AZ ]
		matriz1[5][0] = new Celula(5, 0, null, "00");
		matriz1[5][1] = new Celula(5, 1, null, "00");
		matriz1[5][2] = new Celula(5, 2, null, "RX");
		matriz1[5][3] = new Celula(5, 3, null, "AZ");
		matriz1[5][4] = new Celula(5, 4, null, "AZ");
		matriz1[5][5] = new Celula(5, 5, null, "AZ");
		
		return matriz1;
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
	}

}
