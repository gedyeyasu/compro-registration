package com.miu.registration;

import com.miu.registration.domain.*;
import com.miu.registration.repositories.RegistrationEventRepository;
import com.miu.registration.repositories.StudentRepository;
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
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.transaction.Transactional;
import java.time.LocalDate;

@SpringBootApplication
@EnableKafka
@EnableScheduling
@Transactional
public class RegistrationApplication implements CommandLineRunner {


	@Autowired
	StudentRepository studentRepository;
	@Autowired
	RegistrationEventRepository registrationEventRepository;
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
		Student tewodroes = new Student("Tewodroes", "Hailu",
				"tewodroes.hailu@miu.edu", 615167L, "teddy", "teddy");
		Student gedeon = new Student("Gedeon", "Tona",
				"gedeon.tona@miu.edu", 776655L, "gedy", "gedy");
		Address mAddress = new Address("1000 N4thSt.", "Fairfield", 52557, "Iowa", "USA");
		Address hAddress = new Address("2000SW St.", "Fairfield", 53567, "Iowa", "USA");
		tewodroes.setMailAddress(mAddress);
		tewodroes.setHomeAddress(hAddress);

		gedeon.setHomeAddress(hAddress);
		gedeon.setMailAddress(mAddress);

		studentRepository.save(tewodroes);
		studentRepository.save(gedeon);

		// Adding Faculty
    Faculty faculty1 = new Faculty("Payman", "Saleek","psaleek@gmail.com",
        "psaleek","psaleek",615167L, "Professor" );
    Faculty faculty2 = new Faculty("Assad", "Saad","asaad.saad@gmail.com",
        "assad","assad",615167L, "Professor" );
    Faculty faculty3 = new Faculty("Siamak", "Tavakoli","siamak.tavakoli@gmail.com",
        "stavacoli","stavacoli",615167L, "Professor" );


//
//    // Adding Courses
    Course ea = new Course("CS544","Enterprise Architecture", "Description for EA");
    Course swa = new Course("CS555","Software Architecture", "Description for SWA");
    Course waa = new Course("CS512","Web Application Architecture", "Description for WAA");
    Course mwa = new Course("CS510","Modern Web Application", "Description for MWA");

		// Adding Course Offering
    CourseOffering courseOffering1 = new CourseOffering("CS544-AUG-PS", 50,ea, faculty1);
    CourseOffering courseOffering2 = new CourseOffering("CS555-AUG-AS",25,  swa, faculty2);
    CourseOffering courseOffering3 = new CourseOffering("CS512-AUG-ST",30, waa, faculty3);
    CourseOffering courseOffering4 = new CourseOffering("CS544-APR-PS", 20, mwa, faculty1);


		//Adding Academic Block

    AcademicBlock januaryBlock = new AcademicBlock("January-23", "January Block", LocalDate.of(2023,01, 01),
        LocalDate.of(2023,02, 01), Semester.WINTER);
	januaryBlock.addCourseOffering(courseOffering1);
	januaryBlock.addCourseOffering(courseOffering2);

    AcademicBlock aprilBlock = new AcademicBlock("April-23", "April Block", LocalDate.of(2023,04, 01),
        LocalDate.of(2023,05, 01), Semester.SPRING);
	aprilBlock.addCourseOffering(courseOffering3);
	aprilBlock.addCourseOffering(courseOffering4);

	RegistrationGroup augustFPPGroup = new RegistrationGroup();
	augustFPPGroup.addAcademicBlock(januaryBlock);
	augustFPPGroup.addAcademicBlock(aprilBlock);
	augustFPPGroup.addStudent(tewodroes);
	augustFPPGroup.addStudent(gedeon);
	augustFPPGroup.setGroupEnum(RegistrationGroupEnum.FPP_TRACK);

	RegistrationEvent registrationEvent = new RegistrationEvent();
	registrationEvent.addRegistrationGroup(augustFPPGroup);
	registrationEvent.setEndDate(LocalDate.of(2023,05, 05));
	registrationEvent.setStartDate(LocalDate.of(2023,05, 01));

	registrationEventRepository.save(registrationEvent);

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
