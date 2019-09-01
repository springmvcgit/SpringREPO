package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentInsertCommand;
import com.nt.command.StudentUpdateCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class AddStudents extends SimpleFormController {
	private StudentService service;
	
	
public AddStudents(StudentService service) {
			this.service = service;
	}


@Override
protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
		BindException errors) throws Exception {
	
	StudentInsertCommand cmd=null;
	StudentDTO dto=null;
	String insertMsg=null;
	ModelAndView mav=null;
	List<StudentDTO> listDTO=null;
	
	cmd=(StudentInsertCommand)command;
	//transfer cmd data to dto
	dto=new StudentDTO();
	BeanUtils.copyProperties(cmd, dto);
	
	//use service
	insertMsg=service.addRecords(dto);
	//get all records after inserting new records
	listDTO=service.getAllRecords();
	
	mav=new ModelAndView();
	mav.addObject("insertResult", insertMsg);
	mav.addObject("allRecords", listDTO);
	mav.setViewName("allStudent");
	return mav;
}
	

}
