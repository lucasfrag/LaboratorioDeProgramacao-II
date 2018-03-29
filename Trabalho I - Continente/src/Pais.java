
public class Pais {
	private String nome;
	private double populacao;
	
	public Pais(String nome, double populacao) {
		super();
		this.nome = nome;
		this.populacao = populacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPopulacao() {
		return populacao;
	}
	public void setPopulacao(double populacao) {
		this.populacao = populacao;
	}
}
