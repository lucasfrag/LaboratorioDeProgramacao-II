package br.com.senacrs.lab2.monetizacao.principal;

import br.com.senacrs.lab2.monetizacao.entidades.Produto;
import br.com.senacrs.lab2.monetizacao.jdbc.ProdutoDAO;

public class Principal {

	public static void main(String[] args) {
		Produto produto1 = new Produto(1, "Processador Intel Core i9", 10000.000);
		Produto produto2 = new Produto(2, "Windows 10", 100.00);
		
		// Salvar
		ProdutoDAO.salvar(produto1);
		ProdutoDAO.salvar(produto2);
		
		// Listar
		ProdutoDAO.listar();
		
		// Remover
		ProdutoDAO.deletar(produto2);
		
		// Editar
		produto1.setNome("Windows 7");
		ProdutoDAO.atualizar(produto1);
		
		// Listar
		ProdutoDAO.listar();
	}
}
