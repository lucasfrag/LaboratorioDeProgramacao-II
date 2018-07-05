package br.com.senacrs.lab2.monetizacao.controller;

import java.util.Scanner;

public class Menu {
	
	public static void iniciar(Scanner entrada) {
		System.out.println("Digite uma opção para começar: ");
		System.out.println("1 - Logar como cliente:");
		System.out.println("2 - Logar como funcionário:");
		
		int opcao = entrada.nextInt();
		
		if (ValidarDados.isInteger(opcao) && opcao > 2 && opcao <= 0) {
			System.out.println("Valor inválido.");
			iniciar(entrada);
		}
		
		switch (opcao) {
			case 1: MenuCliente.menuCliente(entrada);
			case 2: MenuFuncionario.menuFuncionario(entrada);
			default: break;
		}
	}
	
}
