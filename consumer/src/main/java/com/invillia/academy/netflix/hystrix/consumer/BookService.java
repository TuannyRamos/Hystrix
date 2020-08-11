package com.invillia.academy.netflix.hystrix.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    Logger logger = LoggerFactory.getLogger(BookService.class);

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "fallbackException")
    public String readingRecommendedBooks() {
        return this.restTemplate().getForObject("http://localhost:8090/recommended", String.class);
    }

    private String fallbackException() {
        logger.info("fallback method exception");
        return "fallback";
    }
}
