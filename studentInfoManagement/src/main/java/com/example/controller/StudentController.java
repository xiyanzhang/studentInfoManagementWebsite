package com.example.controller;

import com.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.service.StudentService;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
    @GetMapping("/getStudentList")
    public String getStudentList() {
        List<Student> list = studentService.getStudentList();
        StringBuilder data = new StringBuilder("{\"code\": 0, \"msg\": \"\", \"count\": " + list.size() + ", \"data\": [");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                data.append(",");
            }
            data.append(list.get(i).toString());
        }
        data.append("]}");

        System.out.println(data);

        return data.toString();
    }

    @PostMapping("/getStudent")
    public String getStudent(@RequestBody int studentId) {
        Student student = studentService.getStudentById(studentId);
        return student.toString();
    }

    @CrossOrigin("*")
    @PostMapping("/deleteStudent")
    public int deleteStudent(@RequestBody Student student) {
        return studentService.deleteStudent(student.getStudentId());
    }

    @CrossOrigin("*")
    @PostMapping("/updateStudent")
    public int updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @CrossOrigin("*")
    @PostMapping("/insertStudent")
    public int insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }


}
