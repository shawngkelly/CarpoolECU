package com.carpool.model.report;

import java.util.Date;

/**
 * Created by djosh on 10/19/2016.
 */
public class RiderMatchTrips {
    private String email;
    private Date departDate;
    private int riderID;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public int getRiderID() {
        return riderID;
    }

    public void setRiderID(int riderID) {
        this.riderID = riderID;
    }
}
