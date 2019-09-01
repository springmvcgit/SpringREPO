package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;
	

	@Override
	public List<StudentDTO> getAllRecords() {
		
		List<StudentBO> listBO=null;
		List<StudentDTO> listDTO=new ArrayList<StudentDTO>();
		
		//use dao
		listBO=dao.getAllStudent();
		//convert BO to DTO
		listBO.forEach(bo1 ->{
			StudentDTO dto=new StudentDTO();
			BeanUtils.copyProperties(bo1, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}



	@Override
	public StudentDTO getById(int id) {
		StudentBO bo=null;
		StudentDTO dto=null;
		dto=new StudentDTO();
		
		//use dao
		bo=dao.getStudentById(id);
		//convert bo to dto
		BeanUtils.copyProperties(bo, dto);
		
		return dto;
	}



	@Override
	public String insertRecord(StudentDTO dto) {
		int result=0;
		StudentBO bo=null;
		bo=new StudentBO();
		
		//convert dto to bo
		BeanUtils.copyProperties(dto, bo);
		//use service
		result=dao.saveStudent(bo);
		return result!=0?"updated":"not update";
	}
	
	@Override
	public String deleteRecord(int id) {
		int result=0;
		//use dao
		result=dao.deleteStudent(id);	
		return result!=0?" Record Deleted":"Record Not Delete";
	}



	@Override
	public String addRecords(StudentDTO dto) {
		StudentBO bo=null;
		int result=0;
		bo=new StudentBO();
		//convert dto to bo
		BeanUtils.copyProperties(dto, bo);
		//use dao
		result=dao.insertStudent(bo);
		return result!=0?"Record Inserted":"Record Not Inserted";
	}

}
