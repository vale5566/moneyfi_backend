package de.moneyfi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.atomic.AtomicLong;

@ComponentScan(basePackages = {"de.moneyfi.feed", "de.moneyfi.user", "de.moneyfi.group"})
@SpringBootApplication
public class Moneyfi {
	
	public final static AtomicLong COUNTER = new AtomicLong();
	
	public static void main(String[] args) {
		SpringApplication.run(Moneyfi.class, args);
	}
}
