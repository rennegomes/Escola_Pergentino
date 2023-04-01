package Escola;

import java.util.*;

public class TelaInicial {
	public static void primeiraTela() {
		// chamar a classe
		Menu a = new Menu();
		Logar b = new Logar();
		// criação variavel para escolha
		int opcao = 0;
		// para receber a resposta
		// Scanner s = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		// repetição com as opções
		while (opcao != 3) {

			System.out.println("\nEscola Pergentino\n");
			System.out.println("-----------------------------------------------");
			System.out.println("\n1 - Crie sua Conta");
			System.out.println("2 - Acessar Conta");
			System.out.println("3 - Sair do sistema\n");
			System.out.println("-----------------------------------------------");
			System.out.print("\nFaça sua escolha: ");
			// tenta fazer isso, se der erro vai para o catch
			try {
				// ve se é numero
				opcao = Integer.parseInt(input.next());
				// condição para saber que digitou um número errado
				if (opcao < 1 || opcao > 3) {
					// chama a função Exception do catch
					throw new Exception();
				}
				// mostrar de acordo com a escolha
				switch (opcao) {
				case 1: // criar conta
					b.criarConta();
					break;
				case 2: // entrar na conta
					b.acessarConta();
					// ativar a classe
					a.opcoes();
					break;
				}// achador de erro
			} catch (Exception ex) {
				// se achar erro mostra mensagem
				System.out.println("\nErro: Opção invalida\nDigite um número valido! (1 - 3)");
			}
		}
	}
}