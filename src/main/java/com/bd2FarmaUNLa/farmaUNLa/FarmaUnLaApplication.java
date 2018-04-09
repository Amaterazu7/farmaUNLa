package com.bd2FarmaUNLa.farmaUNLa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FarmaUnLaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FarmaUnLaApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FarmaUnLaApplication.class);
	}
	
}
