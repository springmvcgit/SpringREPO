package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.StudentInsertCommand;
import com.nt.command.StudentUpdateCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping(value="/welcome.htm")
	public String welcomePage()
	{
		return "home";
	}
	
	@GetMapping("/home.htm")
	public void homePage()
	{
		//returning same page name which is the req url(home.jsp)
	}
	
	@GetMapping("/about.htm")
	public void aboutPage()
	{
		//will return "about"
	}
	
	@GetMapping("/contact.htm")
	public void contactPage()
	{
		
	}
	
	@GetMapping("/help.htm")
	public void helpPage()
	{

	}
	
	
	@GetMapping("/getAllStudent.htm")
	public String getAllStudent(Map<String,Object> map)
	{
		List<StudentDTO> listDTO=null; 
		//use service
		listDTO=service.getAllRecords();
		map.put("allRecords", listDTO);
		return "allStudent";
	}
	
	//initial req for update with dynamic data
	@GetMapping("/updateRecord.htm")
	public String updateRecord(HttpServletRequest req,Map<String,Object> map,@ModelAttribute("stuCmd") StudentUpdateCommand cmd)
	{

		int id=0;
		StudentDTO studentDto=null;
		
		id=Integer.parseInt(req.getParameter("id"));
		//use service
		studentDto=service.getById(id);
		//convert dto to command 
		BeanUtils.copyProperties(studentDto, cmd);
		map.put("stuCmd",cmd);
	
		return "edit";
	}
	
	//post back req for update record
	@PostMapping("/updateRecord.htm")
	public String updateProcess(Map<String,Object> map,@ModelAttribute ("stuCmd") StudentUpdateCommand command)
	{
		
		StudentDTO dto=null;
		List<StudentDTO> listDTO=null;
		StudentUpdateCommand cmd=null;
		String result=null;
		
		cmd=(StudentUpdateCommand)command;
		dto=new StudentDTO();
		//convert cmd to dto
		BeanUtils.copyProperties(cmd, dto);
		//use service for updation result
		result=service.insertRecord(dto);
		//fetch all data 
		listDTO=service.getAllRecords();
		//add all model attributes on mav obj
		
		map.put("result",result);
        map.put("allRecords", listDTO);
        
		return "allStudent";
	}
	
	@GetMapping("/delete.htm")
	public String deleteRecord(HttpServletRequest req,Map<String,Object> map)
	{
		int studentId=0;
		String resultMsg=null;
		List<StudentDTO> listDTO=null;
		
		studentId=(Integer.parseInt(((ServletRequest) req).getParameter("id")));
		//use service
		resultMsg=service.deleteRecord(studentId);
		//get all records after deleted
		listDTO=service.getAllRecords();
		
		//add all model value to map object
		map.put("deleteResult",resultMsg);
		map.put("allRecords", listDTO);

		return "allStudent";
	}
	
	//initial get request for add student(for form display)
	@GetMapping("/addStudent.htm")
	public String addStudent(@ModelAttribute ("stuInsert") StudentInsertCommand cmd)
	{
		return "addStudents";
	}
	
	//post bact req for adding student(form submission)
	@PostMapping("/addStudent.htm")
	public String addStudentProcess(Map<String,Object> map,@ModelAttribute("stuInsert") StudentInsertCommand command)
	{
		StudentDTO dto=null;
		List<StudentDTO> listDTO=null;
		String insertMsg=null;
		
		dto=new StudentDTO();
		//convert cmd form data into dto
		BeanUtils.copyProperties(command, dto);
		//use service
		insertMsg=service.addRecords(dto);
		//get all data after inserting a record
		listDTO=service.getAllRecords();
		//put all model value into map object
		map.put("allRecords", listDTO);
		map.put("insertMsg", insertMsg);
		
		return "allStudent";
	}
	
}
