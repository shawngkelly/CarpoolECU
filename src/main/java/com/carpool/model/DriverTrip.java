package com.carpool.model;

import java.util.Date;
/**
 * Created by shawnkelly on 10/16/16.
 */
public class DriverTrip
{
  private int tripID;
  private int driverID;
  private Date departDate;
  private Date returnDate;
  private String city1;
  private String city2;
  private String city3;
  private int seats;

  public int getTripID()
  {
    return tripID;
  }

  public void setTripID(int tripID)
  {
    this.tripID = tripID;
  }

  public int getDriverID()
  {
    return driverID;
  }

  public void setDriverID(int driverID)
  {
    this.driverID = driverID;
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

  public String getCity1()
  {
    return city1;
  }

  public void setCity1(String city1)
  {
    this.city1 = city1;
  }

  public String getCity2()
  {
    return city2;
  }

  public void setCity2(String city2)
  {
    this.city2 = city2;
  }

  public String getCity3()
  {
    return city3;
  }

  public void setCity3(String city3)
  {
    this.city3 = city3;
  }

  public int getSeats()
  {
    return seats;
  }

  public void setSeats(int seats)
  {
    this.seats = seats;
  }


}
