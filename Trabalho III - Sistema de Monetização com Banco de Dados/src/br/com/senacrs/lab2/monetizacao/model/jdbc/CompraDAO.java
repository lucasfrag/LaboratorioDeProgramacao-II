package br.com.senacrs.lab2.monetizacao.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senacrs.lab2.monetizacao.model.entidades.Compra;

public class CompraDAO {
	
	public static void salvar (Compra compra) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "INSERT INTO compras (produto, quantidade, total, cliente) VALUES (?,?,?,?)";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);

			prepara.setInt(1, compra.getProduto()); 
			prepara.setInt(2, compra.getQuantidade());
			prepara.setDouble(3, compra.getTotal());
			prepara.setLong(4, compra.getCliente());  
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Compra cadastrada com sucesso!");

		} catch(SQLException e) { 
			System.out.println("Erro ao cadastrar a compra no banco.");
			e.printStackTrace();
		}
	}
	
	public static void listar() {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM compras";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("Data e Hora: " + resultado.getString("dataHora"));
				System.out.println("Código do Produto: " + resultado.getInt("produto"));
				System.out.println("Quantidade: " + resultado.getInt("quantidade"));
				System.out.println("Total Gasto: R$" + resultado.getDouble("total"));
				System.out.println("Cliente: " + resultado.getLong("cliente"));
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar as compras do banco.");
		}
	}
	
	public static void getCompraPorCliente(long cliente) {
	
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM compras WHERE cliente = ?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			prepara.setLong(1, cliente);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("Data e Hora: " + resultado.getString("dataHora"));
				System.out.println("Código do Produto: " + resultado.getInt("produto"));
				System.out.println("Quantidade: " + resultado.getInt("quantidade"));
				System.out.println("Total Gasto: R$" + resultado.getDouble("total"));
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar as compras do banco.");
		}
		
	}

	public static void getClientesMaisCompram() {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT count(*) as NrVezes, cliente FROM compras GROUP BY cliente ORDER BY NrVezes DESC";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("CPF do Cliente: " + resultado.getLong("cliente"));
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar as compras do banco.");
		}
	}
}
