package com.example.service.implementation;

import com.example.pojo.Grade;
import com.example.pojo.Test;
import com.example.service.GradeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.GradeMapper;

import java.util.List;

@Service
@MapperScan("com.example.mapper")
public class GradeServiceImplementation implements GradeService {
  @Autowired
  GradeMapper gradeMapper;

  public List<Grade> getGradeList() {
    return gradeMapper.getGradeList();
  }

  @Override
  public List<Grade> getTestList() {
    return gradeMapper.getTestList();
  }

  public int deleteGrade(int studentId) {
    return gradeMapper.deleteGrade(studentId);
  }

  @Override
  public int deleteTest(Grade grade) {
    String semester = grade.getSemester();
    String course = grade.getCourse();

    return gradeMapper.deleteTest(semester, course);
  }

  public int editGrade(Grade grade) {
    String name = grade.getName();
    int studentId = grade.getStudentId();
    String semester = grade.getSemester();
    String course = grade.getCourse();
    int score = grade.getScore();

    return gradeMapper.editGrade(score, name, studentId, semester, course);
  }

  public int editNameInGrade(Grade grade) {
    String name = grade.getName();
    int studentId = grade.getStudentId();

    return gradeMapper.editNameInGrade(name, studentId);
  }

  public List<Grade> getNameList() {
    return gradeMapper.getNameList();
  }

  @Override
  public List<Grade> getScoreList(String semester, String course) {
    return gradeMapper.getScoreList(semester, course);
  }

  @Override
  public int deleteStudentGrades(int studentId) {
    return gradeMapper.deleteStudentGrades(studentId);
  }

//  @Override
//  public int insertTest(Test test) {
//    String semester = test.getSemester();
//    String course = test.getCourse();
//    return gradeMapper.insertTest(semester, course);
//  }

  public int insertGrade(Grade grade) {
    String name = grade.getName();
    int studentId = grade.getStudentId();
    String semester = grade.getSemester();
    String course = grade.getCourse();
    int score = grade.getScore();
    String testDate = grade.getTestDate();

    return gradeMapper.insertGrade(name, studentId, semester, course, score, testDate);
  }

}
