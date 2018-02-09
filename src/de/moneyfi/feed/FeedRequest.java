package de.moneyfi.feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController()
@EnableAutoConfiguration()
@RequestMapping("/feed")
public class FeedRequest {
	
	@Autowired
	private FeedRepository feedRepository;
	
	@RequestMapping("/")
	public @ResponseBody Iterable<Feed> index() {
		return feedRepository.findAll();
	}
	
	@RequestMapping("/get")
	public Feed requestFeed(@RequestParam(name="id", required=true) int id) {
		return feedRepository.findOne(id);
	}
	
	@RequestMapping("/create")
	public Feed createFeed(
			@RequestParam(name="title", required=true) String title,
			@RequestParam(name="content", required=true) String content,
			@RequestParam(name="datum", required=true) String datum,
			@RequestParam(name="company", required = true) String company,
			@RequestParam(name="pplwanted", required=true) Integer pplwanted,
			@RequestParam(name="pplaccepted", required=false) Integer pplaccepted,
			@RequestParam(name="ppldenied", required=false) Integer[] ppldenied) {
		Feed feed = new Feed();
		feed.setTitle(title);
		feed.setContent(content);
		feed.setDatum(datum);
		feed.setCompany(company);
		feed.setPplwanted(pplwanted);
		feed.setPplaccepted(0);
		feed.setPpldenied(new Integer[0]);
		feed = feedRepository.save(feed);
		return feed;
	}

	@RequestMapping("/edit")
	public Feed editFeed(
			@RequestParam(name="id", required = true) Integer id,
			@RequestParam(name="title", required = false) String title,
			@RequestParam(name="content", required = false) String content,
			@RequestParam(name="datum", required = false) String datum,
			@RequestParam(name="company", required = false) String company,
			@RequestParam(name="pplwanted", required = false) Integer pplwanted,
			@RequestParam(name="pplaccepted", required = false) Integer pplaccepted,
			@RequestParam(name="ppldenied", required = false) Integer[] ppldenied) {

		int idd = feedRepository.findById(id).getId();
		Feed feed = feedRepository.findOne(idd);
		if(title != null) {
			feed.setTitle(title);
		}
		if(content != null) {
			feed.setContent(content);
		}
		if(datum != null) {
			feed.setDatum(datum);
		}
		if(company != null) {
			feed.setCompany(company);
		}
		if(pplwanted != null) {
			feed.setPplwanted(pplwanted);
		}
		if(pplaccepted != null) {
			feed.setPplaccepted(pplaccepted);
		}
		if(ppldenied != null) {
			feed.setPpldenied(ppldenied);
		}
		return feed;
	}
}
