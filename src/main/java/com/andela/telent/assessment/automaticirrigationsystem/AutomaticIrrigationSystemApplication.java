package com.andela.telent.assessment.automaticirrigationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableAspectJAutoProxy
public class AutomaticIrrigationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomaticIrrigationSystemApplication.class, args);
	}

}
