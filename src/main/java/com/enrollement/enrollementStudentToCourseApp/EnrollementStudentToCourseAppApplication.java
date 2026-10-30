package com.enrollement.enrollementStudentToCourseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EnrollementStudentToCourseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollementStudentToCourseAppApplication.class, args);
                System.out.println("=======================================");
                System.out.println("^_^ To You Welcome for you in my web application ^_^");
                System.out.println("$$$$ I do it by using spring boot $$$$");
                System.out.println("=======================================");
	}
}
