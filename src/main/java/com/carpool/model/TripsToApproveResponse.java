package com.carpool.model;

import java.util.List;

/**
 * Created by shawnkelly on 11/23/16.
 */
public class TripsToApproveResponse
{
  private List<TripsToApprove> rows;

  private int current = 1;
  private int total;
  private int rowcount;

  public TripsToApproveResponse(List<TripsToApprove> tripsToApprove, int recordTotals)
  {
    this.rows = tripsToApprove;
    this.total = recordTotals;
    this.rowcount = recordTotals;
  }

  public List<TripsToApprove> getRows()
  {
    return rows;
  }

  public void setRows(List<TripsToApprove> rows)
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
