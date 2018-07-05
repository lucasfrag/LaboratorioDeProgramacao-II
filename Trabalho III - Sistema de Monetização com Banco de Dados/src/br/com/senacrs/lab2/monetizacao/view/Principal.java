package br.com.senacrs.lab2.monetizacao.view;

import java.util.Scanner;

import br.com.senacrs.lab2.monetizacao.controller.Menu;

public class Principal {

	public static void main(String[] args) {		
		Scanner entrada = new Scanner(System.in);
		Menu.iniciar(entrada);
	}
}
