package Escola;
import java.util.*;

public class Cripitografia {
	
	public String cripitografar(String login, int chave) {
	
		String senhaCriptografado = "";
	 for(int cont = 0; cont < login.length();cont++) {
		 
		 char caracterTextSenha = (char)login.charAt(cont);

		 int intCaracterSenha = (int)caracterTextSenha;

		  int intsenhaCriptografado = intCaracterSenha += chave;

		  char caracterCriptografadoSenha = (char)intsenhaCriptografado;
		  
		  senhaCriptografado += caracterCriptografadoSenha;
		  
	 }
	 return senhaCriptografado;
	 }
	
}
