package br.com.bbb.game.lines;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathABC {

	private static final String ORIG = "O"; 
	private static final String DEST = "D";
	private static final String FREE = "L";
	private static final String BUSY = "X";
	
	public static void main(String args[]) {

		/*
        char[][] matrix = {
	            {'S', '0', '1', '1'},
	            {'1', '1', '0', '1'},
	            {'0', '1', '1', '1'},
	            {'1', '0', 'D', '1'}
	        };*/		
		String[][] matrix1 = 
			{ 
				{ ORIG, BUSY, FREE, FREE }, 
				{ FREE, FREE, BUSY, FREE }, 
				{ BUSY, FREE, FREE, FREE },
				{ FREE, BUSY, DEST, FREE } 
			}; // 5

		String[][] matrix2 = 
			{ 
				{ ORIG, BUSY, BUSY, DEST }, 
				{ FREE, FREE, BUSY, FREE }, 
				{ FREE, FREE, FREE, FREE },
				{ BUSY, BUSY, BUSY, BUSY } 
			}; // 13
		
		imprimeMatriz(matrix1);
		imprimeMatriz(matrix2);
		int path1 = pathExists(matrix1);
		int path2 = pathExists(matrix2);
		
		System.out.println(path1);
		System.out.println(path2);
	}

	private static void imprimeMatriz(String[][] matrix) {
		System.out.println("\n\n------------- Matriz -------------");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(j!= matrix[i].length-1) {
					System.out.print(matrix[i][j]);	
				}else if(j == matrix[i].length-1) {
					System.out.println(matrix[i][j]);
				}
			}
		}
	}
	
	private static int pathExists(String[][] matrix) {
		Node source = new Node(0, 0, 0);
		Queue<Node> queue = new LinkedList<>();

		queue.add(source);

		while (!queue.isEmpty()) {
			Node poped = queue.poll();

			if (DEST.equals(matrix[poped.x][poped.y])) {
				return poped.distanceFromSource;
			} else {
				matrix[poped.x][poped.y] = BUSY;
				List<Node> neighbourList = addNeighbours(poped, matrix);
				queue.addAll(neighbourList);
			}
		}
		return -1;
	}

	private static List<Node> addNeighbours(Node poped, String[][] matrix) {

		List<Node> list = new LinkedList<>();

		if ((poped.x - 1 > 0 && poped.x - 1 < matrix.length) && !matrix[poped.x - 1][poped.y].equals(BUSY)) {
			list.add(new Node(poped.x - 1, poped.y, poped.distanceFromSource + 1));
		}
		if ((poped.x + 1 > 0 && poped.x + 1 < matrix.length) && !matrix[poped.x + 1][poped.y].equals(BUSY)) {
			list.add(new Node(poped.x + 1, poped.y, poped.distanceFromSource + 1));
		}
		if ((poped.y - 1 > 0 && poped.y - 1 < matrix.length) && !matrix[poped.x][poped.y - 1].equals(BUSY)) {
			list.add(new Node(poped.x, poped.y - 1, poped.distanceFromSource + 1));
		}
		if ((poped.y + 1 > 0 && poped.y + 1 < matrix.length) && !matrix[poped.x][poped.y + 1].equals(BUSY)) {
			list.add(new Node(poped.x, poped.y + 1, poped.distanceFromSource + 1));
		}
		return list;
	}
}

