package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface StudentService {
	public List<StudentDTO> getAllRecords();
	public StudentDTO getById(int id);
	public String insertRecord(StudentDTO dto);
	public String deleteRecord(int id);
	public String addRecords(StudentDTO dto);
	
}
