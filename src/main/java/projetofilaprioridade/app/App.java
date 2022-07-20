package projetofilaprioridade.app;

import java.io.IOException;

import projetofilaprioridade.fila.FilaComPrioridade;

public class App {

	public static void main(String[] args)  throws IOException  {
		FilaComPrioridade minhaFila = new FilaComPrioridade();
		minhaFila.inserirNaFila(22);
		minhaFila.inserirNaFila(25);
		minhaFila.inserirNaFila(15);
		minhaFila.inserirNaFila(12);
		minhaFila.inserirComPrioridade(65);
		minhaFila.inserirComPrioridade(70);
		minhaFila.imprimir();
		minhaFila.removerDaFila();
		minhaFila.imprimir();
	
	}
}
