package br.com.bbb.game.lines;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
	
	private static final String TEXTO_CELULA_VAZIA = "00";
	
	// atributos
	private int score;
	private int rows;
	private int columns;
	private int qtdBolasLinha;
	private Celula[][] matrizBolas;
	private List<Celula> celulasPreenchidas = new ArrayList<>();
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
		int linhas = 6;
		int colunas = 6;
		int trinca = 3;
		int qtdBolasIniciais = 4;
		int qtdNovasBolas = 3;

        // Using Scanner for Getting Input from User 
        Scanner in = new Scanner(System.in); 
        
		Jogo jogoLines = new Jogo(linhas, colunas, trinca);
		
		jogoLines.inicializaJogo(qtdBolasIniciais);
		//int p1X, p1Y, p2X, p2Y;
		int p1X = 0; 
		int p1Y = 0;
		int p2X = 0;
		int p2Y = 0;
		
		while(!jogoLines.getCelulasVazias().isEmpty()) {
			
	        System.out.println("\nDigite posicao1 x,y= "); 
	        String posicaoBola1 = in.nextLine(); 
	        System.out.println("["+posicaoBola1+"]");
	        
	        String[] tkPos1 = posicaoBola1.split(",");
	        p1X = Integer.valueOf(tkPos1[0]);
	        p1Y = Integer.valueOf(tkPos1[1]);
	        
	        System.out.println("\nDigite posicao2 x,y= "); 
	        String posicaoBola2 = in.nextLine(); 
	        System.out.println("["+posicaoBola2+"]");
	        String[] tkPos2 = posicaoBola2.split(",");
	        p2X = Integer.valueOf(tkPos2[0]);
	        p2Y = Integer.valueOf(tkPos2[1]);

	        jogoLines.movimentaBola(p1X, p1Y, p2X, p2Y);
	        // cria mais qtdBolasNovas no tabuleiro 
	        jogoLines.preencheTabuleiroNovasBolas(qtdNovasBolas);
	        
	        jogoLines.imprimeListaCelulas("Celulas Vazias=", jogoLines.getCelulasVazias());
	        jogoLines.imprimeListaCelulas("Celulas Preenchidas=", jogoLines.getCelulasPreenchidas());
	        jogoLines.atualizaMatrizPrincipal(jogoLines.getCelulasPreenchidas());
	        jogoLines.imprimeMatriz(jogoLines.getMatrizBolas());
	        
	        jogoLines.atualizaScore();
			jogoLines.preencheTabuleiro();
			jogoLines.removeBolasTabuleiro();
		}
	}

	private void movimentaBola(int p1X, int p1Y, int p2X, int p2Y) {
		// TODO Auto-generated method stub
		Celula celOrigem = null;
		Celula celDestino = new Celula();
		//Cores corDestino = null;
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
		
	}

	private void removeBolasTabuleiro() {
		// TODO Auto-generated method stub
		
	}

	private void preencheTabuleiro() {
		// TODO Auto-generated method stub
		
	}

	private void preencheTabuleiroNovasBolas(int qtdNovasBolas) {
		// TODO Auto-generated method stub
		// preenche celulas com Bolas iniciais
		int indice = -1;
		int indiceCor = -1;
		Celula cel = null;
		Cores cor = null;
		for (int i = 0; i <= qtdNovasBolas; i++) {
			indice = ((int)(Math.random() * 100) % celulasVazias.size());
			indiceCor = ((int)(Math.random() * 100) % Cores.values().length);
			cor = Cores.values()[indiceCor];
			cel = new Celula(celulasVazias.get(indice).getX(), celulasVazias.get(indice).getY(), cor, cor.getCodigo());
			celulasPreenchidas.add(cel);
		}
	}
	
	private void atualizaScore() {
		// TODO Auto-generated method stub
		
	}

	private void testaTrinca() {
		/**
		[ 00 00 RS CI AM 00 ]
		[ 00 00 00 00 LA 00 ]
		[ RS VD VM LA AM 00 ]
		[ RX VD LA CI 00 00 ]
		[ 00 00 VM 00 00 00 ]
		[ 00 CI 00 00 00 00 ]		
		 */
		Celula[][] matriz1 = new Celula[6][6];
		matriz1[0][0] = new Celula(0, 0, null, "00");
		matriz1[0][1] = new Celula(0, 0, null, "00");
		matriz1[0][2] = new Celula(0, 0, null, "RS");
		matriz1[0][3] = new Celula(0, 0, null, "CI");
		matriz1[0][4] = new Celula(0, 0, null, "AM");
		matriz1[0][5] = new Celula(0, 0, null, "00");

		matriz1[1][0] = new Celula(0, 0, null, "00");
		matriz1[1][1] = new Celula(0, 0, null, "00");
		matriz1[1][2] = new Celula(0, 0, null, "00");
		matriz1[1][3] = new Celula(0, 0, null, "00");
		matriz1[1][4] = new Celula(0, 0, null, "LA");
		matriz1[1][5] = new Celula(0, 0, null, "00");
				
		matriz1[2][0] = new Celula(0, 0, null, "RS");
		matriz1[2][1] = new Celula(0, 0, null, "VD");
		matriz1[2][2] = new Celula(0, 0, null, "VM");
		matriz1[2][3] = new Celula(0, 0, null, "LA");
		matriz1[2][4] = new Celula(0, 0, null, "AM");
		matriz1[2][5] = new Celula(0, 0, null, "00");
		
		matriz1[3][0] = new Celula(0, 0, null, "RX");
		matriz1[3][1] = new Celula(0, 0, null, "VD");
		matriz1[3][2] = new Celula(0, 0, null, "LA");
		matriz1[3][3] = new Celula(0, 0, null, "CI");
		matriz1[3][4] = new Celula(0, 0, null, "00");
		matriz1[3][5] = new Celula(0, 0, null, "00");
		
		matriz1[4][0] = new Celula(0, 0, null, "00");
		matriz1[4][1] = new Celula(0, 0, null, "00");
		matriz1[4][2] = new Celula(0, 0, null, "VM");
		matriz1[4][3] = new Celula(0, 0, null, "00");
		matriz1[4][4] = new Celula(0, 0, null, "00");
		matriz1[4][5] = new Celula(0, 0, null, "00");
		
		matriz1[5][0] = new Celula(0, 0, null, "00");
		matriz1[5][1] = new Celula(0, 0, null, "CI");
		matriz1[5][2] = new Celula(0, 0, null, "00");
		matriz1[5][3] = new Celula(0, 0, null, "00");
		matriz1[5][4] = new Celula(0, 0, null, "00");
		matriz1[5][5] = new Celula(0, 0, null, "00");
		
		System.out.println("\nExiste trinca? "+verificaTrinca(matriz1));
	}
	
	private boolean verificaTrinca(Celula[][] matriz) {
		boolean achouTrinca = false;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(!TEXTO_CELULA_VAZIA.equals(matriz[i][j].getTexto())) {

					String corBola = matriz[i][j].getTexto();

					// verifica o vizinho da linha
					try {
						if(corBola.equals(matriz[i+1][j].getTexto()) && 
							corBola.equals(matriz[i+2][j].getTexto())) {
							
							// achou a trinca na linha
							achouTrinca = true;
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
					// verifica o vizinho da coluna
					try {
						if(corBola.equals(matriz[i][j+1].getTexto()) && 
							corBola.equals(matriz[i][j+2].getTexto())) {
							
							// achou a trinca na coluna
							achouTrinca = true;
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
							achouTrinca = true;
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
							achouTrinca = true;
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
					
				}
			}
		}
		return achouTrinca;
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

	public List<Celula> getCelulasPreenchidas() {
		return celulasPreenchidas;
	}

	public void setCelulasPreenchidas(List<Celula> celulasPreenchidas) {
		this.celulasPreenchidas = celulasPreenchidas;
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
		
	}
	
	private void imprimeListaCelulas(String nome, List<Celula> celulas) {
		System.out.print(nome+" "+celulas.size()+" [ ");
		for (int i = 0; i < celulas.size(); i++) {
			if(null != celulas.get(i)) {
				System.out.print("["+celulas.get(i).getX()+","+celulas.get(i).getY()+"]->");
			}
		}
	}

	private void imprimeListaIndices(String nome, List<Integer> indices) {
		System.out.print(nome+" "+indices.size()+" [ ");
		for (int i = 0; i < indices.size(); i++) {
			System.out.print(indices.get(i)+"->");
		}
	}
	
	private void inicializaJogo(int qtdBolasIniciais) {

		// preenche matriz de bolas
		for (int i = 0; i < matrizBolas.length; i++) {
			for (int j = 0; j < matrizBolas[i].length; j++) {
				matrizBolas[i][j] = new Celula(i,j, null, TEXTO_CELULA_VAZIA);
			}
		}

		// preenche celulas vazias
		for (int i = 0; i < matrizBolas.length; i++) {
			for (int j = 0; j < matrizBolas[i].length; j++) {
				celulasVazias.add(new Celula(i,j, null, TEXTO_CELULA_VAZIA));
			}
		}
		//
		imprimeListaCelulas("Celulas Vazias=", celulasVazias);
		imprimeMatriz(matrizBolas);
		
		// preenche celulas com Bolas iniciais
		int indice = -1;
		int indiceCor = -1;
		Celula cel = null;
		Cores cor = null;
		for (int i = 0; i <= qtdBolasIniciais; i++) {
			indice = ((int)(Math.random() * 100) % celulasVazias.size());
			indiceCor = ((int)(Math.random() * 100) % Cores.values().length);
			cor = Cores.values()[indiceCor];
			cel = new Celula(celulasVazias.get(indice).getX(), celulasVazias.get(indice).getY(), cor, cor.getCodigo());
			celulasPreenchidas.add(cel);
		}
		
		imprimeListaCelulas("Celulas Preenchidas=", celulasPreenchidas);
		atualizaMatrizPrincipal(celulasPreenchidas);
		imprimeMatriz(matrizBolas);
		
		Celula celRemover = null;
		List<Integer> listaIndicesRemover = new ArrayList<>();
		for (int i = 0; i < celulasPreenchidas.size(); i++) {
			celRemover = celulasPreenchidas.get(i);
			for (int j = 0; j < celulasVazias.size(); j++) {
				if(celRemover.getX() == celulasVazias.get(j).getX() && 
				   celRemover.getY() == celulasVazias.get(j).getY()) {
					
					listaIndicesRemover.add(j);
					celulasVazias.remove(j);
					break;
				}
			}
		}

		// 
		imprimeListaIndices("Lista indices a remover=", listaIndicesRemover);
		for (Integer i : listaIndicesRemover) {
			celulasVazias.remove(i);
		}
		imprimeListaCelulas("\nCelulas Vazias=", celulasVazias);
		//testaTrinca();
	}
}
