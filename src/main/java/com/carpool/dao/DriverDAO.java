package com.carpool.dao;

import com.carpool.model.Driver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shawngkelly on 9/9/16.
 */
public class DriverDAO {

    private String SELECT = "SELECT * FROM driver;";
    private String INSERT = "INSERT INTO driver (firstName,lastName) values (?,?);";
    private String UPDATE = "UPDATE driver SET firstName = ?, lastName = ? WHERE driverId = ?;";
    private String DELETE = "DELETE from driver where driverId = ?;";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DriverDAO(){

    }

    public List<Driver> getDrivers(){
        List<Driver> drivers = jdbcTemplate.query(SELECT,new Object[]{},new DriverRowMapper());
        return drivers;
    }

    public int insertDriver(Driver driver){
        return jdbcTemplate.update(INSERT,new Object[]{driver.getFirstName(),driver.getLastName()});
    }

    public int updateDriver(Driver driver){
        return jdbcTemplate.update(UPDATE,new Object[]{driver.getFirstName(),driver.getLastName(), driver.getDriverId()});
    }

    public int deleteDriver(int driverId){
        return jdbcTemplate.update(DELETE,new Object[]{driverId});
    }

    private class DriverRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Driver driver = new Driver();
            driver.setDriverId(resultSet.getInt("driverId"));
            driver.setFirstName(resultSet.getString("firstName"));
            driver.setLastName(resultSet.getString("lastName"));
            return driver;
        }
    }
}
