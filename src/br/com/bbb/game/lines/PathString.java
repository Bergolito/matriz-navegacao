package br.com.bbb.game.lines;

import java.util.ArrayList;
import java.util.List;

/**
 * Java program to find path between two cells in a matrix.
 * 
 * A value of cell 1 means Source.
 * A value of cell 2 means Destination.
 * A value of cell 3 means Blank cell.
 * A value of cell 0 means Blank Wall.
 * 
 * @author 03795871492
 */
class PathString {

	private List<String> caminho = new ArrayList<>();

	private static final String SOURCE = "S";
	private static final String DEST = "D";
	private static final String FREE = "F";
	private static final String OCCU = "X";
	
	// method for finding and printing
	// whether the path exists or not
	public boolean isPath(String[][] matrix) {
		boolean isPath = false;
		
		// defining visited array to keep
		// track of already visited indexes
		int rows = matrix.length;
		int columns = matrix[0].length;
		boolean[][] visited = new boolean[rows][columns];

		// flag to indicate whether the path exists or not
		boolean flag = false;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				
				// if matrix[i][j] is source
				// and it is not visited
				if (matrix[i][j].equals(SOURCE) && !visited[i][j]) {
					
					// starting from i, j and then finding the path
					if (isPath(matrix, i, j, visited)) {
						flag = true; // if path exists
						break;
					}
				}
			}
		}

		if (flag) {
			isPath = true;
			System.out.println("[OK] Achou o caminho!!!");
		}			
		else {
			System.out.println("NAO Achou o caminho!!!");
			isPath = false;
		}

		imprimeMatriz(visited);

		if (flag) {
			for (int i = caminho.size()-1; i > 0; i--) {
				System.out.print(caminho.get(i));
			}
		}			
		
		return isPath;
	}

	public void imprimeMatriz(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			System.out.print("[");
			for (int j = 0; j < visited[i].length; j++) {
				
				if(j != visited[0].length-1) {
					System.out.print(visited[i][j]+", ");	
				}else {
					System.out.println(visited[i][j]+"]");
				}
			}
		}
	}

	public void imprimeMatriz(String[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			System.out.print("[");
			for (int j = 0; j < visited[i].length; j++) {
				
				if(j != visited[0].length-1) {
					System.out.print(visited[i][j]+", ");	
				}else {
					System.out.println(visited[i][j]+"]");
				}
			}
		}
	}
	
	// method for checking boundries
	public boolean isSafe(int i, int j, String[][] matrix) {

		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
			return true;
		return false;
	}

	// Returns true if there is a path from a source (a
	// cell with value 1) to a destination (a cell with
	// value 2)
	public boolean isPath(String[][] matrix, int i, int j, boolean[][] visited) {
		
		// checking the boundries, walls and
		// whether the cell is unvisited
		if (isSafe(i, j, matrix) && !matrix[i][j].equals(OCCU) && !visited[i][j]) {
			
			//caminho.add("["+i+","+"j"+"]->");
			
			// make the cell visited
			visited[i][j] = true;

			// if the cell is the required
			// destination then return true
			if (matrix[i][j].equals(DEST))return true;

			// traverse up
			boolean up = isPath(matrix, i - 1, j, visited);

			// if path is found in up direction return true
			if (up) {
				caminho.add("["+i+","+j+"]->");
				return true;
			}

			// traverse left
			boolean left = isPath(matrix, i, j - 1, visited);

			// if path is found in left direction return true
			if (left) {
				caminho.add("["+i+","+j+"]->");
				return true;
			}

			// traverse down
			boolean down = isPath(matrix, i + 1, j, visited);

			// if path is found in down direction return true
			if (down) {
				caminho.add("["+i+","+j+"]->");
				return true;
			}

			// traverse right
			boolean right = isPath(matrix, i, j + 1, visited);

			// if path is found in right direction return true
			if (right) {
				caminho.add("["+i+","+j+"]->");
				return true;
			}
		}
		return false; // no path has been found
	}

	// driver program to check above function
}

/* This code is contributed by Madhu Priya */
