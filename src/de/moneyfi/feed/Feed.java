package de.moneyfi.feed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feed {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private String content;
	private String datum /*, created, until */;
	private String group;

	public Integer getId() {
		return id;
	}

	public Feed setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Feed setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Feed setContent(String content) {
		this.content = content;
		return this;
	}

	public String getDatum() {
		return datum;
	}

	public Feed setDatum(String datum) {
		this.datum = datum;
		return this;
	}

	public String getGroup(String group) {
		return group;
	}

	public Feed setGroup(String group) {
		this.group = group;
		return this;
	}
}
