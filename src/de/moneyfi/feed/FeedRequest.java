package de.moneyfi.feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
			@RequestParam(name="group", required = true) String group) {
		Feed feed = new Feed();
		feed.setTitle(title);
		feed.setContent(content);
		feed.setDatum(datum);
		feed.setGroup(group);
		feed = feedRepository.save(feed);
		return feed;
	}
}
