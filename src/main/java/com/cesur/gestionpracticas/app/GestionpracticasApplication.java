package com.cesur.gestionpracticas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="com.cesur.gestionpracticas.models")
public class GestionpracticasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionpracticasApplication.class, args);
	}

}
