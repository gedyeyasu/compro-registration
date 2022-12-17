package com.miu.registration;

import com.miu.registration.domain.Data;
import com.miu.registration.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistrationApplication implements CommandLineRunner {
	@Autowired
	DataRepository dataRepository;
	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataRepository.save(new Data("test"));
	}
}
