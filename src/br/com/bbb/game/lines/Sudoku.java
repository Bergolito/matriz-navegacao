package br.com.bbb.game.lines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Sudoku {
	
	private static final Integer[] NUMEROS_POSSIVEIS = new Integer[] { 1, 2, 3, 4 };
	private List<Integer> numerosPossiveis = new ArrayList<>();
	
	// atributos
	private int rows;
	private int columns;
	private int[][] matrizPrincipal;
	private List<Celula> celulasVazias = new ArrayList<>();

	public Sudoku() {
		//
	}

	public Sudoku(int lin, int col, int[][] mat) {
		this.rows = lin;
		this.columns = col;
		this.matrizPrincipal = new int[lin][col];
		this.matrizPrincipal = mat;
		
		numerosPossiveis = Arrays.asList(NUMEROS_POSSIVEIS);
	}
	
	public List<Integer> qtdPossibilidadesCelula(int linha, int coluna) {
		Set<Integer> listaElementos = new HashSet<>();
		List<Integer> elementosRetorno = new ArrayList<>();
		
		// pega elementos da linha 
		listaElementos.addAll(pegaElementosLinha(linha, coluna));
		
		// pega elementos da coluna
		listaElementos.addAll(pegaElementosColuna(linha, coluna));
		
		// pega elementos do quadrante
		listaElementos.addAll(pegaElementosQuadrante(linha, coluna));
		
        // Creating an iterator 
        Iterator<Integer> numeros = listaElementos.iterator(); 
  
        // Displaying the values after iterating through the iterator 
        while (numeros.hasNext()) { 
        	elementosRetorno.add(numeros.next());
        } 
        
        Collections.sort(elementosRetorno);

		List<Integer> diferenca = numerosPossiveis.stream()
				.distinct().filter(aObject -> !elementosRetorno.contains(aObject)).collect(Collectors.toList());
        
		return diferenca;
	}
	
	private Set<Integer> pegaElementosLinha(int linha, int coluna) {
		Set<Integer> listaElementos = new HashSet<>();
		
 		for (int j = 0; j < columns; j++) {
			if(matrizPrincipal[linha][j] != 0) {
				listaElementos.add(matrizPrincipal[linha][j]);
			}
		}
 		
		return listaElementos;
	}

	private Set<Integer> pegaElementosColuna(int linha, int coluna) {
		Set<Integer> listaElementos = new HashSet<>();
		
		for (int i = 0; i < rows; i++) {
			if(matrizPrincipal[i][coluna] != 0) {
				listaElementos.add(matrizPrincipal[i][coluna]);
			}
		}
 		
		return listaElementos;
	}
	
	private Set<Integer> pegaElementosQuadrante(int linha, int coluna) {
		Set<Integer> listaElementos = new HashSet<>();
		
		int linhaInicio = 0;
		int linhaFim = 0;
		int colunaInicio = 0;
		int colunaFim = 0;
		
		if(linha < 2) {
			if(coluna < 2) {
				linhaInicio = 0;
				linhaFim = 2;
				colunaInicio = 0;
				colunaFim = 2;
			} else {
				linhaInicio = 0;
				linhaFim = 2;
				colunaInicio = 2;
				colunaFim = 4;
			}
			
		} else {

			if(coluna < 2) {
				linhaInicio = 2;
				linhaFim = 4;
				colunaInicio = 0;
				colunaFim = 2;
			} else {
				linhaInicio = 2;
				linhaFim = 4;
				colunaInicio = 2;
				colunaFim = 4;
			}
		}
		for (int i = linhaInicio; i < linhaFim; i++) {
			for (int j = colunaInicio; j < colunaFim; j++) {
				if(matrizPrincipal[i][j] != 0) {
					listaElementos.add(matrizPrincipal[i][j]);
				}
			}
		}
		
		return listaElementos;
	}
	
	private void setValor(int linha, int coluna, int valor) {
		System.out.println("Setando o valor "+valor+" na linha "+linha+" coluna "+coluna+"...");
		matrizPrincipal[linha][coluna] = valor;
	}
	
	private boolean existeCelulaVazia() {
		boolean achouCelulaVazia = false;

		for (int i = 0; i < matrizPrincipal.length; i++) {
			for (int j = 0; j < matrizPrincipal[i].length; j++) {
				if(matrizPrincipal[i][j] == 0) {
					achouCelulaVazia = true;
					break;
				}
						
			}
		}
		return achouCelulaVazia;
	}
	
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
		
		do {
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if(matriz[i][j] == 0) {

						if(sudoku.qtdPossibilidadesCelula(i, j).size() == 1) {
							sudoku.setValor(i, j, sudoku.qtdPossibilidadesCelula(i, j).get(0));
						} 

					}
				}
			}
			
		} while(sudoku.existeCelulaVazia());
		
		sudoku.imprimeMatriz(matriz);
		
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public List<Integer> getNumerosPossiveis() {
		return numerosPossiveis;
	}

	public void setNumerosPossiveis(List<Integer> numerosPossiveis) {
		this.numerosPossiveis = numerosPossiveis;
	}

	public int[][] getMatrizPrincipal() {
		return matrizPrincipal;
	}

	public void setMatrizPrincipal(int[][] matrizPrincipal) {
		this.matrizPrincipal = matrizPrincipal;
	}

	public List<Celula> getCelulasVazias() {
		return celulasVazias;
	}

	public void setCelulasVazias(List<Celula> celulasVazias) {
		this.celulasVazias = celulasVazias;
	}

	private void imprimeMatriz(int[][] matriz) {
		System.out.println();
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("[");
			for (int j = 0; j < matriz[i].length; j++) {
				
				if(j != matriz[i].length-1) {
					System.out.print(" "+matriz[i][j]);
				}
				else {
					System.out.println(" "+matriz[i][j]+" ]");
				}
			}
		}
	}

}
