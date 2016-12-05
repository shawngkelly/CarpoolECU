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

@Controller
@RequestMapping("/matchedTrips")
public class TripsToApproveController
{
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

  @ResponseBody
  @RequestMapping(value ="/list", method = RequestMethod.POST)
  public TripsToApproveResponse getTripsToApprove()
  {
    List<TripsToApprove> tripsToApproves = tripsToApproveService
        .getTripsToApprove();
    return new TripsToApproveResponse(tripsToApproves, tripsToApproves.size());
  }

  @ResponseBody
  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes =
      "application/json")
  public int insertTripsToApprove(@RequestBody TripsToApprove tripsToApprove)
  {
    return tripsToApproveService.insertTripsToApprove(tripsToApprove);
  }

  @ResponseBody
  @RequestMapping(value = "/delete/{tripID}", method = RequestMethod.GET)
  public int deleteTripsToApprove(@PathVariable("tripID") int tripID)
  {
    return tripsToApproveService.deleteTripsToApprove(tripID);
  }
}
