package br.com.senacrs.lab2.monetizacao.entidades;

public class Conta {
	private int numero;
	private double saldo;

	public Conta(int numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	public void visualizarSaldo(Conta conta) {
		conta.getSaldo();
	}

	public void transferencia(Conta conta, double valor) {
		if (saldo >= valor) {
			saldo = saldo - valor;
			conta.saldo = saldo + valor;
			System.out.println("Transfer�ncia realizada com sucesso");
			System.out.println();
		} else {
			System.out.println("Saldo insuficiente para realizar opera��o!");
			System.out.println();
		}
	}

	public void deposito(double valor) {
		if (valor > 0) {
			saldo = saldo + valor;
			System.out.println("Dep�sito realizado com sucesso!");
			System.out.println();
		} else {
			System.out.println("Valor inv�lido!");
			System.out.println();
		}

	}

	/* Getters */
	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	/* Setters */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


}