package com.carpool.service;

import com.carpool.dao.RiderTripDAO;
import com.carpool.model.RiderTrip;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shawnkelly on 10/6/16.
 */

//Class to implement the DAO class

public class RiderTripService
{

//Calls DAO class to get object.

  private RiderTripDAO riderTripDAO;

    public void setRiderTripDAO(RiderTripDAO riderTripDAO) {
      this.riderTripDAO = riderTripDAO;
    }

    // Calls DAO to get list of objects

    public List<RiderTrip> getRiderTrips(){
      return riderTripDAO.getRiderTrips();
    }

    // Calls DAO to insert new trip

    public int insertRiderTrip(RiderTrip riderTrip){
      return riderTripDAO.insertRiderTrip(riderTrip);
    }

    //Calls DAO to update specific trip

    public int updateRiderTrip(RiderTrip riderTrip){
      return riderTripDAO.updateRiderTrip(riderTrip);
    }

    //Calls Dao to delete specific trip

    public int deleteRiderTrip(int riderTripID){
      return riderTripDAO.deleteRiderTrip(riderTripID);
    }
  }

