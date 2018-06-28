package br.com.senacrs.lab2.monetizacao.entidades;

import java.util.Scanner;

import br.com.senacrs.lab2.monetizacao.jdbc.FuncionarioDAO;

public class Menu {
	
	public void iniciar() {
		System.out.println("AUTENTICAÇÃO NECESSÁRIA");
		System.out.println("01 - Logar como cliente:");
		System.out.println("02 - Logar como funcionário:");
		
		autenticarCliente();
		autenticarFuncionario();
	}
	
	public void autenticarCliente() {
		System.out.println("AUTENTICAÇÃO NECESSÁRIA");
		System.out.println("Digite seu CPF:");
		System.out.println("Digite a sua senha:");
		
		menuCliente();
	}
	
	public void autenticarFuncionario() {
		System.out.println("AUTENTICAÇÃO NECESSÁRIA");
		System.out.println("Digite seu CPF:");
		System.out.println("Digite a sua senha:");
		
		menuFuncionario();
	}
	
	public void menuFuncionario() {
		System.out.println("01 - Cadastrar cliente");
		System.out.println("02 - Cadastrar produto");
		System.out.println("03 - Verificar cadastro de cliente");
		System.out.println("04 - Fazer uma compra");
	}
	
	public void criarFuncionario(Scanner entrada) {
		System.out.println("Digite o CPF: ");
		long cpf = entrada.nextLong();
		
		System.out.println("Digite o nome: ");
		String nome = entrada.next();
		
		System.out.println("Digite o e-mail: ");
		String endereco = entrada.next();
		
		System.out.println("Digite o login: ");
		String login = entrada.next();
		
		System.out.println("Digite a senha: ");
		String senha = entrada.next();
		
		Funcionario funcionario = new Funcionario(cpf, nome, endereco, login, senha);
		FuncionarioDAO.salvar(funcionario);
	}
	
	public void logarFuncionario(Scanner entrada) {
		System.out.println("Digite o login: ");
		String login = entrada.next();
		
		System.out.println("Digite a senha: ");
		String senha = entrada.next();
		
		FuncionarioDAO.logar(login, senha);
	}
	
	public void cadastrarProduto() {
		System.out.println("Digite o nome do produto:");
		System.out.println("Digite o preço do produto (somente números):");
	}
	
	
}
