package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Teams;

@Repository
public interface TeamRepo extends JpaRepository<Teams, Integer> {
	
	Teams findByTeamname(String teamName);

}
