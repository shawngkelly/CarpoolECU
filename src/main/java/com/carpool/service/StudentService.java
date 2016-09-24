package com.carpool.service;

import com.carpool.dao.StudentDAO;
import com.carpool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shawngkelly on 9/9/16.
 */
public class StudentService {

  private StudentDAO studentDAO;

  public void setStudentDAO(StudentDAO studentDAO) {
    this.studentDAO = studentDAO;
  }

  public List<Student> getStudents(){
    return studentDAO.getStudents();
  }

  public int insertStudent(Student student){
    return studentDAO.insertStudent(student);
  }

  public int updateStudent(Student student){
    return studentDAO.updateStudent(student);
  }

  public int deleteStudent(int idStudent){
    return studentDAO.deleteStudent(idStudent);
  }
}
