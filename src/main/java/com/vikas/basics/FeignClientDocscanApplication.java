package com.vikas.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class FeignClientDocscanApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientDocscanApplication.class, args);
	}

		

}
