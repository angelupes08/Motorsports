package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.DriverRepo;
import com.lti.dao.TeamRepo;
import com.lti.entity.DriverDto;
import com.lti.entity.Drivers;
import com.lti.entity.Teams;
import com.lti.exception.ResourceNotFoundException;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	DriverRepo dRepo;
	
	@Autowired
	TeamRepo tRepo;

	@Override
	public DriverDto saveDrivers(DriverDto driverDto) {
		
		Drivers drivers = new Drivers();
		
		drivers.setName(driverDto.getName());
		drivers.setAge(driverDto.getAge());
		drivers.setNationality(driverDto.getNationality());
		
		String teamName = driverDto.getTeamname();
				
		Teams t = tRepo.findByTeamname(teamName);
		
		if (t==null) {
		
		Teams teams = new Teams();
		
		teams.setTeamname(teamName);
		teams.setTeamprincipal(driverDto.getTeamprincipal());
		
		tRepo.save(teams);
		drivers.setTeams(teams);
		}
		else {
			drivers.setTeams(t);
		}
		dRepo.save(drivers);
		
		return driverDto;
		
	}

	@Override
	public DriverDto getDrivers(int id) {
		
		Optional<DriverDto> opt = dRepo.findDriverDetails(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		else 
			throw new ResourceNotFoundException("No drivers found for the id "+id);
	}

	@Override
	public Drivers setDrivers(int id,Drivers drivers) {
		Optional<Drivers> opt = dRepo.findById(id);
		
		if (opt.isPresent()) {
			Drivers d = opt.get();
			
			d.setName(drivers.getName()!=null?drivers.getName():d.getName());
			d.setAge(drivers.getAge() != 0?drivers.getAge():d.getAge());
			d.setNationality(drivers.getNationality()!=null?drivers.getNationality():d.getNationality());
			
			return dRepo.save(d);
			
		}
		else 
			throw new ResourceNotFoundException("No drivers found for the id "+id);
	}

	@Override
	public List<Drivers> returnDrivers() {
		
		return dRepo.findAll();
	}

	@Override
	public List<Drivers> getDriversByNationality(String nationality) {
		
		return dRepo.findByNationality(nationality);
	}
		
		
		
		
	

}
