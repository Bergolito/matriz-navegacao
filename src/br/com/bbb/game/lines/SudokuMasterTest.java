package br.com.bbb.game.lines;

public class SudokuMasterTest {

	/**
		0 [ 1 2 3 4 5 6 7 8 9 ]
		1 [ 9 1 2 3 4 5 6 7 8 ]
		2 [ 8 9 1 2 3 4 5 6 7 ]
		3 [ 7 8 9 1 2 3 4 5 6 ]
		4 [ 6 7 8 9 1 2 3 4 5 ]
		5 [ 5 6 7 8 9 1 2 3 4 ]
		6 [ 4 5 6 7 8 9 1 2 3 ]
		7 [ 3 4 5 6 7 8 9 1 2 ]
		8 [ 2 3 4 5 6 7 8 9 1 ]
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

		SudokuMaster sudoku = new SudokuMaster(matriz);
		sudoku.infereSolucao();
	}
	
}
