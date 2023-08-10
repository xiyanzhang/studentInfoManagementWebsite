package com.example.service.implementation;

import com.example.mapper.StudentMapper;
import com.example.pojo.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.service.StudentService;

import java.util.List;

@Service
@MapperScan("com.example.mapper")
public class StudentServiceImplementation implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentMapper.getStudentById(studentId);
    }

    @Override
    public int deleteStudent(int studentId) {
        return studentMapper.deleteStudent(studentId);
    }

    @Override
    public int updateStudent(Student student) {
        String name = student.getName();
        Integer age = student.getAge();
        String gender = student.getGender();
        String birthdate = student.getBirthdate();
        long phoneNumber = student.getPhoneNumber();
        String politicalStatus = student.getPoliticalStatus();
        String ethnicGroup = student.getEthnicGroup();
        Integer studentId = student.getStudentId();

        return studentMapper.updateStudent(name, age, gender, birthdate, phoneNumber, politicalStatus, ethnicGroup, studentId);
    }

    @Override
    public int insertStudent(Student student) {
        String name = student.getName();
        Integer age = student.getAge();
        String gender = student.getGender();
        String birthdate = student.getBirthdate();
        long phoneNumber = student.getPhoneNumber();
        String politicalStatus = student.getPoliticalStatus();
        String ethnicGroup = student.getEthnicGroup();
        Integer studentId = student.getStudentId();

        return studentMapper.insertStudent(name, age, studentId, gender, birthdate, phoneNumber, politicalStatus, ethnicGroup);
    }

}
