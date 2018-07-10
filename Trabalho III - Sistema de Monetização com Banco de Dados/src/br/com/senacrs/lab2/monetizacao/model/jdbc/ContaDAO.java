package br.com.senacrs.lab2.monetizacao.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.senacrs.lab2.monetizacao.controller.Menu;
import br.com.senacrs.lab2.monetizacao.model.entidades.Conta;

public class ContaDAO {
	static Scanner entrada = new Scanner(System.in);
	
	public static void salvar (Conta conta) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "INSERT INTO contas (id, dono, saldo) VALUES (?,?,?)";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
 
			prepara.setInt(1, conta.getNumero());
			prepara.setLong(2, conta.getDono());
			prepara.setDouble(3, conta.getSaldo()); 
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Conta cadastrada com sucesso!");

		} catch(SQLException e) { 
			System.out.println("Erro ao cadastrar a conta no banco.");
			e.printStackTrace();
		}
	}
	
	public static void deletar(Conta conta) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "DELETE FROM contas WHERE id=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setInt(1, conta.getNumero());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Conta deletada com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao deletar a conta do banco.");
		}
	}
	
	public static void atualizar(Conta conta) {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "UPDATE contas SET saldo=?, dono=?  WHERE id=?";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			
			prepara.setDouble(1, conta.getSaldo());
			prepara.setLong(2, conta.getDono());
			prepara.setInt(3, conta.getNumero());
			prepara.execute();
			
			prepara.close();
			conexao.close();
			
			System.out.println("Conta atualizada com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro ao atualizar a conta do banco.");
		}
	}
	
	public static void listar() {
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM contas";
			
			PreparedStatement prepara = conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while (resultado.next()) {
				System.out.println("ID: " + resultado.getInt("id"));
				System.out.println("Dono: " + resultado.getLong("dono"));
				System.out.println("Saldo: R$" + resultado.getDouble("saldo"));
				System.out.println("");
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar as contas do banco.");
		}
	}
	
	public static Conta getContaPorCliente(long cliente) {
		Conta conta = new Conta(0, 0, 0);
		
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM contas WHERE dono = ?";

			PreparedStatement prepara = conexao.prepareStatement(sql);
			prepara.setLong(1, cliente); 
			ResultSet resultado = prepara.executeQuery();

			if (resultado.next()) {
				conta.setNumero(resultado.getInt("id"));
				conta.setDono(resultado.getLong("dono"));
				conta.setSaldo(resultado.getDouble("saldo"));
			} else {
				System.out.println("Não foram encontrado registros. Operação abortada!");
				Menu.iniciar(entrada);
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar a conta do banco.");
		}
		
		return conta;
	}
	
	public static Conta getContaPorConta(int minhaConta) {
		Conta conta = new Conta(0, 0, 0);
		
		try {
			Connection conexao = Conexao.getConnection();
			String sql = "SELECT * FROM contas WHERE id = ?";

			PreparedStatement prepara = conexao.prepareStatement(sql);
			prepara.setInt(1, minhaConta); 
			ResultSet resultado = prepara.executeQuery();

			if (resultado.next()) {
				conta.setNumero(resultado.getInt("id"));
				conta.setDono(resultado.getLong("dono"));
				conta.setSaldo(resultado.getDouble("saldo"));
			} else {
				System.out.println("Não foram encontrado registros. Operação abortada!");
				Menu.iniciar(entrada);
			}
			
			prepara.close();
			conexao.close();
			
		} catch(SQLException e) {
			System.out.println("Erro ao listar a conta do banco.");
		}
		
		return conta;
	}
}
