package com.invillia.academy.netflix.hystrix.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConsumerApplication {

	Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

	@Autowired
	private BookService bookService;

	@RequestMapping("/to-read-cb")
	public String toReadWithCircuitBreaker() {
		logger.info("chamando /recommended API");
		return this.bookService.readingRecommendedBooksWithCircuitBreaker();
	}

	@RequestMapping("/to-read-retry")
	public String toReadWithRetry() {
		logger.info("chamando /recommended API");
		return this.bookService.readingRecommendedBooksWithRetry();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
