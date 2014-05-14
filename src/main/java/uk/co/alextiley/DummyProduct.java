package uk.co.alextiley;

/*
 * Product - used to demonstrate REST
 */
public class DummyProduct {
	
	private long id;
	private String title;
	
	public DummyProduct(long id, String title) {
		this.setId(id);
		this.setTitle(title);
	}
	
	@Override
	public String toString() {
		return "<DummyProduct: {\"id\": \"" + this.id + "\", \"name\": \"" + this.title + "\"}>";
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
