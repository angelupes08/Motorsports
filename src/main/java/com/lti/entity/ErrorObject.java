package com.lti.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorObject {
	
	private Integer statusCode;
	
	private String message;
	
	private Date TimeStamp;


}
