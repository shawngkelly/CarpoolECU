package com.carpool.controller;

import com.carpool.model.DriverTrip;
import com.carpool.model.DriverTripResponse;
import com.carpool.service.DriverTripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by shawnkelly on 10/16/16.
 */

//This maps the to the correct jsp page.

@Controller
@RequestMapping("/driverTrip")

/*DriverTripController class will call up the service layer and map the rest of the
jsp page*/

public class DriverTripController {


/*Calls the class DriverTripService to create the object  */

  private DriverTripService driverTripService;

  public void setDriverTripService(DriverTripService driverTripService) {
    this.driverTripService = driverTripService;
  }



  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model)
  {
    return "driverTrip";
  }

/*Calls DriverTripResponse to generate the list of Drivertrips. Returns number of trips and drivertrip objects */

  @ResponseBody
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public DriverTripResponse getDriverTrips() {
    List<DriverTrip> driverTrips = driverTripService.getDriverTrips();
    return new DriverTripResponse(driverTrips, driverTrips.size());
  }

  //This will return an int to specify which driverTrip will be inserted as a new trip.

  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes =
      "application/json")
  public int insertDriverTrip(@RequestBody DriverTrip driverTrip) {
    return driverTripService.insertDriverTrip(driverTrip);
  }

  //This will return an int as the tripID to delete the correct trip

  @ResponseBody
  @RequestMapping(value = "/delete/{tripID}", method = RequestMethod.GET)
  public int deleteDriverTrip(@PathVariable("tripID") int tripID)
  {
    return driverTripService.deleteDriverTrip(tripID);
  }

  //This returns in int to update the correct trip.

  @ResponseBody
  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes =
      "application/json")
  public int updateStudent(@RequestBody DriverTrip driverTrip)
  {
    return driverTripService.updateDriverTrip(driverTrip);
  }
}


