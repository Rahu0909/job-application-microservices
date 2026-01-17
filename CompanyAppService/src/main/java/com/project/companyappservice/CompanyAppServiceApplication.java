package com.project.companyappservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CompanyAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyAppServiceApplication.class, args);
	}

}
