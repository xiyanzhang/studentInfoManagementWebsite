package com.example.service;

import com.example.pojo.Grade;
import com.example.pojo.Test;

import java.util.List;

public interface GradeService {
  List<Grade> getGradeList();
  List<Grade> getTestList();
  int editGrade(Grade grade);
  int insertGrade(Grade grade);
  int deleteGrade(int studentId);
  int deleteTest(Grade grade);
  int editNameInGrade(Grade grade);

  List<Grade> getNameList();

  List<Grade> getScoreList(String semester, String course);

  int deleteStudentGrades(int studentId);

//  int insertTest(Test test);
}
