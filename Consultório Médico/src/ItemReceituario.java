
public class ItemReceituario {
	private Medicamento medicamento;
	private double posologia;
	
	public ItemReceituario(Medicamento medicamento, double posologia) {
		super();
		this.medicamento = medicamento;
		this.posologia = posologia;
	}
	
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public double getPosologia() {
		return posologia;
	}
	public void setPosologia(double posologia) {
		this.posologia = posologia;
	}
	
	
}
