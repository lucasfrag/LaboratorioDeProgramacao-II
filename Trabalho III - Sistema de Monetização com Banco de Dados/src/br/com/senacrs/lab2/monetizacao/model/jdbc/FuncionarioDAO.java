package br.com.senacrs.lab2.monetizacao.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senacrs.lab2.monetizacao.model.entidades.Funcionario;

public class FuncionarioDAO {
	
	public static void salvar (Funcionario funcionario) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "INSERT INTO funcionarios (cpf, nome, login, senha) VALUES (?,?,?,?)";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);

			prepara.setLong(1, funcionario.getCpf()); 
			prepara.setString(2, funcionario.getNome()); 
			prepara.setString(3, funcionario.getLogin()); 
			prepara.setString(4, funcionario.getSenha()); 
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Funcionário cadastrado com sucesso!");

		} catch(SQLException e) { 
			System.out.println("Erro ao cadastrar o funcionário no banco.");
			e.printStackTrace();
		}
	}
	
	public void deletar(Funcionario funcionario) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "DELETE FROM funcionarios WHERE cpf=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setLong(1, funcionario.getCpf());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Funcionário deletado com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao deletar o funcionário do banco.");
		}
	}
	
	public static void atualizar(Funcionario funcionario) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "UPDATE funcionarios SET nome=?, login=?, senha=? WHERE cpf=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setString(1, funcionario.getNome());
			prepara.setString(2, funcionario.getLogin());
			prepara.setString(3, funcionario.getSenha());
			prepara.setLong(4, funcionario.getCpf());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Funcionário atualizado com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao atualizar o funcionário do banco.");
		}
	}
	
	public static void listar() {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM funcionários";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("Nome: " + resultado.getString("nome"));
				System.out.println("CPF: " + resultado.getLong("cpf"));
				System.out.println("Login: " + resultado.getString("login"));
				System.out.println("Senha: " + resultado.getString("senha"));
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar os funcionários do banco.");
		}
	}
	
	public static void logar(String login, String senha) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM funcionários WHERE login = ? AND senha = ?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			prepara.setString(1, login);
			prepara.setString(2, senha);
			
			ResultSet resultado = prepara.executeQuery();
			
			if (resultado.getRow() != 0) {
				System.out.println("Usuário encontrado!");
			} else {
				System.out.println("Os dados informados não foram encontrados. Por favor, tente novamente!");
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar os funcionários do banco.");
		}
	}
}
