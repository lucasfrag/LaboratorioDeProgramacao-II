package br.com.senacrs.lab2.monetizacao.model.entidades;

public class Compra {
	String dataHora;
	int produto, quantidade;
	long cliente;
	double total;
	
	public Compra(int produto, int quantidade, double total, long cliente) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.cliente = cliente;
		this.total = total;
	}

	/* Getters */	
	public String getDataHora() {
		return dataHora;
	}

	public int getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public long getCliente() {
		return cliente;
	}

	public double getTotal() {
		return total;
	}

	/* Setters */
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setCliente(long cliente) {
		this.cliente = cliente;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
