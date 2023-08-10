package com.example.service;

import com.example.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentList();

    Student getStudentById(int studentId);

    int deleteStudent(int studentId);

    int updateStudent(Student student);

    int insertStudent(Student student);

}
