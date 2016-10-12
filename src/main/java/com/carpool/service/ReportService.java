package com.carpool.service;

import com.carpool.dao.ReportDAO;
import com.carpool.model.GenericReport;
import com.carpool.model.report.RiderTrip;
import com.carpool.model.report.RiderTripReportResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawnkelly on 10/9/16.
 */
public class ReportService
{
  private ReportDAO reportDAO;

  public void setReportDAO(ReportDAO reportDAO)
  {
    this.reportDAO = reportDAO;
  }


  public RiderTripReportResponse getReport(int reportNumber){
    List<GenericReport> output = new ArrayList<GenericReport>();

    if(reportNumber == 1){
      List<RiderTrip> riderTrips = reportDAO.getRiderTrips();
      for(int i=0; i <riderTrips.size(); i++){
        GenericReport g = new GenericReport();
        g.setCol1(String.valueOf(riderTrips.get(i).getID()));
        g.setCol2(String.valueOf(riderTrips.get(i).getFirstName()));
        g.setCol3(String.valueOf(riderTrips.get(i).getLastName()));
        g.setCol4(String.valueOf(riderTrips.get(i).getDepartDate()));
        g.setCol5(String.valueOf(riderTrips.get(i).getCity()));
        g.setCol6("1");
        g.setCol7("1");
        output.add(g);
      }
    }

    RiderTripReportResponse  riderTripReportResponse = new
        RiderTripReportResponse(output, output.size());

    return riderTripReportResponse;
  }
}
