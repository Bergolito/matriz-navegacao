package br.com.bbb.game.lines;

public class Sudoku9x9Test {

	public static void main(String[] args) {
		int linhas = 9;
		int colunas = 9;
		int[][] matriz = new int [linhas][colunas];

		matriz[0][0] = 5;
		matriz[0][1] = 8;
		matriz[0][2] = 6;
		matriz[0][3] = 3;
		matriz[0][5] = 4;
		matriz[0][6] = 9;
		matriz[0][7] = 2;
		matriz[0][8] = 7;

		matriz[1][0] = 7;
		matriz[1][5] = 5;

		matriz[2][0] = 4;
		matriz[2][5] = 9;

		matriz[3][0] = 1;
		matriz[3][5] = 6;
		                
		matriz[4][0] = 6;
		matriz[4][1] = 2;
		matriz[4][2] = 7;
		matriz[4][3] = 1;
		matriz[4][5] = 3;
		matriz[4][6] = 5;
		matriz[4][7] = 4;
		matriz[4][8] = 9;

		matriz[5][3] = 2;
		matriz[5][8] = 8;

		matriz[6][3] = 4;
		matriz[6][8] = 5;

		matriz[7][3] = 7;
		matriz[7][8] = 1;

		matriz[8][0] = 9;
		matriz[8][1] = 4;
		matriz[8][2] = 1;
		matriz[8][3] = 5;
		matriz[8][5] = 2;
		matriz[8][6] = 7;
		matriz[8][7] = 8;
		matriz[8][8] = 3;


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
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				if(matriz[i][j] == 0) {
					if(sudoku.qtdPossibilidadesCelula(i, j, matriz).size() == 2) {
						System.out.print("("+i+","+j+") -> [ ");
						sudoku.qtdPossibilidadesCelula(i, j, matriz).forEach(num->System.out.print(num+", "));
						System.out.println(" ] ");
					} 
				}
			}
		}
		
	}
	
}
