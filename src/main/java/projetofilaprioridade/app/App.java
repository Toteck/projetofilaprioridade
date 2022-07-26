package projetofilaprioridade.app;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import projetofilaprioridade.fila.FilaComPrioridade;

public class App {

	public static void main(String[] args)  throws IOException  {
		FilaComPrioridade minhaFila = new FilaComPrioridade();
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int op=1;
		int prioridade;
		String nome;
		
		String menu = "MENU DE OPÇÕES:\n1: Adicionar na Fila\n2: Atendimento\n3: Mostrar Fila\n4: Estatisticas parciais\n0: Encerrar";
		String Info = "NIVEL DE PRIORIDADE\n0 - Deficiente\n1 - Idoso Centenario\n2 - Idoso Nonagenário\n3 - Idoso Octagenário\n4 - Idoso Septuagenário\n5 - Idoso Sexagenário\n6 - Gestante\n7 - Lactante\n8 - Pessoa Com Criança de Colo\n9 - Normal (Sem Prioridade)\n";
		
		System.out.println(Info);
		System.out.println(menu);
		
		while(op != 0) {
			System.out.print("Opção: ");
			op = sc.nextInt();
			if(op==0 && !minhaFila.isEmpty()) {
				do {
					System.out.println("Ainha há pessoas para serem atendidas!");
					System.out.print("Opção: ");
					op = sc.nextInt();
				}while(op==0 && !minhaFila.isEmpty());
			}
			
			switch(op) {
			case 0:
				break;
			case 1: 
				System.out.println("Digite nome: ");
				nome = sc.next();
				String Buffer = sc.nextLine(); //pega nome completo so que chama somente primeiro nome
				
				while(true) {
				System.out.print("Prioridade: ");
				prioridade = sc.nextInt();
				if((prioridade < 0) || (prioridade > 9)) {
					System.out.println("Prioridade Invalida!!");
					}else
						break;
				}
				
				minhaFila.inserirNaFila(nome, prioridade);
				System.out.println();
				break;
				
			case 2:
				minhaFila.removerDaFila();
				break;
				
			case 3:
				minhaFila.imprimir();
				break;
			case 4:
				minhaFila.estatisticasParciais();
				break;
			default:
				System.out.println("Opção inexistente!!");
			}
		}
		minhaFila.estatisticasFinais();
		System.out.println("Programa encerrado!!");
		
	sc.close();
		
	
	}
}
