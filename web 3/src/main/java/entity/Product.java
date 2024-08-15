package entity;

import java.util.List;

public class Product {
	private int id;
	private String productName;
	private String productCategoryPath;
	private String img;
	private double unitPrice;
	private double oldPrice;
	private int cid;
	private int quantity;
	private List<ProductColor> colors;
	private List<ProductMemory> memorys;
	
	public List<ProductColor> getColors() {
		return colors;
	}

	public void setColors(List<ProductColor> colors) {
		this.colors = colors;
	}

	public List<ProductMemory> getMemorys() {
		return memorys;
	}

	public void setMemorys(List<ProductMemory> memorys) {
		this.memorys = memorys;
	}

	public Product(int id, String productName, String productCategoryPath, String img, double unitPrice,
			double oldPrice, int cid, int quantity, List<ProductColor> colors, List<ProductMemory> memorys) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCategoryPath = productCategoryPath;
		this.img = img;
		this.unitPrice = unitPrice;
		this.oldPrice = oldPrice;
		this.cid = cid;
		this.quantity = quantity;
		this.colors = colors;
		this.memorys = memorys;
	}
	
	public Product(String productName, String productCategoryPath, String img, double unitPrice,
			double oldPrice, int cid, int quantity, List<ProductColor> colors, List<ProductMemory> memorys) {
		super();
		this.productName = productName;
		this.productCategoryPath = productCategoryPath;
		this.img = img;
		this.unitPrice = unitPrice;
		this.oldPrice = oldPrice;
		this.cid = cid;
		this.quantity = quantity;
		this.colors = colors;
		this.memorys = memorys;
	}

	public Product(int id, String productName, String productCategoryPath, String img, double unitPrice, double oldPrice, int cid, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCategoryPath = productCategoryPath;
		this.img = img;
		this.unitPrice = unitPrice;
		this.oldPrice = oldPrice;
		this.cid = cid;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategoryPath() {
		return productCategoryPath;
	}
	public void setProductCategoryPath(String productCategoryPath) {
		this.productCategoryPath = productCategoryPath;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productCategoryPath=" + productCategoryPath
				+ ", img=" + img + ", unitPrice=" + unitPrice + ", oldPrice=" + oldPrice + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

}
