package br.com.bbb.game.lines;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sudoku {
	
	private List<Posicao> listaCelulas02Possibs = new ArrayList<>();
	
	public Sudoku() {
		//
	}

	public Sudoku(int lin, int col, int[][] mat) {
		mat = new int[lin][col];
	}
	
	public void analisaNumerosNaHorizontal(int[][] matriz) {
		// Analisa os quadrantes 1,2,3
		analisaCamadaHorizontal01(matriz);
		
		// Analisa os quadrantes 4,5,6
		analisaCamadaHorizontal02(matriz);
		
		// Analisa os quadrantes 7,8,9
		analisaCamadaHorizontal03(matriz);
	}
	
	public void analisaCamadaHorizontal01(int[][] matriz) {
		List<Integer> linhasPossiveis = new ArrayList<>();
		linhasPossiveis.add(0); 
		linhasPossiveis.add(1); 
		linhasPossiveis.add(2);
		
		List<Integer> quadrantesAnalisados = new ArrayList<>();
		quadrantesAnalisados.add(1);
		quadrantesAnalisados.add(2);
		quadrantesAnalisados.add(3);
		analisaCamadaHorizontal(matriz, linhasPossiveis, quadrantesAnalisados);
	}
	
	public void analisaCamadaHorizontal02(int[][] matriz) {
		List<Integer> linhasPossiveis = new ArrayList<>();
		linhasPossiveis.add(3); 
		linhasPossiveis.add(4); 
		linhasPossiveis.add(5);
		
		List<Integer> quadrantesAnalisados = new ArrayList<>();
		quadrantesAnalisados.add(4);
		quadrantesAnalisados.add(5);
		quadrantesAnalisados.add(6);
		
		analisaCamadaHorizontal(matriz, linhasPossiveis, quadrantesAnalisados);
	}
	
	public void analisaCamadaHorizontal03(int[][] matriz) {
		List<Integer> linhasPossiveis = new ArrayList<>();
		linhasPossiveis.add(6); 
		linhasPossiveis.add(7); 
		linhasPossiveis.add(8);
		
		List<Integer> quadrantesAnalisados = new ArrayList<>();
		quadrantesAnalisados.add(7);
		quadrantesAnalisados.add(8);
		quadrantesAnalisados.add(9);
		
		analisaCamadaHorizontal(matriz, linhasPossiveis, quadrantesAnalisados);
	}
	
	public void analisaNumerosNaVertical(int[][] matriz) {
		// Analisa os quadrantes 1,4,7
		analisaCamadaVertical01(matriz);
		
		// Analisa os quadrantes 2,5,8
		analisaCamadaVertical02(matriz);
		
		// Analisa os quadrantes 3,6,9
		analisaCamadaVertical03(matriz);
	}
	
	public void analisaCamadaVertical01(int[][] matriz) {
		List<Integer> colunasPossiveis = new ArrayList<>();
		colunasPossiveis.add(0); 
		colunasPossiveis.add(1); 
		colunasPossiveis.add(2);
		
		List<Integer> quadrantesAnalisados = new ArrayList<>();
		quadrantesAnalisados.add(1);
		quadrantesAnalisados.add(4);
		quadrantesAnalisados.add(7);
		
		analisaCamadaVertical(matriz, colunasPossiveis, quadrantesAnalisados);
	}
	
	public void analisaCamadaVertical02(int[][] matriz) {
		List<Integer> colunasPossiveis = new ArrayList<>();
		colunasPossiveis.add(3); 
		colunasPossiveis.add(4); 
		colunasPossiveis.add(5);
		
		List<Integer> quadrantesAnalisados = new ArrayList<>();
		quadrantesAnalisados.add(2);
		quadrantesAnalisados.add(5);
		quadrantesAnalisados.add(8);
		analisaCamadaVertical(matriz, colunasPossiveis, quadrantesAnalisados);
	}
	
	public void analisaCamadaVertical03(int[][] matriz) {
		List<Integer> colunasPossiveis = new ArrayList<>();
		colunasPossiveis.add(6); 
		colunasPossiveis.add(7); 
		colunasPossiveis.add(8);
		
		List<Integer> quadrantesAnalisados = new ArrayList<>();
		quadrantesAnalisados.add(3);
		quadrantesAnalisados.add(6);
		quadrantesAnalisados.add(9);
		
		analisaCamadaVertical(matriz, colunasPossiveis, quadrantesAnalisados);
	}

	public List<Integer> retornaListaQuadrantesHorizontais(int i) {
		List<Integer> quandrantesAnalisados = new ArrayList<>();
		if(i >= 0 && i <= 2) {
			quandrantesAnalisados.add(1);
			quandrantesAnalisados.add(2);
			quandrantesAnalisados.add(3);
			
		} else if(i >= 3 && i <= 5) {
			quandrantesAnalisados.add(4);
			quandrantesAnalisados.add(5);
			quandrantesAnalisados.add(6);
			
		} else if(i >= 6 && i <= 8) {
			quandrantesAnalisados.add(7);
			quandrantesAnalisados.add(8);
			quandrantesAnalisados.add(9);
		}
		return quandrantesAnalisados;
	}

	public List<Integer> retornaListaQuadrantesVerticais(int j) {
		List<Integer> quandrantesAnalisados = new ArrayList<>();
		if(j >= 0 && j <= 2) {
			quandrantesAnalisados.add(1);
			quandrantesAnalisados.add(4);
			quandrantesAnalisados.add(7);
			
		} else if(j >= 3 && j <= 5) {
			quandrantesAnalisados.add(2);
			quandrantesAnalisados.add(5);
			quandrantesAnalisados.add(8);
			
		} else if(j >= 6 && j <= 8) {
			quandrantesAnalisados.add(3);
			quandrantesAnalisados.add(6);
			quandrantesAnalisados.add(9);
		}	
		return quandrantesAnalisados;
	}
	
	// TODO Reduzir de 161 para 15
	public void analisaCamadaVerticalOLDOLD(
			int[][] matriz, List<Integer> colunasPossiveis, List<Integer> quandrantesPossiveis) {
		
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
		
		int colunaInicio = colunasPossiveis.get(0);
		int colunaFim = colunasPossiveis.get(2);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = colunaInicio; j <= colunaFim; j++) {
				
				if(matriz[i][j] != 0) {
					numeroAnalisado = matriz[i][j];
					
					quandrantesPossiveis.clear();
					quandrantesPossiveis.addAll(retornaListaQuadrantesVerticais(j));
					quadrante1 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz);
					quadrante2 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz);
					quadrante3 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz);
					
					if( (quadrante1 + quadrante2 + quadrante3) == 2) {
						
						System.out.println("Analisando na vertical ("+i+","+j+") = "+numeroAnalisado+"... ");

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
						colunaQuadrante01 = SudokuUtil.qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz); // 2
						colunaQuadrante02 = SudokuUtil.qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz); // 1
						colunaQuadrante03 = SudokuUtil.qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz); // -1

						int contadorQuadrantesVazios = 0;
						if(colunaQuadrante01 == -1) contadorQuadrantesVazios++;
						if(colunaQuadrante02 == -1) contadorQuadrantesVazios++;
						if(colunaQuadrante03 == -1) contadorQuadrantesVazios++;
						
						if(contadorQuadrantesVazios == 1) {
							
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
							colunaFalta =  colunasPossiveis.stream()
									.distinct().
									filter(aObject -> !numerosEncontrados.contains(aObject)).
									collect(Collectors.toList()).get(0);
							
							// TODO Verifica quantas celulas estão preenchidas naquele quadrante e naquela coluna
							int celulasPrenchidas = SudokuUtil.qtdCelulasPreenchidasNasLinhasNaColuna(linhasQuadrante, colunaFalta, matriz);

							// Se celulasPrenchidas == 2 OK, só tem uma celula vazia na colua
							// seta o valor
							if(celulasPrenchidas == 1) {
								
								// nas linhas não preenchidas, verifica se numero existe na linha
								if(matriz[linhasQuadrante.get(0)][colunaFalta] != 0) { // está preenchida
									linhaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(1), matriz); 
									linhaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(2), matriz);
									
									if( (linhaAnalisar01 + linhaAnalisar02 ) == 1) {
										//
										if(linhaAnalisar01 == 0) {
											linhaFalta = linhasQuadrante.get(1);
										} else if(linhaAnalisar02 == 0) {
											linhaFalta = linhasQuadrante.get(2);
										} 
										//
										SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03");
										SudokuUtil.imprimeMatriz(matriz);
										
										//
										analisaNumerosNaHorizontal(matriz);
									}
									
								}
								else if(matriz[linhasQuadrante.get(1)][colunaFalta] != 0) {
									linhaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(0), matriz); 
									linhaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(2), matriz);
									
									if( (linhaAnalisar01 + linhaAnalisar02 ) == 1) {
										//
										if(linhaAnalisar01 == 0) {
											linhaFalta = linhasQuadrante.get(0);
										} else if(linhaAnalisar02 == 0) {
											linhaFalta = linhasQuadrante.get(2);
										} 
										//
										SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03");
										SudokuUtil.imprimeMatriz(matriz);
										//
										analisaNumerosNaHorizontal(matriz);
									}
									
								}
								else if(matriz[linhasQuadrante.get(2)][colunaFalta] != 0) {
									linhaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(0), matriz); 
									linhaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(1), matriz);
									
									if( (linhaAnalisar01 + linhaAnalisar02 ) == 1) {
										//
										if(linhaAnalisar01 == 0) {
											linhaFalta = linhasQuadrante.get(0);
										} else if(linhaAnalisar02 == 0) {
											linhaFalta = linhasQuadrante.get(1);
										} 
										//
										SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03");
										SudokuUtil.imprimeMatriz(matriz);
										//
										analisaNumerosNaHorizontal(matriz);
									}
									
								}
								
								
							}
							else if(celulasPrenchidas == 2) {

								linhaFalta = SudokuUtil.retornaLinhaVaziaNaColunaNoQuadrante(colunaFalta, linhasQuadrante, matriz);
								SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03");
								SudokuUtil.imprimeMatriz(matriz);
								
							} else {

								linhaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(0), matriz); // 1
								linhaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(1), matriz); // 0
								linhaAnalisar03 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(2), matriz); // 1

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
										SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03");
										SudokuUtil.imprimeMatriz(matriz);
										
										String[] celula01Possib = null;
										if(SudokuUtil.existeCelula01Possib(matriz)) {
											celula01Possib = SudokuUtil.retornaCelula01Possib(matriz).split(",");
											SudokuUtil.setValorNaLinhaColuna(
												Integer.parseInt(celula01Possib[2]), 
												Integer.parseInt(celula01Possib[0]), 
												Integer.parseInt(celula01Possib[1]), 
												matriz, "RG01");
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void analisaSolucao(int[][] matriz) {
		
		// analisa na horizontal
	    analisaNumerosNaHorizontal(matriz);
		
		// analisa na vertical
		analisaNumerosNaVertical(matriz);
	}
	
	public boolean verificaInconsistencia(int[][] matriz) {
		boolean inconsistencia = false;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0) {
					if(SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size() == 0) {
						System.out.println("\n\n Achou celula sem possibilidade => ("+i+","+j+") . Matriz incosistente!!!");
						inconsistencia = true;
						break;
					}
				}
			}
		}
		return inconsistencia;
	}
	
	public List<Integer> linhasQuadrantesNaoPreenchido(
			int quadrante1, int quadrante2, int quadrante3) {
			List<Integer> linhasQuadrante = new ArrayList<>();
			
			// analisa o numero verticalmente no quadrante que faltou
			if(quadrante1 == 0) {
				linhasQuadrante.add(0);
				linhasQuadrante.add(1);
				linhasQuadrante.add(2);
				
			} else if(quadrante2 == 0) {
				linhasQuadrante.add(3);
				linhasQuadrante.add(4);
				linhasQuadrante.add(5);
				
			} else if(quadrante3 == 0) {
				linhasQuadrante.add(6);
				linhasQuadrante.add(7);
				linhasQuadrante.add(8);
			}
			return linhasQuadrante;
		}
	
	public List<Integer> colunasQuadrantesNaoPreenchido(
		int quadrante1, int quadrante2, int quadrante3) {
		List<Integer> colunasQuadrante = new ArrayList<>();
		
		// analisa o numero verticalmente no quadrante que faltou
		if(quadrante1 == 0) {
			colunasQuadrante.add(0);
			colunasQuadrante.add(1);
			colunasQuadrante.add(2);
			
		} else if(quadrante2 == 0) {
			colunasQuadrante.add(3);
			colunasQuadrante.add(4);
			colunasQuadrante.add(5);
			
		} else if(quadrante3 == 0) {
			colunasQuadrante.add(6);
			colunasQuadrante.add(7);
			colunasQuadrante.add(8);
		}
		return colunasQuadrante;
	}

	
	public List<Integer> retornaNumerosEncontrados(int linhaQuadrante01, int linhaQuadrante02, int linhaQuadrante03) {
		List<Integer> numerosEncontrados = new ArrayList<>();
		
		// quadrante 01
		if(linhaQuadrante01 == -1) {
			numerosEncontrados.add(linhaQuadrante02);
			numerosEncontrados.add(linhaQuadrante03);
		}
		// quadrante 02
		else if(linhaQuadrante02 == -1) {
			numerosEncontrados.add(linhaQuadrante01);
			numerosEncontrados.add(linhaQuadrante03);
		}
		// quadrante 03
		else if(linhaQuadrante03 == -1) {
			numerosEncontrados.add(linhaQuadrante01);
			numerosEncontrados.add(linhaQuadrante02);
		}
		return numerosEncontrados;
	}
	
	private void analisaCamadaHorizontal01CelulaPrenchida(
			int[][] matriz, List<Integer> colunasQuadrante,
			int numeroAnalisado, int linhaFalta, int colunaFalta) {
	
		int colunaAnalisar01 = -1;
		int colunaAnalisar02 = -1;
		int colunaVazia01 = -1;
		int colunaVazia02 = -1;

		// deve analisar apenas as colunas que estão vazias naquela linha
		if(matriz[linhaFalta][colunasQuadrante.get(0)] == 0 && matriz[linhaFalta][colunasQuadrante.get(1)] == 0) {
			colunaVazia01 = colunasQuadrante.get(0);
			colunaVazia02 = colunasQuadrante.get(1);
		}
		else if(matriz[linhaFalta][colunasQuadrante.get(0)] == 0 && matriz[linhaFalta][colunasQuadrante.get(2)] == 0) {
			colunaVazia01 = colunasQuadrante.get(0);
			colunaVazia02 = colunasQuadrante.get(2);
		}
		else if(matriz[linhaFalta][colunasQuadrante.get(1)] == 0 && matriz[linhaFalta][colunasQuadrante.get(2)] == 0) {
			colunaVazia01 = colunasQuadrante.get(1);
			colunaVazia02 = colunasQuadrante.get(2);
		}
		
		// nas linhas não preenchidas, verifica se numero existe na linha
		colunaAnalisar01 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunaVazia01, matriz); 
		colunaAnalisar02 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunaVazia02, matriz);
		
		if( (colunaAnalisar01 + colunaAnalisar02 ) == 1) {
			if(colunaAnalisar01 == 0) {
				colunaFalta = colunaAnalisar01;
			} else if(colunaAnalisar02 == 0) {
				colunaFalta = colunaAnalisar02;
			} 
			//
			SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03");
			SudokuUtil.imprimeMatriz(matriz);
			analisaNumerosNaVertical(matriz);
		}
	}

	private void analisaCamadaVertical01CelulaPrenchida(
			int[][] matriz,  
			List<Integer> linhasQuadrante,
			int numeroAnalisado, int colunaFalta) {
	
		int linhaAnalisar01 = -1;
		int linhaAnalisar02 = -1;
		int linhaVazia01 = -1;
		int linhaVazia02 = -1;		
		
		if(matriz[linhasQuadrante.get(0)][colunaFalta] == 0 && matriz[linhasQuadrante.get(1)][colunaFalta] == 0) {
			linhaVazia01 = linhasQuadrante.get(0);
			linhaVazia02 = linhasQuadrante.get(1);		
		}
		if(matriz[linhasQuadrante.get(0)][colunaFalta] == 0 && matriz[linhasQuadrante.get(2)][colunaFalta] == 0) {
			linhaVazia01 = linhasQuadrante.get(0);
			linhaVazia02 = linhasQuadrante.get(2);		
		}
		if(matriz[linhasQuadrante.get(1)][colunaFalta] == 0 && matriz[linhasQuadrante.get(2)][colunaFalta] == 0) {
			linhaVazia01 = linhasQuadrante.get(1);
			linhaVazia02 = linhasQuadrante.get(2);		
		}
		
		// nas linhas não preenchidas, verifica se numero existe na linha
		linhaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhaVazia01, matriz); 
		linhaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhaVazia02, matriz);		
		
		int linhaFalta = -1; 
		if( (linhaAnalisar01 + linhaAnalisar02 ) == 1) {
			if(linhaAnalisar01 == 0) {
				linhaFalta = linhaVazia01;
			} else if(linhaAnalisar02 == 0) {
				linhaFalta = linhaVazia02;
			} 
			//
			SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03");
			SudokuUtil.imprimeMatriz(matriz);
			analisaNumerosNaVertical(matriz);
		}
	}
	
	private void analisaCamadaHorizontal02CelulasPrenchidas(
			int[][] matriz, 
			List<Integer> colunasQuadrante,
			int numeroAnalisado, int linhaFalta) {
			
		int colunaFalta = SudokuUtil.retornaColunaVaziaNaLinhaNoQuadrante(linhaFalta, colunasQuadrante, matriz);
		SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG02");
		SudokuUtil.imprimeMatriz(matriz);

		int colunaAnalisar01 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(0), matriz); // 1
		int colunaAnalisar02 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(1), matriz); // 0
		int colunaAnalisar03 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(2), matriz); // 1

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
				SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG02");
				SudokuUtil.imprimeMatriz(matriz);
				analisaNumerosNaVertical(matriz);										
			}
		}
	}

	private void analisaCamadaVertical02CelulasPrenchidas(
			int[][] matriz, 
			List<Integer> colunasQuadrante,
			int numeroAnalisado, int colunaFalta) {
			
		//int colunaFalta = SudokuUtil.retornaColunaVaziaNaLinhaNoQuadrante(linhaFalta, colunasQuadrante, matriz);
		//SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG02");
		//SudokuUtil.imprimeMatriz(matriz);
		int linhaFalta = SudokuUtil.retornaLinhaVaziaNaColunaNoQuadrante(colunaFalta, colunasQuadrante, matriz);
		
		int colunaAnalisar01 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(0), matriz); // 1
		int colunaAnalisar02 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(1), matriz); // 0
		int colunaAnalisar03 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(2), matriz); // 1

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
				SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG02");
				SudokuUtil.imprimeMatriz(matriz);
				//
				analisaNumerosNaVertical(matriz);										
			}
		}
		
	}
	
	private int retornaQuadrantesVazios(int linhaQuadrante01, int linhaQuadrante02, int linhaQuadrante03) {
		int contadorQuadrantesVazios = 0;
		if(linhaQuadrante01 == -1) contadorQuadrantesVazios++;
		if(linhaQuadrante02 == -1) contadorQuadrantesVazios++;
		if(linhaQuadrante03 == -1) contadorQuadrantesVazios++;		
		
		return contadorQuadrantesVazios;
	}
	
	// TODO Reduzir de 27 para 15
	private void analisaCamadaHorizontal(
			int[][] matriz, List<Integer> linhasPossiveis, List<Integer> quandrantesPossiveis) {
		//
		int numeroAnalisado = 0;
		int quadrante1 = 0;
		int quadrante2 = 0;
		int quadrante3 = 0;	
		int linhaFalta = -1;	
		int colunaFalta = -1;
		int linhaQuadrante01 = -1;
		int linhaQuadrante02 = -1;
		int linhaQuadrante03 = -1;
		int linhaInicio = linhasPossiveis.get(0);
		int linhaFim = linhasPossiveis.get(2);
		List<Integer> colunasQuadrante = new ArrayList<>();
		
		for (int i = linhaInicio; i <= linhaFim; i++) {
			for (int j = 0; j < matriz.length; j++) {
				
				if(matriz[i][j] != 0) {
					numeroAnalisado = matriz[i][j];
					
					quandrantesPossiveis.clear();
					quandrantesPossiveis.addAll(retornaListaQuadrantesHorizontais(i));
					
					quadrante1 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz);
					quadrante2 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz);
					quadrante3 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz);
					
					if( (quadrante1 + quadrante2 + quadrante3) == 2) {
						
						System.out.println("Analisando na Horizontal ("+i+","+j+") = "+numeroAnalisado+"... ");
						
						// analisa 
						linhaQuadrante01 = SudokuUtil.qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz); // 1
						linhaQuadrante02 = SudokuUtil.qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz); // -1
						linhaQuadrante03 = SudokuUtil.qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz); // 2
						
						int contadorQuadrantesVazios = 					
								retornaQuadrantesVazios(linhaQuadrante01, linhaQuadrante02, linhaQuadrante03); 
						
						if(contadorQuadrantesVazios == 1) {

							List<Integer> numerosEncontrados = retornaNumerosEncontrados(linhaQuadrante01, linhaQuadrante02, linhaQuadrante03);
							
							// ver a diferenca
							linhaFalta =  linhasPossiveis.stream()
									.distinct().
									filter(aObject -> !numerosEncontrados.contains(aObject)).
									collect(Collectors.toList()).get(0);
							
							// analisa o numero verticalmente no quadrante que faltou
							colunasQuadrante.clear();
							colunasQuadrante.addAll(colunasQuadrantesNaoPreenchido(quadrante1, quadrante2, quadrante3));
							
							// Verifica quantas celulas estão preenchidas naquele quadrante e naquela coluna
							int celulasPrenchidas = SudokuUtil.qtdCelulasPreenchidasNasColunasNaLinha(colunasQuadrante, linhaFalta, matriz);
							
							if(celulasPrenchidas == 1) {
								
							    // nas linhas não preenchidas, verifica se numero existe na linha
								analisaCamadaHorizontal01CelulaPrenchida(
										matriz,  
										colunasQuadrante,
										numeroAnalisado, 
										linhaFalta, 
										colunaFalta); 
								
							} // fim de if(celulasPrenchidas == 1) {
							
							// Se celulasPrenchidas == 2 OK, só tem uma celula vazia na colua
							// seta o valor
							if(celulasPrenchidas == 2) {

								analisaCamadaHorizontal02CelulasPrenchidas(
									matriz, 
									colunasQuadrante,
									numeroAnalisado, 
									linhaFalta);
								
							} // fim de if(celulasPrenchidas == 2) {
						}
					}
				}
			}
		}
	}

	// TODO Reduzir de 27 para 15
	private void analisaCamadaVertical(
			int[][] matriz, List<Integer> colunasPossiveis, List<Integer> quandrantesPossiveis) {
		//
		int numeroAnalisado = 0;
		int quadrante1 = 0;
		int quadrante2 = 0;
		int quadrante3 = 0;	
		int linhaFalta = -1;	
		int colunaFalta = -1;
		int colunaQuadrante01 = -1;
		int colunaQuadrante02 = -1;
		int colunaQuadrante03 = -1;
		int colunaInicio = colunasPossiveis.get(0);
		int colunaFim = colunasPossiveis.get(2);
		List<Integer> linhasQuadrante = new ArrayList<>();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = colunaInicio; j <= colunaFim; j++) {
				
				if(matriz[i][j] != 0) {
					numeroAnalisado = matriz[i][j];
					
					quandrantesPossiveis.clear();
					quandrantesPossiveis.addAll(retornaListaQuadrantesVerticais(i));
					
					quadrante1 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz);
					quadrante2 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz);
					quadrante3 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz);
					
					if( (quadrante1 + quadrante2 + quadrante3) == 2) {
						
						System.out.println("Analisando na Vertical ("+i+","+j+") = "+numeroAnalisado+"... ");
						
						// analisa 
						colunaQuadrante01 = SudokuUtil.qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz); // 1
						colunaQuadrante02 = SudokuUtil.qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz); // -1
						colunaQuadrante03 = SudokuUtil.qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz); // 2
						
						int contadorQuadrantesVazios = 					
								retornaQuadrantesVazios(colunaQuadrante01, colunaQuadrante02, colunaQuadrante03); 
						
						if(contadorQuadrantesVazios == 1) {

							List<Integer> numerosEncontrados = retornaNumerosEncontrados(colunaQuadrante01, colunaQuadrante02, colunaQuadrante03);
							
							// ver a diferenca
							colunaFalta =  colunasPossiveis.stream()
									.distinct().
									filter(aObject -> !numerosEncontrados.contains(aObject)).
									collect(Collectors.toList()).get(0);
							
							// analisa o numero verticalmente no quadrante que faltou
							linhasQuadrante.clear();
							linhasQuadrante.addAll(linhasQuadrantesNaoPreenchido(quadrante1, quadrante2, quadrante3));
							
							// verifica quantas celulas estão preenchidas naquele quadrante e naquela coluna
							//int celulasPrenchidas = SudokuUtil.qtdCelulasPreenchidasNasColunasNaLinha(colunasQuadrante, linhaFalta, matriz);
							int celulasPrenchidas = SudokuUtil.qtdCelulasPreenchidasNasLinhasNaColuna(linhasQuadrante, colunaFalta, matriz);
							
							if(celulasPrenchidas == 1) {
								
							    // nas linhas não preenchidas, verifica se numero existe na linha
								analisaCamadaVertical01CelulaPrenchida(
									matriz, 
									linhasQuadrante,
									numeroAnalisado, 
									colunaFalta); 
								
							} // fim de if(celulasPrenchidas == 1) {
							
							// Se celulasPrenchidas == 2 OK, só tem uma celula vazia na colua
							// seta o valor
							if(celulasPrenchidas == 2) {

								analisaCamadaVertical02CelulasPrenchidas(
									matriz, 
									linhasQuadrante,
									numeroAnalisado, 
									colunaFalta); 
								
							} // fim de if(celulasPrenchidas == 2) {
						}
					}
				}
			}
		}
	}
	
	public List<Posicao> getListaCelulas02Possibs() {
		return listaCelulas02Possibs;
	}

	public void setListaCelulas02Possibs(List<Posicao> listaCelulas02Possibs) {
		this.listaCelulas02Possibs = listaCelulas02Possibs;
	}
	
}
