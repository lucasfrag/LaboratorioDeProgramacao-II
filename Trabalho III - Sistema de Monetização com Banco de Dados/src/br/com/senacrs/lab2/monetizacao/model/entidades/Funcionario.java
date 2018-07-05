package br.com.senacrs.lab2.monetizacao.model.entidades;

public class Funcionario {
	private long cpf;
	private String nome;
	private String login;
	private String senha;
	
	public Funcionario(long cpf, String nome, String endereco, String login, String senha) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	/* Getters */
	
	public long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	/* Setters */
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
	

}