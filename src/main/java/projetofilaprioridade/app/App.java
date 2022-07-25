package projetofilaprioridade.app;

import java.io.IOException;

import projetofilaprioridade.fila.FilaComPrioridade;

public class App {

	public static void main(String[] args)  throws IOException  {
		FilaComPrioridade minhaFila = new FilaComPrioridade();
		minhaFila.inserirNaFila("Mateus", 9);
		minhaFila.inserirNaFila("João", 9);
		minhaFila.inserirNaFila("Marcelo", 0);
		minhaFila.inserirNaFila("Maria", 3);
		minhaFila.inserirNaFila("Raimunda", 1);
		minhaFila.inserirNaFila("Raimundo", 7);
		minhaFila.inserirNaFila("Joana", 6);
		minhaFila.inserirNaFila("Francisco", 5);
		minhaFila.inserirNaFila("Carlos", 9);
		minhaFila.imprimir();
	
	}
}
