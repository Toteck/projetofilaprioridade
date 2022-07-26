package projetofilaprioridade.fila;

import java.io.IOException;

import projetofilaprioridade.no.No;

public class FilaComPrioridade {

	private No inicio;
	private No fim;
	private float tamanhoParcial;
	private float qtdPrioritarioParcial;
	private float qtdNormalParcial;
	private float qtdTotalFinal;
	private float qtdPrioritarioTotal;
	private float qtdNormalFinal;
	
	
	public FilaComPrioridade() {
		this.inicio = null;
		this.fim = null;
		this.tamanhoParcial = 0;
		this.qtdPrioritarioParcial = 0;
		this.qtdNormalParcial = 0;
		this.qtdNormalFinal = 0;
		this.qtdPrioritarioTotal = 0;
		this.qtdTotalFinal = 0;
		
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
		if(grupoPrioridade>=0 && grupoPrioridade<9) {
			qtdPrioritarioParcial++;
			qtdPrioritarioTotal++;
		} else {
			qtdNormalParcial++;
			qtdNormalFinal++;
		}
		tamanhoParcial++;
		qtdTotalFinal++;
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
	
	public void estatisticasParciais() {
		if(!isEmpty()) {
			System.out.println("--------------- ESTATISTICAS PARCIAIS ---------------");
			System.out.printf("Tamanho atual da fila: %.0f\n", tamanhoParcial);
			System.out.printf("Prioritários na fila: %% %.1f\n", (qtdPrioritarioParcial/tamanhoParcial)*100);
			System.out.printf("Pessoas sem prioridade na fila: %% %.1f\n", (qtdNormalParcial/tamanhoParcial)*100);
			System.out.println("-----------------------------------------------------");
		} else {
			System.out.println("Fila vazia!");
		}
	}
	
	public void estatisticasFinais() {
		if(qtdTotalFinal!=0) {
			System.out.println("--------------- ESTATISTICAS FINAIS ---------------");
			System.out.printf("Quantidade de pessoas atendidas: %.0f\n", qtdTotalFinal);
			System.out.printf("Prioritários na fila: %% %.1f\n", (qtdPrioritarioTotal/qtdTotalFinal)*100);
			System.out.printf("Pessoas sem prioridade na fila: %% %.1f\n", (qtdNormalFinal/qtdTotalFinal)*100);
			System.out.println("-----------------------------------------------------");
		} else{
			System.out.println("Não foi inserido ninguém na fila!");
		}
	}
	
	
	public boolean isEmpty() {
		return inicio == null;
	}
	
	
	
}
