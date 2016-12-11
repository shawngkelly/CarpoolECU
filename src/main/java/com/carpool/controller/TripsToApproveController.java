package com.carpool.controller;

/**
 * Created by shawnkelly on 11/23/16.
 */

import com.carpool.model.TripsToApprove;
import com.carpool.model.TripsToApproveResponse;
import com.carpool.service.TripsToApproveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This maps the to the correct jsp page.


@Controller
@RequestMapping("/matchedTrips")

/* Controller class will call up the service layer and map the rest of the
jsp page*/

public class TripsToApproveController
{

/*Calls the Service class to create the object  */

  private TripsToApproveService tripsToApproveService;

  public void setTripsToApproveService(TripsToApproveService tripsToApproveService)
  {
    this.tripsToApproveService = tripsToApproveService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String loadHome(ModelMap model)
  {
    return "tripsToApprove";
  }

/*Calls Response to generate the list of TripsToApprove. Returns number of trips and TripsToApprove objects */

  @ResponseBody
  @RequestMapping(value ="/list", method = RequestMethod.POST)
  public TripsToApproveResponse getTripsToApprove()
  {
    List<TripsToApprove> tripsToApproves = tripsToApproveService
        .getTripsToApprove();
    return new TripsToApproveResponse(tripsToApproves, tripsToApproves.size());
  }

//This will return an int to specify which TripToApprove will be inserted as a new trip.

  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes =
      "application/json")
  public int insertTripsToApprove(@RequestBody TripsToApprove tripsToApprove)
  {
    return tripsToApproveService.insertTripsToApprove(tripsToApprove);
  }

//This will return an int as the TripToaprove to delete the correct trip

  @ResponseBody
  @RequestMapping(value = "/delete/{tripID}", method = RequestMethod.GET)
  public int deleteTripsToApprove(@PathVariable("tripID") int tripID)
  {
    return tripsToApproveService.deleteTripsToApprove(tripID);
  }
}
