package br.com.bbb.game.lines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
	
	// TODO Reduzir de 135 para 15
	public void analisaCamadaVertical(
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
					
					if(j >= 0 && j <= 2) {
						quandrantesPossiveis.add(1);
						quandrantesPossiveis.add(4);
						quandrantesPossiveis.add(7);
						
					} else if(j >= 3 && j <= 5) {
						quandrantesPossiveis.add(2);
						quandrantesPossiveis.add(5);
						quandrantesPossiveis.add(8);
						
					} else if(j >= 6 && j <= 8) {
						quandrantesPossiveis.add(3);
						quandrantesPossiveis.add(6);
						quandrantesPossiveis.add(9);
					}
					
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
								if(matriz[linhasQuadrante.get(0)][colunaFalta] != 0) {
									linhaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(0), matriz); 
									linhaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(1), matriz);
								}
								if(matriz[linhasQuadrante.get(1)][colunaFalta] != 0) {
									linhaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(0), matriz); 
									linhaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(2), matriz);
								}
								if(matriz[linhasQuadrante.get(2)][colunaFalta] != 0) {
									linhaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(0), matriz); 
									linhaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, linhasQuadrante.get(1), matriz);
								}
								
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
		int[][] matrizOriginal = new int[matriz.length][matriz.length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matrizOriginal[i][j] = matriz[i][j];
			}
		}
		
		int numeroAleatorio = -1;
		int indiceAleatorio = -1;
		int contador = 0;
		Random random = new Random();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				contador++;
				
				if(matriz[i][j] == 0) {
					if(SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size() == 1) {
						System.out.println("\n\n\n Matriz inconsistente!!!");
						SudokuUtil.imprimeMatriz(matriz);
						
						matriz = new int[matrizOriginal.length][matrizOriginal.length];
						for (int ii = 0; ii < matrizOriginal.length; ii++) {
							for (int jj = 0; jj < matrizOriginal[ii].length; jj++) {
								matriz[ii][jj] = matrizOriginal[ii][jj];
							}
						}		
						//
						//i = 0;
						//j = 0;
					}
					if(SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size() == 1) {
						SudokuUtil.setValorNaLinhaColuna(SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(0), i, j, matriz, "RG01");
					}
					else if(SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size() >= 2) {
						indiceAleatorio = random.nextInt(SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size());
						numeroAleatorio = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(indiceAleatorio);
						SudokuUtil.setValorNaLinhaColuna(numeroAleatorio, i, j, matriz, "RGXXX");
					}
				}
				
				if(contador == 1_000_000) {
					SudokuUtil.imprimeMatriz(matriz);
					break;
				}
			}
		}
		
		SudokuUtil.imprimeMatriz(matriz);
	}
	
	public void analisaSolucao02(int[][] matriz) {
		
		// analisa na horizontal
	    analisaNumerosNaHorizontal(matriz);
		
		// analisa na vertical
		analisaNumerosNaVertical(matriz);
		
		//
		analisaMatrizPossibilidades(matriz);
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
	
	public void analisaMatrizPossibilidades(int[][] matriz) {
		int possib1 = -1;
		int possib2 = -1;
		boolean existeInconPossib1 = false;
		boolean existeInconPossib2 = false;
		
		listaCelulas02Possibs = new ArrayList<>();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				if(matriz[i][j] == 0 && 
					SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size() == 2) {
					
					System.out.println("Analisando célula ("+i+","+j+") = ["+SudokuUtil.retornaNumerosPossibs(i, j, matriz)+"]...");
					possib1 = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(0);
					possib2 = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(1);
					
					Posicao p1 = new Posicao(i, j, possib1);
					Posicao p2 = new Posicao(i, j, possib2);
					
					listaCelulas02Possibs.add(p1);
					listaCelulas02Possibs.add(p2);
				}

			}
		}
		//
		SudokuUtil.imprimeMatriz(matriz);

		System.out.println("Lista de celulas com 02 possibilidades ");
		Posicao p = null;
		for (int i = 0; i < listaCelulas02Possibs.size(); i++) {
			p = listaCelulas02Possibs.get(i);
			matriz[p.getX()][p.getY()] = p.getValor(); 
			System.out.println(i+"("+p.getX()+","+p.getY()+")="+p.getValor()+" Qtd Total = "+SudokuUtil.qtdTotalPossibilidadesMatriz(matriz));
		}
		
		int linha = -1;
		int coluna = -1;
		for (int i = 0; i < listaCelulas02Possibs.size(); i+=2) {
			possib1 = listaCelulas02Possibs.get(i).getValor();
			linha = listaCelulas02Possibs.get(i).getX();
			coluna = listaCelulas02Possibs.get(i).getY();
			
			matriz[linha][coluna] = possib1;
			existeInconPossib1 = verificaInconsistencia(matriz);

			possib2 = listaCelulas02Possibs.get(i+1).getValor();
			matriz[linha][coluna] = possib2;
			existeInconPossib2 = verificaInconsistencia(matriz);
			
			if(existeInconPossib1 && !existeInconPossib2) {
				// possib2 está OK - seta
				matriz[linha][coluna] = 0;
				SudokuUtil.setValorNaLinhaColuna(possib2, linha, coluna, matriz, "RN05");
				
			} else if(!existeInconPossib1 && existeInconPossib2) {
				// possib1 está OK - seta
				matriz[linha][coluna] = 0;
				SudokuUtil.setValorNaLinhaColuna(possib1, linha, coluna, matriz, "RN05");
			}
		}
		
		SudokuUtil.imprimeMatriz(matriz);
	}
	
	private void analisaCamadaHorizontal(
			int[][] matriz, List<Integer> linhasPossiveis, List<Integer> quandrantesPossiveis) {
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

		int linhaInicio = linhasPossiveis.get(0);
		int linhaFim = linhasPossiveis.get(2);
		
		for (int i = linhaInicio; i <= linhaFim; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				if(matriz[i][j] != 0) {
					numeroAnalisado = matriz[i][j];
					
					if(i >= 0 && i <= 2) {
						quandrantesPossiveis.clear();
						quandrantesPossiveis.add(1);
						quandrantesPossiveis.add(2);
						quandrantesPossiveis.add(3);
						
					} else if(i >= 3 && i <= 5) {
						quandrantesPossiveis.clear();
						quandrantesPossiveis.add(4);
						quandrantesPossiveis.add(5);
						quandrantesPossiveis.add(6);
						
					} else if(i >= 6 && i <= 8) {
						quandrantesPossiveis.clear();
						quandrantesPossiveis.add(7);
						quandrantesPossiveis.add(8);
						quandrantesPossiveis.add(9);
					}
					
					quadrante1 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz);
					quadrante2 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz);
					quadrante3 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz);
					
					if( (quadrante1 + quadrante2 + quadrante3) == 2) {
						
						System.out.println("Analisando na Horizontal ("+i+","+j+") = "+numeroAnalisado+"... ");
						
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
						linhaQuadrante01 = SudokuUtil.qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz); // 1
						linhaQuadrante02 = SudokuUtil.qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz); // -1
						linhaQuadrante03 = SudokuUtil.qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz); // 2
						
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
							linhaFalta =  linhasPossiveis.stream()
									.distinct().
									filter(aObject -> !numerosEncontrados.contains(aObject)).
									collect(Collectors.toList()).get(0);
							
							// TODO Verifica quantas celulas estão preenchidas naquele quadrante e naquela coluna
							int celulasPrenchidas = SudokuUtil.qtdCelulasPreenchidasNasColunasNaLinha(colunasQuadrante, linhaFalta, matriz);
							
							if(celulasPrenchidas == 1) {
								
								// nas linhas não preenchidas, verifica se numero existe na linha
								if(matriz[linhaFalta][colunasQuadrante.get(0)] != 0) {
									colunaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, colunasQuadrante.get(0), matriz); 
									colunaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, colunasQuadrante.get(1), matriz);
								}
								if(matriz[linhaFalta][colunasQuadrante.get(1)] != 0) {
									colunaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, colunasQuadrante.get(0), matriz); 
									colunaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, colunasQuadrante.get(2), matriz);
								}
								if(matriz[linhaFalta][colunasQuadrante.get(2)] != 0) {
									colunaAnalisar01 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, colunasQuadrante.get(0), matriz); 
									colunaAnalisar02 = SudokuUtil.existeNumeroNaLinha(numeroAnalisado, colunasQuadrante.get(1), matriz);
								}
								
								if( (colunaAnalisar01 + colunaAnalisar02 ) == 1) {
									//
									if(colunaAnalisar01 == 0) {
										colunaFalta = colunasQuadrante.get(0);
									} else if(colunaAnalisar02 == 0) {
										colunaFalta = colunasQuadrante.get(1);
									} 

									//
									SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03");
									SudokuUtil.imprimeMatriz(matriz);
								}
								
							}
							
							// Se celulasPrenchidas == 2 OK, só tem uma celula vazia na colua
							// seta o valor
							if(celulasPrenchidas == 2) {

								colunaFalta = SudokuUtil.retornaColunaVaziaNaLinhaNoQuadrante(linhaFalta, colunasQuadrante, matriz);
								SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG02");
								SudokuUtil.imprimeMatriz(matriz);

								colunaAnalisar01 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(0), matriz); // 1
								colunaAnalisar02 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(1), matriz); // 0
								colunaAnalisar03 = SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunasQuadrante.get(2), matriz); // 1

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

	public List<Posicao> getListaCelulas02Possibs() {
		return listaCelulas02Possibs;
	}

	public void setListaCelulas02Possibs(List<Posicao> listaCelulas02Possibs) {
		this.listaCelulas02Possibs = listaCelulas02Possibs;
	}
	
}
