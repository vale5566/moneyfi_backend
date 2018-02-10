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
			@RequestParam(name="pplwanted", required=true) String pplwanted,
			@RequestParam(name="pplaccepted", required=false) String pplaccepted,
			@RequestParam(name="ppldenied", required=false) String ppldenied,
			@RequestParam(name="money", required = true) String money,
			@RequestParam(name="location", required = true) String location,
			@RequestParam(name="timefrom", required = true) String timefrom,
			@RequestParam(name="timeuntil", required = true) String timeuntil) {
		Feed feed = new Feed();
		feed.setTitle(title);
		feed.setContent(content);
		feed.setDatum(datum);
		feed.setCompany(company);
		feed.setPplwanted(pplwanted);
		feed.setPplaccepted(pplaccepted);
		feed.setPpldenied(ppldenied);
		feed.setMoney(money);
		feed.setLocation(location);
		feed.setTimefrom(timefrom);
		feed.setTimeuntil(timeuntil);
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
			@RequestParam(name="pplwanted", required = false) String pplwanted,
			@RequestParam(name="pplaccepted", required = false) String pplaccepted,
			@RequestParam(name="ppldenied", required = false) String ppldenied,
			@RequestParam(name="money", required = false) String money,
			@RequestParam(name= "location", required = false) String location,
			@RequestParam(name="timeuntil", required = false) String timeuntil,
		@RequestParam(name="timefrom", required = false) String timefrom) {

		int idd = feedRepository.findById(id).getId();
		Feed feed = feedRepository.findOne(idd);
		if(title != null && !title.equals("")) {
			feed.setTitle(title);
		}
		if(content != null && !content.equals("")) {
			feed.setContent(content);
		}
		if(datum != null && !datum.equals("")) {
			feed.setDatum(datum);
		}
		if(company != null && !company.equals("")) {
			feed.setCompany(company);
		}
		if(pplwanted != null) {
			feed.setPplwanted(pplwanted);
		}
		if(pplaccepted != null && !pplaccepted.equals("")) {
			feed.setPplaccepted(pplaccepted);
		}
		if(ppldenied != null && !ppldenied.equals("")) {
			feed.setPpldenied(ppldenied);
		}
		if(money != null) {
			feed.setMoney(money);
		}
		if(location != null && !location.equals("")) {
			feed.setLocation(location);
		}
		if(timefrom != null && !timefrom.equals("")) {
			feed.setTimefrom(timefrom);
		}
		if(timeuntil != null && !timeuntil.equals("")) {
			feed.setTimeuntil(timeuntil);
		}

		return feed;
	}

	@RequestMapping("/adduser")
	public Feed addUser(@RequestParam(name="id", required=true) Integer id, @RequestParam(name="user", required=true) String user) {
		Feed feed = feedRepository.findOne(id);
		if(feed.getPplaccepted() == null) {
			feed.setPplaccepted("");
		}
		if(contains(feed.getPplaccepted().split(";"), user)) {
			return null;
		} else {
			feed.setPplaccepted(feed.getPplaccepted() + user + ";");
		}
		return feedRepository.save(feed);
		
	}
	
	@RequestMapping("/denyuser")
	public Feed denyUser(@RequestParam(name="id", required=true) Integer id, @RequestParam(name="user", required=true) String user) {
		Feed feed = feedRepository.findOne(id);
		if(feed.getPpldenied() == null) {
			feed.setPpldenied("");
		}
		if(contains(feed.getPpldenied().split(";"), user)) {
			return null;
		} else {
			feed.setPpldenied(feed.getPpldenied() + user + ";");
		}
		return feedRepository.save(feed);
		
	}
	
	private boolean contains(String[] users, String user) {
		for(String u : users) {
			if(user.equals(u)) return true;
		}
		return false;
	}
}
