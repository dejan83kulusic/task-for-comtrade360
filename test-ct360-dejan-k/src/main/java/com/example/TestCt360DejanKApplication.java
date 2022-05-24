package com.example;


import com.example.translation.Translate;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static com.example.translation.Translate.prettify;


@SpringBootApplication
public class TestCt360DejanKApplication {

	@Bean
	public RestTemplate restTemplate(@NotNull RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(TestCt360DejanKApplication.class, args);
		try {
			Translate translateRequest = new Translate();
			String response = translateRequest.Post();
			System.out.println(prettify(response));
		} catch (Exception e) {
			System.out.println(e);
		}
	}




}
