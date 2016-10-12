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

@Controller
@RequestMapping("/report")
public class ReportController
{
  private ReportService reportService;

  public void setReportService(ReportService reportService) {
    this.reportService = reportService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model) {
    return "report";
  }

  @ResponseBody
  @RequestMapping(value = "/list/{reportid}", method = RequestMethod.GET)
  public RiderTripReportResponse getReports(@PathVariable int reportid){
    RiderTripReportResponse response = reportService.getReport(reportid);
    return response;


  }
}
