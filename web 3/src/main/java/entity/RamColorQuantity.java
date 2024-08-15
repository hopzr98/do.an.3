package entity;

public class RamColorQuantity {
	private int ramId;
	private int colorId;
	private int quantity;
	private String ram;
	private String color;
	public int getRamId() {
		return ramId;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setRamId(int ramId) {
		this.ramId = ramId;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public RamColorQuantity(int ramId, int colorId, int quantity) {
		super();
		this.ramId = ramId;
		this.colorId = colorId;
		this.quantity = quantity;
	}
	public RamColorQuantity(String ramId, String colorId, int quantity) {
		super();
		this.ram = ramId;
		this.color = colorId;
		this.quantity = quantity;
	}	
	
}
