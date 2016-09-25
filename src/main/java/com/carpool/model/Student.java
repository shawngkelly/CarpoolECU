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
  private boolean driver;
  private boolean rider;

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

  public boolean isDriver()
  {
    return driver;
  }

  public void setDriver(boolean driver)
  {
    this.driver = driver;
  }

  public boolean isRider()
  {
    return rider;
  }

  public void setRider(boolean rider)
  {
    this.rider = rider;
  }


}
