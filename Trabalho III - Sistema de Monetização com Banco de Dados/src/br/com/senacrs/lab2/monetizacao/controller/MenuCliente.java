package br.com.senacrs.lab2.monetizacao.controller;

import java.util.Scanner;

import br.com.senacrs.lab2.monetizacao.model.entidades.Conta;
import br.com.senacrs.lab2.monetizacao.model.entidades.Operacao;
import br.com.senacrs.lab2.monetizacao.model.jdbc.CompraDAO;
import br.com.senacrs.lab2.monetizacao.model.jdbc.ContaDAO;
import br.com.senacrs.lab2.monetizacao.model.jdbc.OperacaoDAO;

public class MenuCliente {

	public static void menuCliente(Scanner entrada) {
		System.out.println("MENU CLIENTE");
		System.out.println("1 - Ver saldo");
		System.out.println("2 - Fazer transfêrencia para outra conta");
		System.out.println("3 - Depositar nessa conta");
		System.out.println("4 - Relatório de compras feitas");
		System.out.println("0 - Sair");
		
		int opcao = entrada.nextInt();
		
		if (ValidarDados.isInteger(opcao) && opcao > 4 && opcao < 0) {
			System.out.println("Valor inválido.");
			menuCliente(entrada);
		}
		
		switch (opcao) {
			case 1: verSaldo(entrada);
			case 2: fazerTransferencia(entrada);
			case 3: fazerDeposito(entrada);
			case 4: relatorioCompras(entrada);
			case 0: Menu.iniciar(entrada);
			default: break;
		}
		
	}
	
	public static void verSaldo(Scanner entrada) {
		System.out.println("Digite o número da conta: ");
		int minhaConta = entrada.nextInt();
		
		System.out.println("Saldo da conta: R$" + ContaDAO.getContaPorConta(minhaConta).getSaldo());
		menuCliente(entrada);
	}
	
	public static void fazerTransferencia(Scanner entrada) {
		System.out.println("Digite o número da sua conta: ");
		int minhaConta = entrada.nextInt();
		Conta conta1 = ContaDAO.getContaPorConta(minhaConta);
		
		System.out.println("Digite o número da conta que irá receber o depósito: ");
		int outraConta = entrada.nextInt();
		Conta conta2 = ContaDAO.getContaPorConta(outraConta);
		
		System.out.println("Digite o valor da transfêrencia: ");
		double valor = entrada.nextDouble();
		
		
		conta1.transferencia(conta2, valor);
		
		ContaDAO.atualizar(conta1);
		ContaDAO.atualizar(conta2);
		
		Operacao transferencia = new Operacao(minhaConta, outraConta, valor);
		OperacaoDAO.salvar(transferencia);
		
		menuCliente(entrada);
	}
	
	public static void fazerDeposito(Scanner entrada) {
		System.out.println("Digite o número da conta: ");
		int numero = entrada.nextInt();
		
		if (ValidarDados.isInteger(numero) != true && numero <= 0) {
			System.out.println("Valor inválido!");
			menuCliente(entrada);
		}
		
		System.out.println("Digite o valor do depósito: ");
		double valor = entrada.nextDouble();
		
		if (ValidarDados.isDouble(valor) != true && valor <= 0) {
			System.out.println("Valor inválido!");
			menuCliente(entrada);
		}
		
		Conta conta = ContaDAO.getContaPorConta(numero);
		conta.setSaldo(conta.getSaldo() + valor);
		
		ContaDAO.atualizar(conta);
		
		Operacao deposito = new Operacao(numero, numero, valor);
		OperacaoDAO.salvar(deposito);
		
		menuCliente(entrada);
	}
	
	public static void relatorioCompras(Scanner entrada) {
		System.out.println("Digite o seu CPF: ");
		long cliente = entrada.nextLong();
		
		CompraDAO.getCompraPorCliente(cliente);
		menuCliente(entrada);
	}

}
