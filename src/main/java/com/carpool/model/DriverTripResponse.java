package com.carpool.model;

import java.util.List;
/**
 * Created by shawnkelly on 10/16/16.
 */


//Response Model class creates the List object that is used by the other classes to implement
//the base model.

public class DriverTripResponse
{
  private List<DriverTrip> rows;

  private int current = 1;
  private int total;
  private int rowcount;

  public DriverTripResponse(List<DriverTrip> driverTrips, int recordTotals) {
    this.rows = driverTrips;
    this.total = recordTotals;
    this.rowcount = recordTotals;

  }

  public List<DriverTrip> getRows()
  {
    return rows;
  }

  public void setRows(List<DriverTrip> rows)
  {
    this.rows = rows;
  }

  public int getCurrent()
  {
    return current;
  }

  public void setCurrent(int current)
  {
    this.current = current;
  }

  public int getTotal()
  {
    return total;
  }

  public void setTotal(int total)
  {
    this.total = total;
  }

  public int getRowcount()
  {
    return rowcount;
  }

  public void setRowcount(int rowcount)
  {
    this.rowcount = rowcount;
  }


}
