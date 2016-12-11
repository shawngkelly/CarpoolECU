package com.carpool.dao;

/**
 * Created by shawnkelly on 11/23/16.
 */

import com.carpool.model.TripsToApprove;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//Class to access database with SQL statements and queries.
//Unfinished as of 12/03/2016

public class TripsToApproveDAO
{
 private  String SELECT = "SELECT * FROM matchedtrips;";

  private String INSERT = "INSERT INTO tripstoapprove ( tripID, driverID, "
      + "riderID, departDate, returnDate, city, totalSeats, availSeats"
      + "driverapprove, riderapprove) VALUES"
      + "(?,?,?,?,?,?,?,?,?,?);";

  private String RIDERAPPROVED = "SELECT count(*) FROM tripstoapprove WHERE "
    + "riderapprove = 1 AND riderID = ?";

  private String DRIVERAPPROVED ="SELECT count(*) FROM tripstoapprove WHERE "
      + "driverapprove = 1 AND driverID = ?";

  private String DELETEDRIVERTRIP = "DELETE from tripstoapprove WHERE tripID "
      + "= ?;";

  private String DELETERIDERTRIP ="DELETE from tripstoapprove WHERE tripID "
      + "= ?;";

  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  public TripsToApproveDAO()
  {
  }

  public List<TripsToApprove> getTripsToApprove()
  {
    List<TripsToApprove> tripsToApproves = jdbcTemplate.query(SELECT, new
        Object[]{}, new TripsToApproveRowMapper());
    return tripsToApproves;
  }

  public int insertTripsToApprove (TripsToApprove tripsToApprove)
  {
    int riderApproved  = jdbcTemplate.queryForObject(RIDERAPPROVED, Integer.class,
        tripsToApprove.getRiderID());
    int driverApproved = jdbcTemplate.queryForObject(DRIVERAPPROVED, Integer.class,
        tripsToApprove.getDriverID());
    if(riderApproved == 1 ^ driverApproved == 1)
      {
        return jdbcTemplate.update(INSERT, tripsToApprove.getTripID(),
            tripsToApprove.getDriverID(), tripsToApprove.getRiderID(), new
          Date(tripsToApprove.getDepartDate().getTime()), new Date
          (tripsToApprove.getReturnDate().getTime()), tripsToApprove.getCity
          (), tripsToApprove.getTotalSeats(), tripsToApprove.getAvailSeats(),
          tripsToApprove.isDriverApprove(), tripsToApprove.isRiderApprove());
      }
        else return 0;
  }

  public int deleteDriverTrip (int tripID)
  {
    return jdbcTemplate.update(DELETEDRIVERTRIP, new Object[]{tripID});
  }

  public int deleteRiderTrip (int tripID)
  {
    return jdbcTemplate.update(DELETERIDERTRIP, new Object[]{tripID});
  }

  private class TripsToApproveRowMapper implements RowMapper
  {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException
    {
      TripsToApprove tripsToApprove = new TripsToApprove();
      tripsToApprove.setTripID(resultSet.getInt("tripID"));
      tripsToApprove.setDriverID(resultSet.getInt("driverID"));
      tripsToApprove.setDriverID(resultSet.getInt("riderID"));
      tripsToApprove.setDepartDate(resultSet.getDate("departDate"));
      tripsToApprove.setReturnDate(resultSet.getDate("returnDate"));
      tripsToApprove.setCity(resultSet.getString("city"));
      tripsToApprove.setTotalSeats(resultSet.getInt("totalSeats"));
      tripsToApprove.setAvailSeats(resultSet.getInt("availSeats"));
      tripsToApprove.setDriverApprove(resultSet.getBoolean("driverApprove"));
      tripsToApprove.setRiderApprove(resultSet.getBoolean("riderApprove"));
      return tripsToApprove;

    }
  }
}

