package com.lti.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.entity.DriverDto;
import com.lti.entity.Drivers;

public interface DriverRepo extends JpaRepository<Drivers, Integer> {

    @Query("SELECT d FROM Drivers d WHERE d.driverid = ?1")
    Optional<Drivers> getDriverByDriverid(int id);
    
    
    
    @Query("SELECT new com.lti.entity.DriverDto(d.name, d.nationality, d.age, t.teamname, t.teamprincipal) " +
    	       "FROM Drivers d INNER JOIN d.teams t WHERE d.driverid = ?1")
    	Optional<DriverDto> findDriverDetails(int id);
    
    List<Drivers> findByNationality(String country);


}
