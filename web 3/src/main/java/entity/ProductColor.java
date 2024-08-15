package entity;

import java.util.List;

public class ProductColor {
	private int id;
	private int productId;
	private String color;
	private List<ProductColorImage> images;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<ProductColorImage> getImages() {
		return images;
	}
	public void setImages(List<ProductColorImage> images) {
		this.images = images;
	}
	public ProductColor(int id, int productId, String color, List<ProductColorImage> images) {
		super();
		this.id = id;
		this.productId = productId;
		this.color = color;
		this.images = images;
	}
	public ProductColor() {
		
	}
}
