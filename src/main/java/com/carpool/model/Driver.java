package com.carpool.model;

/**
 * Created by shawngkelly on 9/9/16.
 */
public class Driver {

    private int driverId;

    private String firstName;
    private String lastName;

    public Driver(){

    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
