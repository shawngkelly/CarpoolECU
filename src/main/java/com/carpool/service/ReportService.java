package com.carpool.service;

//Make sure to add any model classes for new reports.

import com.carpool.dao.ReportDAO;
import com.carpool.model.GenericReport;
import com.carpool.model.report.RiderTrip;
import com.carpool.model.report.RiderTripReportResponse;
import com.carpool.model.report.RiderNoTrip;
import com.carpool.model.report.RiderMatchTrips;
import com.carpool.model.report.DriversWithSeats;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawnkelly on 10/9/16.
 */

//Class to implement the various reports. Must have reportID number sent by jsp listener.

public class ReportService
{

//Calls the Dao class to make the object

  private ReportDAO reportDAO;


  public void setReportDAO(ReportDAO reportDAO)
  {
    this.reportDAO = reportDAO;
  }


//These are reports and will only be used to view.  The int will
//come from the jsp listener in the correct page. The report is
//columns will pulled in from the generic model. The data will
//be pulled in from the reportDAO. Comment out unused columns

  public RiderTripReportResponse getReport(int reportNumber){
    List<GenericReport> output = new ArrayList<
            >();

    if(reportNumber == 1){
      List<RiderTrip> riderTrips = reportDAO.getRiderTrips();
      for(int i=0; i <riderTrips.size(); i++){
        GenericReport g = new GenericReport();
        g.setCol1(String.valueOf(riderTrips.get(i).getID()));
        g.setCol2(String.valueOf(riderTrips.get(i).getFirstName()));
        g.setCol3(String.valueOf(riderTrips.get(i).getLastName()));
        g.setCol4(String.valueOf(riderTrips.get(i).getDepartDate()));
        g.setCol5(String.valueOf(riderTrips.get(i).getReturnDate()));
        g.setCol6(String.valueOf(riderTrips.get(i).getCity()));
        //g.setCol6("1");
        //g.setCol7("1");
        output.add(g);

      }
    }

    if(reportNumber == 2){
      List<RiderNoTrip> riderNoTrips = reportDAO.getRiderNoTrips();
      for(int i=0; i<riderNoTrips.size(); i++){
        GenericReport g = new GenericReport();
        g.setCol1(String.valueOf(riderNoTrips.get(i).getId()));
        g.setCol2(String.valueOf(riderNoTrips.get(i).getFirstName()));
        g.setCol3(String.valueOf(riderNoTrips.get(i).getLastName()));
        output.add(g);
      }
    }

    if(reportNumber == 3){
      List<RiderMatchTrips> riderMatchTrips = reportDAO.getRiderMatchTrips();
      for(int i=0; i<riderMatchTrips.size(); i++){
        GenericReport g = new GenericReport();
        g.setCol1(String.valueOf(riderMatchTrips.get(i).getEmail()));
        g.setCol2(String.valueOf(riderMatchTrips.get(i).getDepartDate()));
        g.setCol3(String.valueOf(riderMatchTrips.get(i).getRiderID()));
        output.add(g);
      }
    }


    if(reportNumber ==4) {
      List<DriversWithSeats> driversWithSeats = reportDAO.getDriversWithSeats();
      for(int i=0; i<driversWithSeats.size(); i++){
        GenericReport g = new GenericReport();
        g.setCol1(String.valueOf(driversWithSeats.get(i).getDriverID()));
        g.setCol2(String.valueOf(driversWithSeats.get(i).getDepartDate()));
        g.setCol3(String.valueOf(driversWithSeats.get(i).getCity1()));
        g.setCol4(String.valueOf(driversWithSeats.get(i).getCity2()));
        g.setCol5(String.valueOf(driversWithSeats.get(i).getCity3()));
        g.setCol6(String.valueOf(driversWithSeats.get(i).getSeats()));
        output.add(g);
      }
    }
    RiderTripReportResponse  riderTripReportResponse = new
        RiderTripReportResponse(output, output.size());

    return riderTripReportResponse;
  }
}
