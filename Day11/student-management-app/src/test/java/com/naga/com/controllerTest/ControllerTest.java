package com.naga.com.controllerTest;

import com.naga.com.controller.StudentController;
import com.naga.com.service.StudentService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    StudentService studentService;
}
