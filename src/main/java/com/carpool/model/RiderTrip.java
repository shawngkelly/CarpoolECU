package com.carpool.model;

import java.util.Date;

/**
 * Created by shawnkelly on 10/6/16.
 */
public class RiderTrip
{
  private int riderTripID;
  private int riderID;
  private Date departDate;
  private Date returnDate;
  private String city;

  public int getRiderTripID()
  {
    return riderTripID;
  }

  public void setRiderTripID(int riderTripID)
  {
    this.riderTripID = riderTripID;
  }

  public int getRiderID()
  {
    return riderID;
  }

  public void setRiderID(int riderID)
  {
    this.riderID = riderID;
  }

  public Date getDepartDate()
  {
    return departDate;
  }

  public void setDepartDate(Date departDate)
  {
    this.departDate = departDate;
  }

  public Date getReturnDate()
  {
    return returnDate;
  }

  public void setReturnDate(Date returnDate)
  {
    this.returnDate = returnDate;
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
