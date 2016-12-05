package com.carpool.service;

import com.carpool.dao.TripsToApproveDAO;
import com.carpool.model.TripsToApprove;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by shawnkelly on 11/23/16.
 */
public class TripsToApproveService
{
 private TripsToApproveDAO tripsToApproveDAO;

  public void setTripsToApproveDAO(TripsToApproveDAO tripsToApproveDAO)
  {
    this.tripsToApproveDAO = tripsToApproveDAO;
  }

  public List<TripsToApprove> getTripsToApprove()
  {
    return tripsToApproveDAO.getTripsToApprove();
  }

  public int insertTripsToApprove(TripsToApprove tripsToApprove)
  {
    return tripsToApproveDAO.insertTripsToApprove(tripsToApprove);
  }

  public int deleteTripsToApprove(int tripID)
  {
    return tripsToApproveDAO.deleteDriverTrip(tripID);
  }
}
