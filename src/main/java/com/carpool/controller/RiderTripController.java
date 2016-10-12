package com.carpool.controller;

import com.carpool.model.RiderTrip;
import com.carpool.model.RiderTripResponse;
import com.carpool.service.RiderTripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/riderTrip")
public class  RiderTripController {

  private RiderTripService riderTripService;

  public void setRiderTripService(RiderTripService riderTripService) {
    this.riderTripService = riderTripService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model) {
    return "riderTrip";
  }
  @ResponseBody
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public RiderTripResponse getRiderTrips(){
    List<RiderTrip> riderTrips = riderTripService.getRiderTrips();
    return new RiderTripResponse(riderTrips,riderTrips.size());
  }

  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
  public int insertRiderTrip(@RequestBody RiderTrip riderTrip) {
    return riderTripService.insertRiderTrip(riderTrip);
  }

  @ResponseBody
  @RequestMapping(value = "/delete/{riderTripID}", method = RequestMethod.GET)
  public int deleteStudent(@PathVariable("riderTripID") int riderTripID) {
    return riderTripService.deleteRiderTrip(riderTripID);
  }

  @ResponseBody
  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
  public int updateStudent(@RequestBody RiderTrip riderTrip) {
    return riderTripService.updateRiderTrip(riderTrip);
  }
}

