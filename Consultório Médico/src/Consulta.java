import java.util.Date;

public class Consulta {
	private Date data, hora;
	private Paciente paciente;
	private String prontuario;
	private Receituario receituario;
	
	public Consulta(Date data, Date hora, Paciente paciente, String prontuario, Receituario receituario) {
		super();
		this.data = data;
		this.hora = hora;
		this.paciente = paciente;
		this.prontuario = prontuario;
		this.receituario = receituario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public Receituario getReceituario() {
		return receituario;
	}

	public void setReceituario(Receituario receituario) {
		this.receituario = receituario;
	}
	
	
}
