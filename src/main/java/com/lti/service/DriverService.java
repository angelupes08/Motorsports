package com.lti.service;

import java.util.List;

import com.lti.entity.DriverDto;
import com.lti.entity.Drivers;

public interface DriverService {
	
	DriverDto saveDrivers(DriverDto driverDto);
	
	DriverDto getDrivers(int id);
	
	Drivers setDrivers(int id,Drivers drivers);
	
	List<Drivers> returnDrivers();
	
	List<Drivers> getDriversByNationality(String nationality);
	
	List<DriverDto> getDriverDetailsByNationality(String nationality);

}
