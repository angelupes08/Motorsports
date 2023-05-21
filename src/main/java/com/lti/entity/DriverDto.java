package com.lti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DriverDto {
	
	//private int driverid;
	private String name;
	private String nationality;
	private int age;
	private String teamname;
	private String teamprincipal;

	public DriverDto(String name, String nationality, int age, String teamname, String teamprincipal) {
		//this.driverid = driverid;
		this.name = name;
		this.nationality = nationality;
		this.age = age;
		this.teamname = teamname;
		this.teamprincipal = teamprincipal;
	}
}
