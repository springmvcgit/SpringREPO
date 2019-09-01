package com.nt.command;


public class StudentUpdateCommand {

	private Integer id;	
	private String  SNAME;
	private String SADDRESS;                           
	private String COURSE;                          
	private Long MOBILE;
	private Long  FEES;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}
	public String getSADDRESS() {
		return SADDRESS;
	}
	public void setSADDRESS(String sADDRESS) {
		SADDRESS = sADDRESS;
	}
	public String getCOURSE() {
		return COURSE;
	}
	public void setCOURSE(String cOURSE) {
		COURSE = cOURSE;
	}
	public Long getMOBILE() {
		return MOBILE;
	}
	public void setMOBILE(Long mOBILE) {
		MOBILE = mOBILE;
	}
	public Long getFEES() {
		return FEES;
	}
	public void setFEES(Long fEES) {
		FEES = fEES;
	} 

}
