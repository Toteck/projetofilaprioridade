package projetofilaprioridade.fila;

import java.io.IOException;

import projetofilaprioridade.no.No;

public class FilaComPrioridade {

	private No inicio;
	
	public FilaComPrioridade() {
		this.inicio = null;
	}
	
	
	public void inserirNaFila(int idade) throws IOException{
		No novaPessoa = new No(idade); // Aloca espaço para o novo nó
		if(isEmpty())
			inicio = novaPessoa;
		else {
			No auxiliar = inicio;
			while(auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}
			auxiliar.setProximo(novaPessoa);
		}
	}
	
	
	public void inserirComPrioridade(int idade) throws IOException{
		No novaPessoa = new No(idade); // Aloca espaço para o novo nó
		No auxiliar = inicio;
		if(isEmpty())
			inicio = novaPessoa;
		else {
			if(idade > 59) {
				
				// é prioridade?
				if (inicio.getIdade() < 60) {
					novaPessoa.setProximo(inicio);
					inicio = novaPessoa;
				} else {
					while(auxiliar.getProximo() != null && auxiliar.getProximo().getIdade() > 59)
						auxiliar = auxiliar.getProximo();
					novaPessoa.setProximo(auxiliar.getProximo());
					auxiliar.setProximo(novaPessoa);
				}
				
			} else {
				
				while(auxiliar.getProximo() != null) {
					auxiliar = auxiliar.getProximo();
				}
				auxiliar.setProximo(novaPessoa);
				
			}
		}
	}
	
	
	public No removerDaFila() {
		No remover = null;
		
		if(inicio!=null) {
			remover = inicio;
			inicio = remover.getProximo();
		} else {
			System.out.println("\tFila Vazia\n");
		}
		return remover;
	}
	
	
	public void imprimir() {
		No auxiliar = inicio;
		System.out.println("--------- FILA ---------");
		while(auxiliar!=null) {
			System.out.print(auxiliar.getIdade() + " ");
			auxiliar = auxiliar.getProximo();	
		}
		System.out.println("\n--------- FIM FILA ---------");
	}
	
	
	public boolean isEmpty() {
		return inicio == null;
	}
}
