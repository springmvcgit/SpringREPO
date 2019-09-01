package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {
	
	private int id;
	private String  SNAME;
	private String SADDRESS;                           
	private String COURSE;                          
	private long MOBILE;
	private long  FEES;      
	


}
