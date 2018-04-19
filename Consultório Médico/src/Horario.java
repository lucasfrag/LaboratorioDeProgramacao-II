import java.util.Date;

public class Horario {
	private Date data;
	private Date hora;
	private Paciente paciente;
	
	public Horario(Date data, Date hora, Paciente paciente) {
		super();
		this.data = data;
		this.hora = hora;
		this.paciente = paciente;
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
	
	
}
