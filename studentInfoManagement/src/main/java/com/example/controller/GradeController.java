package com.example.controller;

import com.example.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.service.GradeService;

import java.util.List;

@RestController
public class GradeController {
  @Autowired
  GradeService gradeService;


  @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
  @GetMapping("/getGradeList")
  public String getGradeList() {
    List<Grade> list = gradeService.getGradeList();
    StringBuilder data = new StringBuilder("{\"code\": 0, \"msg\": \"\", \"count\": " + list.size() + ", \"data\": [");
    for (int i = 0; i < list.size(); i++) {
      if (i > 0) {
        data.append(",");
      }
      data.append(list.get(i).toString());
    }
    data.append("]}");

    return data.toString();
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
  @GetMapping("/getNameList")
  public String getNameList() {
    List<Grade> list = gradeService.getNameList();
    StringBuilder data = new StringBuilder("{\"code\": 0, \"msg\": \"\", \"count\": " + list.size() + ", \"data\": [");
    for (int i = 0; i < list.size(); i++) {
      if (i > 0) {
        data.append(",");
      }
      data.append(list.get(i).toString());
    }
    data.append("]}");

    return data.toString();
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
  @GetMapping("/getScoreList")
  public String getScoreList(@RequestParam String semester, @RequestParam String course) {
    List<Grade> list = gradeService.getScoreList(semester, course);
    StringBuilder data = new StringBuilder("{\"code\": 0, \"msg\": \"\", \"count\": " + list.size() + ", \"data\": [");
    for (int i = 0; i < list.size(); i++) {
      if (i > 0) {
        data.append(",");
      }
      data.append(list.get(i).toString());
    }
    data.append("]}");

    return data.toString();
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
  @GetMapping("/getTestList")
  public String getTestList() {
    List<Grade> list = gradeService.getTestList();
    StringBuilder data = new StringBuilder("{\"code\": 0, \"msg\": \"\", \"count\": " + list.size() + ", \"data\": [");
    for (int i = 0; i < list.size(); i++) {
      if (i > 0) {
        data.append(",");
      }
      data.append(list.get(i).toString());
    }
    data.append("]}");
    return data.toString();
  }

  @CrossOrigin("*")
  @PostMapping("/deleteGrade")
  public int deleteGrade(@RequestBody Grade grade) {
    return gradeService.deleteGrade(grade.getGradeId());
  }

  @CrossOrigin("*")
  @PostMapping("/deleteStudentGrades")
  public int deleteStudentGradesGrade(@RequestBody Grade grade) {
    return gradeService.deleteStudentGrades(grade.getStudentId());
  }

  @CrossOrigin("*")
  @PostMapping("/deleteTest")
  public int deleteTest(@RequestBody Grade grade) {
    return gradeService.deleteTest(grade);
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
  @PostMapping("/editGrade")
  public int editGrade(@RequestBody Grade grade) {
    return gradeService.editGrade(grade);
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
  @PostMapping("/editNameInGrade")
  public int editNameInGrade(@RequestBody Grade grade) {
    return gradeService.editNameInGrade(grade);
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
  @PostMapping("/insertGrade")
  public int insertGrade(@RequestBody Grade grade) {
    return gradeService.insertGrade(grade);
  }


//
//  @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
//  @PostMapping("/insertTest")
//  public int insertTest(@RequestBody Test test) {
//    return gradeService.insertTest(test);
//  }
}
