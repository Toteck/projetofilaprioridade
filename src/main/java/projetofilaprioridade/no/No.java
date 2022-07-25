package projetofilaprioridade.no;

import projetofilaprioridade.pessoa.Pessoa;

public class No {
	
	Pessoa item;
	No proximo = null;
	public No(String nome, int grupoPrioridade) {
		item = new Pessoa(nome, grupoPrioridade);
		proximo = null;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	public int getGrupoPrioridade() {
		return item.getGrupoPrioridade();
	}
	
	public String getNome() {
		return this.item.getNome();
	}
	
	
	
	
	
	

}
