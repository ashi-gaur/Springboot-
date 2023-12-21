package com.example.spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController

public class Spring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
	}

	// @GetMapping("/**")
	// public List<Student> hello(){
	// 	return List.of(
	// 		new Student(
	// 		1L,
	// 		"Ashi", "ashi@gmail.com", LocalDate.of(2000,Month.JANUARY,5),12)
	// 	);
		
	// }
	

}
