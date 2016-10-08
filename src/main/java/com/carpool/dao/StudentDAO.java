package com.carpool.dao;

import com.carpool.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shawngkelly on 9/24/16.
 */
public class StudentDAO {

  private String SELECT = "SELECT * FROM student;";
  private String INSERT = "INSERT INTO student (firstName,lastName, email, " +
      "driver, rider) values "
      + " (?,?,?,?,?);";

  private String UPDATE = "UPDATE student SET firstName = ?, lastName = ?, " +
      "email =?, driver = ?, rider = ? " +
      "WHERE " +
      "idStudent = ?;";
  private String DELETE = "DELETE from student where idStudent = ?;";

  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public StudentDAO(){

  }

  public List<Student> getStudents(){
    List<Student> students = jdbcTemplate.query(SELECT,new Object[]{},new
        StudentRowMapper());
    return students;
  }

  public int insertStudent(Student student){
    return jdbcTemplate.update(INSERT, student.getFirstName(),
        student.getLastName(),student.getEmail(),student.isDriver(),student.isRider());
  }

  public int updateStudent(Student student){
    return jdbcTemplate.update(UPDATE, student.getFirstName(),
        student.getLastName(), student.getEmail(),
        student.isDriver() ? 1 : 0,student.isRider() ? 1 :0, student.getIdStudent());

    //Fixed the by correcting isDriver and putting getIdStudent

  }

  public int deleteStudent(int idStudent){
    return jdbcTemplate.update(DELETE,new Object[]{idStudent});
  }

  private class StudentRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
     Student student = new Student();
      student.setIdStudent(resultSet.getInt("idStudent"));
      student.setFirstName(resultSet.getString("firstName"));
      student.setLastName(resultSet.getString("lastName"));
      student.setEmail(resultSet.getString("email"));
      student.setDriver(resultSet.getBoolean("driver"));
      student.setRider(resultSet.getBoolean("rider"));
      return student;
    }
  }
}
