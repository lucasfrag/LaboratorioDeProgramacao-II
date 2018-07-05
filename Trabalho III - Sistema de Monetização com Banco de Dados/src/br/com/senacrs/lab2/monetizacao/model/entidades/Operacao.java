package br.com.senacrs.lab2.monetizacao.model.entidades;

public class Operacao {
	int id, remetente, destinatario;
	double valor;
	String dataHora;
	
	public Operacao(int remetente, int destinatario, double valor) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.valor = valor;
	}

	/* Getters */
	
	public int getId() {
		return id;
	}

	public int getRemetente() {
		return remetente;
	}

	public int getDestinatario() {
		return destinatario;
	}

	public double getValor() {
		return valor;
	}

	public String getDataHora() {
		return dataHora;
	}

	/* Setters */
	
	public void setId(int id) {
		this.id = id;
	}

	public void setRemetente(int remetente) {
		this.remetente = remetente;
	}

	public void setDestinatario(int destinatario) {
		this.destinatario = destinatario;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
}
