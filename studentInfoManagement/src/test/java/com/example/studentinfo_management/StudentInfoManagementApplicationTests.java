package com.example.studentinfo_management;

import com.example.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.example.mapper")
class StudentInfoManagementApplicationTests {
    @Autowired
    private StudentController studentController;

    @Test
    public void testFindAll() {
        String list = studentController.getStudentList();
        System.out.println(list);
    }

}
