package com.carpool.model;

import java.util.Date;

/**
 * Created by shawnkelly on 11/23/16.
 */
public class TripsToApprove
{
  private int tripID;
  private int driverID;
  private int riderID;
  private Date departDate;
  private Date returnDate;
  private String city;
  private int totalSeats;
  private int availSeats;
  private boolean driverApprove;
  private boolean riderApprove;

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

  public int getTotalSeats()
  {
    return totalSeats;
  }

  public void setTotalSeats(int totalSeats)
  {
    this.totalSeats = totalSeats;
  }

  public int getAvailSeats()
  {
    return availSeats;
  }

  public void setAvailSeats(int availSeats)
  {
    this.availSeats = availSeats;
  }

  public boolean isDriverApprove()
  {
    return driverApprove;
  }

  public void setDriverApprove(boolean driverApprove)
  {
    this.driverApprove = driverApprove;
  }

  public boolean isRiderApprove()
  {
    return riderApprove;
  }

  public void setRiderApprove(boolean riderApprove)
  {
    this.riderApprove = riderApprove;
  }


}
