package entity;

public class News {
	private int id;
	private String pnews;
	public News(int id, String pnews) {
		super();
		this.id = id;
		this.pnews = pnews;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPnews() {
		return pnews;
	}
	public void setPnews(String pnews) {
		this.pnews = pnews;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", pnews=" + pnews + "]";
	}
	
	
}
