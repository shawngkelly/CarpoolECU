package com.carpool.dao;


import com.carpool.model.RiderTrip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shawnkelly on 10/6/16.
 */

//Class to access database with SQL statements and queries..

public class RiderTripDAO
{

//The following are variables to perform SQL statements in the database.

  private String SELECT = "SELECT * FROM riderTrip;";

  private String INSERT = "INSERT INTO ridertrip (riderID, departDate,returnDate,city) VALUES" +
      " (?,?,?,?);";

  private String ISRIDER = "SELECT count(*) FROM student WHERE rider = 1 and " +
      "idStudent = ?";

  private String UPDATE = "UPDATE ridertrip SET riderID = ?, departDate =?, " +
      "returnDate = ?, city = ? " +
      "WHERE " +
      "riderTripID = ?;";
  private String DELETE = "DELETE from riderTrip where riderTripID = ?;";

  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public RiderTripDAO(){

  }

  public List<RiderTrip> getRiderTrips(){
    List<RiderTrip> riderTrips = jdbcTemplate.query(SELECT,new Object[]{},new
        RiderTripRowMapper());
    return riderTrips;
  }


//Checks to make sure a student is a rider before inserting into table.

  public int insertRiderTrip(RiderTrip riderTrip){
    int isRider = jdbcTemplate.queryForObject(ISRIDER, Integer.class,
        riderTrip.getRiderID());
    if (isRider == 1){
    return jdbcTemplate.update(INSERT, riderTrip.getRiderID(),new Date
        (riderTrip.getDepartDate().getTime()),
        new Date(riderTrip.getReturnDate().getTime()),riderTrip.getCity());}
    else return 0;
  }

  public int updateRiderTrip(RiderTrip riderTrip){
    return jdbcTemplate.update(UPDATE, riderTrip.getRiderID(), new Date(riderTrip.getDepartDate().getTime())
        , new Date(riderTrip.getReturnDate().getTime()),
        riderTrip.getCity(), riderTrip.getRiderTripID());
  }

  public int deleteRiderTrip(int riderTripID){
    return jdbcTemplate.update(DELETE,new Object[]{riderTripID});
  }


  private class RiderTripRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
      RiderTrip riderTrip = new RiderTrip();
      riderTrip.setRiderTripID(resultSet.getInt("riderTripID"));
      riderTrip.setRiderID(resultSet.getInt("riderID"));
      riderTrip.setDepartDate(resultSet.getDate("departDate"));
      riderTrip.setReturnDate(resultSet.getDate("returnDate"));
      riderTrip.setCity(resultSet.getString("city"));
      return riderTrip;
    }
  }
}
