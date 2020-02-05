package br.com.bbb.game.lines;

import java.util.Random;

public class SudokuMaster {

	private int iteracao = 0;
	private MatrizSudoku matrizOriginal;
	private MatrizSudoku matrizInferida;
	
	public SudokuMaster() {
		
	}
	
	public SudokuMaster(int[][] matriz) {
		matrizOriginal = new MatrizSudoku(matriz);
		SudokuUtil.imprimeMatriz(matriz);
	}
	
	public void infereSolucao() {
		//
		int valor = -1;
		int ciclo = 0;
		int possibs = -1;
		boolean matrizIncosistente = true;
		String textoNumeros = "";
		Random random = new Random();
		int indice = -1;
		int[][] matriz = new int[matrizOriginal.getMatriz().length][matrizOriginal.getMatriz().length];
		
		for (int i = 0; i < matrizOriginal.getMatriz().length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = matrizOriginal.getMatriz()[i][j];
			}
		}
		SudokuUtil.imprimeMatriz(matriz);
		
		do {

			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
			
					possibs = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).size();
					textoNumeros = SudokuUtil.retornaNumerosPossibs(i, j, matriz);
					
					if(matriz[i][j] == 0) {

						// qtdPossibs == 1
						if(possibs == 1) {
							System.out.println("Analisando ("+i+","+j+") => "+possibs+" possib(s) = ["+textoNumeros+"]");
							valor = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(0);
							SudokuUtil.setValorNaLinhaColuna(valor, i, j, matriz, "RG01");
							
							i = 0; j = 0;
						}
						
						// qtdPossibs == 2
						else if(possibs == 2) {
							System.out.println("Analisando ("+i+","+j+") => "+possibs+" possib(s) = ["+textoNumeros+"]");
							indice = random.nextInt(2);
							System.out.println("Indice = "+indice);
							valor = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(indice);
							SudokuUtil.setValorNaLinhaColuna(valor, i, j, matriz, "RG01");
							
//							i = 0; j = 0;
						}
						
						// qtdPossibs == 3
						else if(possibs == 3) {
							System.out.println("Analisando ("+i+","+j+") => "+possibs+" possib(s) = ["+textoNumeros+"]");
							indice = random.nextInt(3);
							System.out.println("Indice = "+indice);
							valor = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(indice);
							SudokuUtil.setValorNaLinhaColuna(valor, i, j, matriz, "RG01");
							
//							i = 0; j = 0;
						}

						// qtdPossibs == 4
						else if(possibs == 4) {
							System.out.println("Analisando ("+i+","+j+") => "+possibs+" possib(s) = ["+textoNumeros+"]");
							indice = random.nextInt(4);
							valor = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(indice);
							SudokuUtil.setValorNaLinhaColuna(valor, i, j, matriz, "RG01");
							
//							i = 0; j = 0;
						}

						// qtdPossibs == 5
						else if(possibs == 5) {
							System.out.println("Analisando ("+i+","+j+") => "+possibs+" possib(s) = ["+textoNumeros+"]");
							indice = random.nextInt(5);
							valor = SudokuUtil.qtdPossibilidadesCelula(i, j, matriz).get(indice);
							SudokuUtil.setValorNaLinhaColuna(valor, i, j, matriz, "RG01");
							
//							i = 0; j = 0;
						}
						
					}
				}
			}

			ciclo++;
			
			//
			SudokuUtil.imprimeMatriz(matriz);
			//matrizIncosistente = SudokuUtil.existeInconsistenciaMatriz(matriz);
			System.out.println("Matriz eh inconsistente = "+matrizIncosistente);
			
			if(matrizIncosistente) {
				matriz = new int[matrizOriginal.getMatriz().length][matrizOriginal.getMatriz().length];
				System.out.println("Zerando a matriz para a original");

				for (int i = 0; i < matrizOriginal.getMatriz().length; i++) {
					for (int j = 0; j < matriz.length; j++) {
						matriz[i][j] = matrizOriginal.getMatriz()[i][j];
					}
				}
				SudokuUtil.imprimeMatriz(matriz);
			}
			else if(!matrizIncosistente) {
				System.out.println("\n\n Achou a solução!!!");
				break;
			}
			
		} while (matrizIncosistente);

		if(!matrizIncosistente) {
			System.out.println("\n\n Achou a solução!!!");
		}
		
	}

	public int getIteracao() {
		return iteracao;
	}

	public void setIteracao(int iteracao) {
		this.iteracao = iteracao;
	}

	public MatrizSudoku getMatrizOriginal() {
		return matrizOriginal;
	}

	public void setMatrizOriginal(MatrizSudoku matrizOriginal) {
		this.matrizOriginal = matrizOriginal;
	}

	public MatrizSudoku getMatrizInferida() {
		return matrizInferida;
	}

	public void setMatrizInferida(MatrizSudoku matrizInferida) {
		this.matrizInferida = matrizInferida;
	}
	
	
}
