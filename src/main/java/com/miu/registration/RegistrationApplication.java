package com.miu.registration;

import com.miu.registration.domain.Course;
import com.miu.registration.domain.RegistrationGroup;
import com.miu.registration.domain.RegistrationGroupEnum;
import com.miu.registration.service.DTO.AddressDTO;
import com.miu.registration.service.DTO.CourseDTO;
import com.miu.registration.service.DTO.StudentDTO;
import com.miu.registration.service.Impl.CourseService;
import com.miu.registration.service.Impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
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
	@Autowired
	CourseService courseService;
	public static void main(String[] args) {

		SpringApplication.run(RegistrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addStudent();
		addCourse();

	}

	public void addStudent(){
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

	public void addCourse(){
		CourseDTO EA = new CourseDTO("CS544","Enterprise Application", "Development of Enterprise applications using modern technologies.");
		courseService.addCourse(EA);
	}

//	public void addRegistrationGroup(){
//		RegistrationGroup regGroup = new RegistrationGroup();
//		regGroup.setGroupEnum(RegistrationGroupEnum.FPP_TRACK);
//
//		StudentDTO tewodroes = new StudentDTO("Tewodroes", "Hailu",
//				"tewodroes.hailu@miu.edu", 615167L);
//		StudentDTO gedeon = new StudentDTO("Gedeon", "Tona",
//				"gedeon.tona@miu.edu", 776655L);
//		AddressDTO mAddress = new AddressDTO("1000 N4thSt.", "Fairfield", 52557, "Iowa", "USA");
//		AddressDTO hAddress = new AddressDTO("2000SW St.", "Fairfield", 53567, "Iowa", "USA");
//		tewodroes.setMailAddress(mAddress);
//		tewodroes.setHomeAddress(hAddress);
//
//		gedeon.setHomeAddress(hAddress);
//		gedeon.setMailAddress(mAddress);
//
//		regGroup.addStudent(tewodroes);
//
//
//	}
}
