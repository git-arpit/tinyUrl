package com.urlShortner.urlShortnerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.urlShortner.urlShortnerService.*"})
public class UrlShortnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortnerServiceApplication.class, args);
	}

}
