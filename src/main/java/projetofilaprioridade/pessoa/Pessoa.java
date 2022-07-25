package projetofilaprioridade.pessoa;

public class Pessoa {

	String nome;
	int grupoPrioridade;
	
	public Pessoa(String nome, int grupoPrioridade) {
		this.nome = nome;
		this.grupoPrioridade = grupoPrioridade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getGrupoPrioridade() {
		return grupoPrioridade;
	}

	
}
