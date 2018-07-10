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
	
	static Conta contaEstabelecimento = ContaDAO.getContaPorCliente(123);
	
	/* Menu Principal */
	
	public static void menuFuncionario(Scanner entrada) {
		System.out.println("MENU FUNCIONÁRIO");
		System.out.println("1 - CRUD cliente");
		System.out.println("2 - CRUD produto");
		System.out.println("3 - Fazer uma venda");
		System.out.println("4 - Relatórios");
		System.out.println("0 - Sair");
		
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int opcao = Integer.parseInt(temp);
		
		switch (opcao) {
			case 1: subMenuClientes(entrada);
			case 2: subMenuProdutos(entrada);
			case 3: fazerCompra(entrada);
			case 4: subMenuRelatorios(entrada);
			case 0: Menu.iniciar(entrada);
			default: break;
		}
	}
	
	
	/* Submenus */
	
	public static void subMenuClientes(Scanner entrada) {
		System.out.println("MENU FUNCIONÁRIO -> Cliente");
		System.out.println("1 - Listar clientes");
		System.out.println("2 - Verificar cadastro de cliente");
		System.out.println("3 - Cadastrar cliente");
		System.out.println("4 - Editar cliente");
		System.out.println("5 - Remover cliente");
		System.out.println("0 - Sair");
		
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int opcao = Integer.parseInt(temp);
		
		switch (opcao) {
			case 1: listarClientes(entrada);
			case 2: buscarCliente(entrada);
			case 3: cadastrarCliente(entrada);
			case 4: editarCliente(entrada);
			case 5: removerCliente(entrada);
			case 0: menuFuncionario(entrada);
			default: break;
		}
	}
	
	public static void subMenuProdutos(Scanner entrada) {
		System.out.println("MENU FUNCIONÁRIO -> Produtos");
		System.out.println("1 - Listar produtos");
		System.out.println("2 - Cadastrar produto");
		System.out.println("3 - Editar produto");
		System.out.println("4 - Remover produto");
		System.out.println("0 - Sair");
		
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int opcao = Integer.parseInt(temp);
			
		switch (opcao) {
			case 1: listarProdutos(entrada);
			case 2: cadastrarProduto(entrada);
			case 3: editarProduto(entrada);
			case 4: removerProduto(entrada);
			case 0: menuFuncionario(entrada);
			default: break;
		}
	}
	
	public static void subMenuRelatorios(Scanner entrada) {
		System.out.println("MENU FUNCIONÁRIO -> Relatórios");
		System.out.println("1 - Relatório de produtos vendidos");
		System.out.println("2 - Relatório de clientes que mais compram");
		System.out.println("3 - Relatório de clientes que mais realizam operações de monetização");
		
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int opcao = Integer.parseInt(temp);
		
		switch (opcao) {
			case 1: produtosVendidos(entrada);
			case 2: clientesMaisCompram(entrada);
			case 3: clientesMaisOperam(entrada);
			case 0: menuFuncionario(entrada);
			default: break;
		}
	}
	
	
	/* Submenu de Clientes */
	public static void listarClientes(Scanner entrada) {
		ClienteDAO.listar();
		menuFuncionario(entrada);
	}
	
	public static void buscarCliente(Scanner entrada) {		
		
		System.out.println("Digite o CPF do cliente:");
		String temp = entrada.next();
		
		ValidarDados.verificaLong(temp);
		long cpf = Long.parseLong(temp);
		
		ClienteDAO.listarUm(cpf);
		
		menuFuncionario(entrada);

		return;
	}
	
	public static void cadastrarCliente(Scanner entrada) {
		System.out.println("Digite o CPF: ");
		String temp = entrada.next();

		ValidarDados.verificaLong(temp);
		long cpf = Long.parseLong(temp);
		
		if (cpf <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		System.out.println("Digite o nome: ");
		String nome = entrada.next();
		ValidarDados.verificaString(nome);
		
		System.out.println("Digite o e-mail: ");
		String email = entrada.next();
		ValidarDados.verificaString(email);
		
		System.out.println("Digite o número da sua conta: ");
		temp = entrada.next();
		
		ValidarDados.verificaInteger(temp);
		int numeroConta = Integer.parseInt(temp);
		
		if (numeroConta <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		/* Cria conta do cliente */
		Conta conta = new Conta(numeroConta, cpf,0);
		ContaDAO.salvar(conta);
		
		/* Cria cliente e vincula a conta */
		Cliente cliente = new Cliente(cpf, nome, email, conta);
		ClienteDAO.salvar(cliente);
		
		menuFuncionario(entrada);
	}
	
	public static void editarCliente(Scanner entrada) {
		System.out.println("Digite o CPF do cliente que deseja alterar: ");
		String temp = entrada.next();
		
		ValidarDados.verificaLong(temp);
		long cpf = Long.parseLong(temp);
		
		if (cpf <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		Cliente cliente01 = ClienteDAO.getClientePorCpf(cpf);
		
		System.out.println("Informe qual opção deseja alterar: ");
		System.out.println("1 - CPF");
		System.out.println("2 - Nome");
		System.out.println("3 - E-mail");
		System.out.println("0 - Voltar");
		temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int opcao = Integer.parseInt(temp);
		
		
		switch (opcao) {
			case 1:
				System.out.println("Digite o novo CPF: ");
				temp = entrada.next();

				ValidarDados.verificaLong(temp);
				long cpf2 = Long.parseLong(temp);
				
				
				ClienteDAO.deletar(cliente01);
				cliente01.setCpf(cpf2);
				ClienteDAO.salvar(cliente01);
				subMenuClientes(entrada);
			case 2:
				System.out.println("Digite o novo nome: ");
				String nome = entrada.next();
				ValidarDados.verificaString(nome);
				
				cliente01.setNome(nome);
				ClienteDAO.atualizar(cliente01);
				subMenuClientes(entrada);
			case 3:
				System.out.println("Digite o novo e-mail: ");
				String email = entrada.next();
				ValidarDados.verificaString(email);
				
				cliente01.setEmail(email);
				ClienteDAO.atualizar(cliente01);
				subMenuClientes(entrada);
			case 0:
				subMenuClientes(entrada);
			default: break;
		}

	}

	public static void removerCliente(Scanner entrada) {
		System.out.println("Digite o CPF do cliente: ");
		String temp = entrada.next();
		
		ValidarDados.verificaLong(temp);
		long cpf = Long.parseLong(temp);
		
		if (cpf <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		Conta conta = ContaDAO.getContaPorCliente(cpf);
		ContaDAO.deletar(conta);
		
		Cliente cliente = new Cliente(cpf, "", "", conta);
		ClienteDAO.deletar(cliente);
		menuFuncionario(entrada);
	}
	
	/* Submenu de Produtos */
	
	public static void listarProdutos(Scanner entrada) {
		ProdutoDAO.listar();
		menuFuncionario(entrada);
	}
	
	public static void cadastrarProduto(Scanner entrada) {
		System.out.println("Digite o código do produto:");
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int id = Integer.parseInt(temp);
		
		if (id <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		System.out.println("Digite o nome do produto:");
		String nome = entrada.next();
		ValidarDados.verificaString(nome);
		
		System.out.println("Digite o preço do produto (somente números | Ex.: 10.50):");
		temp = entrada.next();
		ValidarDados.verificaDouble(temp);
		double preco = Double.parseDouble(temp);
		
		if (preco <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		Produto produto = new Produto(id, nome, preco);
		ProdutoDAO.salvar(produto);
		
		menuFuncionario(entrada);
	}
	
	public static void editarProduto (Scanner entrada) {
		System.out.println("Informe o código do produto: ");
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int id = Integer.parseInt(temp);

		if (id <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		Produto produto01 = ProdutoDAO.getProdutoPorId(id);
		
		System.out.println("Informe qual opção deseja alterar: ");
		System.out.println("1 - Código");
		System.out.println("2 - Nome");
		System.out.println("3 - Preço");
		System.out.println("0 - Voltar");
		temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int opcao = Integer.parseInt(temp);
		
		switch (opcao) { 
			case 1:
				System.out.println("Digite o novo código: ");
				temp = entrada.next();

				ValidarDados.verificaInteger(temp);
				int id2 = Integer.parseInt(temp);
				
				if (id2 <= 0) {
					System.out.println("Valor inválido.");
					menuFuncionario(entrada);
				}
				
				ProdutoDAO.deletar(produto01);
				produto01.setId(id2);
				ProdutoDAO.salvar(produto01);
				menuFuncionario(entrada);
			case 2:
				System.out.println("Digite o novo nome: ");
				String nome = entrada.next();
				ValidarDados.verificaString(nome);
				
				produto01.setNome(nome);
				ProdutoDAO.atualizar(produto01);
				menuFuncionario(entrada);
			case 3:
				System.out.println("Digite o novo preço: ");
				temp = entrada.next();
				ValidarDados.verificaDouble(temp);
				double preco = Double.parseDouble(temp);
				
				produto01.setPreco(preco);
				ProdutoDAO.atualizar(produto01);
				menuFuncionario(entrada);
			case 0:
				menuFuncionario(entrada);
			default: break;
		}
	}
	
	public static void removerProduto(Scanner entrada) {
		System.out.println("Digite o código do produto: ");
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int id = Integer.parseInt(temp);
		
		if (id <= 0) {
			System.out.println("Operação abortada. Dado inválido.");
		}
		
		Produto produto = new Produto(id, null, id);
		ProdutoDAO.deletar(produto);
		
		menuFuncionario(entrada);
	}

	/* Submenu de Relatórios */
	
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
	
	/* Realizar venda */
	
	public static void fazerCompra(Scanner entrada) {
		ProdutoDAO.listar();
		
		System.out.println("Digite o código do produto:");
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int produto = Integer.parseInt(temp);
		
		if (produto <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		System.out.println("Digite a quantidade do produto:");
		temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int quantidade = Integer.parseInt(temp);
		
		if (quantidade <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
		System.out.println("Digite o CPF do cliente: ");
		temp = entrada.next();
		
		ValidarDados.verificaLong(temp);
		long cliente = Long.parseLong(temp);
		if (cliente <= 0) {
			System.out.println("Valor inválido.");
			menuFuncionario(entrada);
		}
		
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
}
