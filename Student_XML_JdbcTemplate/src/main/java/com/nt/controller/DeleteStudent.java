package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class DeleteStudent extends AbstractController {
	private StudentService service;
	
	public DeleteStudent(StudentService service) {
			this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int studentId=0;
		String resultMsg=null;
		ModelAndView mav=null;
		List<StudentDTO> listDTO=null;
		
		studentId=(Integer.parseInt(request.getParameter("id")));
		//use service
		resultMsg=service.deleteRecord(studentId);
		//get all records after deleted
		listDTO=service.getAllRecords();
		
		//add all model value to mav object
		mav=new ModelAndView();
		mav.addObject("deleteResult",resultMsg);
		mav.addObject("allRecords", listDTO);
		mav.setViewName("allStudent");
		return mav;
	}

}
