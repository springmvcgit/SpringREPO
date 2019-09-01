<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    <div >
      <a href="home.htm">Home</a> &nbsp;&nbsp;&nbsp;&nbsp;
      <a href="contact.htm">Contact_us</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="about.htm">About_us</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="help.htm">Help</a>&nbsp;&nbsp;&nbsp;&nbsp;
   </div> 
    
    
    
<div>
<h1 style="color:red;text-align:center">All Records</h1><br>
</div>


<div>
<c:choose>
	<c:when test="${!empty allRecords}">
		<table border="1" width="600" align="center" color="cyan">
			<tr>
			    <th>ID</th>
				<th>NAME</th>
				<th>ADDRESS</th>
				<th>COURSE</th>
				<th>MOBILE</th>
				<th>FEES</th>
				<th>OPERATIONS</th>
				
			</tr>
			
	<c:forEach var="dto" items="${allRecords}">
		<tr>
		   <td>${dto.id}</td>	
		   <td>${dto.SNAME}</td>
		   <td>${dto.SADDRESS}</td>
		   <td>${dto.COURSE}</td>
		   <td>${dto.MOBILE}</td>
		   <td>${dto.FEES}</td>
		   <td>&nbsp;&nbsp;&nbsp;<a href="updateRecord.htm?id=${dto.id}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <a href="delete.htm?id=${dto.id}">Delete</a></td>
		   
		   
		</tr>
	</c:forEach>		
		</table>
	
	</c:when>
	
   <c:otherwise>
      <h2>Record Not Found</h2>
   </c:otherwise>

</c:choose>
</div>

<div>
	<a href="addStudent.htm"><h5 style="color:green;text-align:center">Add Students</h5></a>	
</div>
<div>
	<c:if test="${!empty result}">
		<h5 style="color:green;text-align:center">SuccessFully Record Updated</h5>	
	</c:if>
	
	<c:if test="${!empty deleteResult}">
		<h5 style="color:green;text-align:center">SuccessFully Record Deleted</h5>	
	</c:if>
	
	<c:if test="${!empty insertResult}">
		<h5 style="color:green;text-align:center">SuccessFully Record Inserted</h5>	
		
	</c:if>
	
</div>


