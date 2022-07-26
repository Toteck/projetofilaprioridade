package projetofilaprioridade.fila;

import java.io.IOException;

import projetofilaprioridade.no.No;

public class FilaComPrioridade {

	private No inicio;
	private No fim;
	private int tamanho;
	
	
	public FilaComPrioridade() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}
	
	
	public void inserirNaFila(String nome, int grupoPrioridade) throws IOException{
		No novaPessoa = new No(nome, grupoPrioridade); // Aloca espaço para o novo nó
		No aux;
		if(isEmpty()) {
			inicio = novaPessoa;
			fim = novaPessoa;
			
		} else if(novaPessoa.getGrupoPrioridade() < inicio.getGrupoPrioridade()){
			novaPessoa.setProximo(inicio); // o novo nó aponta para o inicio da nossa lista
			inicio = novaPessoa;
		} else {
			aux = inicio;
			while(aux.getProximo() != null && novaPessoa.getGrupoPrioridade() > aux.getProximo().getGrupoPrioridade()) {
				aux = aux.getProximo();
			}
			novaPessoa.setProximo(aux.getProximo());
			aux.setProximo(novaPessoa);
			
		}
		tamanho++;
	}	

	public No removerDaFila() {
		No remover = null;
		
		if(inicio!=null) {
			remover = inicio;
			inicio = remover.getProximo();
			System.out.println("Chamando: "+remover.getNome()+"\nPrioridade: "+remover.getGrupoPrioridade() );
			System.out.println();
		} else {
			System.out.println("\tFila Vazia!!!\n");
		}
		return remover;
	}
	
	
	public void imprimir() {
		if(inicio != null) {
			No auxiliar = inicio;
			System.out.println("\n--------- FILA ---------");
			while(auxiliar!=null) {
				System.out.println(auxiliar.getNome() + " - " + auxiliar.getGrupoPrioridade());
				auxiliar = auxiliar.getProximo();	
			}
			System.out.print("\n--------- FIM FILA ---------\n\n");
			}else
				System.out.println("\tFila Vazia!!!");
		}
	
	
	public boolean isEmpty() {
		return inicio == null;
	}

	public int getTamanho() {
		return tamanho;
	}
	
}
