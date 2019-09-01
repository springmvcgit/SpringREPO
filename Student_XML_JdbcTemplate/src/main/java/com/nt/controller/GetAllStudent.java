package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class GetAllStudent extends AbstractController {
	private StudentService service;
	
	public GetAllStudent(StudentService service) {
			this.service = service;
	}
	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModelAndView mav=null;
		mav=new ModelAndView();
		
		List<StudentDTO> listDTO=null;
		//use service
		listDTO=service.getAllRecords();
		//put model into mav
		mav.addObject("allRecords", listDTO);
		mav.setViewName("allStudent");		
		return mav;
	}

}
