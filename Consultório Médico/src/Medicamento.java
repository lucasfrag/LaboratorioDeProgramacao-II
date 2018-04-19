
public class Medicamento {
	private int id;
	private String nome;
	private String bula;
	
	public Medicamento(int id, String nome, String bula) {
		super();
		this.id = id;
		this.nome = nome;
		this.bula = bula;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBula() {
		return bula;
	}

	public void setBula(String bula) {
		this.bula = bula;
	}
	
	public void consultarMedicamento(String id) {
		System.out.println("ID: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("Bula: " + bula);
	}
	
}
