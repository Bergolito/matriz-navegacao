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
	
	// TODO Diminuir de 29 para 15
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
	
	public String retornaCelula01Possib(int[][] matriz) {
		String str = "";

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(qtdPossibilidadesCelula(i, j, matriz).size() == 1) {
					str= i+","+j+","+qtdPossibilidadesCelula(i, j, matriz).get(0);
					break;
				}
			}
		}
		return str;
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
	
	public void imprimeMatrizPossibilidades(int[][] matriz) {
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
	
	public void analisaNumerosNaHorizontal(int[][] matriz) {
		//
		// Analisa os quadrantes 1,2,3
		List<Integer> valoresPossiveis = new ArrayList<>();
		valoresPossiveis.clear();
		valoresPossiveis.add(0); valoresPossiveis.add(1); valoresPossiveis.add(2);
		List<Integer> quadrantesAnalisados = new ArrayList<>();
		quadrantesAnalisados.clear();
		quadrantesAnalisados.add(1);quadrantesAnalisados.add(2);quadrantesAnalisados.add(3);
		analisaCamadaHorizontal(matriz, valoresPossiveis, quadrantesAnalisados);

		// Analisa os quadrantes 4,5,6
		valoresPossiveis.clear();
		valoresPossiveis.add(3); valoresPossiveis.add(4); valoresPossiveis.add(5);
		quadrantesAnalisados.clear();
		quadrantesAnalisados.add(4);quadrantesAnalisados.add(5);quadrantesAnalisados.add(6);
		analisaCamadaHorizontal(matriz, valoresPossiveis, quadrantesAnalisados);

		// Analisa os quadrantes 7,8,9
		valoresPossiveis.clear();
		valoresPossiveis.add(6); valoresPossiveis.add(7); valoresPossiveis.add(8);
		quadrantesAnalisados.clear();
		quadrantesAnalisados.add(7);quadrantesAnalisados.add(8);quadrantesAnalisados.add(9);
		analisaCamadaHorizontal(matriz, valoresPossiveis, quadrantesAnalisados);
	}
	
	public void analisaNumerosNaVertical(int[][] matriz) {
		//
		// Analisa os quadrantes 1,4,7
		List<Integer> valoresPossiveis = new ArrayList<>();
		valoresPossiveis.clear();
		valoresPossiveis.add(0); valoresPossiveis.add(1); valoresPossiveis.add(2);
		List<Integer> quadrantesAnalisados = new ArrayList<>();
		quadrantesAnalisados.clear();
		quadrantesAnalisados.add(1);quadrantesAnalisados.add(4);quadrantesAnalisados.add(7);
		analisaCamadaVertical(matriz, valoresPossiveis, quadrantesAnalisados);

		// Analisa os quadrantes 2,5,8
		valoresPossiveis.clear();
		valoresPossiveis.add(3); valoresPossiveis.add(4); valoresPossiveis.add(5);
		quadrantesAnalisados.clear();
		quadrantesAnalisados.add(2);quadrantesAnalisados.add(5);quadrantesAnalisados.add(8);
		analisaCamadaVertical(matriz, valoresPossiveis, quadrantesAnalisados);

		// Analisa os quadrantes 3,6,9
		valoresPossiveis.clear();
		valoresPossiveis.add(6); valoresPossiveis.add(7); valoresPossiveis.add(8);
		quadrantesAnalisados.clear();
		quadrantesAnalisados.add(3);quadrantesAnalisados.add(6);quadrantesAnalisados.add(9);
		analisaCamadaVertical(matriz, valoresPossiveis, quadrantesAnalisados);
	}
	
	public void analisaCamadaVertical(
			int[][] matriz, List<Integer> valoresPossiveis, List<Integer> quandrantesPossiveis) {
		
		int numeroAnalisado = 0;
		int quadrante1 = 0;
		int quadrante2 = 0;
		int quadrante3 = 0;	
		// 
		int linhaFalta = -1;	
		int colunaFalta = -1;
		//
		int colunaQuadrante01 = -1;
		int colunaQuadrante02 = -1;
		int colunaQuadrante03 = -1;
		
		int linhaAnalisar01 = -1;
		int linhaAnalisar02 = -1;
		int linhaAnalisar03 = -1;
		
		List<Integer> linhasQuadrante = new ArrayList<>();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				if(matriz[i][j] != 0) {
					numeroAnalisado = matriz[i][j];
					quadrante1 = existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz);
					quadrante2 = existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz);
					quadrante3 = existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz);
					
					if( (quadrante1 + quadrante2 + quadrante3) == 2) {
						
						System.out.println("Analisando ("+i+","+j+") = "+numeroAnalisado+"... ");

						// analisa o numero horizontalmente no quadrante que faltou
						if(quadrante1 == 0) {
							linhasQuadrante.clear();
							linhasQuadrante.add(0);
							linhasQuadrante.add(1);
							linhasQuadrante.add(2);
							
						} else if(quadrante2 == 0) {
							linhasQuadrante.clear();
							linhasQuadrante.add(3);
							linhasQuadrante.add(4);
							linhasQuadrante.add(5);
							
						} else if(quadrante3 == 0) {
							linhasQuadrante.clear();
							linhasQuadrante.add(6);
							linhasQuadrante.add(7);
							linhasQuadrante.add(8);
						}
						
						// analisa 
						
						colunaQuadrante01 = qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz); // 2
						colunaQuadrante02 = qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz); // 1
						colunaQuadrante03 = qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz); // -1
						
						List<Integer> numerosEncontrados = new ArrayList<>();
						
						// quadrante 01
						if(colunaQuadrante01 == -1) {
							numerosEncontrados.add(colunaQuadrante02);
							numerosEncontrados.add(colunaQuadrante03);
						}

						// quadrante 02
						if(colunaQuadrante02 == -1) {
							numerosEncontrados.add(colunaQuadrante01);
							numerosEncontrados.add(colunaQuadrante03);
						}
						
						// quadrante 03
						if(colunaQuadrante03 == -1) {
							numerosEncontrados.add(colunaQuadrante01);
							numerosEncontrados.add(colunaQuadrante02);
						}
						
						// ver a diferenca
						colunaFalta =  valoresPossiveis.stream()
								.distinct().
								filter(aObject -> !numerosEncontrados.contains(aObject)).
								collect(Collectors.toList()).get(0);
						
						linhaAnalisar01 = existeNumeroNaLinha(numeroAnalisado, valoresPossiveis.get(0), matriz); // 1
						linhaAnalisar02 = existeNumeroNaLinha(numeroAnalisado, valoresPossiveis.get(1), matriz); // 0
						linhaAnalisar03 = existeNumeroNaLinha(numeroAnalisado, valoresPossiveis.get(2), matriz); // 1
						
						if( (linhaAnalisar01 + linhaAnalisar02 + linhaAnalisar03)  == 2) {
							
							//
							if(linhaAnalisar01 == 0) {
								linhaFalta = linhasQuadrante.get(0);
							} else if(linhaAnalisar02 == 0) {
								linhaFalta = linhasQuadrante.get(1);
							} else if(linhaAnalisar03 == 0) {
								linhaFalta = linhasQuadrante.get(2);
							}
							
							if(linhaFalta != -1 && colunaFalta != -1) {
								setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz);
								imprimeMatriz(matriz);
								imprimeMatrizPossibilidades(matriz);
								
								String[] celula01Possib = null;
								if(existeCelula01Possib(matriz)) {
									celula01Possib = retornaCelula01Possib(matriz).split(",");
									setValorNaLinhaColuna(Integer.parseInt(celula01Possib[2]), Integer.parseInt(celula01Possib[0]), Integer.parseInt(celula01Possib[1]), matriz);
								}
								
							}
						}
					}
				}
			}
		}
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
		// analisa na horizontal
		analisaNumerosNaHorizontal(matriz);
		
		// analisa na vertical
		analisaNumerosNaVertical(matriz);
	}
	
	private void analisaCamadaHorizontal(
			int[][] matriz, List<Integer> valoresPossiveis, List<Integer> quandrantesPossiveis) {
		//
		int numeroAnalisado = 0;
		int quadrante1 = 0;
		int quadrante2 = 0;
		int quadrante3 = 0;	
		// 
		int linhaFalta = -1;	
		int colunaFalta = -1;
		//
		int linhaQuadrante01 = -1;
		int linhaQuadrante02 = -1;
		int linhaQuadrante03 = -1;
		
		int colunaAnalisar01 = -1;
		int colunaAnalisar02 = -1;
		int colunaAnalisar03 = -1;
		
		List<Integer> colunasQuadrante = new ArrayList<>();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				if(matriz[i][j] != 0) {
					numeroAnalisado = matriz[i][j];
					quadrante1 = existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz);
					quadrante2 = existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz);
					quadrante3 = existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz);
					
					if( (quadrante1 + quadrante2 + quadrante3) == 2) {
						
						System.out.println("Analisando ("+i+","+j+") = "+numeroAnalisado+"... ");
						
						// analisa o numero verticalmente no quadrante que faltou
						if(quadrante1 == 0) {
							colunasQuadrante.clear();
							colunasQuadrante.add(0);
							colunasQuadrante.add(1);
							colunasQuadrante.add(2);
							
						} else if(quadrante2 == 0) {
							colunasQuadrante.clear();
							colunasQuadrante.add(3);
							colunasQuadrante.add(4);
							colunasQuadrante.add(5);
							
						} else if(quadrante3 == 0) {
							colunasQuadrante.clear();
							colunasQuadrante.add(6);
							colunasQuadrante.add(7);
							colunasQuadrante.add(8);
						}
						
						// analisa 
						linhaQuadrante01 = qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz); // 1
						linhaQuadrante02 = qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz); // -1
						linhaQuadrante03 = qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz); // 2
						
						int contadorQuadrantesVazios = 0;
						
						if(linhaQuadrante01 == -1) contadorQuadrantesVazios++;
						if(linhaQuadrante02 == -1) contadorQuadrantesVazios++;
						if(linhaQuadrante03 == -1) contadorQuadrantesVazios++;
						
						if(contadorQuadrantesVazios == 1) {

							List<Integer> numerosEncontrados = new ArrayList<>();
							
							// quadrante 01
							if(linhaQuadrante01 == -1) {
								numerosEncontrados.add(linhaQuadrante02);
								numerosEncontrados.add(linhaQuadrante03);
							}

							// quadrante 02
							if(linhaQuadrante02 == -1) {
								numerosEncontrados.add(linhaQuadrante01);
								numerosEncontrados.add(linhaQuadrante03);
							}
							
							// quadrante 03
							if(linhaQuadrante03 == -1) {
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
								if(colunaAnalisar01 == 0) {
									colunaFalta = colunasQuadrante.get(0);
								} else if(colunaAnalisar02 == 0) {
									colunaFalta = colunasQuadrante.get(1);
								} else if(colunaAnalisar03 == 0) {
									colunaFalta = colunasQuadrante.get(2);
								}
								
								if(linhaFalta != -1 && colunaFalta != -1) {
									setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz);
									imprimeMatriz(matriz);
									imprimeMatrizPossibilidades(matriz);
									
									String[] celula01Possib = null;
									if(existeCelula01Possib(matriz)) {
										celula01Possib = retornaCelula01Possib(matriz).split(",");
										setValorNaLinhaColuna(Integer.parseInt(celula01Possib[2]), Integer.parseInt(celula01Possib[0]), Integer.parseInt(celula01Possib[1]), matriz);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private int existeNumeroNaLinha(int numero, int linha, int[][] matriz) {
		int retorno = 0;
		
		for (int j = 0; j < matriz.length; j++) {
			if(matriz[linha][j] == numero) {
				retorno = 1;
				break;
			}
			
		}
		return retorno;
	}	
	
	private int existeNumeroNaColuna(int numero, int coluna, int[][] matriz) {
		int retorno = 0;
		
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

	public int qualColunaNumeroEstaNoQuadrante(int numeroAnalisado, int quadrante, int[][] matriz) {
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
	
	public int existeNumeroQuadrante(int numero, int quadrante, int[][] matriz) {
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
