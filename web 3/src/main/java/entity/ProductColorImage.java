package entity;

public class ProductColorImage {
	private int colorId;
	private String imageUrl;
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public ProductColorImage(int colorId, String imageUrl) {
		super();
		this.colorId = colorId;
		this.imageUrl = imageUrl;
	}
	public ProductColorImage() {
		
	}
}
