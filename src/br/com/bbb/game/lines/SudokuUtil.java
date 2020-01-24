package br.com.bbb.game.lines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SudokuUtil {
	
	private SudokuUtil() {
		//
	}

	public static boolean existeInconsistenciaMatriz(int[][] matriz) {
		boolean inconsistencia = false;
		
		// verifica nas linhas
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(!isUnique(matriz[i])) {
					inconsistencia = true;
					break;
				}
			}
		}
		// verifica nas colunas
		int[] colunas = new int[matriz.length]; 
		for (int j = 0; j < matriz.length; j++) {
			for (int i = 0; i < matriz[j].length; i++) {
				colunas[i] = matriz[i][j];
			}
			if(!isUnique(colunas)) {
				inconsistencia = true;
				break;
			}
		}
		
		return inconsistencia;
	}
	
	public static String retornaNumerosPossibs(int i, int j, int[][] matriz) {
		StringBuilder str = new StringBuilder();
		for (int num : qtdPossibilidadesCelula(i, j, matriz)) {
			str.append(" "+num);
		}
		
		return str.toString();
	}
	
	public static boolean isUnique(int[] nums){
	    Set<Integer> set = new HashSet<>(nums.length);

	    for (int a : nums) {
	        if (!set.add(a))
	            return false;
	    }

	    return true;
	}	
	
	public static void imprimeMatrizPossibilidades(int[][] matriz) {
		System.out.println("\n\n|==== Matriz de Possibilidades ====|");
		
		for (int i = 0; i < matriz.length; i++) {
			System.out.print(i+" [");
			for (int j = 0; j < matriz[i].length; j++) {
				
				if(j != matriz[i].length-1) {
					if(matriz[i][j] == 0) {
						System.out.print(" "+qtdPossibilidadesCelula(i, j, matriz).size());	
					} else {
						System.out.print(" _");
					}
				}
				else {
					
					if(matriz[i][j] == 0) {
						System.out.println(" "+qtdPossibilidadesCelula(i, j, matriz).size()+" ]");
					} else {
						System.out.println(" _ ]");
					}
				}
			}
		}
	}
	
	public static int existeNumeroQuadrante(int numero, int quadrante, int[][] matriz) {
		int achou = 0;
		int linhaInicio = -1;
		int linhaFim = -1;
		int colunaInicio = -1;
		int colunaFim = -1;
		
		// linhas 0, 1, 2 
		if(quadrante == 1) {
			
			linhaInicio = 0;
			linhaFim = 2;
			colunaInicio = 0;
			colunaFim = 2;
		}
		else if(quadrante == 2) {

			linhaInicio = 0;
			linhaFim = 2;
			colunaInicio = 3;
			colunaFim = 5;
		}
		else if(quadrante == 3) {
			
			linhaInicio = 0;
			linhaFim = 2;
			colunaInicio = 6;
			colunaFim = 8;
		}
		// linhas 3, 4, 5 
		else if(quadrante == 4) {
			
			linhaInicio = 3;
			linhaFim = 5;
			colunaInicio = 0;
			colunaFim = 2;
		}
		else if(quadrante == 5) {
			
			linhaInicio = 3;
			linhaFim = 5;
			colunaInicio = 3;
			colunaFim = 5;
		}
		else if(quadrante == 6) {
			
			linhaInicio = 3;
			linhaFim = 5;
			colunaInicio = 6;
			colunaFim = 8;
		}
		// linhas 6, 7, 8 
		else if(quadrante == 7) {
			
			linhaInicio = 6;
			linhaFim = 8;
			colunaInicio = 0;
			colunaFim = 2;
		}
		else if(quadrante == 8) {
			
			linhaInicio = 6;
			linhaFim = 8;
			colunaInicio = 3;
			colunaFim = 5;
		}
		else if(quadrante == 9) {
			
			linhaInicio = 6;
			linhaFim = 8;
			colunaInicio = 6;
			colunaFim = 8;
		}
		
		for (int i = linhaInicio; i <= linhaFim; i++) {
			for (int j = colunaInicio; j <= colunaFim; j++) {
				if(matriz[i][j] == numero) {
					achou = 1;
					break;
				}
			}
		}
		
		return achou;
	}

	public static int qualLinhaNumeroEstaNoQuadrante(int numeroAnalisado, int quadrante, int[][] matriz) {
		int linha = -1;
		int linhaInicio = -1;
		int linhaFim = -1;
		int colunaInicio = -1;
		int colunaFim = -1;
		
		// linhas 0, 1, 2 
		if(quadrante == 1) {
			
			linhaInicio = 0;
			linhaFim = 2;
			colunaInicio = 0;
			colunaFim = 2;
		} 
		else if(quadrante == 2) {
			
			linhaInicio = 0;
			linhaFim = 2;
			colunaInicio = 3;
			colunaFim = 5;
		}
		else if(quadrante == 3) {
			
			linhaInicio = 0;
			linhaFim = 2;
			colunaInicio = 6;
			colunaFim = 8;

		}
		
		// linhas 3, 4, 5 
		else if(quadrante == 4) {
			
			linhaInicio = 3;
			linhaFim = 5;
			colunaInicio = 0;
			colunaFim = 2;
			
		}
		else if(quadrante == 5) {
			
			linhaInicio = 3;
			linhaFim = 5;
			colunaInicio = 3;
			colunaFim = 5;
			
		}
		else if(quadrante == 6) {
			
			linhaInicio = 3;
			linhaFim = 5;
			colunaInicio = 6;
			colunaFim = 8;

		}
		
		// linhas 6, 7, 8 
		else if(quadrante == 7) {
			
			linhaInicio = 6;
			linhaFim = 8;
			colunaInicio = 0;
			colunaFim = 2;
			
		}
		else if(quadrante == 8) {
			
			linhaInicio = 6;
			linhaFim = 8;
			colunaInicio = 3;
			colunaFim = 5;
			
		}
		else if(quadrante == 9) {
			
			linhaInicio = 6;
			linhaFim = 8;
			colunaInicio = 6;
			colunaFim = 8;
			
		}
		
		for (int i = linhaInicio; i <= linhaFim; i++) {
			for (int j = colunaInicio; j <= colunaFim; j++) {
				if(matriz[i][j] == numeroAnalisado) {
					linha = i;
					break;
				}
			}
		}
		
		return linha;		
	}
	
	public static int qtdCelulasPreenchidasNasLinhasNaColuna(List<Integer> linhasQuadrante, int coluna, int[][] matriz) {
		int qtd = 0;
		
		if(matriz[linhasQuadrante.get(0)][coluna] != 0) qtd++;
		if(matriz[linhasQuadrante.get(1)][coluna] != 0) qtd++;
		if(matriz[linhasQuadrante.get(2)][coluna] != 0) qtd++;

		return qtd;
	}

	public static int qtdCelulasPreenchidasNasColunasNaLinha(List<Integer> colunasQuadrante, int linha, int[][] matriz) {
		int qtd = 0;
		
		if(matriz[linha][colunasQuadrante.get(0)] != 0) qtd++;
		if(matriz[linha][colunasQuadrante.get(1)] != 0) qtd++;
		if(matriz[linha][colunasQuadrante.get(2)] != 0) qtd++;

		return qtd;
	}

	public static List<Integer> qtdPossibilidadesCelula(int linha, int coluna, int[][] matriz) {
		Set<Integer> listaElementos = new HashSet<>();
		List<Integer> elementosRetorno = new ArrayList<>();
		
		// pega elementos da linha 
		listaElementos.addAll(pegaElementosLinha(linha, coluna, matriz));
		
		// pega elementos da coluna
		listaElementos.addAll(pegaElementosColuna(linha, coluna, matriz));
		
		// pega elementos do quadrante
		listaElementos.addAll(pegaElementosQuadrante(linha, coluna, matriz));
		
        // Creating an iterator 
        Iterator<Integer> numeros = listaElementos.iterator(); 
  
        // Displaying the values after iterating through the iterator 
        while (numeros.hasNext()) { 
        	elementosRetorno.add(numeros.next());
        } 
        
        Collections.sort(elementosRetorno);

        Integer[] arrayNumerosPossiveis = null;
		if(matriz.length == 4) {
			arrayNumerosPossiveis = new Integer[] { 1, 2, 3, 4 };
		} else if(matriz.length == 9) {
			arrayNumerosPossiveis = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		}

		List<Integer> numerosPossiveis = Arrays.asList(arrayNumerosPossiveis);

		return numerosPossiveis.stream()
				.distinct().
				filter(aObject -> !elementosRetorno.contains(aObject)).
				collect(Collectors.toList());
	}
	
	public static Set<Integer> pegaElementosLinha(int linha, int coluna, int[][] matriz) {
		Set<Integer> listaElementos = new HashSet<>();
		
 		for (int j = 0; j < matriz[0].length; j++) {
			if(j != coluna &&  matriz[linha][j] != 0) {
				listaElementos.add(matriz[linha][j]);
			}
		}
 		
		return listaElementos;
	}

	public static Set<Integer> pegaElementosColuna(int linha, int coluna, int[][] matriz) {
		Set<Integer> listaElementos = new HashSet<>();
		
		for (int i = 0; i < matriz.length; i++) {
			if(i != linha && matriz[i][coluna] != 0) {
				listaElementos.add(matriz[i][coluna]);
			}
		}
 		
		return listaElementos;
	}
	
	public static Set<Integer> pegaElementosQuadrante(int linha, int coluna, int[][] matriz) {
		Set<Integer> conjuntoElementos = new HashSet<>();
		
		if(linha == 4 && coluna == 4) {
			conjuntoElementos = pegaElementosQuadrante4X4(linha, coluna, matriz);
			
		} else if(linha == 9 && coluna == 9) {
			conjuntoElementos = pegaElementosQuadrante9X9(linha, coluna, matriz);
		}
		
		return conjuntoElementos;
	}
	
	public static Set<Integer> pegaElementosQuadrante4X4(int linha, int coluna, int[][] matriz) {
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
				if(i != linha && j != coluna && matriz[i][j] != 0) {
					listaElementos.add(matriz[i][j]);
				}
			}
		}
		
		return listaElementos;
	}
	
	public static Set<Integer> pegaElementosQuadrante9X9(int linha, int coluna, int[][] matriz) {
		Set<Integer> listaElementos = new HashSet<>();
		
		int linhaInicio = 0;
		int linhaFim = 0;
		int colunaInicio = 0;
		int colunaFim = 0;
		
		if(linha < 3) {
			linhaInicio = 0;
			linhaFim = 3;

			if(coluna < 3) {
				colunaInicio = 0;
				colunaFim = 3;
			} else if(coluna > 3 && coluna < 6) {
				colunaInicio = 3;
				colunaFim = 6;
			} else {
				colunaInicio = 6;
				colunaFim = 9;
			}
			
		} else if(linha >= 3 && linha < 6) {

			linhaInicio = 3;
			linhaFim = 6;

			if(coluna < 3) {
				colunaInicio = 0;
				colunaFim = 3;
			} else if(coluna > 3 && coluna < 6) {
				colunaInicio = 3;
				colunaFim = 6;
			} else if(coluna > 6 && coluna < 9) {
				colunaInicio = 6;
				colunaFim = 9;
			}

		} else if(linha >= 6 && linha < 9) {
			
			linhaInicio = 6;
			linhaFim = 9;

			if(coluna < 3) {
				colunaInicio = 0;
				colunaFim = 3;
			} else if(coluna > 3 && coluna < 6) {
				colunaInicio = 3;
				colunaFim = 6;
			} else if(coluna > 6 && coluna < 9) {
				colunaInicio = 6;
				colunaFim = 9;
			}
		}
		
		for (int i = linhaInicio; i < linhaFim; i++) {
			for (int j = colunaInicio; j < colunaFim; j++) {
				if(i != linha && j != coluna && matriz[i][j] != 0) {
					listaElementos.add(matriz[i][j]);
				}
			}
		}
		
		return listaElementos;
	}

	public static int qualColunaNumeroEstaNoQuadrante(int numeroAnalisado, int quadrante, int[][] matriz) {
		int coluna = -1;

		int linhaInicio = -1;
		int linhaFim = -1;
		int colunaInicio = -1;
		int colunaFim = -1;
		
		// linhas 0, 1, 2 
		if(quadrante == 1) {
			
			linhaInicio = 0;
			linhaFim = 2;
			colunaInicio = 0;
			colunaFim = 2;
		} 
		else if(quadrante == 2) {
			
			linhaInicio = 0;
			linhaFim = 2;
			colunaInicio = 3;
			colunaFim = 5;
		}
		else if(quadrante == 3) {
			
			linhaInicio = 0;
			linhaFim = 2;
			colunaInicio = 6;
			colunaFim = 8;
		}
		
		// linhas 3, 4, 5 
		else if(quadrante == 4) {
			
			linhaInicio = 3;
			linhaFim = 5;
			colunaInicio = 0;
			colunaFim = 2;
		}
		else if(quadrante == 5) {
			
			linhaInicio = 3;
			linhaFim = 5;
			colunaInicio = 3;
			colunaFim = 5;
		}
		else if(quadrante == 6) {
			
			linhaInicio = 3;
			linhaFim = 5;
			colunaInicio = 6;
			colunaFim = 8;
		}
		
		// linhas 6, 7, 8 
		else if(quadrante == 7) {
			
			linhaInicio = 6;
			linhaFim = 8;
			colunaInicio = 0;
			colunaFim = 2;
		}
		else if(quadrante == 8) {
			
			linhaInicio = 6;
			linhaFim = 8;
			colunaInicio = 3;
			colunaFim = 5;
		}
		else if(quadrante == 9) {
			
			linhaInicio = 6;
			linhaFim = 8;
			colunaInicio = 6;
			colunaFim = 8;
		}
		
		for (int i = linhaInicio; i <= linhaFim; i++) {
			for (int j = colunaInicio; j <= colunaFim; j++) {
				if(matriz[i][j] == numeroAnalisado) {
					coluna = j;
					break;
				}
			}
		}
		
		return coluna;		
	}
	
	public static int retornaColunaVaziaNaLinhaNoQuadrante(int linha, List<Integer> linhasQuadrante, int[][] matriz) {
		int colunaVazia = -1;
		
		if(matriz[linha][linhasQuadrante.get(0)] == 0) colunaVazia = linhasQuadrante.get(0);  	
		if(matriz[linha][linhasQuadrante.get(1)] == 0) colunaVazia = linhasQuadrante.get(1);  	
		if(matriz[linha][linhasQuadrante.get(2)] == 0) colunaVazia = linhasQuadrante.get(2);  	
		
		return colunaVazia;
	}

	public static int existeNumeroNaLinha(int numero, int linha, int[][] matriz) {
		int retorno = 0;
		
		for (int j = 0; j < matriz.length; j++) {
			if(matriz[linha][j] == numero) {
				retorno = 1;
				break;
			}
		}
		return retorno;
	}	
	
	public static int existeNumeroNaColuna(int numero, int coluna, int[][] matriz) {
		int retorno = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[i][coluna] == numero) {
				retorno = 1;
				break;
			}
		}
		return retorno;
	}
	
	public static int retornaLinhaVaziaNaColunaNoQuadrante(int coluna, List<Integer> linhasQuadrante, int[][] matriz) {
		int linhaVazia = -1;
		
		if(matriz[linhasQuadrante.get(0)][coluna] == 0) linhaVazia = linhasQuadrante.get(0);  	
		if(matriz[linhasQuadrante.get(1)][coluna] == 0) linhaVazia = linhasQuadrante.get(1);  	
		if(matriz[linhasQuadrante.get(2)][coluna] == 0) linhaVazia = linhasQuadrante.get(2);  	
		
		return linhaVazia;
	}
	
	public static void setValorNaLinhaColuna(int valor, int linha, int coluna, int[][] matriz, String regraId) {

		if(matriz[linha][coluna] == 0) {
			System.out.println("|>>>>>>>>>>  Setando valor => ("+linha+","+coluna+")="+valor+" Regra="+regraId+" ]");
			matriz[linha][coluna] = valor;	
		} else {
			System.out.print("\nSudoku: Não é possível setar numero em celula preenchida.  ");
			System.out.println(" | => ("+linha+","+coluna+")="+valor+" Regra="+regraId+" ]");
		}
		
	}
	
	public static boolean existeCelulaVazia(int[][] matriz) {
		boolean achouCelulaVazia = false;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0) {
					achouCelulaVazia = true;
					break;
				}
						
			}
		}
		return achouCelulaVazia;
	}
	
	public static void imprimeMatriz(int[][] matriz) {
		System.out.print("");
		for (int i = 0; i < matriz.length; i++) {
			System.out.print(i+" [");
			for (int j = 0; j < matriz[i].length; j++) {
				
				if(j != matriz[i].length-1) {
					
					if(matriz[i][j] != 0) {
						System.out.print(" "+matriz[i][j]);	
					} else {
						System.out.print(" _");
					}
					
				}
				else {
					
					if(matriz[i][j] != 0) {
						System.out.println(" "+matriz[i][j]+" ]");

					} else {
						System.out.println(" _ ]");
					}
				}
			}
		}
	}

//	public static boolean verficaInconsistenciaMatriz(int[][] matriz) {
//		boolean achouInconsistencia = false;
//
//		int valor = -1;
//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz[i].length; j++) {
//				if(matriz[i][j] != 0) {
//					valor = matriz[i][j];
//					if(existeNumeroMatriz(valor, i, j, matriz)) {
//						System.out.println(i+","+j+"="+valor);
//						achouInconsistencia = true;
//						break;
//					}
//				}
//			}
//		}
//		return achouInconsistencia;
//	}
	
	public static boolean existeNumeroMatriz(int valor, int linha, int coluna, int[][] matriz) {
		boolean achouInconsistencia = false;

		Set<Integer> conjuntoLinha = SudokuUtil.pegaElementosLinha(linha, coluna,  matriz);
		Set<Integer> conjuntoColuna = SudokuUtil.pegaElementosColuna(linha, coluna, matriz);
		Set<Integer> conjuntoQuadrante = SudokuUtil.pegaElementosQuadrante(linha, coluna, matriz);
		
		if(conjuntoLinha.contains(valor)) {
			System.out.print("Valor= "+valor+" [ ");
			conjuntoLinha.forEach(num->System.out.print(num+" "));
			System.out.println("] ");
			achouInconsistencia = true;
		}
		if(!achouInconsistencia) {
			if(conjuntoColuna.contains(valor)) {
				System.out.print("Valor= "+valor+" [");
				conjuntoColuna.forEach(num->System.out.print(num+" "));
				System.out.println("] ");
				achouInconsistencia = true;
			}
		}
		if(!achouInconsistencia) {
			if(conjuntoQuadrante.contains(valor)) {
				System.out.print("Valor= "+valor+" [");
				conjuntoQuadrante.forEach(num->System.out.print(num+" "));
				System.out.println("] ");
				achouInconsistencia = true;
			}
		}

		return achouInconsistencia;
	}	
	
	public static boolean existeCelula01Possib(int[][] matriz) {
		boolean achouCelula01Possib = false;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if( (matriz[i][j] == 0) &&  (SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size() == 1) ) {
					achouCelula01Possib = true;
					break;
				}
			}
		}
		return achouCelula01Possib;
	}
	
	public static String retornaCelula01Possib(int[][] matriz) {
		String str = "";

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if( (matriz[i][j] == 0) && (SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size() == 1) ) {
					str= i+","+j+","+SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(0);
					break;
				}
			}
		}
		return str;
	}
	
}
