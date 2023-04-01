package Escola;

import java.util.*;

public class Aluno {

	private int matricula;
	private String nome;
	private String serie;

	// public Aluno(int matricula, String nome, String serie) {
	// this.matricula = matricula;
	// this.nome = nome;
	// this.serie = serie;
	// }

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return "\n---------------------------------------------\nAluno Número de matrícula: " + matricula
				+ "\nNome do estudante: " + nome + "\nSerie do estudante: " + serie + "\n";
	}

}
