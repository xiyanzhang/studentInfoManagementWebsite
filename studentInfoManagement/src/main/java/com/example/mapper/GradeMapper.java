package com.example.mapper;

import com.example.pojo.Grade;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GradeMapper {
  @Update("UPDATE grade_data SET score = #{score}" +
      " WHERE studentId = #{studentId} AND name = #{name} AND semester = #{semester} AND course = #{course}")
  int editGrade(int score, String name, int studentId, String semester, String course);

  @Update("UPDATE grade_data SET name = #{name}" +
      " WHERE studentId = #{studentId}")
  int editNameInGrade(String name, int studentId);

  @Delete("DELETE FROM grade_data WHERE gradeId = #{gradeId}")
  int deleteGrade(int gradeId);

  @Delete("DELETE FROM grade_data WHERE semester = #{semester} AND course = #{course}")
  int deleteTest(String semester, String course);

  @Insert("INSERT INTO grade_data (name, studentId, semester, course, score, testDate) " +
      "VALUES (#{name}, #{studentId}, #{semester}, #{course}, #{score}, #{testDate})")
  int insertGrade(String name, int studentId, String semester, String course, int score, String testDate);

  @Select("SELECT DISTINCT name, studentId, semester, course, score, gradeId FROM grade_data")
  List<Grade> getGradeList();

  @Select("SELECT DISTINCT name, studentId, score\n" +
      "FROM grade_data\n" +
      "WHERE name IS NOT NULL AND semester = #{semester} AND course = #{course}")
  List<Grade> getScoreList(String semester, String course);

  @Select("SELECT name, studentId FROM student_data")
  List<Grade> getNameList();

  @Select("SELECT DISTINCT semester, course, testDate \n" +
      "FROM grade_data \n" +
      "WHERE semester IS NOT NULL AND course IS NOT NULL AND testDate IS NOT NULL")
  List<Grade> getTestList();

  @Delete("DELETE FROM grade_data WHERE studentId = #{studentId}")
  int deleteStudentGrades(int studentId);

//  @Insert("INSERT INTO test_data (semester, course) VALUES (#{semester}, #{course}")
//  int insertTest(String semester, String course);
}
