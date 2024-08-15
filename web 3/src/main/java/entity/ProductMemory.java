package entity;

public class ProductMemory {
	private int id;
	private int productId;
	private String memory;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ProductMemory(int id, int productId, String memory, double price) {
		super();
		this.id = id;
		this.productId = productId;
		this.memory = memory;
		this.price = price;
	}
	public ProductMemory() {
		
	}
}
