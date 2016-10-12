package com.carpool.model.report;

import com.carpool.model.GenericReport;

import java.util.*;

/**
 * Created by shawnkelly on 10/10/16.
 */
public class RiderTripReportResponse {

  private List<GenericReport> rows;

  private int current = 1;
  private int total;
  private int rowCount;

  public RiderTripReportResponse(){

  }

  public RiderTripReportResponse(List<GenericReport> genericReports, int recordsTotal)
  {
    this.rows = genericReports;
    this.total = recordsTotal;
    this.rowCount = recordsTotal;
  }
  public List<GenericReport> getRows()
  {
    return rows;
  }

  public void setRows(List<GenericReport> rows)
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
