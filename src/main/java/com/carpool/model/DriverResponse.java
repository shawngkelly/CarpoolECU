package com.carpool.model;

import java.util.List;

/**
 * Created by shawngkelly on 9/12/16.
 */
public class DriverResponse {

    private List<Driver> rows;

    private int current = 1;
    private int total;
    private int rowCount;

    public DriverResponse(){

    }

    public DriverResponse(List<Driver> drivers, int recordsTotal){
        this.rows = drivers;
        this.total = recordsTotal;
        this.rowCount = recordsTotal;
    }

    public List<Driver> getRows() {
        return rows;
    }

    public void setRows(List<Driver> data) {
        this.rows = data;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

}
