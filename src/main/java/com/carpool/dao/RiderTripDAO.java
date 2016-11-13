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

public class RiderTripDAO
{
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



  /* Creates genericreports

  public List<RiderTrip> getGenericReports(){
    List<RiderTrip> genericReports = jdbcTemplate.query(SELECTRIDERTRIPS,
        new Object[]{}, new GenericReportRowMapper());
    return genericReports;
  } */

  // This checks to make sure student is a rider before insert. If the
  // student id is a rider it will return a 1.


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
  /*private class GenericReportRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
      GenericReport genericReport = new GenericReport();
      genericReport.setCol1(resultSet.getString("col1"));
      genericReport.setCol2(resultSet.getString("col2"));
      genericReport.setCol3(resultSet.getString("col3"));
      genericReport.setCol4(resultSet.getString("col4"));
      genericReport.setCol5(resultSet.getString("col5"));
      genericReport.setCol6(resultSet.getString("col6"));
      genericReport.setCol7(resultSet.getString("col7"));
      return genericReport;

    }
  } */
