package com.carpool.controller;

import com.carpool.model.Student;
import com.carpool.model.StudentResponse;
import com.carpool.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {

  private StudentService studentService;

  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model) {
    return "student";
  }
  @ResponseBody
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public StudentResponse getStudents(){
    List<Student> students = studentService.getStudents();
    return new StudentResponse(students,students.size());
  }

  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
  public int insertStudent(@RequestBody Student student) {
    return studentService.insertStudent(student);
  }

  @ResponseBody
  @RequestMapping(value = "/delete/{idStudent}", method = RequestMethod.GET)
  public int deleteStudent(@PathVariable("idStudent") int idStudent) {
    return studentService.deleteStudent(idStudent);
  }

  @ResponseBody
  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
  public int updateStudent(@RequestBody Student student) {
    return studentService.updateStudent(student);
  }
}

