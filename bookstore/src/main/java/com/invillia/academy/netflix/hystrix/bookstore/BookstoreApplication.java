package com.invillia.academy.netflix.hystrix.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class BookstoreApplication {
	Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);

	@RequestMapping(value = "/recommended")
	public String bookList() {
		List<String> books = new ArrayList<>();
		books.add("Spring in Action (Manning)");
		books.add("Cloud Native Java (O'Reilly)");
		books.add("Learning Spring Boot (Packt)");
		logger.info("acessando livros recomendados");

		return String.join(", ", books);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
