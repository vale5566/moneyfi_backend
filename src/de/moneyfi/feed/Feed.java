package de.moneyfi.feed;

public class Feed {
	
	private final long id;
	private final String content;

	public Feed(long id) {
		this.id = id;
		this.content = "Test-Value";
	}
	
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}

}
