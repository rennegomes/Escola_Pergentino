package Escola;

import java.util.*;

public class Menu {
	static ArrayList alunos = new ArrayList();

	public static void criarAluno() {
		Scanner usuarioCR = new Scanner(System.in);
		boolean parar = false;
		int resposta = 0;
		int valida = 1;
		while (parar == false) {

			resposta = 0;
			Aluno aluno = new Aluno();

			while (valida == 1) {
				System.out.println("Digite a matricula do Aluno:");
				try {
					int matriculaAluno;
					matriculaAluno = Integer.parseInt(usuarioCR.next());
					usuarioCR.nextLine();
					aluno.setMatricula(matriculaAluno);
					valida = 2;
				} catch (Exception ex) {
					// se achar erro mostra mensagem
					System.out.println("Erro: Opção invalida\nDigite apenas números");
					valida = 1;
				}
			}

			String nomeDoAluno = null;
			while (valida == 2) {
				System.out.println("Digite Nome Completo do Aluno:");

				nomeDoAluno = usuarioCR.nextLine();
				valida = 3;
				for (int i = 0; i < nomeDoAluno.length(); i++) {
					char c = nomeDoAluno.charAt(i);
					if (Character.isDigit(c) == true && valida != 2) {
						System.out.println("Erro: Opção invalida\nDigite apenas letras");
						valida = 2;
					}

				}
			}

			aluno.setNome(nomeDoAluno);

			System.out.println("Digite a Série:\n");
			String serieAluno = usuarioCR.nextLine();
			aluno.setSerie(serieAluno);
			alunos.add(aluno);

			System.out.println("Aluno adicionado com sucesso!\n");

			while (resposta != 1 && resposta != 2) {
				System.out.println("Continuar inserindo alunos?\n1 - SIM\n2 - NÃO");
				try {
//	      String resposta = usuarioCR.nextLine();
					resposta = Integer.parseInt(usuarioCR.next());
					if (resposta < 1 || resposta > 2) {
						// chama a função Exception do catch
						throw new Exception();
					}
				} catch (Exception ex) {
					// se achar erro mostra mensagem
					System.out.println("\nErro: Opção invalida\nDigite um número valido! (1 - 2)");
				}
			}
			if (resposta == 2) {
				parar = true;
			} else {
				valida = 1;
			}
		}
	}

	public static void exibirTodosCadastros() {

		System.out.println(alunos);
	}

	public static void alterarAluno() {
		Scanner usuarioA = new Scanner(System.in);
		System.out.println("Indique o número da matrícula:");
		int matriculaUsuário;
		boolean confirmacao = false;
		try {
//			      String resposta = usuario.nextLine();
			matriculaUsuário = Integer.parseInt(usuarioA.next());
			for (int i = 0; i < alunos.size(); i++) {
				Aluno alunoProcurado = (Aluno) alunos.get(i);
				if (alunoProcurado.getMatricula() == matriculaUsuário) {
					confirmacao = true;
					alunos.remove(i);
					Aluno alunoAtualizado = new Aluno();
					System.out.println("Digite as novas informações deste aluno:\n" + "Matricula: ");
					int novaMatricula = usuarioA.nextInt();
					usuarioA.nextLine();
					alunoAtualizado.setMatricula(novaMatricula);
					System.out.println("Nome Completo: ");
					String nomeAtualizado = usuarioA.nextLine();
					alunoAtualizado.setNome(nomeAtualizado);
					System.out.println("Série: ");
					String serieAtualizada = usuarioA.nextLine();
					alunoAtualizado.setSerie(serieAtualizada);
					alunos.add(alunoAtualizado);
					System.out.println("\nCadastro Atualizado com sucesso!");

				}

			}
			if (confirmacao == false) {
				System.out.println("Aluno não encontrado.");
			}
		} catch (Exception ex) {
			// se achar erro mostra mensagem
			System.out.println("\nErro: Opção invalida\nDigite apenas números");

		}
	}

	public static void removerAluno() {
		Scanner usuarioR = new Scanner(System.in);
		System.out.println("Digite a matrícula do Aluno:\n");
		int matriculaUsuario;
		boolean confirmacao = false;
		int cont = 0;
		try {
//			      String resposta = usuario.nextLine();
			matriculaUsuario = Integer.parseInt(usuarioR.next());

			while (cont < alunos.size()) {

				Aluno alunoRemovido = (Aluno) alunos.get(cont);
				if (alunoRemovido.getMatricula() == matriculaUsuario) {
					confirmacao = true;
					alunos.remove(cont);
					System.out.println("Aluno removido com sucesso!");
				}
				cont++;
			}
			if (confirmacao == false) {
				System.out.println("Aluno não encontrado.");
			}
		} catch (Exception ex) {
			// se achar erro mostra mensagem
			System.out.println("\nErro: Opção invalida\nDigite apenas números");

		}

	}

	public static void consultarEstudante() {
		Scanner usuarioC = new Scanner(System.in);
		int matriculaUsuario;
		boolean confirmacao = false;
		System.out.println("Digite a matrícula do Aluno:\n");

		try {
//			      String resposta = usuario.nextLine();
			matriculaUsuario = Integer.parseInt(usuarioC.next());

			for (int contador = 0; contador < alunos.size(); contador++) {
				Aluno alunoProcurado = (Aluno) alunos.get(contador);
				if (alunoProcurado.getMatricula() == matriculaUsuario) {

					System.out.println("Aluno encontrado!");
					System.out.println(alunoProcurado);
					confirmacao = true;
					break;
				}
			}
			if (confirmacao == false) {
				System.out.println("Aluno não encontrado.");
			}
		} catch (Exception ex) {
			// se achar erro mostra mensagem
			System.out.println("\nErro: Opção invalida\nDigite apenas números");

		}
	}

	public static void opcoes() {
		// chamar a classe para usar se preciso
		Aluno x = new Aluno();
		// criação variavel para escolha
		int escolha = 0;
		// para receber a resposta
		Scanner s = new Scanner(System.in);
		// repetição com as opções
		while (escolha != 6) {

			System.out.println("\nCentral da cordenação da escola Pergentino\n");
			System.out.println("-----------------------------------------------");
			System.out.println("\n1 - Cadastrar Estudante");
			System.out.println("2 - Consultar Estudante");
			System.out.println("3 - Alterar Cadastro do Estudante");
			System.out.println("4 - Remover Cadastro do Estudante");
			System.out.println("5 - Exibe Todos os Cadastros dos Estudantes");
			System.out.println("6 - Sair da Conta\n");
			System.out.println("-----------------------------------------------");
			System.out.print("\nFaça sua escolha: ");

			try {
				// ve se é numero
				escolha = Integer.parseInt(s.nextLine());
				// condição para saber que digitou um número errado
				if (escolha < 1 || escolha > 6) {
					System.out.println("\nDigite um número valido! (1 - 6)");
				}

				// mostrar de acordo com a escolha
				switch (escolha) {
				case 1: // inserir estudante
					criarAluno();
					break;
				case 2: // consultar estudante
					consultarEstudante();
					break;
				case 3: // alterar cadastro do estudante
					alterarAluno();
					break;
				case 4: // remover cadastro do estudante
					removerAluno();
					break;
				case 5: // mostrar todos os cadastros
					exibirTodosCadastros();
					break;
				case 6: // encerramento do programa...
					System.out.println("Você saiu da conta");
				}
			} catch (Exception e) {
				// se achar erro mostra mensagem
				System.out.println("\nErro: Opção invalida\nDigite um número valido! (1 - 6)");
			}
		}

	}
}
