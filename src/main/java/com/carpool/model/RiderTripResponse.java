package com.carpool.model;

import java.util.List;
/**
 * Created by shawnkelly on 10/6/16.
 */
public class RiderTripResponse
{
  private List<RiderTrip> rows;

  private int current = 1;
  private int total;
  private int rowCount;

  public RiderTripResponse(){

  }

  public RiderTripResponse(List<RiderTrip> riderTrips, int recordsTotal)
  {
    this.rows = riderTrips;
    this.total = recordsTotal;
    this.rowCount = recordsTotal;
  }

  public List<RiderTrip> getRows()
  {
    return rows;
  }

  public void setRows(List<RiderTrip> rows)
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

  public int getRowCount()
  {
    return rowCount;
  }

  public void setRowCount(int rowCount)
  {
    this.rowCount = rowCount;
  }





}
