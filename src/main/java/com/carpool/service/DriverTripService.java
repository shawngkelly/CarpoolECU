package com.carpool.service;

import com.carpool.dao.DriverTripDAO;
import com.carpool.model.DriverTrip;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


/**
 * Created by shawnkelly on 10/16/16.
 */
//Class to implement the DAO class

public class DriverTripService
{

//Calls DAO class to get object.

  private DriverTripDAO driverTripDAO;

    public void setDriverTripDAO(DriverTripDAO driverTripDAO) {
      this.driverTripDAO = driverTripDAO;
    }

// Calls DAO to get list of objects

    public List<DriverTrip> getDriverTrips(){
      return driverTripDAO.getDriverTrips();
    }

// Calls DAO to insert new trip

    public int insertDriverTrip(DriverTrip driverTrip){
      return driverTripDAO.insertDriverTrip(driverTrip);
    }

//Calls DAO to update specific trip

    public int updateDriverTrip(DriverTrip driverTrip) {
      return driverTripDAO.updateDriverTrip(driverTrip);
    }

//Calls Dao to delete specific trip

    public int deleteDriverTrip(int tripID) {
      return driverTripDAO.deleteDriverTrip(tripID);
    }



}
