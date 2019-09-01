package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBO;

public interface StudentDAO {
	public List<StudentBO> getAllStudent();
	public StudentBO getStudentById(int id);
	public int saveStudent(StudentBO bo);
	public int deleteStudent(int id);
	public int insertStudent(StudentBO bo);

}
