package de.moneyfi.main;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"de.moneyfi.feed"})
//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class Moneyfi {
	
	public final static AtomicLong COUNTER = new AtomicLong();
	
	public static void main(String[] args) {
		SpringApplication.run(Moneyfi.class, args);
	}

}
