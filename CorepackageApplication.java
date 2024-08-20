package com.etiya.corepackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.etiya.corepackage")
public class CorepackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorepackageApplication.class, args);
	}

}
