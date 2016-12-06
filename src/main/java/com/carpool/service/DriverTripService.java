package com.carpool.service;

import com.carpool.dao.DriverTripDAO;
import com.carpool.model.DriverTrip;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


/**
 * Created by shawnkelly on 10/16/16.
 */
//Class to implement the DriverTripDAO class

public class DriverTripService
{
  private DriverTripDAO driverTripDAO;

    public void setDriverTripDAO(DriverTripDAO driverTripDAO) {
      this.driverTripDAO = driverTripDAO;
    }

    public List<DriverTrip> getDriverTrips(){
      return driverTripDAO.getDriverTrips();
    }

    public int insertDriverTrip(DriverTrip driverTrip){
      return driverTripDAO.insertDriverTrip(driverTrip);
    }

    public int updateDriverTrip(DriverTrip driverTrip) {
      return driverTripDAO.updateDriverTrip(driverTrip);
    }

    public int deleteDriverTrip(int tripID) {
      return driverTripDAO.deleteDriverTrip(tripID);
    }



}
