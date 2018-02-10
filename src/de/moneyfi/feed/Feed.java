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
	private String company;
	private Integer pplwanted;
	private String pplaccepted;
	private String ppldenied;

	public Integer getPplwanted() {
		return pplwanted;
	}

	public void setPplwanted(Integer pplwanted) {
		this.pplwanted = pplwanted;
	}

	public String getPplaccepted() {
		return pplaccepted;
	}

	public void setPplaccepted(String pplaccepted) {
		this.pplaccepted = pplaccepted;
	}

	public String getPpldenied() {
		return ppldenied;
	}

	public void setPpldenied(String ppldenied) {
		this.ppldenied = ppldenied;
	}

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

	public String getCompany() {
		return company;
	}

	public Feed setCompany(String company) {
		this.company = company;
		return this;
	}
}
