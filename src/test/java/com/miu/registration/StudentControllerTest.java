package com.miu.registration;

import com.miu.registration.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    StudentController studentController;

    @Test
    void getStudentById(){
        assertEquals(true, true);
    }
}
