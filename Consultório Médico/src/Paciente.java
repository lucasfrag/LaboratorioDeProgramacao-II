import java.util.Date;

public class Paciente {
	private String rg;
	private String nome;
	private Date dataNascimento;
	
	public Paciente(String rg, String nome, Date dataNascimento) {
		super();
		this.rg = rg;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void consultarPaciente(String rg) {
		System.out.println("Nome: " + nome);
		System.out.println("RG: " + rg);
		System.out.println("Data de Nascimento: " + dataNascimento);
	}
}
