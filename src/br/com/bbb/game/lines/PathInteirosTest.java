package br.com.bbb.game.lines;

public class PathInteirosTest {

	public static void main(String[] args) {

		/*
		    A value of cell 1 means Source.
		    A value of cell 2 means Destination.
		    A value of cell 3 means Blank cell.
		    A value of cell 0 means Blank Wall.
		 */
		int[][] matrix1OK = 
		{  
			{0, 3, 0, 1}, 
			{3, 0, 3, 3}, 
			{2, 3, 3, 3}, 
			{0, 3, 3, 3}
		}; 
		System.out.println("Achou Caminho? "+PathInteiros.isPath(matrix1OK));
		
		int[][] matrix1Falha = 
		{  
			{0, 3, 0, 1}, 
			{3, 0, 0, 0}, 
			{2, 3, 3, 3}, 
			{0, 3, 3, 3}
		}; 
				
		System.out.println("Achou Caminho? "+PathInteiros.isPath(matrix1Falha));

		
		int[][] matrix2OK = 
		{  
			{1, 0, 3, 3, 3}, 
			{3, 0, 3, 0, 3}, 
			{3, 0, 3, 0, 3}, 
			{3, 0, 3, 0, 3},
			{3, 3, 3, 0, 2}
		}; 
				
		System.out.println("Achou Caminho? "+PathInteiros.isPath(matrix2OK));

		int[][] matrix2Falha = 
		{  
			{1, 0, 3, 3, 3}, 
			{3, 0, 3, 0, 3}, 
			{3, 0, 3, 0, 3}, 
			{3, 0, 3, 0, 0},
			{3, 3, 3, 0, 2}
		}; 
				
		System.out.println("Achou Caminho? "+PathInteiros.isPath(matrix2Falha));
		
		int[][] matrix3OK = 
		{  
			{1, 0, 3, 3, 3, 3}, 
			{3, 0, 3, 0, 0, 3}, 
			{3, 0, 3, 0, 0, 3}, 
			{3, 0, 3, 0, 0, 3},
			{3, 0, 3, 0, 0, 3},
			{3, 3, 3, 0, 2, 3}
		}; 
				
		System.out.println("Achou Caminho? "+PathInteiros.isPath(matrix3OK));

		int[][] matrix3Falha = 
		{  
			{1, 0, 3, 3, 3, 3}, 
			{3, 0, 3, 0, 0, 0}, 
			{3, 0, 3, 0, 0, 0}, 
			{3, 0, 3, 0, 0, 0},
			{3, 0, 3, 0, 0, 0},
			{3, 3, 3, 0, 2, 0}
		}; 
				
		System.out.println("Achou Caminho? "+PathInteiros.isPath(matrix3Falha));
	}
}
