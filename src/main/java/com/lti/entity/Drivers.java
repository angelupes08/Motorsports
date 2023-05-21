package com.lti.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Drivers")
public class Drivers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "driver_sequence")
	@SequenceGenerator(name="driver_sequence", initialValue = 101,allocationSize = 1)
	private int driverid;
	
	private String name;
	
	private String nationality;
	
	private int age;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="teamid")
	private Teams teams;
	
	@JsonIgnore
	@Column(name="created_at",columnDefinition = "timestamp without time zone",nullable = false,updatable = false)
	@CreationTimestamp()
	private Timestamp creationTime;
	
	@JsonIgnore
	@Column(name="updated_at",columnDefinition = "timestamp without time zone")
	@UpdateTimestamp
	private Timestamp updateTime;
}
