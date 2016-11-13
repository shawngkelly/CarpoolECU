package com.carpool.dao;

import com.carpool.model.DriverTrip;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * Created by shawnkelly on 10/16/16.
 */
public class DriverTripDAO
{
  private String SELECT = "SELECT * FROM drivertrip;";

  private String INSERT = "INSERT INTO drivertrip ( driverID, departDate, "
      + "returnDate, city1, city2, city3, seats) VALUES"
      + "(?,?,?,?,?,?,?);";

  private String ISDRIVER = "SELECT count(*) FROM student WHERE driver = 1 "
      + " AND idStudent = ?";

  private String UPDATE = "UPDATE drivertrip SET driverID = ?, departDate = "
      + "?, returnDate = ?, city1 = ?, city2 = ?, city3 = ?, seats = ? "
      + "WHERE tripID = ?;";

  private String DELETE =  "DELETE from drivertrip where tripID = ?;";


  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  public DriverTripDAO(){

  }

  public List<DriverTrip> getDriverTrips(){
    List<DriverTrip> driverTrips = jdbcTemplate.query(SELECT, new Object[]{},
        new DriverTripRowMapper());
    return driverTrips;
  }
  //This checks the student to check for the driver flag before inserting
  // into the drivertrip table.

  public int  insertDriverTrip (DriverTrip driverTrip) {
    int isDriver = jdbcTemplate.queryForObject(ISDRIVER, Integer.class,
        driverTrip.getDriverID());
    if(isDriver == 1) {
      return jdbcTemplate.update(INSERT, driverTrip.getDriverID(), new Date
          (driverTrip.getDepartDate().getTime()), new Date(driverTrip
          .getReturnDate().getTime()), driverTrip.getCity1(), driverTrip
          .getCity2(),driverTrip.getCity3(), driverTrip.getSeats());}
    else return 0;
    }

    public int updateDriverTrip (DriverTrip driverTrip) {
      return jdbcTemplate.update(UPDATE, driverTrip.getDriverID(), new Date
          (driverTrip.getDepartDate().getTime()), new Date(driverTrip
          .getReturnDate().getTime()), driverTrip.getCity1(), driverTrip
          .getCity2(),driverTrip.getCity3(), driverTrip.getSeats(),
          driverTrip.getTripID());}

    public int deleteDriverTrip (int tripID) {
      return jdbcTemplate.update(DELETE, new Object[]{tripID});
    }

    private class DriverTripRowMapper implements RowMapper{

      @Override
      public Object mapRow(ResultSet resultSet, int i) throws SQLException{
        DriverTrip driverTrip = new DriverTrip();
        driverTrip.setTripID(resultSet.getInt("tripID"));
        driverTrip.setDriverID(resultSet.getInt("driverID"));
        driverTrip.setDepartDate(resultSet.getDate("departDate"));
        driverTrip.setReturnDate(resultSet.getDate("returnDate"));
        driverTrip.setCity1(resultSet.getString("city1"));
        driverTrip.setCity2(resultSet.getString("city2"));
        driverTrip.setCity3(resultSet.getString("city3"));
        driverTrip.setSeats(resultSet.getInt("seats"));
        return driverTrip;
      }
    }

  }



