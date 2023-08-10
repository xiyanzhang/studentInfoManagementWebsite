package com.example.mapper;

import com.example.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student_data")
    List<Student> getStudentList();

    @Select("SELECT name FROM student_data WHERE studentId = #{studentId}")
    Student getStudentById(int studentId);

    @Delete("DELETE FROM student_data WHERE studentId = #{studentId}")
    int deleteStudent(int studentId);

    @Insert("INSERT INTO student_data (name, age, studentId, gender, birthdate, phoneNumber, politicalStatus, ethnicGroup) " +
        "VALUES (#{name}, #{age}, #{studentId}, #{gender}, #{birthdate}, #{phoneNumber}, #{politicalStatus}, #{ethnicGroup})")
    int insertStudent(String name, Integer age, Integer studentId, String gender, String birthdate, long phoneNumber, String politicalStatus, String ethnicGroup);

    @Update("UPDATE student_data SET name = #{name}, age = #{age}, gender = #{gender}, birthdate = #{birthdate}, phoneNumber = #{phoneNumber}, " +
        "politicalStatus = #{politicalStatus}, ethnicGroup = #{ethnicGroup} " +
        "WHERE studentId = #{studentId}")
    int updateStudent(String name, Integer age, String gender, String birthdate, long phoneNumber, String politicalStatus, String ethnicGroup, Integer studentId);

}
