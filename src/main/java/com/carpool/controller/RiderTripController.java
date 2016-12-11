package com.carpool.controller;

import com.carpool.model.RiderTrip;
import com.carpool.model.RiderTripResponse;
import com.carpool.service.RiderTripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This maps the to the correct jsp page.

@Controller
@RequestMapping("/riderTrip")
public class  RiderTripController {

/* Controller class will call up the service layer and map the rest of the
jsp page*/

  private RiderTripService riderTripService;

  public void setRiderTripService(RiderTripService riderTripService) {
    this.riderTripService = riderTripService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model) {
    return "riderTrip";
  }

 /*Calls Response to generate the list of Ridertrips. Returns number of trips and Ridertrip objects */

  @ResponseBody
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public RiderTripResponse getRiderTrips(){
    List<RiderTrip> riderTrips = riderTripService.getRiderTrips();
    return new RiderTripResponse(riderTrips, riderTrips.size());
  }

//This will return an int to specify which riderTrip will be inserted as a new trip.


  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
  public int insertRiderTrip(@RequestBody RiderTrip riderTrip) {
    return riderTripService.insertRiderTrip(riderTrip);
  }


 //This will return an int as the ridertripID to delete the correct ridertrip

  @ResponseBody
  @RequestMapping(value = "/delete/{riderTripID}", method = RequestMethod.GET)
  public int deleteStudent(@PathVariable("riderTripID") int riderTripID) {
    return riderTripService.deleteRiderTrip(riderTripID);
  }


//  This returns in int to update the correct trip.

  @ResponseBody
  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
  public int updateStudent(@RequestBody RiderTrip riderTrip) {
    return riderTripService.updateRiderTrip(riderTrip);
  }
}

