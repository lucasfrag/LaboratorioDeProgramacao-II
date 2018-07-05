package br.com.senacrs.lab2.monetizacao.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senacrs.lab2.monetizacao.model.entidades.Operacao;

public class OperacaoDAO {
	
	public static void salvar (Operacao operacao) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "INSERT INTO operacoes (remetente, destinatario, valor) VALUES (?,?,?)";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
 
			prepara.setInt(1, operacao.getRemetente());
			prepara.setInt(2, operacao.getDestinatario()); 
			prepara.setDouble(3, operacao.getValor()); 
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Operação cadastrada com sucesso!");

		} catch(SQLException e) { 
			System.out.println("Erro ao cadastrar a operação no banco.");
			e.printStackTrace();
		}
	}
	
	public static void getClientesMaisOperam() {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT count(*) as NrVezes, remetente FROM operacoes GROUP BY remetente ORDER BY NrVezes DESC";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("CPF de quem realizou a operação: " + resultado.getLong("remetente"));
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar as operações do banco.");
		}
	}
}
