import java.util.ArrayList;

public class Receituario {
	private ArrayList<ItemReceituario> item;
	private double posologia;
	
	public ArrayList<ItemReceituario> getItem() {
		return item;
	}
	public void setItem(ArrayList<ItemReceituario> item) {
		this.item = item;
	}
	public double getPosologia() {
		return posologia;
	}
	public void setPosologia(double posologia) {
		this.posologia = posologia;
	}
	
}
