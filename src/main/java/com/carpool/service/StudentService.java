package com.carpool.service;

import com.carpool.dao.StudentDAO;
import com.carpool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shawngkelly on 9/9/16.
 */

//Class to implement the DAO class
public class StudentService {


    //Calls DAO class to get object.

  private StudentDAO studentDAO;

  public void setStudentDAO(StudentDAO studentDAO) {
    this.studentDAO = studentDAO;
  }

    // Calls DAO to get list of objects

  public List<Student> getStudents(){
    return studentDAO.getStudents();
  }

    // Calls DAO to insert new Student

  public int insertStudent(Student student){
    return studentDAO.insertStudent(student);
  }

    //Calls DAO to update specific trip

  public int updateStudent(Student student){
    return studentDAO.updateStudent(student);
  }

    //Calls Dao to delete specific trip

  public int deleteStudent(int idStudent){
    return studentDAO.deleteStudent(idStudent);
  }
}
