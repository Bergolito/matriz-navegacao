package br.com.bbb.game.lines;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sudoku {
	
	public Sudoku() {
		//
	}

	public Sudoku(int lin, int col, int[][] mat) {
		mat = new int[lin][col];
	}
	
	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public void regra01(int[][] matriz) {
		if(SudokuUtil.existeCelula01Possib(matriz)) {
			Posicao posicao = SudokuUtil.retornaCelula01Possib(matriz);
			SudokuUtil.setValorNaLinhaColuna(posicao.getValor(), posicao.getX(), posicao.getY(), matriz, "RG01");
		}
	}
	
	/**
	 * 
	 * @param matriz
	 */
	public void regra04(int[][] matriz) {
		int coluna = -1;
		for (int j = 0; j < matriz.length; j++) {
			if(SudokuUtil.existeColuna01PosicaoRestante(j, matriz)) {
				coluna = j;
				Posicao posicao = SudokuUtil.posicaoColuna01PosicaoRestante(coluna, matriz);
				SudokuUtil.setValorNaLinhaColuna(posicao.getValor(), posicao.getX(), posicao.getY(), matriz, "RG04");
			}
			
		}
	}	
	/**
	 * Análise Horizontal
	 * @param matriz
	 * @return
	 */
	public Posicao regra02AnaliseHorizontal(int[][] matriz) {
		Posicao pos = null;

		return pos;
	}

	/**
	 * Análise Vertical
	 * @param matriz
	 * @return
	 */
	public Posicao regra03AnaliseVertical(int[][] matriz) {
		Posicao pos = null;

		return pos;
	}
	
	public void analisaNumerosNaHorizontal(int[][] matriz) {
		// Analisa os quadrantes 1,2,3
		analisaCamadaHorizontal01_02QuadrantesPreenchidos(matriz);
		
		// Analisa os quadrantes 4,5,6
		analisaCamadaHorizontal02_02QuadrantesPreenchidos(matriz);
		
		// Analisa os quadrantes 7,8,9
		analisaCamadaHorizontal03_02QuadrantesPreenchidos(matriz);
		
		// Analisa os quadrantes 1,2,3
		analisaCamadaHorizontal01_01QuadrantePreenchido(matriz);
		
		// Analisa os quadrantes 4,5,6
		analisaCamadaHorizontal02_01QuadrantePreenchido(matriz);
		
		// Analisa os quadrantes 7,8,9
		analisaCamadaHorizontal03_01QuadrantePreenchido(matriz);
	}
	
	public void analisaCamadaHorizontal01_02QuadrantesPreenchidos(int[][] matriz) {
		List<Integer> linhasPossiveis = new ArrayList<>();
		linhasPossiveis.add(0); 
		linhasPossiveis.add(1); 
		linhasPossiveis.add(2);
		
		analisaCamadaHorizontal02QuadrantesPreenchidos(matriz, linhasPossiveis);
	}

	public void analisaCamadaHorizontal01_01QuadrantePreenchido(int[][] matriz) {
		List<Integer> linhasPossiveis = new ArrayList<>();
		linhasPossiveis.add(0); 
		linhasPossiveis.add(1); 
		linhasPossiveis.add(2);
		
		analisaCamadaHorizontal01QuadrantePreenchido(matriz, linhasPossiveis);
	}

	public void analisaCamadaHorizontal02_01QuadrantePreenchido(int[][] matriz) {
		List<Integer> linhasPossiveis = new ArrayList<>();
		linhasPossiveis.add(3); 
		linhasPossiveis.add(4); 
		linhasPossiveis.add(5);
		
		analisaCamadaHorizontal01QuadrantePreenchido(matriz, linhasPossiveis);
	}
	
	public void analisaCamadaHorizontal03_01QuadrantePreenchido(int[][] matriz) {
		List<Integer> linhasPossiveis = new ArrayList<>();
		linhasPossiveis.add(6); 
		linhasPossiveis.add(7); 
		linhasPossiveis.add(8);
		
		analisaCamadaHorizontal01QuadrantePreenchido(matriz, linhasPossiveis);
	}
	
	public void analisaCamadaHorizontal02_02QuadrantesPreenchidos(int[][] matriz) {
		List<Integer> linhasPossiveis = new ArrayList<>();
		linhasPossiveis.add(3); 
		linhasPossiveis.add(4); 
		linhasPossiveis.add(5);
		
		analisaCamadaHorizontal02QuadrantesPreenchidos(matriz, linhasPossiveis);
	}
	
	public void analisaCamadaHorizontal03_02QuadrantesPreenchidos(int[][] matriz) {
		List<Integer> linhasPossiveis = new ArrayList<>();
		linhasPossiveis.add(6); 
		linhasPossiveis.add(7); 
		linhasPossiveis.add(8);
		
		analisaCamadaHorizontal02QuadrantesPreenchidos(matriz, linhasPossiveis);
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
		
		analisaCamadaVertical02QuadrantesPreenhidos(matriz, colunasPossiveis);
	}
	
	public void analisaCamadaVertical02(int[][] matriz) {
		List<Integer> colunasPossiveis = new ArrayList<>();
		colunasPossiveis.add(3); 
		colunasPossiveis.add(4); 
		colunasPossiveis.add(5);
		
		analisaCamadaVertical02QuadrantesPreenhidos(matriz, colunasPossiveis);
	}
	
	public void analisaCamadaVertical03(int[][] matriz) {
		List<Integer> colunasPossiveis = new ArrayList<>();
		colunasPossiveis.add(6); 
		colunasPossiveis.add(7); 
		colunasPossiveis.add(8);
		
		analisaCamadaVertical02QuadrantesPreenhidos(matriz, colunasPossiveis);
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
	
	public void analisaSolucao(int[][] matriz) {

		// Regra 01
		regra01(matriz);
		regra04(matriz);
		// analisa na horizontal
	    analisaNumerosNaHorizontal(matriz);

		// Regra 01
		regra01(matriz);
		regra04(matriz);
		// analisa na vertical
		analisaNumerosNaVertical(matriz);
		
		// Regra 01
		regra01(matriz);
		regra04(matriz);
		System.out.println("\n\n TERMINOU ANALISE. Qtd infericoes = "+(++SudokuUtil.infericoes));
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
	
	public List<Integer> retornaLinhasRestantes(int linhaAnalisada, List<Integer> linhasPossiveis) {
		
		return linhasPossiveis.stream() 
                .filter(num -> linhaAnalisada != num)     
                .collect(Collectors.toList());
	}	

	public int retornaLinhaRestante(int linhaAnalisada, int linhaEncontradaQuadrante, List<Integer> linhasPossiveis) {
		
		return linhasPossiveis.stream() 
                .filter(num -> (linhaAnalisada != num && linhaEncontradaQuadrante != num))     
                .collect(Collectors.toList()).get(0);
	}	
	
	public List<Integer> retornaColunasRestantes(int colunaAnalisada01, int colunaAnalisada02, int colunaAnalisada03) {
		List<Integer> colunasRestantes = new ArrayList<>();
		
		// quadrante 01
		if(colunaAnalisada01 == 1) {
			colunasRestantes.add(colunaAnalisada02);
			colunasRestantes.add(colunaAnalisada03);
		}
		// quadrante 02
		else if(colunaAnalisada02 == 1) {
			colunasRestantes.add(colunaAnalisada01);
			colunasRestantes.add(colunaAnalisada03);
		}
		// quadrante 03
		else if(colunaAnalisada03 == 1) {
			colunasRestantes.add(colunaAnalisada01);
			colunasRestantes.add(colunaAnalisada02);
		}
		return colunasRestantes;
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
				colunaFalta = colunaVazia01;
			} else if(colunaAnalisar02 == 0) {
				colunaFalta = colunaVazia02;
			} 
			//
			SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG02-Análise Horizontal");
			SudokuUtil.imprimeMatriz(matriz);
			
			// verifica celula 01 possibilidade e seta
			verificaCelula01PossibilidadeESetaValor(matriz);
			
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
			SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03-Análise Vertical");
			SudokuUtil.imprimeMatriz(matriz);

			// verifica celula 01 possibilidade e seta
			verificaCelula01PossibilidadeESetaValor(matriz);
			
			// 
			analisaNumerosNaHorizontal(matriz);
		}
	}
	
	private void verificaCelula01PossibilidadeESetaValor(int[][] matriz) {
		if(SudokuUtil.existeCelula01Possib(matriz)) {
			Posicao celula01Possib = SudokuUtil.retornaCelula01Possib(matriz);
			SudokuUtil.setValorNaLinhaColuna(celula01Possib.getValor(), celula01Possib.getX(), celula01Possib.getY(), matriz, "RG01");
			SudokuUtil.imprimeMatriz(matriz);
		}
	}
			
	private void analisaCamadaHorizontal02CelulasPrenchidas(
			int[][] matriz, 
			List<Integer> colunasQuadrante,
			int numeroAnalisado, int linhaFalta) {
			
		int colunaFalta = SudokuUtil.retornaColunaVaziaNaLinhaNoQuadrante(linhaFalta, colunasQuadrante, matriz);
		SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG02-Análise Horizontal");
		SudokuUtil.imprimeMatriz(matriz);

		// verifica celula 01 possibilidade e seta
		verificaCelula01PossibilidadeESetaValor(matriz);
		
		analisaNumerosNaVertical(matriz);	
	}

	private void analisaCamadaVertical02CelulasPrenchidas(
			int[][] matriz, 
			List<Integer> colunasQuadrante,
			int numeroAnalisado, int colunaFalta) {

		int linhaFalta = SudokuUtil.retornaLinhaVaziaNaColunaNoQuadrante(colunaFalta, colunasQuadrante, matriz);
		SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaFalta, colunaFalta, matriz, "RG03-Análise Vertical");
		SudokuUtil.imprimeMatriz(matriz);		

		analisaNumerosNaHorizontal(matriz);
	}
	
	private int retornaQuadrantesVazios(int linhaQuadrante01, int linhaQuadrante02, int linhaQuadrante03) {
		int contadorQuadrantesVazios = 0;
		if(linhaQuadrante01 == -1) contadorQuadrantesVazios++;
		if(linhaQuadrante02 == -1) contadorQuadrantesVazios++;
		if(linhaQuadrante03 == -1) contadorQuadrantesVazios++;		
		
		return contadorQuadrantesVazios;
	}

	private void analisaCamadaHorizontal01QuadrantePreenchido(
		int[][] matriz, List<Integer> linhasPossiveis) {
	
		int numeroAnalisado = 0;
		int quadrante1 = 0;
		int quadrante2 = 0;
		int quadrante3 = 0;	
		int linhaInicio = linhasPossiveis.get(0);
		int linhaFim = linhasPossiveis.get(2);
		List<Integer> colunasQuadrante = new ArrayList<>();
		List<Integer> quandrantesPossiveis = new ArrayList<>();
		
		int quadranteNaoPreenchido01 = -1;
		int quadranteNaoPreenchido02 = -1;
		
		for (int i = linhaInicio; i <= linhaFim; i++) {
			for (int j = 0; j < matriz.length; j++) {
				
				if(matriz[i][j] != 0) {
					numeroAnalisado = matriz[i][j];
					
					quandrantesPossiveis.clear();
					quandrantesPossiveis.addAll(retornaListaQuadrantesHorizontais(i));	
					
					quadrante1 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz);
					quadrante2 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz);
					quadrante3 = SudokuUtil.existeNumeroQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz);
					
					if( (quadrante1 + quadrante2 + quadrante3) == 1) {
						
						System.out.println("Analisando na Horizontal (01-Quad-Preenc) ("+i+","+j+") = "+numeroAnalisado+"... ");
						
						// verifica os 02 quadrantes nao preenchidos
						if(quadrante1 == 1) {
							quadranteNaoPreenchido01 = quandrantesPossiveis.get(1);
							quadranteNaoPreenchido02 = quandrantesPossiveis.get(2);
							
						} else if(quadrante2 == 1) {
							quadranteNaoPreenchido01 = quandrantesPossiveis.get(0);
							quadranteNaoPreenchido02 = quandrantesPossiveis.get(2);
							
						} else if(quadrante3 == 1) {
							quadranteNaoPreenchido01 = quandrantesPossiveis.get(0);
							quadranteNaoPreenchido02 = quandrantesPossiveis.get(1);
						}
						
						int linhaNumeroAnalisado = i;
						List<Integer> linhasRestantesParaAnalise = new ArrayList<>();
						linhasRestantesParaAnalise.addAll(retornaLinhasRestantes(linhaNumeroAnalisado, linhasPossiveis)); 
						
						// verifica numero analisado nas linhas restantes e no quadranteNaoPreenchido01
						int linhaQuadrante01 = analisaCamadaHorizontal01QuadrantePreenchido_retornaLinhaQuandrante(
								matriz, 
								//colunasQuadrante,
								numeroAnalisado,
								quadranteNaoPreenchido01, 
								linhasRestantesParaAnalise);
						
						int linhaQuadrante02 = -1;
						
						if(linhaQuadrante01 != -1) {
							
							// linhaQuadrante02 será a diferença entre linhaNumeroAnalisado e linhaQuadrante01
							linhaQuadrante02 = retornaLinhaRestante(linhaNumeroAnalisado, linhaQuadrante01, linhasPossiveis);
							
							// O numero analisado deve estar na linhaQuadrante02
							// verifica a qtd celulas preenchidas na linha no quadrante
							
							colunasQuadrante = SudokuUtil.retornaColunasQuadrante(quadranteNaoPreenchido02, matriz);

							int qtdNumPreenchidosLinha = 
								qtdNumPreenchidosNaLinhaNoQuadrante(linhaQuadrante02, quadranteNaoPreenchido02, matriz);

							int colunaVazia01 = -1;
							int colunaVazia02 = -1;
							// se qtdNumPreenchidosLinha == 2 seta o valor na coluna vazia
							if(qtdNumPreenchidosLinha == 2) {
								
								if(matriz[linhaQuadrante02][colunasQuadrante.get(0)] == 0) {
									colunaVazia01 = colunasQuadrante.get(0);	
								}
								else if(matriz[linhaQuadrante02][colunasQuadrante.get(1)] == 0) {
									colunaVazia01 = colunasQuadrante.get(1);	
								}
								else if(matriz[linhaQuadrante02][colunasQuadrante.get(2)] == 0) {
									colunaVazia01 = colunasQuadrante.get(2);	
								}
								
								SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaQuadrante02, colunaVazia01, matriz, "RG02-AH-(01-Quad-Preenc)");
								
							}
							// se for == 1 analisa
							else if(qtdNumPreenchidosLinha == 1) {

								colunasQuadrante = SudokuUtil.retornaColunasQuadrante(quadranteNaoPreenchido02, matriz);
								
								if(matriz[linhaQuadrante02][colunasQuadrante.get(0)] == 0 && matriz[linhaQuadrante02][colunasQuadrante.get(1)] == 0) {
									colunaVazia01 = colunasQuadrante.get(0);	
									colunaVazia02 = colunasQuadrante.get(1);
								}
								if(matriz[linhaQuadrante02][colunasQuadrante.get(0)] == 0 && matriz[linhaQuadrante02][colunasQuadrante.get(2)] == 0) {
									colunaVazia01 = colunasQuadrante.get(0);	
									colunaVazia02 = colunasQuadrante.get(2);
								}
								if(matriz[linhaQuadrante02][colunasQuadrante.get(1)] == 0 && matriz[linhaQuadrante02][colunasQuadrante.get(2)] == 0) {
									colunaVazia01 = colunasQuadrante.get(1);	
									colunaVazia02 = colunasQuadrante.get(2);
								}
								// 
								if(SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunaVazia01, matriz) == 0 &&
										SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunaVazia02, matriz) == 1) {
									
									// a coluna 01 está vazia e a coluna 02 está preenchida
									SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaQuadrante02, colunaVazia01, matriz, "RG02-AH-(01-Quad-Preenc)");
								}
								else if(SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunaVazia01, matriz) == 1 &&
										SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunaVazia02, matriz) == 0) {
									
									// a coluna 01 está preenhida e a coluna 02 está vazia
									SudokuUtil.setValorNaLinhaColuna(numeroAnalisado, linhaQuadrante02, colunaVazia02, matriz, "RG02-AH-(01-Quad-Preenc)");
								}
							}
							
						} else if(linhaQuadrante01 == -1) {

							// verifica numero analisado nas linhas restantes e no quadranteNaoPreenchido01
							linhaQuadrante02 = analisaCamadaHorizontal01QuadrantePreenchido_retornaLinhaQuandrante(
									matriz, 
									//colunasQuadrante,
									numeroAnalisado,
									quadranteNaoPreenchido02, 
									linhasRestantesParaAnalise);

							if(linhaQuadrante02 != -1) {
								
								// linhaQuadrante01 será a diferença entre linhaNumeroAnalisado e linhaQuadrante02
								linhaQuadrante01 = retornaLinhaRestante(linhaNumeroAnalisado, linhaQuadrante02, linhasPossiveis);
							}
						}
					}	
				}
			}
		}	
	}

	private int analisaCamadaHorizontal01QuadrantePreenchido_retornaLinhaQuandrante(
			int[][] matriz, 
			//List<Integer> colunasQuadrante,
			int numeroAnalisado,
			int quadranteNaoPreenchido01, 
			List<Integer> linhasRestantesParaAnalise) {

		int linhaNumeroAnalisadoPrimeiroQuadrante = -1;
		int numerosPreenchidosLinha01 = 
				qtdNumPreenchidosNaLinhaNoQuadrante(linhasRestantesParaAnalise.get(0), quadranteNaoPreenchido01, matriz);
		int numerosPreenchidosLinha02 = 
				qtdNumPreenchidosNaLinhaNoQuadrante(linhasRestantesParaAnalise.get(1), quadranteNaoPreenchido01, matriz);
		
		int colunaVazia = -1;
		List<Integer> colunasQuadrante = new ArrayList<>();
		//colunasQuadrante.clear();
		colunasQuadrante = SudokuUtil.retornaColunasQuadrante(quadranteNaoPreenchido01, matriz);
		
		if(numerosPreenchidosLinha01 == 2) {
			if(matriz[linhasRestantesParaAnalise.get(0)][colunasQuadrante.get(0)] == 0) {
				colunaVazia = colunasQuadrante.get(0);	
			}
			if(matriz[linhasRestantesParaAnalise.get(0)][colunasQuadrante.get(1)] == 0) {
				colunaVazia = colunasQuadrante.get(1);	
			}
			if(matriz[linhasRestantesParaAnalise.get(0)][colunasQuadrante.get(2)] == 0) {
				colunaVazia = colunasQuadrante.get(2);	
			}
			if(SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunaVazia, matriz) == 1) {
				linhaNumeroAnalisadoPrimeiroQuadrante = linhasRestantesParaAnalise.get(1);
			}
		} else if(numerosPreenchidosLinha02 == 2) {
			if(matriz[linhasRestantesParaAnalise.get(1)][colunasQuadrante.get(0)] == 0) {
				colunaVazia = colunasQuadrante.get(0);	
			}
			if(matriz[linhasRestantesParaAnalise.get(1)][colunasQuadrante.get(1)] == 0) {
				colunaVazia = colunasQuadrante.get(1);	
			}
			if(matriz[linhasRestantesParaAnalise.get(1)][colunasQuadrante.get(2)] == 0) {
				colunaVazia = colunasQuadrante.get(2);	
			}
			if(SudokuUtil.existeNumeroNaColuna(numeroAnalisado, colunaVazia, matriz) == 1) {
				linhaNumeroAnalisadoPrimeiroQuadrante = linhasRestantesParaAnalise.get(0);
			}
		}
		return linhaNumeroAnalisadoPrimeiroQuadrante;
	}
	
	private int qtdNumPreenchidosNaLinhaNoQuadrante(int linhaAnalisada, int quadrante, int[][] matriz) {
		int contador = 0;
		int colunaInicio = -1;
		int colunaFim = -1;
		
		if(quadrante == 1 || quadrante == 4 || quadrante == 7) {
			
			colunaInicio = 0;
			colunaFim = 2;
		} 
		else if(quadrante == 2 || quadrante == 5 || quadrante == 8) {
			
			colunaInicio = 3;
			colunaFim = 5;
		}
		else if(quadrante == 3 || quadrante == 6 || quadrante == 9) {
			
			colunaInicio = 6;
			colunaFim = 8;
		}

		for (int j = colunaInicio; j <= colunaFim; j++) {
			if(matriz[linhaAnalisada][j] != 0) {
				contador++;
			}
		}
		return contador;
	}
	
	// TODO Reduzir de 27 para 15
	private void analisaCamadaHorizontal02QuadrantesPreenchidos(
			int[][] matriz, List<Integer> linhasPossiveis) {
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
		List<Integer> quandrantesPossiveis = new ArrayList<>();
		
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
						
						System.out.println("Analisando na Horizontal (02-Quads-Preenc) ("+i+","+j+") = "+numeroAnalisado+"... ");
						
						// analisa 
						linhaQuadrante01 = SudokuUtil.qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz); // 1
						linhaQuadrante02 = SudokuUtil.qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz); // -1
						linhaQuadrante03 = SudokuUtil.qualLinhaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz); // 2
						
						int contadorQuadrantesVazios = 					
								retornaQuadrantesVazios(linhaQuadrante01, linhaQuadrante02, linhaQuadrante03); 
						
						if(contadorQuadrantesVazios == 1) {

							List<Integer> linhasEncontradas = retornaNumerosEncontrados(linhaQuadrante01, linhaQuadrante02, linhaQuadrante03);
							
							// ver a diferenca
							linhaFalta =  linhasPossiveis.stream()
									.distinct().
									filter(aObject -> !linhasEncontradas.contains(aObject)).
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
	private void analisaCamadaVertical02QuadrantesPreenhidos(
			int[][] matriz, List<Integer> colunasPossiveis) {
		//
		int numeroAnalisado = 0;
		int quadrante1 = 0;
		int quadrante2 = 0;
		int quadrante3 = 0;	
		int colunaFalta = -1;
		int colunaQuadrante01 = -1;
		int colunaQuadrante02 = -1;
		int colunaQuadrante03 = -1;
		int colunaInicio = colunasPossiveis.get(0);
		int colunaFim = colunasPossiveis.get(2);
		List<Integer> linhasQuadrante = new ArrayList<>();
		List<Integer> quandrantesPossiveis = new ArrayList<>();
		
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
						
						System.out.println("Analisando na Vertical (02-Quads-Preench) ("+i+","+j+") = "+numeroAnalisado+"... ");
						
						// analisa 
						colunaQuadrante01 = SudokuUtil.qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(0), matriz); // 1
						colunaQuadrante02 = SudokuUtil.qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(1), matriz); // -1
						colunaQuadrante03 = SudokuUtil.qualColunaNumeroEstaNoQuadrante(numeroAnalisado, quandrantesPossiveis.get(2), matriz); // 2
						
						int contadorQuadrantesVazios = 					
								retornaQuadrantesVazios(colunaQuadrante01, colunaQuadrante02, colunaQuadrante03); 
						
						if(contadorQuadrantesVazios == 1) {

							List<Integer> colunasEncontradas = retornaNumerosEncontrados(colunaQuadrante01, colunaQuadrante02, colunaQuadrante03);
							
							// ver a diferenca
							colunaFalta =  colunasPossiveis.stream()
									.distinct().
									filter(aObject -> !colunasEncontradas.contains(aObject)).
									collect(Collectors.toList()).get(0);
							
							// analisa o numero verticalmente no quadrante que faltou
							linhasQuadrante.clear();
							linhasQuadrante.addAll(linhasQuadrantesNaoPreenchido(quadrante1, quadrante2, quadrante3));
							
							// verifica quantas celulas estão preenchidas naquele quadrante e naquela coluna
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
}
