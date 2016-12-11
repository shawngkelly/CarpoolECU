package com.carpool.controller;

import com.carpool.model.Student;
import com.carpool.model.StudentResponse;
import com.carpool.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This maps the to the correct jsp page.

@Controller
@RequestMapping("/student")

/* Controller class will call up the service layer and map the rest of the
jsp page*/

public class StudentController {

/*Calls the Service class to create the object  */

  private StudentService studentService;

  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model) {
    return "student";
  }

/*Calls Response to generate the list of Students. Returns number of trips and Students objects */


  @ResponseBody
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public StudentResponse getStudents(){
    List<Student> students = studentService.getStudents();
    return new StudentResponse(students,students.size());
  }

//This will return an int to specify which driverTrip will be inserted as a new trip.

  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
  public int insertStudent(@RequestBody Student student) {
    return studentService.insertStudent(student);
  }


//This will return an int as the idStudent to delete the correct Student

  @ResponseBody
  @RequestMapping(value = "/delete/{idStudent}", method = RequestMethod.GET)
  public int deleteStudent(@PathVariable("idStudent") int idStudent) {
    return studentService.deleteStudent(idStudent);
  }

//This returns in int to update the correct trip.

  @ResponseBody
  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
  public int updateStudent(@RequestBody Student student) {
    return studentService.updateStudent(student);
  }
}

