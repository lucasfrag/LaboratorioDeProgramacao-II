import java.util.ArrayList;

public class Continente {
	private ArrayList<Pais> paises = new ArrayList();
	private String nome;
	private int totalPaises = 0;
	private double totalPopulacao;
	
	
	// Metodo construtor
	public Continente(String nome, int totalPaises, double totalPopulacao) {
		this.nome = nome;
		this.totalPaises = totalPaises;
		this.totalPopulacao = totalPopulacao;
	}


	// Metodo para adicionar paises
	public void adicionarPais(Pais pais) {		
		if (totalPaises < 10) {
			paises.add(pais);
			totalPopulacao = totalPopulacao + pais.getPopulacao();
			totalPaises++;
		} else {
			System.out.println(pais + " não pode ser adicionado. O continente não pode conter mais de 10 países.");
			System.out.println("");
		}
	}
	
	// Metodo para comparar paises
	public void compararPaises() {
		
		Pais menorPopulacao = null;
		Pais maiorPopulacao = null;
		
		// Percorrer ArrayList
		for (int i=0; i < paises.size(); i++) {
			if (i == 0) {
				menorPopulacao = paises.get(0);
				maiorPopulacao = paises.get(0);
			} else {
				if (paises.get(i).getPopulacao() < menorPopulacao.getPopulacao()) {
					menorPopulacao = paises.get(i);
				}

				if (paises.get(i).getPopulacao() > maiorPopulacao.getPopulacao()) {
					maiorPopulacao = paises.get(i);
				}
			}
		}
		
		System.out.println("País com maior população: " + maiorPopulacao.getNome());
		System.out.println("País com menor população: " + menorPopulacao.getNome());
	}
	
	// Getters & Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotalPaises() {
		return totalPaises;
	}

	public void setTotalPaises(int totalPaises) {
		this.totalPaises = totalPaises;
	}

	public double getTotalPopulacao() {
		return totalPopulacao;
	}

	public void setTotalPopulacao(double totalPopulacao) {
		this.totalPopulacao = totalPopulacao;
	}
	
}
