package com.carpool.service;

import com.carpool.dao.RiderTripDAO;
import com.carpool.model.RiderTrip;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shawnkelly on 10/6/16.
 */
public class RiderTripService
{
  private RiderTripDAO riderTripDAO;

    public void setRiderTripDAO(RiderTripDAO riderTripDAO) {
      this.riderTripDAO = riderTripDAO;
    }

    public List<RiderTrip> getRiderTrips(){
      return riderTripDAO.getRiderTrips();
    }

    public int insertRiderTrip(RiderTrip riderTrip){
      return riderTripDAO.insertRiderTrip(riderTrip);
    }

    public int updateRiderTrip(RiderTrip riderTrip){
      return riderTripDAO.updateRiderTrip(riderTrip);
    }

    public int deleteRiderTrip(int riderTripID){
      return riderTripDAO.deleteRiderTrip(riderTripID);
    }
  }

