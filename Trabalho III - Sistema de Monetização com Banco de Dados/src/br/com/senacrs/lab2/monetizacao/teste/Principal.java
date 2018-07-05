package br.com.senacrs.lab2.monetizacao.teste;

import br.com.senacrs.lab2.monetizacao.model.entidades.Cliente;
import br.com.senacrs.lab2.monetizacao.model.entidades.Conta;
import br.com.senacrs.lab2.monetizacao.model.entidades.Funcionario;
import br.com.senacrs.lab2.monetizacao.model.entidades.Produto;
import br.com.senacrs.lab2.monetizacao.model.jdbc.ClienteDAO;
import br.com.senacrs.lab2.monetizacao.model.jdbc.ContaDAO;
import br.com.senacrs.lab2.monetizacao.model.jdbc.FuncionarioDAO;
import br.com.senacrs.lab2.monetizacao.model.jdbc.ProdutoDAO;

public class Principal {

	public static void main(String[] args) {
		
		// Entidades
		Conta conta1 = new Conta(1, 1, 100.50);
		Conta conta2 = new Conta(2, 2, 200.38);
		
		Cliente cliente1 = new Cliente(0, null, null, null);
		Cliente cliente2 = new Cliente(0, null, null, null);
		
		Funcionario funcionario1 = new Funcionario(123456789, "Funcionario 1", "", "", "");
		Funcionario funcionario2 = new Funcionario(234567891, "Funcionario 2", "", "", "");

		Produto produto1 = new Produto(1, "Produto 1", 100);
		Produto produto2 = new Produto(2, "Produto 2", 200.50);
		
		// SalvarDAO
		ContaDAO.salvar(conta1);
		ContaDAO.salvar(conta2);
		
		ClienteDAO.salvar(cliente1);
		ClienteDAO.salvar(cliente2);
		
		FuncionarioDAO.salvar(funcionario1);
		FuncionarioDAO.salvar(funcionario2);
		
		ProdutoDAO.salvar(produto1);
		ProdutoDAO.salvar(produto2);
		
		// EditarDAO
		cliente1.setNome("Outro nome pro cliente");
		funcionario1.setNome("Outro nome pro funcionário");
		produto1.setPreco(1.50);
		
		ClienteDAO.atualizar(cliente1);
		FuncionarioDAO.atualizar(funcionario1);
		ProdutoDAO.atualizar(produto1);
		
		// Listar
		ClienteDAO.listar();
		FuncionarioDAO.listar();
		ProdutoDAO.listar();
	}

}
