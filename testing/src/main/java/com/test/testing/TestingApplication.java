package com.test.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = { "com.test.testing.*" })

public class TestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingApplication.class, args);
	}

}
