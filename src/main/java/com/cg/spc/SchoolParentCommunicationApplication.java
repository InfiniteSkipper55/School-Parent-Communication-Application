package com.cg.spc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg.spc")
public class SchoolParentCommunicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolParentCommunicationApplication.class, args);
	}

}
