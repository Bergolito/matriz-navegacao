package br.com.bbb.game.lines;

public class Sudoku9x9Test {

	public static void main(String[] args) {
		int linhas = 9;
		int colunas = 9;
		int[][] matriz = new int [linhas][colunas];
		
		//
		matriz[1][0] = 8;
		matriz[1][1] = 9;
		matriz[1][2] = 4;
		matriz[1][3] = 2;
		matriz[1][5] = 6;
		matriz[1][8] = 1;
		//
		matriz[2][2] = 2;
		matriz[2][6] = 6;
		matriz[2][8] = 8;
		//
		matriz[3][3] = 3;
		matriz[3][5] = 9;
		//
		matriz[4][0] = 1;
		matriz[4][4] = 4;
		matriz[4][8] = 2;
		//
		matriz[5][0] = 9;
		matriz[5][2] = 7;
		matriz[5][3] = 6;
		matriz[5][5] = 2;
		matriz[5][6] = 3;
		//
		matriz[6][0] = 7;
		matriz[6][5] = 4;
		matriz[6][6] = 2;
		//
		matriz[7][4] = 7;
		matriz[7][6] = 4;
		matriz[7][7] = 1;
		matriz[7][8] = 5;
		//
		matriz[8][0] = 3;
		matriz[8][4] = 2;
		matriz[8][7] = 6;

		Sudoku sudoku = new Sudoku(linhas, colunas, matriz);

		sudoku.imprimeMatriz(matriz);
		
		int valor = -1;
		int contador = 0;
		do {
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					
					if(matriz[i][j] == 0) {
						if(sudoku.qtdPossibilidadesCelula(i, j, matriz).size() == 1) {
							valor = sudoku.qtdPossibilidadesCelula(i, j, matriz).get(0);
							sudoku.setValorNaLinhaColuna(valor, i, j, matriz);
						} 
					}
				}
			}
			contador++;
		} while(sudoku.existeCelulaVazia(matriz) && sudoku.existeCelula01Possib(matriz) && contador < (linhas*colunas));

		sudoku.imprimeMatriz(matriz);
		
		System.out.println("--------------------------------------");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0) {
					if(sudoku.qtdPossibilidadesCelula(i, j, matriz).size() == 2 ) {
						System.out.print("("+i+","+j+") -> [ ");
						sudoku.qtdPossibilidadesCelula(i, j, matriz).forEach(num->System.out.print(num+", "));
						System.out.println(" ] ");
					}
				}
			}
		}
		System.out.println("--------------------------------------");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0) {
					if(sudoku.qtdPossibilidadesCelula(i, j, matriz).size() == 3 ) {
						System.out.print("("+i+","+j+") -> [ ");
						sudoku.qtdPossibilidadesCelula(i, j, matriz).forEach(num->System.out.print(num+", "));
						System.out.println(" ] ");
					}
				}
			}
		}
		System.out.println("--------------------------------------");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0) {
					if(sudoku.qtdPossibilidadesCelula(i, j, matriz).size() == 4 ) {
						System.out.print("("+i+","+j+") -> [ ");
						sudoku.qtdPossibilidadesCelula(i, j, matriz).forEach(num->System.out.print(num+", "));
						System.out.println(" ] ");
					}
				}
			}
		}
		System.out.println("--------------------------------------");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0) {
					if(sudoku.qtdPossibilidadesCelula(i, j, matriz).size() == 5 ) {
						System.out.print("("+i+","+j+") -> [ ");
						sudoku.qtdPossibilidadesCelula(i, j, matriz).forEach(num->System.out.print(num+", "));
						System.out.println(" ] ");
					}
				}
			}
		}
		System.out.println("--------------------------------------");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0) {
					if(sudoku.qtdPossibilidadesCelula(i, j, matriz).size() == 6 ) {
						System.out.print("("+i+","+j+") -> [ ");
						sudoku.qtdPossibilidadesCelula(i, j, matriz).forEach(num->System.out.print(num+", "));
						System.out.println(" ] ");
					}
				}
			}
		}
		System.out.println("--------------------------------------");
		sudoku.tentaInferirValores(matriz);
	}
	
}
