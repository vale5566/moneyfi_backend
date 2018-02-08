package de.moneyfi.feed;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.moneyfi.main.Moneyfi;

@RestController
public class FeedRequest {
	
	@RequestMapping("/feed")
	public static Feed requestFeed() {
		return new Feed(Moneyfi.COUNTER.incrementAndGet());
	}
	
}
