package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	private static final String FETCH_ALL_STUDENT="SELECT ID,SNAME,SADDRESS,COURSE,MOBILE,FEES FROM STUDENT";
	private static final String FETCH_BY_ID="SELECT ID,SNAME,SADDRESS,COURSE,MOBILE,FEES FROM STUDENT WHERE ID=?";
	private static final String UPDATE_STUDENT="UPDATE STUDENT SET SNAME=?,SADDRESS=?,COURSE=?,MOBILE=?,FEES=? WHERE ID=?";
	private static final String DELETE_STUDENT_BY_ID="DELETE FROM STUDENT WHERE ID=?";
	//private static final String INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
	private static final String INSERT_QUERY="INSERT INTO STUDENT VALUES(stu_seq.NEXTVAL,?,?,?,?,?)"; 

	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<StudentBO> getAllStudent() {
		List<StudentBO> listBO=null;
		listBO=jt.query(FETCH_ALL_STUDENT, rs->
		{
			StudentBO bo=null;
			List<StudentBO> listBO1=null;
			listBO1=new ArrayList<>();
			while(rs.next())
			{
				bo=new StudentBO();
				bo.setId(rs.getInt(1));
				bo.setSNAME(rs.getString(2));
				bo.setSADDRESS(rs.getString(3));
				bo.setCOURSE(rs.getString(4));
				bo.setMOBILE(rs.getLong(5));
				bo.setFEES(rs.getLong(6));
				listBO1.add(bo);
			}//while
			return listBO1;
		});
		return listBO;
		
	}


	@Override
	public StudentBO getStudentById(int id){
		StudentBO bo =null;
		bo=jt.queryForObject(FETCH_BY_ID,(rs,rownum)->
		{
			StudentBO bo1=new StudentBO();
			
			bo1.setId(rs.getInt(1));
			bo1.setSNAME(rs.getString(2));
			bo1.setSADDRESS(rs.getString(3));
			bo1.setCOURSE(rs.getString(4));
			bo1.setFEES(rs.getLong(5));
			bo1.setMOBILE(rs.getLong(6));
			
			
			return bo1;
		},id);
		
		return bo;
	}


	@Override
	public int saveStudent(StudentBO bo) {
		int result=0;
		result=jt.update(UPDATE_STUDENT,bo.getSNAME(),bo.getSADDRESS(),bo.getCOURSE(),bo.getMOBILE(),bo.getFEES(),bo.getId());
		return result;
	}
	
	@Override
	public int deleteStudent(int id) {

		int result=0;
		result=jt.update(DELETE_STUDENT_BY_ID,id);
		return result;
	}


	@Override
	public int insertStudent(StudentBO bo) {
		int result=0;
		result=jt.update(INSERT_QUERY,bo.getSNAME(),bo.getSADDRESS(),bo.getCOURSE(),bo.getMOBILE(),bo.getFEES());
		return result;
	}

}

