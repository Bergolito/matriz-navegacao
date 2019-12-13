package br.com.bbb.game.lines;

class ShortestPath{

	private static final String ORIG = "O"; 
	private static final String DEST = "D";
	private static final String FREE = "L";
	private static final String BUSY = "X";

	// M x N matrix
	private static final int ROWS = 4;
	private static final int COLUMNS = 4;

	// Check if it is possible to go to (x, y) from current position. The
	// function returns false if the cell has value 0 or already visited
	private static boolean isSafe(String[][] mat, String[][] visited, int x, int y) {
		//return !(mat[x][y] == 0 || visited[x][y] != 0);
		return !(mat[x][y].equals(BUSY) || visited[x][y].equals(BUSY));
	}

	// if not a valid position, return false
	private static boolean isValid(int x, int y) {
		return (x < ROWS && y < COLUMNS && x >= 0 && y >= 0);
	}

	// Find Shortest Possible Route in a Matrix mat from source cell (0, 0)
	// to destination cell (x, y)

	// 'min_dist' stores length of longest path from source to destination
	// found so far and 'dist' maintains length of path from source cell to
	// the current cell (i, j)

	public static int findShortestPath(
		String[][] mat, String[][] visited, int i, int j, int x, int y, int min_dist, int dist) {
	
		// if destination is found, update min_dist
		if (i == x && j == y)
		{
			return Integer.min(dist, min_dist);
		}

		// set (i, j) cell as visited
		//visited[i][j] = 1;
		visited[i][j] = BUSY;

		// go to bottom cell
		if (isValid(i + 1, j) && isSafe(mat, visited, i + 1, j)) {
			min_dist = findShortestPath(mat, visited, i + 1, j, x, y,
										min_dist, dist + 1);
		}

		// go to right cell
		if (isValid(i, j + 1) && isSafe(mat, visited, i, j + 1)) {
			min_dist = findShortestPath(mat, visited, i, j + 1, x, y,
										min_dist, dist + 1);
		}

		// go to top cell
		if (isValid(i - 1, j) && isSafe(mat, visited, i - 1, j)) {
			min_dist = findShortestPath(mat, visited, i - 1, j, x, y,
										min_dist, dist + 1);
		}

		// go to left cell
		if (isValid(i, j - 1) && isSafe(mat, visited, i, j - 1)) {
			min_dist = findShortestPath(mat, visited, i, j - 1, x, y,
										min_dist, dist + 1);
		}

		// Backtrack - Remove (i, j) from visited matrix
		//visited[i][j] = 0;
		visited[i][j] = BUSY;
		
		return min_dist;
	}
	
	private static String[][] inicializaMatrizVisitacao(int M, int N) {
		String[][] visited = new String [M][N]; 
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				visited[i][j] = FREE;
			}
		}
		
		return visited;
	}

	private static void teste01() {
		String[][] mat = { 
				{ ORIG, BUSY, BUSY, DEST }, 
				{ FREE, FREE, BUSY, FREE }, 
				{ FREE, FREE, FREE, FREE },
				{ BUSY, BUSY, BUSY, BUSY } 
			}; // 7
			
		System.out.println("Linhas= "+mat.length+" Colunas="+mat[0].length);
		String[][] visited = inicializaMatrizVisitacao(mat.length, mat[0].length);
		
		int minDist = findShortestPath(mat, visited, 0, 0, 0, 3, Integer.MAX_VALUE, 0);

		if(minDist != Integer.MAX_VALUE) {
			System.out.println("The shortest path from source to destination " + "has length " + minDist);
		}
		else {
			System.out.println("Destination can't be reached from source");
		}
	}

	private static void teste02() {
		String[][] mat = { 
				{ ORIG, BUSY, BUSY, BUSY, BUSY }, 
				{ FREE, BUSY, BUSY, BUSY, BUSY }, 
				{ FREE, FREE, FREE, BUSY, DEST },
				{ BUSY, BUSY, FREE, BUSY, FREE },
				{ BUSY, BUSY, FREE, FREE, FREE }
			}; // 7
			
		System.out.println("Linhas= "+mat.length+" Colunas="+mat[0].length);
		String[][] visited = inicializaMatrizVisitacao(mat.length, mat[0].length);
		
		int minDist = findShortestPath(mat, visited, 0, 0, 0, 3, Integer.MAX_VALUE, 0);

		if(minDist != Integer.MAX_VALUE) {
			System.out.println("The shortest path from source to destination " + "has length " + minDist);
		}
		else {
			System.out.println("Destination can't be reached from source");
		}
		
	}
	
	public static void main(String[] args) {
		teste01(); // 7
		teste02(); // 10
	}
}
