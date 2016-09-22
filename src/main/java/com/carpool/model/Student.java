package com.carpool.model;

/**
 * Created by shawnkelly on 9/22/16.
 */
public class Student
{
  private int idStudent;
  private String firstName;
  private String lastName;
  private String email;
  private boolean yesDriver;
  private boolean yesRider;

  public int getIdStudent()
  {
    return idStudent;
  }

  public void setIdStudent(int idStudent)
  {
    this.idStudent = idStudent;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public boolean isYesDriver()
  {
    return yesDriver;
  }

  public void setYesDriver(boolean yesDriver)
  {
    this.yesDriver = yesDriver;
  }

  public boolean isYesRider()
  {
    return yesRider;
  }

  public void setYesRider(boolean yesRider)
  {
    this.yesRider = yesRider;
  }


}
