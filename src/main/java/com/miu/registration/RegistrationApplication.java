package com.miu.registration;

import com.miu.registration.domain.Address;
import com.miu.registration.domain.Student;
import com.miu.registration.repositories.AddressRepository;
import com.miu.registration.repositories.StudentRepository;
import com.miu.registration.service.AddressDTO;
import com.miu.registration.service.StudentDTO;
import com.miu.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.miu.registration.repositories")
public class RegistrationApplication implements CommandLineRunner {
//	@Autowired
//	StudentRepository studentRepository;
//	@Autowired
//	FacultyRepository facultyRepository;
//	@Autowired
//	AdminRepository adminRepository;

	@Autowired
	StudentService studentService;
	public static void main(String[] args) {

		SpringApplication.run(RegistrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StudentDTO tewodroes = new StudentDTO("Tewodroes", "Hailu",
				"tewodroes.hailu@miu.edu", 615167L);
		StudentDTO gedeon = new StudentDTO("Gedeon", "Tona",
				"gedeon.tona@miu.edu", 776655L);
		AddressDTO mAddress = new AddressDTO("1000 N4thSt.", "Fairfield", 52557, "Iowa", "USA");
		AddressDTO hAddress = new AddressDTO("2000SW St.", "Fairfield", 53567, "Iowa", "USA");
		tewodroes.setMailAddress(mAddress);
		tewodroes.setHomeAddress(hAddress);

		gedeon.setHomeAddress(hAddress);
		gedeon.setMailAddress(mAddress);

		studentService.createStudent(tewodroes);
		studentService.createStudent(gedeon);

	}
}
