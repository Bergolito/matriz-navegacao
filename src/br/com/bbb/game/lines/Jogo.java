package br.com.bbb.game.lines;

import java.util.ArrayList;
import java.util.List;

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
		
		Jogo jogoLines = new Jogo(linhas, colunas, trinca);
		
		jogoLines.inicializaJogo(qtdBolasIniciais);
		jogoLines.verificaFormacaoLinha();
		jogoLines.atualizaScore();
		jogoLines.preencheTabuleiro();
		jogoLines.removeBolasTabuleiro();
	}

	private void verificaFormacaoLinha() {
		// TODO Auto-generated method stub
		
	}

	private void movimentaBola(int p1x, int p1y, int p2x, int p2y) {
		// TODO Auto-generated method stub
		
	}

	private void removeBolasTabuleiro() {
		// TODO Auto-generated method stub
		
	}

	private void preencheTabuleiro() {
		// TODO Auto-generated method stub
		
	}

	private void atualizaScore() {
		// TODO Auto-generated method stub
		
	}

	private boolean verificaTrinca() {
		boolean achouTrinca = false;
		// TODO Auto-generated method stub
		for (int i = 0; i < matrizBolas.length; i++) {
			for (int j = 0; j < matrizBolas[i].length; j++) {
				if(!TEXTO_CELULA_VAZIA.equals(matrizBolas[i][j].getTexto())) {

					String corBola = matrizBolas[i][j].getTexto();

					// verifica o vizinho da linha
					try {
						if(corBola.equals(matrizBolas[i+1][j].getTexto()) && corBola.equals(matrizBolas[i+2][j].getTexto())) {
							// achou a trinca na linha
							achouTrinca = true;
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
					// verifica o vizinho da coluna
					try {
						if(corBola.equals(matrizBolas[i][j+1].getTexto()) && corBola.equals(matrizBolas[i][j+2].getTexto())) {
							// achou a trinca na coluna
							achouTrinca = true;
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
					
					// verifica o vizinha da diagonal superior
					try {
						if(corBola.equals(matrizBolas[i][j+1].getTexto()) && corBola.equals(matrizBolas[i][j+2].getTexto())) {
							// achou a trinca na coluna
							achouTrinca = true;
							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
					
					// verifica o vizinha da diagonal inferior
					try {
						if(corBola.equals(matrizBolas[i][j+1].getTexto()) && corBola.equals(matrizBolas[i][j+2].getTexto())) {
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
		System.out.println(nome+" "+celulas.size());
		for (int i = 0; i < celulas.size(); i++) {
			if(null != celulas.get(i)) {
				System.out.print("["+celulas.get(i).getX()+","+celulas.get(i).getY()+"]->");
			}
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
		
		// preenche celulas Preenchidas
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
	}
}
