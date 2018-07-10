package br.com.senacrs.lab2.monetizacao.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.senacrs.lab2.monetizacao.controller.Menu;
import br.com.senacrs.lab2.monetizacao.model.entidades.Cliente;

public class ClienteDAO {
	static Scanner entrada = new Scanner(System.in);
	public static void salvar (Cliente cliente) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "INSERT INTO clientes (cpf, nome, email) VALUES (?,?,?)";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);

			prepara.setLong(1, cliente.getCpf()); 
			prepara.setString(2, cliente.getNome()); 
			prepara.setString(3, cliente.getEmail()); 
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Cliente cadastrado com sucesso!");

		} catch(SQLException e) { 
			System.out.println("Erro ao cadastrar o cliente no banco.");
			e.printStackTrace();
		}
	}
	
	public static void deletar(Cliente cliente) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "DELETE FROM clientes WHERE cpf=?";
			
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
	
	public static void atualizar(Cliente cliente) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "UPDATE clientes SET nome=?, email=? WHERE cpf=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setString(1, cliente.getNome());
			prepara.setString(2, cliente.getEmail());
			prepara.setLong(3, cliente.getCpf());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Cliente atualizado com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao atualizar o cliente do banco.");
		}
	}
		
	public static void listar() {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM clientes";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("Nome: " + resultado.getString("nome"));
				System.out.println("CPF: " + resultado.getLong("cpf"));
				System.out.println("E-mail: " + resultado.getString("email"));
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar os usu�rios do banco.");
		}
	}

	public static void listarUm(long cpf) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM clientes WHERE cpf=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setLong(1, cpf);
			
			ResultSet resultado = prepara.executeQuery();

			if (resultado.next() != false) {
				System.out.println("Nome: " + resultado.getString("nome"));
				System.out.println("CPF: " + resultado.getLong("cpf"));
				System.out.println("E-mail: " + resultado.getString("email"));
			} else {
				System.out.println("N�o foram encontrado registros.");
			}
		
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao localizar o cliente do banco.");
		}
	}
	
	public static Cliente getClientePorCpf(long cpf) {
		Cliente cliente = new Cliente(0, null, null, null);
		
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM clientes WHERE cpf = ?";

			PreparedStatement prepara = conexao.prepareStatement(sql);
			prepara.setLong(1, cpf); 
			ResultSet resultado = prepara.executeQuery();
			
			if (resultado.next()) {
				cliente.setCpf(resultado.getInt("cpf"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setEmail(resultado.getString("email"));
			} else {
				System.out.println("N�o foram encontrado registros. Opera��o abortada!");
				Menu.iniciar(entrada);
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar o cliente do banco.");
		}
		
		return cliente;
	}

}
