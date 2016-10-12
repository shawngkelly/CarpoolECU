package com.carpool.model.report;

import java.util.Date;

/**
 * Created by shawnkelly on 10/10/16.
 */
public class RiderTrip
{
  private int ID;
  private String FirstName;
  private String LastName;
  private Date departDate;
  private String city;

  public int getID()
  {
    return ID;
  }

  public void setID(int ID)
  {
    this.ID = ID;
  }

  public String getFirstName()
  {
    return FirstName;
  }

  public void setFirstName(String firstName)
  {
    FirstName = firstName;
  }

  public String getLastName()
  {
    return LastName;
  }

  public void setLastName(String lastName)
  {
    LastName = lastName;
  }

  public Date getDepartDate()
  {
    return departDate;
  }

  public void setDepartDate(Date departDate)
  {
    this.departDate = departDate;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }
}
