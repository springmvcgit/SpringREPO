package com.nt.command;

import lombok.Data;

@Data
public class StudentUpdateCommand {

	private Integer id;	
	private String  SNAME;
	private String SADDRESS;                           
	private String COURSE;                          
	private Long MOBILE;
	private Long  FEES; 
}
