package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.DriverDto;
import com.lti.entity.Drivers;
import com.lti.service.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	DriverService dService;
	
	@PostMapping("/drivers")
	public DriverDto saveDrivers(@RequestBody DriverDto driverDto) {
		
		DriverDto d = dService.saveDrivers(driverDto);
		return d;
		
	}
	
	@GetMapping("/driver")
	public DriverDto getDrivers(@RequestParam("id") int id )
	{
		return dService.getDrivers(id);
		
	}
	
	@GetMapping("/drivers")
	List<Drivers> returnDrivers(){
		return dService.returnDrivers();
	}
	
	@PutMapping("/updatedriver")
	public Drivers updateDrivers(@RequestParam("id") int id,@RequestBody Drivers drivers) {
		
		return dService.setDrivers(id, drivers);
		
	}
	
	@GetMapping("/nationality")
	public List<Drivers> getDriversByNationality(@RequestParam("nationality") String nationality){
		
		return dService.getDriversByNationality(nationality);
		
	}
	
	@GetMapping("/country")
	public List<DriverDto> getDriverDetailsByNationality(@RequestParam("country") String country){
		
		return dService.getDriverDetailsByNationality(country);
	}
	
}
