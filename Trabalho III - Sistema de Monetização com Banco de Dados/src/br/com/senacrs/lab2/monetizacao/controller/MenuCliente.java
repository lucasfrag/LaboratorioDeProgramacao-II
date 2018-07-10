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
		
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int opcao = Integer.parseInt(temp);
		
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
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int minhaConta = Integer.parseInt(temp);
		
		if (minhaConta <= 0) {
			System.out.println("Valor inválido.");
			menuCliente(entrada);
		}
		
		System.out.println("Saldo da conta: R$" + ContaDAO.getContaPorConta(minhaConta).getSaldo());
		menuCliente(entrada);
	}
	
	public static void fazerTransferencia(Scanner entrada) {
		System.out.println("Digite o número da sua conta: ");
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int minhaConta = Integer.parseInt(temp);
		
		if (minhaConta <= 0) {
			System.out.println("Valor inválido.");
			menuCliente(entrada);
		}
		
		Conta conta1 = ContaDAO.getContaPorConta(minhaConta);
		
		System.out.println("Digite o número da conta que irá receber o depósito: ");
		temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int outraConta = Integer.parseInt(temp);
		
		if (outraConta <= 0) {
			System.out.println("Valor inválido.");
			menuCliente(entrada);
		}
		
		Conta conta2 = ContaDAO.getContaPorConta(outraConta);
		
		System.out.println("Digite o valor da transfêrencia: ");
		temp = entrada.next();
		ValidarDados.verificaDouble(temp);
		
		double valor = Double.parseDouble(temp);
		
		if (valor <= 0) {
			System.out.println("Valor inválido!");
			menuCliente(entrada);
		}
		
		conta1.transferencia(conta2, valor);
		
		ContaDAO.atualizar(conta1);
		ContaDAO.atualizar(conta2);
		
		Operacao transferencia = new Operacao(minhaConta, outraConta, valor);
		OperacaoDAO.salvar(transferencia);
		
		menuCliente(entrada);
	}
	
	public static void fazerDeposito(Scanner entrada) {
		System.out.println("Digite o número da conta: ");
		String temp = entrada.next();

		ValidarDados.verificaInteger(temp);
		int numero = Integer.parseInt(temp);
		
		if (numero <= 0) {
			System.out.println("Valor inválido!");
			menuCliente(entrada);
		}
		
		
		System.out.println("Digite o valor do depósito: ");
		temp = entrada.next();
		ValidarDados.verificaDouble(temp);
		double valor = Double.parseDouble(temp);
		
		if (valor <= 0) {
			System.out.println("Valor inválido.");
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
		String temp = entrada.next();
		
		ValidarDados.verificaLong(temp);
		long cliente = Long.parseLong(temp);
		if (cliente <= 0) {
			System.out.println("Valor inválido.");
			menuCliente(entrada);
		}
		CompraDAO.getCompraPorCliente(cliente);
		menuCliente(entrada);
	}

}
