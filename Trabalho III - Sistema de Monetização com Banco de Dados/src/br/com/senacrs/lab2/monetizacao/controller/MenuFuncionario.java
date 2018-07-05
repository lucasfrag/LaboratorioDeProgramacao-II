package br.com.senacrs.lab2.monetizacao.controller;

import java.util.Scanner;

import br.com.senacrs.lab2.monetizacao.model.entidades.Cliente;
import br.com.senacrs.lab2.monetizacao.model.entidades.Compra;
import br.com.senacrs.lab2.monetizacao.model.entidades.Conta;
import br.com.senacrs.lab2.monetizacao.model.entidades.Produto;
import br.com.senacrs.lab2.monetizacao.model.jdbc.ClienteDAO;
import br.com.senacrs.lab2.monetizacao.model.jdbc.CompraDAO;
import br.com.senacrs.lab2.monetizacao.model.jdbc.ContaDAO;
import br.com.senacrs.lab2.monetizacao.model.jdbc.OperacaoDAO;
import br.com.senacrs.lab2.monetizacao.model.jdbc.ProdutoDAO;

public class MenuFuncionario {
	
	// Conta conta = new Conta(123, 101010, 1000);
	// ContaDAO.salvar(conta);
	static Conta contaEstabelecimento = ContaDAO.getContaPorCliente(123);
	
	public static void menuFuncionario(Scanner entrada) {
		System.out.println("MENU FUNCIONÁRIO");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Cadastrar produto");
		System.out.println("3 - Verificar cadastro de cliente");
		System.out.println("4 - Fazer uma compra");
		System.out.println("5 - Relatório de produtos vendidos");
		System.out.println("6 - Relatório de clientes que mais compram");
		System.out.println("7 - Relatório de clientes que mais realizam operações de monetizacao");
		System.out.println("0 - Sair");
		
		int opcao = entrada.nextInt();
		
		if (ValidarDados.isInteger(opcao) && opcao > 7 && opcao < 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		switch (opcao) {
			case 1: cadastrarCliente(entrada);
			case 2: cadastrarProduto(entrada);
			case 3: buscarCliente(entrada);
			case 4: fazerCompra(entrada);
			case 5: produtosVendidos(entrada);
			case 6: clientesMaisCompram(entrada);
			case 7: clientesMaisOperam(entrada);
			default: Menu.iniciar(entrada);
		}
	}
	
	public static void cadastrarCliente(Scanner entrada) {
		System.out.println("Digite o CPF: ");
		long cpf = entrada.nextLong();
		
		System.out.println("Digite o nome: ");
		String nome = entrada.next();
		
		System.out.println("Digite o e-mail: ");
		String email = entrada.next();
		
		System.out.println("Digite o número da sua conta: ");
		int numeroConta = entrada.nextInt();
		
		Conta conta = new Conta(numeroConta, cpf,0);
		ContaDAO.salvar(conta);
		
		Cliente cliente = new Cliente(cpf, nome, email, conta);
		ClienteDAO.salvar(cliente);
		
		menuFuncionario(entrada);
	}
	
	public static void cadastrarProduto(Scanner entrada) {
		System.out.println("Digite o código do produto:");
		int id = entrada.nextInt();
		
		System.out.println("Digite o nome do produto:");
		String nome = entrada.next();
		
		System.out.println("Digite o preço do produto (somente números | Ex.: 10.50):");
		double preco = entrada.nextDouble();
		
		Produto produto = new Produto(id, nome, preco);
		ProdutoDAO.salvar(produto);
		
		menuFuncionario(entrada);
	}
	
	public static void buscarCliente(Scanner entrada) {
		System.out.println("Digite o CPF do cliente:");
		long cpf = entrada.nextLong();
		
		ClienteDAO.listarUm(cpf);
		menuFuncionario(entrada);
	}
	
	public static void fazerCompra(Scanner entrada) {
		ProdutoDAO.listar();
		
		System.out.println("Digite o código do produto:");
		int produto = entrada.nextInt();
		System.out.println("Digite a quantidade do produto:");
		int quantidade = entrada.nextInt();
		System.out.println("Digite o CPF do cliente: ");
		long cliente = entrada.nextLong();
		
		double total = produto*quantidade;
		
		System.out.println("O valor total da compra é de R$"+total);
		System.out.println("Digite:");
		System.out.println("1 - Confirmar a compra");
		System.out.println("2 - Cancelar a compra");
		int resposta = entrada.nextInt();
		
		if (resposta == 1) {
			Conta conta = ContaDAO.getContaPorCliente(cliente);
			conta.transferencia(contaEstabelecimento, total);
			ContaDAO.atualizar(conta);
			ContaDAO.atualizar(contaEstabelecimento);
			
			Compra compra = new Compra(produto, quantidade, total, cliente);
			CompraDAO.salvar(compra);
			
			System.out.println("Compra realizada com sucesso!");
		} else {
			System.out.println("Compra cancelada com sucesso!");
		}
		
		menuFuncionario(entrada);
	}
	
	public static void produtosVendidos(Scanner entrada) {
		CompraDAO.listar();
		menuFuncionario(entrada);
	}
	
	public static void clientesMaisCompram(Scanner entrada) {
		CompraDAO.getClientesMaisCompram();
		menuFuncionario(entrada);
	}
	
	public static void clientesMaisOperam(Scanner entrada ) {
		OperacaoDAO.getClientesMaisOperam();
		menuFuncionario(entrada);
	}
}
