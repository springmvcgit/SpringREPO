package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentUpdateCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class UpdateStudent extends SimpleFormController{
	
	private StudentService service;
	
	
	public UpdateStudent(StudentService service) {
		this.service = service;
	}

	//for setting command data in edit box
	@Override
	public Object formBackingObject(HttpServletRequest request) throws Exception {
		
		StudentUpdateCommand cmd=null;
		int id=0;
		StudentDTO studentDto=null;
		
		id=Integer.parseInt(request.getParameter("id"));
		//use service
		studentDto=service.getById(id);
		//convert dto to command 
		cmd=new StudentUpdateCommand();
		BeanUtils.copyProperties(studentDto, cmd);
		return cmd;
	}
	
	//for solving double posting problem
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("doublePosting");
	}
	
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		StudentDTO dto=null;
		List<StudentDTO> listDTO=null;
		StudentUpdateCommand cmd=null;
		String result=null;
		ModelAndView mav=null;
		
		cmd=(StudentUpdateCommand)command;
		dto=new StudentDTO();
		//convert cmd to dto
		BeanUtils.copyProperties(cmd, dto);
		//use service for updation result
		result=service.insertRecord(dto);
		//fetch all data 
		listDTO=service.getAllRecords();
		//add all model attributes on mav obj
		mav=new ModelAndView();
		mav.addObject("result", result);
		mav.addObject("allRecords", listDTO);
		mav.setViewName("allStudent");
		System.out.println(result);
		return mav;
	}
	
		
		
	}

