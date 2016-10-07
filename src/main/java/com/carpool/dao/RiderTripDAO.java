package com.carpool.dao;

import com.carpool.model.RiderTrip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shawnkelly on 10/6/16.
 */

public class RiderTripDAO
{
  private String SELECT = "SELECT * FROM riderTrip;";
  private String INSERT = "INSERT INTO riderTrip (riderTripID, riderID, " +
      "departDate, returnDate, city, values (?,?,?,?,?);";

  private String UPDATE = "UPDATE riderTrip SET riderTripID = ?, riderID = " +
      "?, " +
      "departDate =?, returnDate = ?, city = ? " +
      "WHERE " +
      "riderID = ?;";
  private String DELETE = "DELETE from riderTrip where riderID = ?;";

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

  public int insertRiderTrip(RiderTrip riderTrip){
    return jdbcTemplate.update(INSERT,new Object[]{riderTrip.getRiderTripID(),
       riderTrip.getRiderID(),riderTrip.getDepartDate(),riderTrip
        .getReturnDate(),riderTrip.getCity()});
  }

  public int updateRiderTrip(RiderTrip riderTrip){
    return jdbcTemplate.update(UPDATE,new Object[]{riderTrip.getRiderTripID(),
        riderTrip.getRiderID(), riderTrip.getDepartDate(), riderTrip.getReturnDate(),
        riderTrip.getCity()});
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

