package com.etiya.corepackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.etiya.corepackage")
public class CorePackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorePackageApplication.class, args);
	}

}
