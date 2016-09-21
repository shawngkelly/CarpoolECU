package com.carpool.service;

import com.carpool.dao.DriverDAO;
import com.carpool.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shawngkelly on 9/9/16.
 */
public class DriverService {

    private DriverDAO driverDAO;

    public void setDriverDAO(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    public List<Driver> getDrivers(){
        return driverDAO.getDrivers();
    }

    public int insertDriver(Driver driver){
        return driverDAO.insertDriver(driver);
    }

    public int updateDriver(Driver driver){
        return driverDAO.updateDriver(driver);
    }

    public int deleteDriver(int driverId){
        return driverDAO.deleteDriver(driverId);
    }
}
