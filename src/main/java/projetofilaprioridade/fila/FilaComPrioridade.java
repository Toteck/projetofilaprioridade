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
		if(isEmpty()) {
			if(idade<59)
				novaPessoa.setGrupoIdade(59);
			inicio = novaPessoa;
		}
		else {
			No auxiliar = inicio; // auxiliar recebe
			while(auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}
			auxiliar.setProximo(novaPessoa);
		}
	}
	
	
	public void inserirComPrioridade(int idade) throws IOException{
		No novaPessoa = new No(idade); // Aloca espaço para o novo nó
		No auxiliar = inicio; // auxiliar recebe o inicio da fila
		if(isEmpty()) //  se a fila estiver vazia, não preciso verificar se é prioridade ou não
			inicio = novaPessoa; // essa pessoa é inserida na primeira posição da fila
		else { // Se a fila não estiver vazia 
			if(idade > 59) { // Se idade > 59, então é uma prioridade
				// é prioridade?
				if (inicio.getIdade() < 60) { // A primeira pessoa da fila é uma prioridade
					novaPessoa.setProximo(inicio); // Essa nova pessoa que é uma prioridade vai ser o nosso inicio, essa prioridade vai apontar para o proxima da fila que é a pessoa normal que tava antes
					inicio = novaPessoa; // inicio vai ser a nova pessoa que é prioridade
				} else { // Se a pessoa que já tá fila é uma prioridade
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
