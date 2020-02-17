package br.com.bbb.game.lines;

public class JogoTest {

	public static void main(String[] args) {
		//
		//testaMatriz01();
		//
		//testaMatriz02();
		//
		testaMatriz03();
		//
		testaMatriz04();
	}
	
	public static void testaMatriz01() {
		Celula[][] matriz = matrizTeste01();
		int trinca = 3;
		Jogo jogoLines = new Jogo(matriz.length, matriz.length, trinca);
		boolean existeTrinca = jogoLines.verificaTrinca(matriz).size() >= trinca; 
		System.out.println("Existe trinca? "+existeTrinca);
		for (int i = 0; i < jogoLines.verificaTrinca(matriz).size(); i++) {
			System.out.print(" "+jogoLines.verificaTrinca(matriz).get(i));
		}
	}

	public static void testaMatriz02() {
		Celula[][] matriz = matrizTeste02();
		int trinca = 3;
		Jogo jogoLines = new Jogo(matriz.length, matriz.length, trinca);
		boolean existeTrinca = jogoLines.verificaTrinca(matriz).size() >= trinca; 
		System.out.println(" Existe trinca? "+existeTrinca);
		for (int i = 0; i < jogoLines.verificaTrinca(matriz).size(); i++) {
			System.out.print(" "+jogoLines.verificaTrinca(matriz).get(i));
		}
	}

	public static void testaMatriz03() {
		Celula[][] matriz = matrizTeste03();
		int trinca = 3;
		Jogo jogoLines = new Jogo(matriz.length, matriz.length, trinca);
		boolean existeTrinca = jogoLines.verificaTrinca(matriz).size() >= trinca; 
		System.out.println(" Existe trinca? "+existeTrinca);
		for (int i = 0; i < jogoLines.verificaTrinca(matriz).size(); i++) {
			System.out.print(" "+jogoLines.verificaTrinca(matriz).get(i));
		}
	}

	public static void testaMatriz04() {
		Celula[][] matriz = matrizTeste04();
		int trinca = 3;
		Jogo jogoLines = new Jogo(matriz.length, matriz.length, trinca);
		boolean existeTrinca = jogoLines.verificaTrinca(matriz).size() >= trinca; 
		System.out.println(" Existe trinca? "+existeTrinca);
		for (int i = 0; i < jogoLines.verificaTrinca(matriz).size(); i++) {
			System.out.print(" "+jogoLines.verificaTrinca(matriz).get(i));
		}
	}
	
	/**
	[ LA LA LA 00 ]
	[ RS 00 00 00 ]
	[ AM VM 00 00 ]
	[ 00 00 RX VM ]
	 */
	public static Celula[][] matrizTeste01() {
		Celula[][] matriz1 = new Celula[4][4];
		//[ VD 00 00 LA LA 00 ]
		matriz1[0][0] = new Celula(0, 0, null, "LA");
		matriz1[0][1] = new Celula(0, 1, null, "LA");
		matriz1[0][2] = new Celula(0, 2, null, "LA");
		matriz1[0][3] = new Celula(0, 3, null, "00");
		//[ RS 00 00 00 00 00 ]
		matriz1[1][0] = new Celula(1, 0, null, "RS");
		matriz1[1][1] = new Celula(1, 1, null, "00");
		matriz1[1][2] = new Celula(1, 2, null, "00");
		matriz1[1][3] = new Celula(1, 3, null, "00");
		//[ AM VM 00 00 00 RX ]
		matriz1[2][0] = new Celula(2, 0, null, "AM");
		matriz1[2][1] = new Celula(2, 1, null, "VM");
		matriz1[2][2] = new Celula(2, 2, null, "00");
		matriz1[2][3] = new Celula(2, 3, null, "00");
		//[ 00 00 RX VM 00 VD ]
		matriz1[3][0] = new Celula(3, 0, null, "00");
		matriz1[3][1] = new Celula(3, 1, null, "00");
		matriz1[3][2] = new Celula(3, 2, null, "RX");
		matriz1[3][3] = new Celula(3, 3, null, "VM");
		
		return matriz1;
	}

	/**
	[ LA AZ LA 00 ]
	[ RS 00 VD VM ]
	[ AM 00 00 VM ]
	[ 00 00 RX VM ]
	 */
	public static Celula[][] matrizTeste02() {
		Celula[][] matriz1 = new Celula[4][4];
		//[ LA AZ LA 00 ]
		matriz1[0][0] = new Celula(0, 0, null, "LA");
		matriz1[0][1] = new Celula(0, 1, null, "AZ");
		matriz1[0][2] = new Celula(0, 2, null, "LA");
		matriz1[0][3] = new Celula(0, 3, null, "00");
		//[ RS 00 VD VM ]
		matriz1[1][0] = new Celula(1, 0, null, "RS");
		matriz1[1][1] = new Celula(1, 1, null, "00");
		matriz1[1][2] = new Celula(1, 2, null, "VD");
		matriz1[1][3] = new Celula(1, 3, null, "VM");
		//[ AM 00 00 VM ]
		matriz1[2][0] = new Celula(2, 0, null, "AM");
		matriz1[2][1] = new Celula(2, 1, null, "00");
		matriz1[2][2] = new Celula(2, 2, null, "00");
		matriz1[2][3] = new Celula(2, 3, null, "VM");
		//[ 00 00 RX VM ]
		matriz1[3][0] = new Celula(3, 0, null, "00");
		matriz1[3][1] = new Celula(3, 1, null, "00");
		matriz1[3][2] = new Celula(3, 2, null, "RX");
		matriz1[3][3] = new Celula(3, 3, null, "VM");
		
		return matriz1;
	}
	
	/**
	[ LA VD 00 AZ ]
	[ RS LA VD AM ]
	[ AM 00 LA RX ]
	[ VM 00 RX LA ]
	 */
	public static Celula[][] matrizTeste03() {
		Celula[][] matriz1 = new Celula[4][4];
		//[ LA VD LA 00 ]
		matriz1[0][0] = new Celula(0, 0, null, "LA");
		matriz1[0][1] = new Celula(0, 1, null, "VD");
		matriz1[0][2] = new Celula(0, 2, null, "00");
		matriz1[0][3] = new Celula(0, 3, null, "AZ");
		//[ RS LA VD AM ]
		matriz1[1][0] = new Celula(1, 0, null, "RS");
		matriz1[1][1] = new Celula(1, 1, null, "LA");
		matriz1[1][2] = new Celula(1, 2, null, "VD");
		matriz1[1][3] = new Celula(1, 3, null, "AM");
		//[ AM 00 LA RX ]
		matriz1[2][0] = new Celula(2, 0, null, "AM");
		matriz1[2][1] = new Celula(2, 1, null, "00");
		matriz1[2][2] = new Celula(2, 2, null, "LA");
		matriz1[2][3] = new Celula(2, 3, null, "RX");
		//[ VM 00 RX LA ]
		matriz1[3][0] = new Celula(3, 0, null, "VM");
		matriz1[3][1] = new Celula(3, 1, null, "00");
		matriz1[3][2] = new Celula(3, 2, null, "RX");
		matriz1[3][3] = new Celula(3, 3, null, "LA");
		
		return matriz1;
	}

	/**
	[ LA VD 00 AZ ]
	[ 00 00 AZ 00 ]
	[ AM AZ 00 RX ]
	[ AZ 00 RX 00 ]
	 */
	public static Celula[][] matrizTeste04() {
		Celula[][] matriz1 = new Celula[4][4];
		//[ LA VD 00 AZ ]
		matriz1[0][0] = new Celula(0, 0, null, "LA");
		matriz1[0][1] = new Celula(0, 1, null, "VD");
		matriz1[0][2] = new Celula(0, 2, null, "00");
		matriz1[0][3] = new Celula(0, 3, null, "AZ");
		//[ 00 00 AZ 00 ]
		matriz1[1][0] = new Celula(1, 0, null, "00");
		matriz1[1][1] = new Celula(1, 1, null, "00");
		matriz1[1][2] = new Celula(1, 2, null, "AZ");
		matriz1[1][3] = new Celula(1, 3, null, "00");
		//[ AM AZ 00 RX ]
		matriz1[2][0] = new Celula(2, 0, null, "AM");
		matriz1[2][1] = new Celula(2, 1, null, "AZ");
		matriz1[2][2] = new Celula(2, 2, null, "00");
		matriz1[2][3] = new Celula(2, 3, null, "RX");
		//[ AZ 00 RX 00 ]
		matriz1[3][0] = new Celula(3, 0, null, "AZ");
		matriz1[3][1] = new Celula(3, 1, null, "00");
		matriz1[3][2] = new Celula(3, 2, null, "RX");
		matriz1[3][3] = new Celula(3, 3, null, "00");
		
		return matriz1;
	}
	
}
