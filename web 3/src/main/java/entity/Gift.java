package entity;

public class Gift {
	private int id;
	private String giftName;
	private int productId;
	public Gift(int id, String giftName, int productId) {
		super();
		this.id = id;
		this.giftName = giftName;
		this.productId = productId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "Gift [id=" + id + ", giftName=" + giftName + ", productId=" + productId + "]";
	}
	
	
	
}
