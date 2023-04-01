package Escola;

import java.util.*;

public class Logar {
	static ArrayList<Login> logins = new ArrayList<Login>();
	static Scanner usuario = new Scanner(System.in);
	// chamar a classe
	TelaInicial a = new TelaInicial();
	Login c = new Login();
	Cripitografia j = new Cripitografia();
	

	
	public void criarConta() {
		
		int entrar = 1;
		int pass = 2;
		char outro = 'b';
		String convert = "a";
		
		Login Login = new Login();
		System.out.println("\nDigite o número da sua matrícula para ser seu Login:");
		String loginUsuario = usuario.nextLine();
		
		Login.setLogin(j.cripitografar(loginUsuario, 20));

		System.out.println("Crie sua senha de acesso ao portal da coordenação:");
		String senhaUsuario = usuario.nextLine();

		Login.setSenha(j.cripitografar(senhaUsuario, 2));
		
		logins.add(Login);
		System.out.println("\nLogin criado com sucesso!\n");
		
	}
	
	public void acessarConta() {

		boolean confirma = false;
		int b = 3;
		int entrar = 1;
		int pass = 2;
		
		for (int contadorDevez = 1; contadorDevez <= 3; contadorDevez++) {
			Login login = new Login();
			System.out.print("\nLogin: ");
			String loginDeAcesso = usuario.nextLine();
		
			login.setLogin(j.cripitografar(loginDeAcesso, 20));
			
			System.out.print("Senha: ");
			String senhaUsuario = usuario.nextLine();
			
			
			login.setSenha(j.cripitografar(senhaUsuario, 2));
			int i = 0;
			
			while (i < logins.size()) {
				Login verificaLoginUsuario = (Login) logins.get(i);
				if (verificaLoginUsuario.getLogin().equals(j.cripitografar(loginDeAcesso, 20))
						&& verificaLoginUsuario.getSenha().equals(j.cripitografar(senhaUsuario, 2))) {
					confirma = true;
					contadorDevez = 3;
					System.out.println("\nAcesso Liberado!\n");

					break;
				}
				i++;
			}
			if (confirma == false && contadorDevez < 3) {
				b--;
				System.out.println("\nLogin ou senha incorretos tente novamente\nVocê tem " + b + " tentativas.\n");

			} else if (contadorDevez == 3 && confirma == false) {
				System.out.println("\nVocê chegou ao máximo de quantidade de tentativas...\n");
				a.primeiraTela();
			}

		}

	}
}
