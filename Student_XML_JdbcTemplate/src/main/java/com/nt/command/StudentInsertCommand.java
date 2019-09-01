package com.nt.command;

import lombok.Data;

@Data
public class StudentInsertCommand {
	
	private String  SNAME;
	private String SADDRESS;                           
	private String COURSE;                          
	private Long MOBILE;
	private Long  FEES; 
}
