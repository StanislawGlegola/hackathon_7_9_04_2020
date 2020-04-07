package com.example.VWP_Covid_19_nie_wiesz_zapytaj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class VwpCovid19NieWieszZapytajApplication {

	public static void main(String[] args) {
		SpringApplication.run(VwpCovid19NieWieszZapytajApplication.class, args);
	}


	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}



}
