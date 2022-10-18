package com.brodosTest.fileoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FileoperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileoperationApplication.class, args);
	}

}
