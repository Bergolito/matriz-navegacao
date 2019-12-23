package br.com.bbb.game.lines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Jogo {
	
	private static final String TEXTO_CELULA_VAZIA = "00";
	
	// atributos
	private int score;
	private int rows;
	private int columns;
	private int qtdBolasLinha;
	private Celula[][] matrizBolas;
	private List<Celula> celulasVazias = new ArrayList<>();

	public Jogo() {
		//
	}

	public Jogo(int lin, int col, int trinca) {
		this.rows = lin;
		this.columns = col;
		this.qtdBolasLinha = trinca;
		this.matrizBolas = new Celula[lin][col];
	}
	
	public static void main(String[] args) {
		int linhas = 4;
		int colunas = 4;
		int trinca = 2;
		int qtdBolasIniciais = 2;
		int qtdNovasBolas = 2;

        // Using Scanner for Getting Input from User 
        Scanner in = new Scanner(System.in); 
        
		Jogo jogoLines = new Jogo(linhas, colunas, trinca);
		jogoLines.inicializaJogo(qtdBolasIniciais);
		int p1X = 0; 
		int p1Y = 0;
		int p2X = 0;
		int p2Y = 0;
		List<Celula> elementosTrinca = new ArrayList<>();
		
		do {
			boolean validaMovimento = true;
	        do {
	        	
				System.out.println("\n:: Movimente as Bolas :: Digite as posicoes x1,y1=x2,y2 ");
		        String entradaUsuario = in.nextLine(); 
		        
		        String[] posicoes = entradaUsuario.split("=");
		        String[] posicao1 = posicoes[0].split(",");
		        p1X = Integer.valueOf(posicao1[0]);
		        p1Y = Integer.valueOf(posicao1[1]);
		        
		        String[] posicao2 = posicoes[1].split(",");
		        p2X = Integer.valueOf(posicao2[0]);
		        p2Y = Integer.valueOf(posicao2[1]);

		        System.out.println("Entradas = p1("+p1X+","+p1Y+") p2("+p2X+","+p2Y+")");
		        validaMovimento = jogoLines.validaMovimentacaoBola(p1X, p1Y, p2X, p2Y); 
		        if(validaMovimento) {
			        jogoLines.movimentaBola(p1X, p1Y, p2X, p2Y);
			        jogoLines.imprimeMatriz(jogoLines.getMatrizBolas());
		        }
		        
	        } while (!validaMovimento);
	        
	        elementosTrinca = jogoLines.verificaTrinca(jogoLines.getMatrizBolas());
	        System.out.println("\nExiste trinca? "+!elementosTrinca.isEmpty());
	        if(!elementosTrinca.isEmpty()) {
	        	
	        	// remove celulas da trinca 
	        	jogoLines.removeBolasTabuleiro(elementosTrinca);
	        	jogoLines.imprimeMatriz(jogoLines.getMatrizBolas());
	        	
	        	// atualiza score
	        	jogoLines.atualizaScore(elementosTrinca);
	        } else {

		        // cria mais qtdBolasNovas no tabuleiro
		        jogoLines.preencheTabuleiroNovasBolas(qtdNovasBolas);
		        jogoLines.imprimeMatriz(jogoLines.getMatrizBolas());
	        	
	        }
	        
	        
		} while(!jogoLines.getCelulasVazias().isEmpty());
		
		System.out.println("Jogo acabou!!!! Score ="+jogoLines.getScore());
	}

	private void removeBolasTabuleiro(List<Celula> elementosTrinca) {
    	
		Celula cel = null;
    	for (Celula elem : elementosTrinca) {
			for (int i = 0; i < matrizBolas.length; i++) {
				for (int j = 0; j < matrizBolas[i].length; j++) {
					if(matrizBolas[i][j].getX() == elem.getX() && matrizBolas[i][j].getY() == elem.getY()) {
						cel = new Celula(i, j, null, TEXTO_CELULA_VAZIA);
						matrizBolas[i][j] = cel;
						continue;
					}
				}
			}
		}
		celulasVazias.clear();
		for (int i = 0; i < matrizBolas.length; i++) {
			for (int j = 0; j < matrizBolas[i].length; j++) {
				cel = matrizBolas[i][j];
				if(cel.getTexto().equals(TEXTO_CELULA_VAZIA)) {
					//
					celulasVazias.add(cel);
				}
			}
		}
		System.out.println("Celulas Vazias= "+ celulasVazias.size() +" | Celulas Preenchidas= "+ (getRows()*getColumns() - celulasVazias.size()));
	}
	
	private boolean validaMovimentacaoBola(int p1X, int p1Y, int p2X, int p2Y) {
		Celula celOrigem = null;
		Celula celDestino = null;
		
		boolean bolaOrigemVazia = false;
		boolean bolaDestinoPreenchida = false;
		
		for (int i = 0; i < matrizBolas.length; i++) {
			for (int j = 0; j < matrizBolas[i].length; j++) {
				
				if((p1X == i && p1Y == j)) {
					
					celOrigem = matrizBolas[i][j];
					if(null != celOrigem && TEXTO_CELULA_VAZIA.equals(celOrigem.getTexto())) {
						bolaOrigemVazia = true;
						break;
					} 
				}

				if((p2X == i && p2Y == j)) {
					celDestino = matrizBolas[i][j];
					if(null != celDestino && !TEXTO_CELULA_VAZIA.equals(celDestino.getTexto())) {
						bolaDestinoPreenchida = true;
						break;
					}
				}
			}
		}
		
		if(bolaOrigemVazia) {
			System.out.println("Erro de movimentação de peças: Bola de origem não pode ser vazia.");
			return false;
			
		} else if(bolaDestinoPreenchida) {
			System.out.println("Erro de movimentação de peças: Bola de destino não pode estar preenchida. ");
			return false;
		}

		return true;
	}
	
	private void movimentaBola(int p1X, int p1Y, int p2X, int p2Y) {
		Celula celOrigem = null;
		Celula celDestino = new Celula();
		
		
		for (int i = 0; i < matrizBolas.length; i++) {
			for (int j = 0; j < matrizBolas[i].length; j++) {
				if((p1X == i && p1Y == j)) {
					celOrigem = matrizBolas[i][j];
					celDestino.setCor(celOrigem.getCor());
					celDestino.setTexto(celOrigem.getTexto());
					celOrigem.setCor(null);
					celOrigem.setTexto(TEXTO_CELULA_VAZIA);
					
					matrizBolas[i][j] = celOrigem; 
					continue;
				}

				if((p2X == i && p2Y == j)) {
					celDestino.setX(p2X);
					celDestino.setY(p2Y);
					matrizBolas[i][j] = celDestino;
					continue;
				}
			}
		}
		
		Celula cel = null;
		celulasVazias.clear();
		for (int i = 0; i < matrizBolas.length; i++) {
			for (int j = 0; j < matrizBolas[i].length; j++) {
				cel = matrizBolas[i][j];
				if(cel.getTexto().equals(TEXTO_CELULA_VAZIA)) {
					//
					celulasVazias.add(cel);
				}
			}
		}
		System.out.println("Celulas Vazias= "+ celulasVazias.size() +" | Celulas Preenchidas= "+ (getRows()*getColumns() - celulasVazias.size()));
	}

	private void preencheTabuleiroNovasBolas(int qtdNovasBolas) {
		// preenche celulas com Bolas iniciais
		int indiceCor = -1;
		Celula cel = null;
		Cores cor = null;
		List<Celula> novasBolas = new ArrayList<>();
		List<Integer> listaIndices = null;
		
		if(qtdNovasBolas <= celulasVazias.size()) {
			System.out.println("Adicionando "+qtdNovasBolas+" novas bolas ao tabuleiro");
			listaIndices = geraIndicesAletatorios(celulasVazias.size(), qtdNovasBolas);
			
		} else if(qtdNovasBolas > celulasVazias.size()) {
			System.out.println("Adicionando "+celulasVazias.size()+" novas bolas ao tabuleiro");
			listaIndices = geraIndicesAletatorios(celulasVazias.size(), celulasVazias.size());
		}

		Random rand = new Random();
		novasBolas.clear();
		for (Integer indice : listaIndices) {
			indiceCor = rand.nextInt(Cores.values().length);
			cor = Cores.values()[indiceCor];
			cel = new Celula(celulasVazias.get(indice).getX(), celulasVazias.get(indice).getY(), cor, cor.getCodigo());
			System.out.print(" ("+celulasVazias.get(indice).getX()+","+celulasVazias.get(indice).getY()+")->");
			novasBolas.add(cel);
		}
		
		atualizaMatrizPrincipal(novasBolas);
	}
	
	private void atualizaScore(List<Celula> celulasRemover) {
		// atualiza score
    	// 3 -  5 pontos
    	// 4 - 12 pontos
    	// 5 - 21 pontos
		int score = this.getScore();
    	int pontos = 0;
    	if(celulasRemover.size() == 3) {
    		pontos = 5;
    	} else if(celulasRemover.size() == 4) {
    		pontos = 12;
    	} else if(celulasRemover.size() == 5) {
    		pontos = 21;
    	}
    	score += pontos;  
    	
    	this.setScore(score);
    	System.out.println("Score="+getScore());
	}

	private List<Celula> verificaTrinca(Celula[][] matriz) {
		List<Celula> elementosTrinca = new ArrayList<>();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(!TEXTO_CELULA_VAZIA.equals(matriz[i][j].getTexto())) {

					String corBola = matriz[i][j].getTexto();

					// verifica o vizinho da linha
					try {

						if(corBola.equals(matriz[i][j+1].getTexto()) && 
							corBola.equals(matriz[i][j+2].getTexto())) {
							
							// achou a trinca na linha
							System.out.println("Trinca ="+matriz[i][j].getTexto()+","+
									matriz[i][j+1].getTexto()+","+matriz[i][j+2].getTexto());
							
							elementosTrinca.clear();
							elementosTrinca.add(matriz[i][j]);
							elementosTrinca.add(matriz[i][j+1]);
							elementosTrinca.add(matriz[i][j+2]);
							
							break;
						}
						
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
					// verifica o vizinho da coluna
					try {
						if(corBola.equals(matriz[i+1][j].getTexto()) && 
							corBola.equals(matriz[i+2][j].getTexto())) {
							
							// achou a trinca na coluna
							System.out.println("Trinca ="+matriz[i][j].getTexto()+","+
									matriz[i+1][j].getTexto()+","+matriz[i+2][j].getTexto());
							
							elementosTrinca.clear();
							elementosTrinca.add(matriz[i][j]);
							elementosTrinca.add(matriz[i+1][j]);
							elementosTrinca.add(matriz[i+2][j]);
							
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
					
					// verifica o vizinha da diagonal superior
					try {
						if(corBola.equals(matriz[i+1][j-1].getTexto()) && 
							corBola.equals(matriz[i+2][j-2].getTexto())) {
							
							// achou a trinca na coluna
							System.out.println("Trinca ="+matriz[i][j].getTexto()+","+
									matriz[i+1][j-1].getTexto()+","+matriz[i+2][j-2].getTexto());
							
							elementosTrinca.clear();
							elementosTrinca.add(matriz[i][j]);
							elementosTrinca.add(matriz[i+1][j-1]);
							elementosTrinca.add(matriz[i+2][j-2]);
							
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
					
					// verifica o vizinha da diagonal inferior
					try {
						if(corBola.equals(matrizBolas[i+1][j+1].getTexto()) && 
							corBola.equals(matrizBolas[i+2][j+2].getTexto())) {
							
							// achou a trinca na coluna
							System.out.println("Trinca ="+matriz[i][j].getTexto()+","+
									matriz[i+1][j+1].getTexto()+","+matriz[i+2][j+2].getTexto());
							
							elementosTrinca.clear();
							elementosTrinca.add(matriz[i][j]);
							elementosTrinca.add(matriz[i+1][j+1]);
							elementosTrinca.add(matriz[i+2][j+2]);
							
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
					
				}
			}
		}
		return elementosTrinca;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public int getQtdBolasLinha() {
		return qtdBolasLinha;
	}

	public void setQtdBolasLinha(int qtdBolasLinha) {
		this.qtdBolasLinha = qtdBolasLinha;
	}

	public Celula[][] getMatrizBolas() {
		return matrizBolas;
	}

	public void setMatrizBolas(Celula[][] matrizBolas) {
		this.matrizBolas = matrizBolas;
	}

	public List<Celula> getCelulasVazias() {
		return celulasVazias;
	}

	public void setCelulasVazias(List<Celula> celulasVazias) {
		this.celulasVazias = celulasVazias;
	}

	private void imprimeMatriz(Celula[][] matriz) {
		System.out.println();
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("[");
			for (int j = 0; j < matriz[i].length; j++) {
				
				if(j != matriz[i].length-1) {
					System.out.print(matriz[i][j] != null ? " "+matriz[i][j].getTexto() : " ");
				}
				else {
					System.out.println(matriz[i][j] != null ? " "+matriz[i][j].getTexto()+" ]" : " ");
				}
			}
		}
	}

	private void atualizaMatrizPrincipal(List<Celula> preenchidas) {
		for (Celula celula : preenchidas) {
			matrizBolas[celula.getX()][celula.getY()] = celula;
		}
		
		Celula cel = null;
		celulasVazias.clear();
		for (int i = 0; i < matrizBolas.length; i++) {
			for (int j = 0; j < matrizBolas[i].length; j++) {
				cel = matrizBolas[i][j];
				if(cel.getTexto().equals(TEXTO_CELULA_VAZIA)) {
					//
					celulasVazias.add(cel);
				}
			}
		}
		System.out.println("\nCelulas Vazias= "+ celulasVazias.size() +" | Celulas Preenchidas="+ (getRows()*getColumns() - celulasVazias.size()));
	}
	
	private List<Integer> geraIndicesAletatorios(int numeroMaximo, int qtdNumeros) {
		Random rand = new Random();
		Set<Integer> conjuntoNumeros = new HashSet<>();
		List<Integer> listaIndices = new ArrayList<>();
		
		do {
			for (int i = 0; i < qtdNumeros; i++) {
				conjuntoNumeros.add(rand.nextInt(numeroMaximo));
			}
			
		} while (conjuntoNumeros.size() != qtdNumeros);
		
        // Creating an iterator 
        Iterator<Integer> indices = conjuntoNumeros.iterator(); 
  
        // Displaying the values after iterating through the iterator 
        while (indices.hasNext()) { 
            listaIndices.add(indices.next());
        } 
        
        Collections.sort(listaIndices);
        
        return listaIndices;
	}

	private void inicializaJogo(int qtdBolasIniciais) {
		// preenche matriz de bolas
		Celula cel = null;
		for (int i = 0; i < matrizBolas.length; i++) {
			for (int j = 0; j < matrizBolas[i].length; j++) {
				cel = new Celula(i,j, null, TEXTO_CELULA_VAZIA);
				matrizBolas[i][j] = cel;
				// preenche celulas vazias
				celulasVazias.add(cel);
			}
		}
		imprimeMatriz(matrizBolas);
		System.out.println("Celulas Vazias= "+ celulasVazias.size() +" | Celulas Preenchidas="+ (getRows()*getColumns() - celulasVazias.size()));

		// preenche celulas com Bolas iniciais
		int indiceCor = -1;
		Cores cor = null;
		List<Integer> listaIndices = geraIndicesAletatorios(celulasVazias.size(), qtdBolasIniciais);
		Random rand = new Random();
		List<Celula> novas = new ArrayList<>();
		for (Integer indice : listaIndices) {
			indiceCor = rand.nextInt(Cores.values().length);
			cor = Cores.values()[indiceCor];
			cel = new Celula(celulasVazias.get(indice).getX(), celulasVazias.get(indice).getY(), cor, cor.getCodigo());
			novas.add(cel);
		}
        
		atualizaMatrizPrincipal(novas);
		imprimeMatriz(matrizBolas);
	}
}
