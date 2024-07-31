package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan           
public class EmpApp1 {
	public static void main(String[] args) {
		SpringApplication.run(EmpApp1.class, args);
	}

}
