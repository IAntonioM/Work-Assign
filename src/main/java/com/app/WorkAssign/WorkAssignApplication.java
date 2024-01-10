package com.app.WorkAssign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WorkAssignApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkAssignApplication.class, args);
	}
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Bean
	public CommandLineRunner createpasswordCommand(){
		return args ->{
			System.out.println(passwordEncoder.encode("contra123"));
			System.out.println(passwordEncoder.encode("contra234"));
		};
	}
}
