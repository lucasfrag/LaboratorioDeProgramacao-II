package br.com.senacrs.lab2.monetizacao.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.senacrs.lab2.monetizacao.controller.Menu;
import br.com.senacrs.lab2.monetizacao.model.entidades.Produto;

public class ProdutoDAO {
	static Scanner entrada = new Scanner(System.in);
	
	public static void salvar (Produto produto) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "INSERT INTO produtos (id, nome, preco) VALUES (?,?,?)";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
 
			prepara.setDouble(1, produto.getId());
			prepara.setString(2, produto.getNome()); 
			prepara.setDouble(3, produto.getPreco()); 
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Produto cadastrado com sucesso!");

		} catch(SQLException e) { 
			System.out.println("Erro ao cadastrar o produto no banco.");
			e.printStackTrace();
		}
	}
	
	public static void deletar(Produto produto) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "DELETE FROM produtos WHERE id=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setInt(1, produto.getId());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Produto deletado com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao deletar o produto do banco.");
		}
	}
	
	public static void atualizar(Produto produto) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "UPDATE produtos SET nome=?, preco=? WHERE id=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setString(1, produto.getNome()); 
			prepara.setDouble(2, produto.getPreco());
			prepara.setInt(3, produto.getId());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Produto atualizado com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao atualizar o produto do banco.");
		}
	}
	
	public static void listar() {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM produtos";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("ID: " + resultado.getString("id"));
				System.out.println("Nome: " + resultado.getString("nome"));
				System.out.println("Preço: R$" + resultado.getDouble("preco"));
				System.out.println("");
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar os produtos do banco.");
		}
	}

	public static Produto getProdutoPorId(int id) {
		Produto produto = new Produto(0, null, 0);
		
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM produtos WHERE id = ?";

			PreparedStatement prepara = conexao.prepareStatement(sql);
			prepara.setInt(1, id); 
			ResultSet resultado = prepara.executeQuery();

			if (resultado.next()) {
				produto.setId(resultado.getInt("id"));
				produto.setNome(resultado.getString("nome"));
				produto.setPreco(resultado.getDouble("preco"));
			} else {
				System.out.println("Não foram encontrado registros. Operação abortada!");
				Menu.iniciar(entrada);
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar o produto do banco.");
		}
		
		return produto;
	}
}
