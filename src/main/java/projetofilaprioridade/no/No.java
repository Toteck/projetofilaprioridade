package projetofilaprioridade.no;

import projetofilaprioridade.pessoa.Pessoa;

public class No {
	
	Pessoa item;
	No proximo = null;
	public No(int idade) {
		item = new Pessoa(idade);
		proximo = null;
	}
	
	public int getIdade() {
        return item.getIdade();
    }
	
	public void setIdade(int idade) {
		this.item.setIdade(idade);
	}
	

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	public int getGrupoIdade() {
		return item.getGrupoIdade();
	}
	
	public void setGrupoIdade(int idade) {
		this.item.setGrupoIdade(idade);
	}
	
	
	
	
	
	

}
