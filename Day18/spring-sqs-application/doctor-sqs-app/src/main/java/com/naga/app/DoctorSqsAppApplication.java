package com.naga.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorSqsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientSqsAppApplication.class, args);
	}

}
