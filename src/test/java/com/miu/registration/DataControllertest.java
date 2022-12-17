package com.miu.registration;

import com.miu.registration.controller.DataController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class DataControllertest {

    @Autowired
    DataController dataController;

    @Test
    void version(){
        assertEquals("Version 1.0.0", dataController.version());
    }
}
