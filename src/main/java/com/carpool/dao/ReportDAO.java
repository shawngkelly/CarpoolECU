package com.carpool.dao;

/**
 * Created by shawnkelly on 10/10/16.
 */

//Add import statement here if adding any new models for reports


import com.carpool.model.report.RiderNoTrip;
import com.carpool.model.report.RiderTrip;
import com.carpool.model.report.RiderMatchTrips;
import com.carpool.model.report.DriversWithSeats;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//Class to access database with SQL statements and queries.

public class ReportDAO
{
//The following are variables to perform SQL statements in the database.
//Calls all the views.

  private String SELECTRIDERWITHTRIPS = "SELECT * FROM studentridertrips;";

  private String SELECTRIDERWNOTRIPS = "SELECT * FROM studentridernotrips;";

  private String SELECTRIDEMATCHTRIPS = "SELECT * FROM ridermatchtrips;";


  private String SELECTDRIVERSWITHSEATS = "SELECT * FROM driverswithseats";

  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  public ReportDAO()
  {

  }

  public List<RiderTrip> getRiderTrips()
  {
    List<RiderTrip> riderTrips = jdbcTemplate.query(SELECTRIDERWITHTRIPS, new
        Object[]{}, new RiderTripRowMapper());
    return riderTrips;
  }

  private class RiderTripRowMapper implements RowMapper
  {


//Calls the rowmapper to return the data in model object.

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException
    {
      RiderTrip riderTrip = new RiderTrip();
      riderTrip.setID(resultSet.getInt("ID"));
      riderTrip.setFirstName(resultSet.getString("FirstName"));
      riderTrip.setLastName(resultSet.getString("LastName"));
      riderTrip.setDepartDate(resultSet.getDate("DepartDate"));
      riderTrip.setReturnDate(resultSet.getDate("ReturnDate"));
      riderTrip.setCity(resultSet.getString("city"));
      return riderTrip;
    }
  }

  public List<RiderNoTrip> getRiderNoTrips()
  {
    List<RiderNoTrip> riderNoTrips = jdbcTemplate.query(SELECTRIDERWNOTRIPS,
        new Object[]{}, new RiderNoTripRowMapper());
    return riderNoTrips;
  }

  private class RiderNoTripRowMapper implements RowMapper
  {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException
    {
      RiderNoTrip riderNoTrip = new RiderNoTrip();
      riderNoTrip.setId(resultSet.getInt("idstudent"));
      riderNoTrip.setFirstName(resultSet.getString("FirstName"));
      riderNoTrip.setLastName(resultSet.getString("LastName"));
      return riderNoTrip;
    }
  }

  public List<RiderMatchTrips> getRiderMatchTrips()
  {
    List<RiderMatchTrips> riderMatchTrips = jdbcTemplate.query(SELECTRIDEMATCHTRIPS,
            new Object[]{}, new RiderMatchTripsRowMapper());
    return riderMatchTrips;
  }

  private class RiderMatchTripsRowMapper implements RowMapper
  {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException
    {
      RiderMatchTrips riderMatchTrip = new RiderMatchTrips();
      riderMatchTrip.setEmail(resultSet.getString("email"));
      riderMatchTrip.setDepartDate(resultSet.getDate("departDate"));
      riderMatchTrip.setRiderID(resultSet.getInt("riderID"));
      return riderMatchTrip;
    }
  }
    public List<DriversWithSeats> getDriversWithSeats()
    {
        List<DriversWithSeats> driversWithSeats = jdbcTemplate.query(SELECTDRIVERSWITHSEATS, new
                Object[]{}, new DriversWithSeatsRowMapper());
        return driversWithSeats;
    }
  //Taylor add you public, privagte and @overrie stuff here.
    private class DriversWithSeatsRowMapper implements RowMapper
  {
      @Override
      public Object mapRow(ResultSet resultSet, int i) throws SQLException
      {
          DriversWithSeats driversWithSeats = new DriversWithSeats();
          driversWithSeats.setDriverID(resultSet.getInt("driverID"));
          driversWithSeats.setDepartDate(resultSet.getDate("departDate"));
          driversWithSeats.setCity1(resultSet.getString("city1"));
          driversWithSeats.setCity2(resultSet.getString("city2"));
          driversWithSeats.setCity3(resultSet.getString("city3"));
          driversWithSeats.setSeats(resultSet.getInt("seats"));
          return driversWithSeats;
      }
  }

}
