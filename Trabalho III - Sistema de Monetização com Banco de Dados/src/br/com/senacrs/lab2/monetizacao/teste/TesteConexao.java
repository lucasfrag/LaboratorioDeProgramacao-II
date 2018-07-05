package br.com.senacrs.lab2.monetizacao.teste;

import br.com.senacrs.lab2.monetizacao.model.jdbc.Conexao;

public class TesteConexao {
	public static void main(String[] args) {
		Conexao.getConnection();
	}
}

