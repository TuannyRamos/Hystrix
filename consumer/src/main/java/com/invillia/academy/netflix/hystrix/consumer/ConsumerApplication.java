package com.invillia.academy.netflix.hystrix.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableCircuitBreaker
@SpringBootApplication
public class ConsumerApplication {

	Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

	@Autowired
	private BookService bookService;

	@RequestMapping("/to-read")
	public String toRead() {
		logger.info("chamando /recommended API");
		return this.bookService.readingRecommendedBooks();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
