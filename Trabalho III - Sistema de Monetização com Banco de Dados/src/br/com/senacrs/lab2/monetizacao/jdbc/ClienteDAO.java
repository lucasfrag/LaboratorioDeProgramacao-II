package br.com.senacrs.lab2.monetizacao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senacrs.lab2.monetizacao.entidades.Cliente;

public class ClienteDAO {
	public void salvar (Cliente cliente) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "INSERT INTO clientes (cpf, nome, email, conta) VALUES (?,?,?,?)";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);

			prepara.setLong(1, cliente.getCpf()); 
			prepara.setString(2, cliente.getNome()); 
			prepara.setString(3, cliente.getEmail()); 
			// prepara.setConta(4, cliente.getConta()); 
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Cliente cadastrado com sucesso!");

		} catch(SQLException e) { 
			System.out.println("Erro ao cadastrar o cliente no banco.");
			e.printStackTrace();
		}
	}
	
	public void deletar(Cliente cliente) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "DELETE FROM clientes WHERE id=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setLong(1, cliente.getCpf());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Cliente deletado com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao deletar o cliente do banco.");
		}
	}
	
	public void atualizar(Cliente cliente) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "UPDATE clientes SET nome=?, email=?, conta=? WHERE cpf=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setString(1, cliente.getNome());
			prepara.setString(2, cliente.getEmail());
			//prepara.setString(3, cliente.getConta());
			prepara.setLong(4, cliente.getCpf());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Cliente atualizado com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao atualizar o cliente do banco.");
		}
	}
	
	public void listar() {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM clientes";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("Nome: " + resultado.getString("nome"));
				System.out.println("CPF: " + resultado.getLong("cpf"));
				System.out.println("E-mail: " + resultado.getString("email"));
				System.out.println("Conta: " + resultado.getString("conta"));
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar os usuários do banco.");
		}
	}
}
