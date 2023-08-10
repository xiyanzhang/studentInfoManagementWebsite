package com.example.pojo;

public class Grade {
  private String name;
  private int studentId;
  private String semester;
  private String course;
  private int score;
  private int gradeId;

  private String testDate;

  public int getGradeId() {
    return gradeId;
  }

  public void setGradeId(int gradeId) {
    this.gradeId = gradeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getSemester() {
    return semester;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getTestDate() {
    return testDate;
  }

  public void setTestDate(String testDate) {
    this.testDate = testDate;
  }

  @Override
  public String toString() {
    return "{\"name\":\"" + name + "\",\"studentId\":\"" + studentId + "\",\"semester\":\"" + semester +
        "\",\"course\":\"" + course + "\",\"score\":\"" + score + "\",\"gradeId\":\"" + gradeId + "\",\"testDate\":\"" + testDate + "\"}";
  }

}
