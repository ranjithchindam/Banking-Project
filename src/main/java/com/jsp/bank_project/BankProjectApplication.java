package com.jsp.bank_project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankProjectApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}

}
