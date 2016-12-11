package com.carpool.controller;

import com.carpool.model.GenericReport;
import com.carpool.model.RiderTripResponse;
import com.carpool.model.report.RiderTrip;
import com.carpool.model.report.RiderTripReportResponse;
import com.carpool.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * Created by shawnkelly on 10/10/16.
 */

//maps the report page for the jsp.

@Controller
@RequestMapping("/report")
public class ReportController
{

/* Controller class will call up the service layer and map the rest of the
    jsp page*/


  private ReportService reportService;

  public void setReportService(ReportService reportService) {
    this.reportService = reportService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model) {
    return "report";
  }

//This calls the response class and will generate the appropriate list based on the
// on the var reportID.

  @ResponseBody
  @RequestMapping(value = "/list/{reportid}", method = RequestMethod.GET)
  public RiderTripReportResponse getReports(@PathVariable int reportid){
    RiderTripReportResponse response = reportService.getReport(reportid);
    return response;


  }
}
