package com.carpool.model.report;

/**
 * Created by taylorlawrence on 10/23/16.
 */
import java.util.Date;

public class DriversWithSeats {
    private int driverID;
    private Date departDate;
    private String city1;
    private String city2;
    private String city3;
    private int seats;

    public int getDriverID() {
        return driverID;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public String getCity1() {
        return city1;
    }

    public String getCity2() {
        return city2;
    }

    public String getCity3() {
        return city3;
    }

    public int getSeats() {
        return seats;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public void setCity3(String city3) {
        this.city3 = city3;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

}
