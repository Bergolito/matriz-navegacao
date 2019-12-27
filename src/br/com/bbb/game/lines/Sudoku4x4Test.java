package br.com.bbb.game.lines;

public class Sudoku4x4Test {

	public static void main(String[] args) {
		int linhas = 4;
		int colunas = 4;
		int[][] matriz = new int [linhas][colunas];
		matriz[0][0] = 1;
		matriz[0][3] = 4;
		matriz[1][1] = 2;
		matriz[2][2] = 4;
		matriz[3][0] = 3;

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
			
		} while(sudoku.existeCelulaVazia(matriz) && sudoku.existeCelula01Possib(matriz) && contador < (linhas*colunas));
		
		sudoku.imprimeMatriz(matriz);
	}
	
}
