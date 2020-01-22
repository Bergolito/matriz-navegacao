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
	
	// atributos
	private List<Integer> numerosPossiveis = new ArrayList<>();
	private int rows;
	private int columns;

	public Sudoku() {
		//
	}

	public Sudoku(int lin, int col, int[][] mat) {
		this.rows = lin;
		this.columns = col;
		mat = new int[lin][col];
		Integer[] arrayNumerosPossiveis = null;
		
		if(lin == 4 && col == 4) {
			arrayNumerosPossiveis = new Integer[] { 1, 2, 3, 4 };	
		} else if(lin == 9 && col == 9) {
			arrayNumerosPossiveis = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		}
		numerosPossiveis = Arrays.asList(arrayNumerosPossiveis);
	}
	
	public List<Integer> qtdPossibilidadesCelula(int linha, int coluna, int[][] matriz) {
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

		return numerosPossiveis.stream()
				.distinct().
				filter(aObject -> !elementosRetorno.contains(aObject)).
				collect(Collectors.toList());
	}
	
	private Set<Integer> pegaElementosLinha(int linha, int coluna, int[][] matriz) {
		Set<Integer> listaElementos = new HashSet<>();
		
 		for (int j = 0; j < columns; j++) {
			if(j != coluna &&  matriz[linha][j] != 0) {
				listaElementos.add(matriz[linha][j]);
			}
		}
 		
		return listaElementos;
	}

	private Set<Integer> pegaElementosColuna(int linha, int coluna, int[][] matriz) {
		Set<Integer> listaElementos = new HashSet<>();
		
		for (int i = 0; i < rows; i++) {
			if(i != linha && matriz[i][coluna] != 0) {
				listaElementos.add(matriz[i][coluna]);
			}
		}
 		
		return listaElementos;
	}
	
	private Set<Integer> pegaElementosQuadrante(int linha, int coluna, int[][] matriz) {
		Set<Integer> conjuntoElementos = new HashSet<>();
		
		if(linha == 4 && coluna == 4) {
			conjuntoElementos = pegaElementosQuadrante4X4(linha, coluna, matriz);
			
		} else if(linha == 9 && coluna == 9) {
			conjuntoElementos = pegaElementosQuadrante9X9(linha, coluna, matriz);
		}
		
		return conjuntoElementos;
	}
	
	private Set<Integer> pegaElementosQuadrante4X4(int linha, int coluna, int[][] matriz) {
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
	
	private Set<Integer> pegaElementosQuadrante9X9(int linha, int coluna, int[][] matriz) {
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
			
		} else if(linha > 3 && linha < 6) {

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

		} else if(linha > 6 && linha < 9) {
			
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
	
	public void setValorNaLinhaColuna(int valor, int linha, int coluna, int[][] matriz) {
		System.out.println("Setando valor => ("+linha+","+coluna+")="+valor);
		matriz[linha][coluna] = valor;
	}
	
	public boolean existeCelulaVazia(int[][] matriz) {
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

	public boolean existeCelula01Possib(int[][] matriz) {
		boolean achouCelula01Possib = false;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(qtdPossibilidadesCelula(i, j, matriz).size() == 1) {
					achouCelula01Possib = true;
					break;
				}
			}
		}
		return achouCelula01Possib;
	}
	
	public boolean verficaInconsistenciaMatriz(int[][] matriz) {
		boolean achouInconsistencia = false;

		int valor = -1;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] != 0) {
					valor = matriz[i][j];
					if(existeNumeroMatriz(valor, i, j, matriz)) {
						System.out.println(i+","+j+"="+valor);
						achouInconsistencia = true;
						break;
					}
				}
			}
		}
		return achouInconsistencia;
	}
	
	public boolean existeNumeroMatriz(int valor, int linha, int coluna, int[][] matriz) {
		boolean achouInconsistencia = false;

		Set<Integer> conjuntoLinha = pegaElementosLinha(linha, coluna,  matriz);
		Set<Integer> conjuntoColuna = pegaElementosColuna(linha, coluna, matriz);
		Set<Integer> conjuntoQuadrante = pegaElementosQuadrante(linha, coluna, matriz);
		
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
	
	public void imprimeMatriz(int[][] matriz) {
		System.out.println();
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("[");
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
	
	public void analisaNumerosNaHorizontal() {
		
		
	}
	
	public void tentaInferirValores(int[][] matriz) {
		List<int[][]> listaMatrizes = new ArrayList<>();
		int[][] matrizClonada1 = null;
		int[][] matrizClonada2 = null;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0) {
					matrizClonada1 = matriz.clone();
					matrizClonada2 = matriz.clone();
					
					if(qtdPossibilidadesCelula(i, j, matriz).size() == 2 ) {
						matrizClonada1[i][j] = qtdPossibilidadesCelula(i, j, matriz).get(0); 
						matrizClonada2[i][j] = qtdPossibilidadesCelula(i, j, matriz).get(1);
						
						listaMatrizes.add(matrizClonada1);
						listaMatrizes.add(matrizClonada2);
					}
				}
			}
		}
		
		int cont = 0;
		for (int[][] matX : listaMatrizes) {
			System.out.println("Matriz inferida "+(cont++));
			System.out.println("Existe inconsistencia = "+verficaInconsistenciaMatriz(matX));
			imprimeMatriz(matX);
		}
	}
	
	public void analisaSolucao(int[][] matriz) {
		//
		List<Integer> valoresPossiveis = new ArrayList<Integer>();
		valoresPossiveis.add(0);
		valoresPossiveis.add(1);
		valoresPossiveis.add(2);
		analisaCamadaHorizontal(matriz, valoresPossiveis);
		
		valoresPossiveis.clear();
		valoresPossiveis.add(3);
		valoresPossiveis.add(4);
		valoresPossiveis.add(5);
		analisaCamadaHorizontal(matriz, valoresPossiveis);
		
		valoresPossiveis.clear();
		valoresPossiveis.add(6);
		valoresPossiveis.add(7);
		valoresPossiveis.add(8);
		analisaCamadaHorizontal(matriz, valoresPossiveis);
		
		//
		//analisaCamadaVertical01(matriz);
		//analisaCamadaVertical02(matriz);
		//analisaCamadaVertical03(matriz);
	}
	
	
	private void analisaCamadaHorizontal03(int[][] matriz, List<Integer> valoresPossiveis) {
		// TODO Auto-generated method stub
		
	}

	private void analisaCamadaHorizontal02(int[][] matriz, List<Integer> valoresPossiveis) {
		// TODO Auto-generated method stub
		
	}

	private void analisaCamadaHorizontal(int[][] matriz, List<Integer> valoresPossiveis) {
		//
		int numeroAnalisado = 0;
		int quadrante1 = 0;
		int quadrante2 = 0;
		int quadrante3 = 0;	
		// 
		int linhaFalta = -1;	
		int colunaFalta = -1;
		int quadranteFalta = -1;	
		//
		int linhaQuadrante01 = -1;
		int linhaQuadrante02 = -1;
		int linhaQuadrante03 = -1;
		
		int colunaAnalisar01 = -1;
		int colunaAnalisar02 = -1;
		int colunaAnalisar03 = -1;
		
		List<Integer> colunasQuadrante = new ArrayList<Integer>();
		
		// TODO Auto-generated method stub
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				if(matriz[i][j] != 0) {
					numeroAnalisado = matriz[i][j];
					quadrante1 = existeNumeroQuadrante(numeroAnalisado, valoresPossiveis.get(0), matriz);
					quadrante2 = existeNumeroQuadrante(numeroAnalisado, valoresPossiveis.get(1), matriz);
					quadrante3 = existeNumeroQuadrante(numeroAnalisado, valoresPossiveis.get(2), matriz);
					
					if( (quadrante1 + quadrante2 + quadrante3) == 2) {
						
						System.out.println("\n\n Analisando ("+i+","+j+") = "+numeroAnalisado+" ");
						
						// analisa o numero verticalmente no quadrante que faltou
						if(quadrante1 == 0) {
							quadranteFalta = 1;
							colunasQuadrante.clear();
							colunasQuadrante.add(0);
							colunasQuadrante.add(1);
							colunasQuadrante.add(2);
							
						} else if(quadrante2 == 0) {
							quadranteFalta = 2;
							colunasQuadrante.clear();
							colunasQuadrante.add(3);
							colunasQuadrante.add(4);
							colunasQuadrante.add(5);
							
						} else if(quadrante3 == 0) {
							quadranteFalta = 3;
							colunasQuadrante.clear();
							colunasQuadrante.add(6);
							colunasQuadrante.add(7);
							colunasQuadrante.add(8);
						}
						
						// analisa 
						linhaQuadrante01 = qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, 1, matriz); // 2
						linhaQuadrante02 = qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, 2, matriz); // 1
						linhaQuadrante03 = qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, 3, matriz); // -1
						
						List<Integer> numerosEncontrados = new ArrayList<>();
						
						// quadrante 01
						if(linhaQuadrante01 != -1) {
							numerosEncontrados.add(linhaQuadrante02);
							numerosEncontrados.add(linhaQuadrante03);
						}

						// quadrante 02
						if(linhaQuadrante02 != -1) {
							numerosEncontrados.add(linhaQuadrante01);
							numerosEncontrados.add(linhaQuadrante03);
						}
						
						// quadrante 03
						if(linhaQuadrante03 != -1) {
							numerosEncontrados.add(linhaQuadrante01);
							numerosEncontrados.add(linhaQuadrante02);
						}
						
						// ver a diferenca
						linhaFalta =  valoresPossiveis.stream()
								.distinct().
								filter(aObject -> !numerosEncontrados.contains(aObject)).
								collect(Collectors.toList()).get(0);
						
						colunaAnalisar01 = existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(0), matriz); // 1
						colunaAnalisar02 = existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(1), matriz); // 0
						colunaAnalisar03 = existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(2), matriz); // 1
						
						if( (colunaAnalisar01 + colunaAnalisar02 + colunaAnalisar03)  == 2) {
							
							//
							if(colunaAnalisar02 == 0) {
								colunaFalta = 6;
							} else if(colunaAnalisar02 == 0) {
								colunaFalta = 7;
							} else if(colunaAnalisar03 == 0) {
								colunaFalta = 8;
							}
						}
						
						if(linhaFalta != -1 && colunaFalta != -1) {
							setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz);
						}
					}
					
					
				}
			}
		}
	}

	private int existeNumeroNaColuna(int numero, int coluna, int[][] matriz) {
		// TODO Auto-generated method stub
		int retorno = -1;
		
		for (int i = 0; i < matriz.length; i++) {
				
				if(matriz[i][coluna] == numero) {
					retorno = 1;
					break;
				}
		}
		return retorno;
	}

	public int qualLinhaNumeroEstaNoQuadrante(int numeroAnalisado, int quadrante, int[][] matriz) {
		int linha = -1;
		
		// linhas 0, 1, 2 
		if(quadrante == 1) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					if(matriz[i][j] == numeroAnalisado) {
						linha = i;
						break;
					}
				}
			}
		} 
		else if(quadrante == 2) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 3; j < 5; j++) {
					if(matriz[i][j] == numeroAnalisado) {
						linha = i;
						break;
					}
				}
			}
		}
		else if(quadrante == 3) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 6; j <= 8; j++) {
					if(matriz[i][j] == numeroAnalisado) {
						linha = i;
						break;
					}
				}
			}
		}
		
		// linhas 3, 4, 5 
		else if(quadrante == 4) {
			for (int i = 3; i <= 5; i++) {
				for (int j = 0; j <= 2; j++) {
					if(matriz[i][j] == numeroAnalisado) {
						linha = i;
						break;
					}
				}
			}
		}
		else if(quadrante == 5) {
			for (int i = 3; i <= 5; i++) {
				for (int j = 3; j <= 5; j++) {
					if(matriz[i][j] == numeroAnalisado) {
						linha = i;
						break;
					}
				}
			}
		}
		else if(quadrante == 6) {
			for (int i = 3; i <= 5; i++) {
				for (int j = 6; j <= 8; j++) {
					if(matriz[i][j] == numeroAnalisado) {
						linha = i;
						break;
					}
				}
			}
		}
		
		// linhas 6, 7, 8 
		else if(quadrante == 7) {
			for (int i = 6; i <= 8; i++) {
				for (int j = 0; j <= 2; j++) {
					if(matriz[i][j] == numeroAnalisado) {
						linha = i;
						break;
					}
				}
			}
		}
		else if(quadrante == 8) {
			for (int i = 6; i <= 8; i++) {
				for (int j = 3; j <= 5; j++) {
					if(matriz[i][j] == numeroAnalisado) {
						linha = i;
						break;
					}
				}
			}
		}
		else if(quadrante == 9) {
			for (int i = 6; i <= 8; i++) {
				for (int j = 6; j <= 8; j++) {
					if(matriz[i][j] == numeroAnalisado) {
						linha = i;
						break;
					}
				}
			}
		}
		return linha;		
	}
	
	public int qualColunaNumero(int numeroAnalisado) {
		
		return -1;
	}
	
	public int existeNumeroQuadrante(int numero, int quadrante, int[][] matriz) {
		int achou = 0;
		
		// linhas 0, 1, 2 
		if(quadrante == 1) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					if(matriz[i][j] == numero) {
						achou = 1;
						break;
					}
				}
			}
		}
		else if(quadrante == 2) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 3; j < 5; j++) {
					if(matriz[i][j] == numero) {
						achou = 1;
						break;
					}
				}
			}
		}
		else if(quadrante == 3) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 6; j <= 8; j++) {
					if(matriz[i][j] == numero) {
						achou = 1;
						break;
					}
				}
			}
		}
		
		// linhas 3, 4, 5 
		else if(quadrante == 4) {
			for (int i = 3; i <= 5; i++) {
				for (int j = 0; j <= 2; j++) {
					if(matriz[i][j] == numero) {
						achou = 1;
						break;
					}
				}
			}
		}
		else if(quadrante == 5) {
			for (int i = 3; i <= 5; i++) {
				for (int j = 3; j <= 5; j++) {
					if(matriz[i][j] == numero) {
						achou = 1;
						break;
					}
				}
			}
		}
		else if(quadrante == 6) {
			for (int i = 3; i <= 5; i++) {
				for (int j = 6; j <= 8; j++) {
					if(matriz[i][j] == numero) {
						achou = 1;
						break;
					}
				}
			}
		}
		
		// linhas 6, 7, 8 
		else if(quadrante == 7) {
			for (int i = 6; i <= 8; i++) {
				for (int j = 0; j <= 2; j++) {
					if(matriz[i][j] == numero) {
						achou = 1;
						break;
					}
				}
			}
		}
		else if(quadrante == 8) {
			for (int i = 6; i <= 8; i++) {
				for (int j = 3; j <= 5; j++) {
					if(matriz[i][j] == numero) {
						achou = 1;
						break;
					}
				}
			}
		}
		else if(quadrante == 9) {
			for (int i = 6; i <= 8; i++) {
				for (int j = 6; j <= 8; j++) {
					if(matriz[i][j] == numero) {
						achou = 1;
						break;
					}
				}
			}
		}
		return achou;
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
		
		int valor = -1;
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
			
		} while(sudoku.existeCelulaVazia(matriz) && sudoku.existeCelula01Possib(matriz));
		
		sudoku.imprimeMatriz(matriz);
		
		//sudoku.tentaInferirValores(matriz);
		sudoku.analisaSolucao(matriz);
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

}
