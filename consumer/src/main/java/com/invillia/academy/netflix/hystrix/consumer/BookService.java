package com.invillia.academy.netflix.hystrix.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    Logger logger = LoggerFactory.getLogger(BookService.class);
    private int count = 0;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String readingRecommendedBooksWithCircuitBreaker() {
        return this.restTemplate().getForObject("http://localhost:8090/recommended", String.class);
    }

    public String readingRecommendedBooksWithRetry() {
        count++;
        logger.info("COUNTER = " + count);
        return this.restTemplate().getForObject("http://localhost:8090/recommended", String.class);
    }

    private String fallbackException() {
        logger.info("fallback method exception");
        return "fallback";
    }

    public String recover() {
        logger.info("recover method exception");
        return "recover exception";
    }
}