package com.carpool.dao;

/**
 * Created by shawnkelly on 10/10/16.
 */
import com.carpool.model.report.RiderTrip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReportDAO
{
  private String SELECTRIDERWITHTRIPS = "SELECT * FROM studentridertrips;";

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

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException
    {
      RiderTrip riderTrip = new RiderTrip();
      riderTrip.setID(resultSet.getInt("ID"));
      riderTrip.setFirstName(resultSet.getString("FirstName"));
      riderTrip.setLastName(resultSet.getString("LastName"));
      riderTrip.setDepartDate(resultSet.getDate("DepartDate"));
      riderTrip.setCity(resultSet.getString("city"));
      return riderTrip;
    }
  }
}
