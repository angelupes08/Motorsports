package com.lti.entity;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Teams")
public class Teams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "team_sequence")
	@SequenceGenerator(name="team_sequence", initialValue = 201,allocationSize = 1)
	private int TeamId;
	
	private String teamname;
	
	private String teamprincipal;
	
	@OneToMany(mappedBy ="teams" )
	private List<Drivers> drivers;
	
	@Column(name="created_at",nullable = false,updatable = false)
	@CreationTimestamp()
	private Timestamp creationTime;
	
	@UpdateTimestamp
	private Timestamp updateTime;
}
