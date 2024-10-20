package com.example.JDBCdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class})
public class JdbCdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbCdemoApplication.class, args);
	}

}
