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

@Controller
@RequestMapping("/driverTrip")
public class DriverTripController {

  private DriverTripService driverTripService;

  public void setDriverTripService(DriverTripService driverTripService) {
    this.driverTripService = driverTripService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model)
  {
    return "driverTrip";
  }

  @ResponseBody
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public DriverTripResponse getDriverTrips() {
    List<DriverTrip> driverTrips = driverTripService.getDriverTrips();
    return new DriverTripResponse(driverTrips, driverTrips.size());
  }

  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes =
      "application/json")
  public int insertDriverTrip(@RequestBody DriverTrip driverTrip)
  {
    return driverTripService.insertDriverTrip(driverTrip);
  }

  @ResponseBody
  @RequestMapping(value = "/delete/{tripID}", method = RequestMethod.GET)
  public int deleteDriverTrip(@PathVariable("tripID") int tripID)
  {
    return driverTripService.deleteDriverTrip(tripID);
  }

  @ResponseBody
  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes =
      "application/json")
  public int updateStudent(@RequestBody DriverTrip driverTrip)
  {
    return driverTripService.updateDriverTrip(driverTrip);
  }
}


