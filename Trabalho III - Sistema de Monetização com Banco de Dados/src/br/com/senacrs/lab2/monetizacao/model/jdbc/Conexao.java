package br.com.senacrs.lab2.monetizacao.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {
		Connection conexao = null;
		
		String url = "jdbc:postgresql://localhost:5432/monetizacao";
		String usuario  = "postgres";
		String senha = "123456";
		
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Falha na conexão.");
		}
		return conexao;
	}
}
