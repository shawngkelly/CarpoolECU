package com.carpool.model.report;

import java.util.Date;
/**
 * Created by shawnkelly on 10/16/16.
 */

//Model class creates the object to hold data from or going to database.
//Should be in the same format as the table or view it relates too.

public class RiderNoTrip
{
  private int id;
  private String firstName;
  private String lastName;


  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
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



}
