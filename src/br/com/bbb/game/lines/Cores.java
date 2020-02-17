package br.com.bbb.game.lines;

public enum Cores {

	AZU("AZ","AZUL"),
	AMA("AM","AMARELO"),
	CIA("CI","CIANO"),
	LAR("LA","LARANJA"),
	VDE("VD","VERDE"),
	VME("VM","VERMELHO");
	//ROS("RS","ROSA"),
	//ROX("RX","ROXO"),
	
	private String codigo;
	private String nome;
	
	private Cores(String c, String n){
		this.codigo = c;
		this.nome = n;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	
}
