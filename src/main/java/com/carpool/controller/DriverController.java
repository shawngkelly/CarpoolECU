package com.carpool.controller;

import com.carpool.model.Driver;
import com.carpool.model.DriverResponse;
import com.carpool.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class DriverController {

	private DriverService driverService;

	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loadHome(ModelMap model) {
		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/driver/list", method = RequestMethod.POST)
	public DriverResponse getDrivers(){
		List<Driver> drivers = driverService.getDrivers();
		return new DriverResponse(drivers,drivers.size());
	}

	@ResponseBody
	@RequestMapping(value = "/driver/save", method = RequestMethod.POST, consumes = "application/json")
	public int insertDriver(@RequestBody Driver driver) {
		return driverService.insertDriver(driver);
	}

	@ResponseBody
	@RequestMapping(value = "/driver/delete/{driverId}", method = RequestMethod.GET)
	public int deleteDriver(@PathVariable("driverId") int driverId) {
		return driverService.deleteDriver(driverId);
	}

	@ResponseBody
	@RequestMapping(value = "/driver/update", method = RequestMethod.POST, consumes = "application/json")
	public int updateDriver(@RequestBody Driver driver) {
		return driverService.updateDriver(driver);
	}
}