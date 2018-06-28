package br.com.senacrs.lab2.monetizacao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senacrs.lab2.monetizacao.entidades.Carrinho;

public class CarrinhoDAO {
	public void salvar (Carrinho carrinho) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "INSERT INTO compras (cpf, nome, login, senha) VALUES (?,?,?)";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);

			//prepara.setArrayList(1, carrinho.getListaProdutos());  
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Carrinho cadastrado com sucesso!");

		} catch(SQLException e) { 
			System.out.println("Erro ao cadastrar o carrinho no banco.");
			e.printStackTrace();
		}
	}
	
	public void deletar(Carrinho carrinho) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "DELETE FROM usuarios WHERE id=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			//prepara.setLong(1, usuario.getCpf());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Usuário deletado com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao deletar o usuário do banco.");
		}
	}
	
	public void atualizar(Carrinho carrinho) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "UPDATE usuarios SET nome=?, login=?, senha=? WHERE id=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			//prepara.setString(1, usuario.getNome());
			//prepara.setString(2, usuario.getLogin());
			//prepara.setString(3, usuario.getSenha());
			//prepara.setLong(4, usuario.getCpf());
			//prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Usuário atualizado com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao atualizar o usuário do banco.");
		}
	}
	
	public void listar() {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM usuarios";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("Nome: " + resultado.getString("nome"));
				System.out.println("CPF: " + resultado.getLong("cpf"));
				System.out.println("Usuário: " + resultado.getString("usuario"));
				System.out.println("Senha: " + resultado.getString("senha"));
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar os usuários do banco.");
		}
	}
}
