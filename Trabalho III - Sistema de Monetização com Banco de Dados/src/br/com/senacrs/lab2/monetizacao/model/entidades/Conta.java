package br.com.senacrs.lab2.monetizacao.model.entidades;

import java.util.Scanner;

import br.com.senacrs.lab2.monetizacao.controller.Menu;
import br.com.senacrs.lab2.monetizacao.controller.MenuCliente;

public class Conta {
	private int numero;
	private long dono;
	private double saldo;

	Scanner entrada = new Scanner(System.in);
	
	public Conta(int numero, long dono, double saldo) {
		this.dono = dono;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	/* Métodos especificos */
	public void visualizarSaldo(Conta conta) {
		conta.getSaldo();
	}

	public void transferencia(Conta conta, double valor) {
		if (saldo >= valor && valor > 0) {
			setSaldo(getSaldo() - valor);
			conta.setSaldo(conta.getSaldo() + valor);
			System.out.println("Transferência realizada com sucesso");
			System.out.println();
		} else {
			System.out.println("Saldo insuficiente. Operação abortada!");
			System.out.println();
			Menu.iniciar(entrada);
		}
	}

	public void deposito(double valor) {
		if (valor > 0) {
			saldo = saldo + valor;
			System.out.println("Depósito realizado com sucesso!");
			System.out.println();
		} else {
			System.out.println("Valor inválido!");
			System.out.println();
			MenuCliente.menuCliente(entrada);
		}

	}

	/* Getters */
	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public long getDono() {
		return dono;
	}

	/* Setters */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setDono(long dono) {
		this.dono = dono;
	}

}