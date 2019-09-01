package com.nt.bo;


public class StudentBO {
	
private int id;	
private String  SNAME;
private String SADDRESS;                           
private String COURSE;                          
private long MOBILE;
private long  FEES;
public int getId() {
	return id;
}
public void setId(int id) {
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
public long getMOBILE() {
	return MOBILE;
}
public void setMOBILE(long mOBILE) {
	MOBILE = mOBILE;
}
public long getFEES() {
	return FEES;
}
public void setFEES(long fEES) {
	FEES = fEES;
}                              


}
