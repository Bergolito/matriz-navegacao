package br.com.bbb.game.lines;

public class Sudoku9x9Test {

	/**
		0 [ _ _ _ _ _ _ _ _ _ ]
		1 [ 8 9 4 2 _ 6 _ _ 1 ]
		2 [ _ _ 2 _ _ _ 6 _ 8 ]
		3 [ _ _ _ 3 _ 9 _ _ _ ]
		4 [ 1 _ _ _ 4 _ _ _ 2 ]
		5 [ 9 _ 7 6 _ 2 3 _ _ ]
		6 [ 7 _ _ _ _ 4 2 _ _ ]
		7 [ _ _ _ _ 7 _ 4 1 5 ]
		8 [ 3 _ _ _ 2 _ _ 6 _ ]
	 */
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

		SudokuUtil.imprimeMatriz(matriz);
		
		int valor = -1;
		int contador = 0;
		do {
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					
					if(matriz[i][j] == 0) {
						if(SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size() == 1) {
							valor = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(0);
							SudokuUtil.setValorNaLinhaColuna(valor, i, j, matriz, "RG01");
						} 
					}
				}
			}
			contador++;
		} while(SudokuUtil.existeCelulaVazia(matriz) && SudokuUtil.existeCelula01Possib(matriz) && contador < (linhas*colunas));

		SudokuUtil.imprimeMatriz(matriz);
		
		sudoku.analisaSolucao(matriz);
	}
	
}
