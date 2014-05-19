package uk.co.personalisation.model;


public class UserEvent {
	
	private long productId;
	private long customerId;
	private Enum<EventType> type;
	private int score;
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getCustomerId() {
		return this.customerId;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public Enum<EventType> getType() {
		return this.type;
	}
	
	public void setType(Enum<EventType> type) {
		this.type = type;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

}
